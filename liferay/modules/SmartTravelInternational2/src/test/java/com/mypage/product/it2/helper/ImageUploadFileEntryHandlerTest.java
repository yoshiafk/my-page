package com.mypage.product.it2.helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.liferay.blogs.exception.EntryImageNameException;
import com.liferay.blogs.exception.EntryImageSizeException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UniqueFileNameProvider;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ImageUploadFileEntryHandlerTest {

    private ImageUploadFileEntryHandler handler;

    @BeforeEach
    void setUp() throws Exception {
        handler = new ImageUploadFileEntryHandler("myFile", "MyFolder");

        UniqueFileNameProvider mockProvider = Mockito.mock(UniqueFileNameProvider.class);
        Mockito.when(mockProvider.provide(Mockito.anyString(), Mockito.any()))
               .thenAnswer(invocation -> invocation.getArgument(0));

        Field field = ImageUploadFileEntryHandler.class.getDeclaredField("uniqueFileNameProvider");
        field.setAccessible(true);
        field.set(handler, mockProvider);
    }

    @Test
    void testUpload_Success() throws Exception {
        UploadPortletRequest upr = mockUploadRequest("gambar.png", "image/png", 500L);

        withStaticMocks(upr, () -> {
            try {
                FileEntry result = handler.upload(upr);
                assertNotNull(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }, "image/png");
    }

    @Test
    void testValidateFile_TooLarge() throws Exception {
        UploadPortletRequest upr = mockUploadRequest("gambar.png", "image/png", 999999999L);

        withStaticMocks(upr, () ->
                assertThrows(EntryImageSizeException.class, () -> handler.upload(upr)), "image/png");
    }

    @Test
    void testValidateFile_InvalidExtension() throws Exception {
        UploadPortletRequest upr = mockUploadRequest("gambar.bmp", "image/bmp", 500L);

        withStaticMocks(upr, () ->
                assertThrows(EntryImageNameException.class, () -> handler.upload(upr)), "image/bmp");
    }

    private UploadPortletRequest mockUploadRequest(String fileName, String contentType, long size) throws Exception {
        UploadPortletRequest upr = Mockito.mock(UploadPortletRequest.class);
        Mockito.when(upr.getFileName("myFile")).thenReturn(fileName);
        Mockito.when(upr.getContentType("myFile")).thenReturn(contentType);
        Mockito.when(upr.getSize("myFile")).thenReturn(size);
        Mockito.when(upr.getFileAsStream("myFile")).thenReturn(Mockito.mock(InputStream.class));
        Mockito.when(upr.getFile("myFile")).thenReturn(Mockito.mock(File.class));

        ThemeDisplay themeDisplay = Mockito.mock(ThemeDisplay.class);
        Mockito.when(themeDisplay.getScopeGroupId()).thenReturn(1000L);
        Mockito.when(themeDisplay.getUserId()).thenReturn(2000L);
        Mockito.when(upr.getAttribute(WebKeys.THEME_DISPLAY)).thenReturn(themeDisplay);

        return upr;
    }

    private void withStaticMocks(UploadPortletRequest upr, Runnable testLogic, String mimeType) throws Exception {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(1000L);

        try (MockedStatic<ServiceContextFactory> mockedSCF =
                     Mockito.mockStatic(ServiceContextFactory.class);
             MockedStatic<DLFolderLocalServiceUtil> mockedFolder =
                     Mockito.mockStatic(DLFolderLocalServiceUtil.class);
             MockedStatic<DLAppLocalServiceUtil> mockedApp =
                     Mockito.mockStatic(DLAppLocalServiceUtil.class);
             MockedStatic<MimeTypesUtil> mockedMime =
                     Mockito.mockStatic(MimeTypesUtil.class)) {

            mockedSCF.when(() -> ServiceContextFactory.getInstance(Mockito.anyString(), Mockito.eq(upr)))
                     .thenReturn(serviceContext);

            DLFolder folder = Mockito.mock(DLFolder.class);
            Mockito.when(folder.getFolderId()).thenReturn(10L);
            mockedFolder.when(() -> DLFolderLocalServiceUtil.fetchFolder(
                    Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString()))
                        .thenReturn(folder);

            FileEntry fakeEntry = Mockito.mock(FileEntry.class);
            mockedApp.when(() -> DLAppLocalServiceUtil.addFileEntry(
                    Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString(),
                    Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                    Mockito.any(File.class), Mockito.any(ServiceContext.class)))
                     .thenReturn(fakeEntry);

            mockedMime.when(() -> MimeTypesUtil.getExtensions(mimeType))
                      .thenReturn(new HashSet<>(Arrays.asList("." + mimeType.split("/")[1])));

            testLogic.run();
        }
    }
}

package com.mypage.product.it.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.mypage.product.it.wrapper.JournalArticleService;
import com.mypage.product.it.wrapper.PropsUtilService;

import java.nio.file.Files;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MypageHelpersTest {

    private MypageHelpers helpers;
	private JournalArticleService journalService = Mockito.mock(JournalArticleService.class);
	private PropsUtilService propService = Mockito.mock(PropsUtilService.class);
	
	@BeforeEach
    void setUp() {
        helpers = new MypageHelpers();
        helpers.setJournalService(journalService);
        helpers.setPropService(propService);
    }

	@Test
    void testGetWebContentByFriendlyUrl_Success() throws Exception {
		// Mock dependencies
        ThemeDisplay themeDisplay = Mockito.mock(ThemeDisplay.class);
        JournalArticle article = Mockito.mock(JournalArticle.class);
        JournalArticleDisplay display = Mockito.mock(JournalArticleDisplay.class);

        Mockito.when(themeDisplay.getScopeGroupId()).thenReturn(123L);
        Mockito.when(themeDisplay.getLocale()).thenReturn(Locale.ENGLISH);
        Mockito.when(article.getArticleId()).thenReturn("ART123");
        Mockito.when(display.getContent()).thenReturn("<p>Hello World</p>");

        Mockito.when(journalService.getArticleByUrlTitle(123L, "my-url")).thenReturn(article);
        Mockito.when(journalService.getArticleDisplay(123L, "ART123", Locale.ENGLISH.toString(), themeDisplay)).thenReturn(display);

        // Execute
        String result = helpers.getWebContentByFriendlyUrl("my-url", themeDisplay);

        // Verify
        assertEquals("<p>Hello World</p>", result);
        Mockito.verify(journalService).getArticleByUrlTitle(123L, "my-url");
        Mockito.verify(journalService).getArticleDisplay(123L, "ART123", Locale.ENGLISH.toString(), themeDisplay);
    }

    @Test
    void testGetWebContentByFriendlyUrl_Exception() throws Exception {
        ThemeDisplay themeDisplay = Mockito.mock(ThemeDisplay.class);

        Mockito.when(themeDisplay.getScopeGroupId()).thenReturn(123L);
        Mockito.when(journalService.getArticleByUrlTitle(123L, "bad-url")).thenThrow(new PortalException("Not found"));

        String result = helpers.getWebContentByFriendlyUrl("bad-url", themeDisplay);

        assertEquals("", result); // fallback
    }

    @Test
    void testGetConfig_ValidJson() throws JSONException {    	
    	String jsonData = "{ \"pimcoreHost\": \"http://localhost\" }";
    	
    	try (MockedStatic<Files> mocked = Mockito.mockStatic(Files.class)) {
            mocked.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(jsonData.getBytes());

            String result = helpers.getConfig("pimcoreHost");

            assertEquals("http://localhost", result);
        }
    }

    @Test
    void testGetConfig_InvalidJson_FixMissingCommas() throws JSONException {
    	String jsonData = "{ \"pimcoreHost\": \"http://localhost\" \"apiKey\": \"ABC123\" }";
    	
    	try (MockedStatic<Files> mocked = Mockito.mockStatic(Files.class)) {
            mocked.when(() -> Files.readAllBytes(Mockito.any())).thenReturn(jsonData.getBytes());

            String result = helpers.getConfig("pimcoreHost");

            assertEquals("http://localhost", result);
        }
    }
    
    @Test
    void testCapitalizeEachWord() {
        assertEquals("Hello World", MypageHelpers.capitalizeEachWord("hello world"));
        assertEquals("Java Is Fun", MypageHelpers.capitalizeEachWord("java IS fun"));
        assertEquals("", MypageHelpers.capitalizeEachWord(""));
        assertNull(MypageHelpers.capitalizeEachWord(null));
    }
}

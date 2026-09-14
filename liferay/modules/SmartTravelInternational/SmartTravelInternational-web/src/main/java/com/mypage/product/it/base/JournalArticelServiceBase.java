package com.mypage.product.it.base;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

public interface JournalArticelServiceBase {
	JournalArticle getArticleByUrlTitle(long groupId, String urlTitle) throws PortalException;
    JournalArticleDisplay getArticleDisplay(long groupId, String articleId, String languageId, ThemeDisplay themeDisplay) throws PortalException;
}

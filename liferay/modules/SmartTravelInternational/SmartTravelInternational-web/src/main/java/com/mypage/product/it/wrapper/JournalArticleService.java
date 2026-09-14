package com.mypage.product.it.wrapper;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.mypage.product.it.base.JournalArticelServiceBase;

public class JournalArticleService implements JournalArticelServiceBase {

	@Override
	public JournalArticle getArticleByUrlTitle(long groupId, String urlTitle) throws PortalException {
		 return JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, urlTitle);
	}

	@Override
	public JournalArticleDisplay getArticleDisplay(long groupId, String articleId, String languageId, ThemeDisplay themeDisplay) throws PortalException {
		return JournalArticleLocalServiceUtil.getArticleDisplay(groupId, articleId, "", themeDisplay.getLocale().toString(), themeDisplay);
	}
}

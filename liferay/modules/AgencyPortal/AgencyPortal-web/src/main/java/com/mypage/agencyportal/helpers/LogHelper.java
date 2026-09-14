package com.mypage.agencyportal.helpers;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class LogHelper<T> {
	private static Log _log = LogFactoryUtil.getLog(LogHelper.class);
    private static ActionHelpers helpers = new ActionHelpers();
	
	public static boolean isLog() {
        return Boolean.valueOf(helpers.getConfig("com.mypage.agent.config.showLog"));
	}

    public void log(T param) {
        if (isLog()) {
        	if (Validator.isNotNull(param) && param.getClass().isArray() && param instanceof StackTraceElement[]) {
        		StackTraceElement[] stackTraceElements = (StackTraceElement[]) param;
        		for (StackTraceElement item : stackTraceElements) {
                    _log.info("Log Info: " + item.toString());
        		}
        	} else {
        		_log.info("Log Info: " + param.toString());
        	}
        }
    }
}
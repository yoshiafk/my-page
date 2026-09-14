package com.mypage.user.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class MypageUserException extends PortalException {
	public static class CreditWalletIdMustNotBeDuplicate extends MypageUserException {
		public CreditWalletIdMustNotBeDuplicate(long userId, long creditWalletId) {
			super(
				String.format(
					"Credit Wallet %s must not be duplicate but is already " +
						"used by MypageUser %s",
						creditWalletId, userId));

			this.userId = userId;
			this.creditWalletId = creditWalletId;
		}

		public final long creditWalletId;
		public final long userId;

	}
	
	private MypageUserException(String msg) {
		super(msg);
	}

	private MypageUserException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}

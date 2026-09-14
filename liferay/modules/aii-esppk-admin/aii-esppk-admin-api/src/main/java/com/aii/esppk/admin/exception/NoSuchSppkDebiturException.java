/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.aii.esppk.admin.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Gositus
 */
public class NoSuchSppkDebiturException extends NoSuchModelException {

	public NoSuchSppkDebiturException() {
	}

	public NoSuchSppkDebiturException(String msg) {
		super(msg);
	}

	public NoSuchSppkDebiturException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSppkDebiturException(Throwable throwable) {
		super(throwable);
	}

}
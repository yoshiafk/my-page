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

package com.mypage.admin.product.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SmartActiveBenefitType service. Represents a row in the &quot;SmartActiveBenefitType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitTypeModel
 * @generated
 */
@ImplementationClassName(
	"com.mypage.admin.product.model.impl.SmartActiveBenefitTypeImpl"
)
@ProviderType
public interface SmartActiveBenefitType
	extends PersistedModel, SmartActiveBenefitTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SmartActiveBenefitType, Long>
		SMART_ACTIVE_BENEFIT_TYPE_ID_ACCESSOR =
			new Accessor<SmartActiveBenefitType, Long>() {

				@Override
				public Long get(SmartActiveBenefitType smartActiveBenefitType) {
					return smartActiveBenefitType.getSmartActiveBenefitTypeId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<SmartActiveBenefitType> getTypeClass() {
					return SmartActiveBenefitType.class;
				}

			};

}
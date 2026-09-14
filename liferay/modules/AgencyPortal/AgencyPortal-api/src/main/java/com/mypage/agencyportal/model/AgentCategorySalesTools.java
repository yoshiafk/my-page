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

package com.mypage.agencyportal.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AgentCategorySalesTools service. Represents a row in the &quot;AP_AgentCategorySalesTools&quot; database table, with each column mapped to a property of this class.
 *
 * @author Gositus Team
 * @see AgentCategorySalesToolsModel
 * @generated
 */
@ImplementationClassName(
	"com.mypage.agencyportal.model.impl.AgentCategorySalesToolsImpl"
)
@ProviderType
public interface AgentCategorySalesTools
	extends AgentCategorySalesToolsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mypage.agencyportal.model.impl.AgentCategorySalesToolsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AgentCategorySalesTools, Long>
		AGENT_CATEGORY_SALES_TOOLS_ID_ACCESSOR =
			new Accessor<AgentCategorySalesTools, Long>() {

				@Override
				public Long get(
					AgentCategorySalesTools agentCategorySalesTools) {

					return agentCategorySalesTools.
						getAgentCategorySalesToolsId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AgentCategorySalesTools> getTypeClass() {
					return AgentCategorySalesTools.class;
				}

			};

}
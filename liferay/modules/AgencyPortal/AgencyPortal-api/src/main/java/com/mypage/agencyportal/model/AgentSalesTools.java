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
 * The extended model interface for the AgentSalesTools service. Represents a row in the &quot;AP_AgentSalesTools&quot; database table, with each column mapped to a property of this class.
 *
 * @author Gositus Team
 * @see AgentSalesToolsModel
 * @generated
 */
@ImplementationClassName(
	"com.mypage.agencyportal.model.impl.AgentSalesToolsImpl"
)
@ProviderType
public interface AgentSalesTools extends AgentSalesToolsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mypage.agencyportal.model.impl.AgentSalesToolsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AgentSalesTools, Long>
		AGENT_SALES_TOOLS_ID_ACCESSOR = new Accessor<AgentSalesTools, Long>() {

			@Override
			public Long get(AgentSalesTools agentSalesTools) {
				return agentSalesTools.getAgentSalesToolsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AgentSalesTools> getTypeClass() {
				return AgentSalesTools.class;
			}

		};

}
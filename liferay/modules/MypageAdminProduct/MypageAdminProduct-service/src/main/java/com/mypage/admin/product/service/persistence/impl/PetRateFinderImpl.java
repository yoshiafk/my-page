package com.mypage.admin.product.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.mypage.admin.product.model.PetRate;
import com.mypage.admin.product.model.impl.PetPlanImpl;
import com.mypage.admin.product.model.impl.PetRateImpl;
import com.mypage.admin.product.model.impl.PetRemarksImpl;
import com.mypage.admin.product.service.persistence.PetRateFinder;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = PetRateFinder.class)
public class PetRateFinderImpl extends PetRateFinderBaseImpl implements PetRateFinder {
	public List<Object[]> getAllPetRateCombinedWithPlanAndRemarks() {
		return null;
	}
	
	@Reference
	private CustomSQL customSQL;
}

package com.mypage.admin.product.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiFinder;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = TravelDomesticPremiFinder.class)
public class TravelDomesticPremiFinderImpl extends TravelDomesticPremiFinderBaseImpl implements TravelDomesticPremiFinder {
	public static final String GET_TRAVEL_DOMESTIC_PREMIS =
			TravelDomesticPremiFinder.class.getName() + ".getTravelDomesticPremis";	
	public List getTravelDomesticPremis(int start, int end) {
		Session session = null;
	
		try {
			session = openSession();
	
			String sql = _customSQL.get(getClass(), GET_TRAVEL_DOMESTIC_PREMIS);
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
//			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);
			
//			sqlQuery.addEntity("TravelDomesticPremi", TravelDomesticPremiImpl.class);
//			sqlQuery.addEntity("TravelDomesticTravellerType", TravelDomesticTravellerTypeImpl.class);
			
			sqlQuery.addScalar("travelDomesticPremiId", Type.INTEGER);
			sqlQuery.addScalar("travellerTypeName", Type.STRING);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

//			return (List) sqlQuery.list();
			return (List) QueryUtil.list(sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
		finally {
			closeSession(session);
		}
	}
	
	@Reference
	private CustomSQL _customSQL;
}

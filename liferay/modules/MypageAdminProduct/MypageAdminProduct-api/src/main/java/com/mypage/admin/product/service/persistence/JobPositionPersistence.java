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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchJobPositionException;
import com.mypage.admin.product.model.JobPosition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see JobPositionUtil
 * @generated
 */
@ProviderType
public interface JobPositionPersistence extends BasePersistence<JobPosition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobPositionUtil} to access the job position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the job position in the entity cache if it is enabled.
	 *
	 * @param jobPosition the job position
	 */
	public void cacheResult(JobPosition jobPosition);

	/**
	 * Caches the job positions in the entity cache if it is enabled.
	 *
	 * @param jobPositions the job positions
	 */
	public void cacheResult(java.util.List<JobPosition> jobPositions);

	/**
	 * Creates a new job position with the primary key. Does not add the job position to the database.
	 *
	 * @param jobPositionId the primary key for the new job position
	 * @return the new job position
	 */
	public JobPosition create(long jobPositionId);

	/**
	 * Removes the job position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position that was removed
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	public JobPosition remove(long jobPositionId)
		throws NoSuchJobPositionException;

	public JobPosition updateImpl(JobPosition jobPosition);

	/**
	 * Returns the job position with the primary key or throws a <code>NoSuchJobPositionException</code> if it could not be found.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position
	 * @throws NoSuchJobPositionException if a job position with the primary key could not be found
	 */
	public JobPosition findByPrimaryKey(long jobPositionId)
		throws NoSuchJobPositionException;

	/**
	 * Returns the job position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position, or <code>null</code> if a job position with the primary key could not be found
	 */
	public JobPosition fetchByPrimaryKey(long jobPositionId);

	/**
	 * Returns all the job positions.
	 *
	 * @return the job positions
	 */
	public java.util.List<JobPosition> findAll();

	/**
	 * Returns a range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @return the range of job positions
	 */
	public java.util.List<JobPosition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job positions
	 */
	public java.util.List<JobPosition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPosition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job positions
	 */
	public java.util.List<JobPosition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobPosition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job positions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job positions.
	 *
	 * @return the number of job positions
	 */
	public int countAll();

}
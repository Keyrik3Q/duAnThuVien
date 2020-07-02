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

package com.thuvien.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.thuvien.model.GiaHan;

import java.util.List;

/**
 * The persistence utility for the gia han service. This utility wraps {@link GiaHanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see GiaHanPersistence
 * @see GiaHanPersistenceImpl
 * @generated
 */
public class GiaHanUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GiaHan giaHan) {
		getPersistence().clearCache(giaHan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GiaHan> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GiaHan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GiaHan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GiaHan update(GiaHan giaHan) throws SystemException {
		return getPersistence().update(giaHan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GiaHan update(GiaHan giaHan, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(giaHan, serviceContext);
	}

	/**
	* Caches the gia han in the entity cache if it is enabled.
	*
	* @param giaHan the gia han
	*/
	public static void cacheResult(com.thuvien.model.GiaHan giaHan) {
		getPersistence().cacheResult(giaHan);
	}

	/**
	* Caches the gia hans in the entity cache if it is enabled.
	*
	* @param giaHans the gia hans
	*/
	public static void cacheResult(
		java.util.List<com.thuvien.model.GiaHan> giaHans) {
		getPersistence().cacheResult(giaHans);
	}

	/**
	* Creates a new gia han with the primary key. Does not add the gia han to the database.
	*
	* @param IdGh the primary key for the new gia han
	* @return the new gia han
	*/
	public static com.thuvien.model.GiaHan create(long IdGh) {
		return getPersistence().create(IdGh);
	}

	/**
	* Removes the gia han with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han that was removed
	* @throws com.thuvien.NoSuchGiaHanException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.GiaHan remove(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchGiaHanException {
		return getPersistence().remove(IdGh);
	}

	public static com.thuvien.model.GiaHan updateImpl(
		com.thuvien.model.GiaHan giaHan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(giaHan);
	}

	/**
	* Returns the gia han with the primary key or throws a {@link com.thuvien.NoSuchGiaHanException} if it could not be found.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han
	* @throws com.thuvien.NoSuchGiaHanException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.GiaHan findByPrimaryKey(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchGiaHanException {
		return getPersistence().findByPrimaryKey(IdGh);
	}

	/**
	* Returns the gia han with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han, or <code>null</code> if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.GiaHan fetchByPrimaryKey(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(IdGh);
	}

	/**
	* Returns all the gia hans.
	*
	* @return the gia hans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.GiaHan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the gia hans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.GiaHanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gia hans
	* @param end the upper bound of the range of gia hans (not inclusive)
	* @return the range of gia hans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.GiaHan> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the gia hans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.GiaHanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gia hans
	* @param end the upper bound of the range of gia hans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gia hans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.GiaHan> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the gia hans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gia hans.
	*
	* @return the number of gia hans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GiaHanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GiaHanPersistence)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					GiaHanPersistence.class.getName());

			ReferenceRegistry.registerReference(GiaHanUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GiaHanPersistence persistence) {
	}

	private static GiaHanPersistence _persistence;
}
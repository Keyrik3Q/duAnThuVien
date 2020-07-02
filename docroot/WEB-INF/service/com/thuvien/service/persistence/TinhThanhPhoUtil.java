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

import com.thuvien.model.TinhThanhPho;

import java.util.List;

/**
 * The persistence utility for the tinh thanh pho service. This utility wraps {@link TinhThanhPhoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see TinhThanhPhoPersistence
 * @see TinhThanhPhoPersistenceImpl
 * @generated
 */
public class TinhThanhPhoUtil {
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
	public static void clearCache(TinhThanhPho tinhThanhPho) {
		getPersistence().clearCache(tinhThanhPho);
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
	public static List<TinhThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TinhThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TinhThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TinhThanhPho update(TinhThanhPho tinhThanhPho)
		throws SystemException {
		return getPersistence().update(tinhThanhPho);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TinhThanhPho update(TinhThanhPho tinhThanhPho,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tinhThanhPho, serviceContext);
	}

	/**
	* Caches the tinh thanh pho in the entity cache if it is enabled.
	*
	* @param tinhThanhPho the tinh thanh pho
	*/
	public static void cacheResult(com.thuvien.model.TinhThanhPho tinhThanhPho) {
		getPersistence().cacheResult(tinhThanhPho);
	}

	/**
	* Caches the tinh thanh phos in the entity cache if it is enabled.
	*
	* @param tinhThanhPhos the tinh thanh phos
	*/
	public static void cacheResult(
		java.util.List<com.thuvien.model.TinhThanhPho> tinhThanhPhos) {
		getPersistence().cacheResult(tinhThanhPhos);
	}

	/**
	* Creates a new tinh thanh pho with the primary key. Does not add the tinh thanh pho to the database.
	*
	* @param name the primary key for the new tinh thanh pho
	* @return the new tinh thanh pho
	*/
	public static com.thuvien.model.TinhThanhPho create(long name) {
		return getPersistence().create(name);
	}

	/**
	* Removes the tinh thanh pho with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho that was removed
	* @throws com.thuvien.NoSuchTinhThanhPhoException if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.TinhThanhPho remove(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchTinhThanhPhoException {
		return getPersistence().remove(name);
	}

	public static com.thuvien.model.TinhThanhPho updateImpl(
		com.thuvien.model.TinhThanhPho tinhThanhPho)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tinhThanhPho);
	}

	/**
	* Returns the tinh thanh pho with the primary key or throws a {@link com.thuvien.NoSuchTinhThanhPhoException} if it could not be found.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho
	* @throws com.thuvien.NoSuchTinhThanhPhoException if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.TinhThanhPho findByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchTinhThanhPhoException {
		return getPersistence().findByPrimaryKey(name);
	}

	/**
	* Returns the tinh thanh pho with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho, or <code>null</code> if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.TinhThanhPho fetchByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(name);
	}

	/**
	* Returns all the tinh thanh phos.
	*
	* @return the tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.TinhThanhPho> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tinh thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.TinhThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tinh thanh phos
	* @param end the upper bound of the range of tinh thanh phos (not inclusive)
	* @return the range of tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.TinhThanhPho> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tinh thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.TinhThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tinh thanh phos
	* @param end the upper bound of the range of tinh thanh phos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.TinhThanhPho> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tinh thanh phos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tinh thanh phos.
	*
	* @return the number of tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TinhThanhPhoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TinhThanhPhoPersistence)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					TinhThanhPhoPersistence.class.getName());

			ReferenceRegistry.registerReference(TinhThanhPhoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TinhThanhPhoPersistence persistence) {
	}

	private static TinhThanhPhoPersistence _persistence;
}
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

import com.thuvien.model.PhuongThanhPho;

import java.util.List;

/**
 * The persistence utility for the phuong thanh pho service. This utility wraps {@link PhuongThanhPhoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see PhuongThanhPhoPersistence
 * @see PhuongThanhPhoPersistenceImpl
 * @generated
 */
public class PhuongThanhPhoUtil {
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
	public static void clearCache(PhuongThanhPho phuongThanhPho) {
		getPersistence().clearCache(phuongThanhPho);
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
	public static List<PhuongThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhuongThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhuongThanhPho> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PhuongThanhPho update(PhuongThanhPho phuongThanhPho)
		throws SystemException {
		return getPersistence().update(phuongThanhPho);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PhuongThanhPho update(PhuongThanhPho phuongThanhPho,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(phuongThanhPho, serviceContext);
	}

	/**
	* Caches the phuong thanh pho in the entity cache if it is enabled.
	*
	* @param phuongThanhPho the phuong thanh pho
	*/
	public static void cacheResult(
		com.thuvien.model.PhuongThanhPho phuongThanhPho) {
		getPersistence().cacheResult(phuongThanhPho);
	}

	/**
	* Caches the phuong thanh phos in the entity cache if it is enabled.
	*
	* @param phuongThanhPhos the phuong thanh phos
	*/
	public static void cacheResult(
		java.util.List<com.thuvien.model.PhuongThanhPho> phuongThanhPhos) {
		getPersistence().cacheResult(phuongThanhPhos);
	}

	/**
	* Creates a new phuong thanh pho with the primary key. Does not add the phuong thanh pho to the database.
	*
	* @param name the primary key for the new phuong thanh pho
	* @return the new phuong thanh pho
	*/
	public static com.thuvien.model.PhuongThanhPho create(long name) {
		return getPersistence().create(name);
	}

	/**
	* Removes the phuong thanh pho with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho that was removed
	* @throws com.thuvien.NoSuchPhuongThanhPhoException if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.PhuongThanhPho remove(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchPhuongThanhPhoException {
		return getPersistence().remove(name);
	}

	public static com.thuvien.model.PhuongThanhPho updateImpl(
		com.thuvien.model.PhuongThanhPho phuongThanhPho)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(phuongThanhPho);
	}

	/**
	* Returns the phuong thanh pho with the primary key or throws a {@link com.thuvien.NoSuchPhuongThanhPhoException} if it could not be found.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho
	* @throws com.thuvien.NoSuchPhuongThanhPhoException if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.PhuongThanhPho findByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchPhuongThanhPhoException {
		return getPersistence().findByPrimaryKey(name);
	}

	/**
	* Returns the phuong thanh pho with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho, or <code>null</code> if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.thuvien.model.PhuongThanhPho fetchByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(name);
	}

	/**
	* Returns all the phuong thanh phos.
	*
	* @return the phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.PhuongThanhPho> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the phuong thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.PhuongThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phuong thanh phos
	* @param end the upper bound of the range of phuong thanh phos (not inclusive)
	* @return the range of phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.PhuongThanhPho> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the phuong thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.PhuongThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of phuong thanh phos
	* @param end the upper bound of the range of phuong thanh phos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.thuvien.model.PhuongThanhPho> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the phuong thanh phos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of phuong thanh phos.
	*
	* @return the number of phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PhuongThanhPhoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PhuongThanhPhoPersistence)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					PhuongThanhPhoPersistence.class.getName());

			ReferenceRegistry.registerReference(PhuongThanhPhoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PhuongThanhPhoPersistence persistence) {
	}

	private static PhuongThanhPhoPersistence _persistence;
}
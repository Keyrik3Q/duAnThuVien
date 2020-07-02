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

import com.liferay.portal.service.persistence.BasePersistence;

import com.thuvien.model.QuanThanhPho;

/**
 * The persistence interface for the quan thanh pho service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see QuanThanhPhoPersistenceImpl
 * @see QuanThanhPhoUtil
 * @generated
 */
public interface QuanThanhPhoPersistence extends BasePersistence<QuanThanhPho> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuanThanhPhoUtil} to access the quan thanh pho persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the quan thanh pho in the entity cache if it is enabled.
	*
	* @param quanThanhPho the quan thanh pho
	*/
	public void cacheResult(com.thuvien.model.QuanThanhPho quanThanhPho);

	/**
	* Caches the quan thanh phos in the entity cache if it is enabled.
	*
	* @param quanThanhPhos the quan thanh phos
	*/
	public void cacheResult(
		java.util.List<com.thuvien.model.QuanThanhPho> quanThanhPhos);

	/**
	* Creates a new quan thanh pho with the primary key. Does not add the quan thanh pho to the database.
	*
	* @param name the primary key for the new quan thanh pho
	* @return the new quan thanh pho
	*/
	public com.thuvien.model.QuanThanhPho create(long name);

	/**
	* Removes the quan thanh pho with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the quan thanh pho
	* @return the quan thanh pho that was removed
	* @throws com.thuvien.NoSuchQuanThanhPhoException if a quan thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.QuanThanhPho remove(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchQuanThanhPhoException;

	public com.thuvien.model.QuanThanhPho updateImpl(
		com.thuvien.model.QuanThanhPho quanThanhPho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the quan thanh pho with the primary key or throws a {@link com.thuvien.NoSuchQuanThanhPhoException} if it could not be found.
	*
	* @param name the primary key of the quan thanh pho
	* @return the quan thanh pho
	* @throws com.thuvien.NoSuchQuanThanhPhoException if a quan thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.QuanThanhPho findByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchQuanThanhPhoException;

	/**
	* Returns the quan thanh pho with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param name the primary key of the quan thanh pho
	* @return the quan thanh pho, or <code>null</code> if a quan thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.QuanThanhPho fetchByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the quan thanh phos.
	*
	* @return the quan thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.QuanThanhPho> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the quan thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.QuanThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of quan thanh phos
	* @param end the upper bound of the range of quan thanh phos (not inclusive)
	* @return the range of quan thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.QuanThanhPho> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the quan thanh phos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.QuanThanhPhoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of quan thanh phos
	* @param end the upper bound of the range of quan thanh phos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of quan thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.QuanThanhPho> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the quan thanh phos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of quan thanh phos.
	*
	* @return the number of quan thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
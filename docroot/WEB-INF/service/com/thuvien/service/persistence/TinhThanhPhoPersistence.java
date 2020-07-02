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

import com.thuvien.model.TinhThanhPho;

/**
 * The persistence interface for the tinh thanh pho service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see TinhThanhPhoPersistenceImpl
 * @see TinhThanhPhoUtil
 * @generated
 */
public interface TinhThanhPhoPersistence extends BasePersistence<TinhThanhPho> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TinhThanhPhoUtil} to access the tinh thanh pho persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tinh thanh pho in the entity cache if it is enabled.
	*
	* @param tinhThanhPho the tinh thanh pho
	*/
	public void cacheResult(com.thuvien.model.TinhThanhPho tinhThanhPho);

	/**
	* Caches the tinh thanh phos in the entity cache if it is enabled.
	*
	* @param tinhThanhPhos the tinh thanh phos
	*/
	public void cacheResult(
		java.util.List<com.thuvien.model.TinhThanhPho> tinhThanhPhos);

	/**
	* Creates a new tinh thanh pho with the primary key. Does not add the tinh thanh pho to the database.
	*
	* @param name the primary key for the new tinh thanh pho
	* @return the new tinh thanh pho
	*/
	public com.thuvien.model.TinhThanhPho create(long name);

	/**
	* Removes the tinh thanh pho with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho that was removed
	* @throws com.thuvien.NoSuchTinhThanhPhoException if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.TinhThanhPho remove(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchTinhThanhPhoException;

	public com.thuvien.model.TinhThanhPho updateImpl(
		com.thuvien.model.TinhThanhPho tinhThanhPho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tinh thanh pho with the primary key or throws a {@link com.thuvien.NoSuchTinhThanhPhoException} if it could not be found.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho
	* @throws com.thuvien.NoSuchTinhThanhPhoException if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.TinhThanhPho findByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchTinhThanhPhoException;

	/**
	* Returns the tinh thanh pho with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param name the primary key of the tinh thanh pho
	* @return the tinh thanh pho, or <code>null</code> if a tinh thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.TinhThanhPho fetchByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tinh thanh phos.
	*
	* @return the tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.TinhThanhPho> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.TinhThanhPho> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.TinhThanhPho> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tinh thanh phos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tinh thanh phos.
	*
	* @return the number of tinh thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
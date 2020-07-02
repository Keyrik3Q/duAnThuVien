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

import com.thuvien.model.PhuongThanhPho;

/**
 * The persistence interface for the phuong thanh pho service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see PhuongThanhPhoPersistenceImpl
 * @see PhuongThanhPhoUtil
 * @generated
 */
public interface PhuongThanhPhoPersistence extends BasePersistence<PhuongThanhPho> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhuongThanhPhoUtil} to access the phuong thanh pho persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the phuong thanh pho in the entity cache if it is enabled.
	*
	* @param phuongThanhPho the phuong thanh pho
	*/
	public void cacheResult(com.thuvien.model.PhuongThanhPho phuongThanhPho);

	/**
	* Caches the phuong thanh phos in the entity cache if it is enabled.
	*
	* @param phuongThanhPhos the phuong thanh phos
	*/
	public void cacheResult(
		java.util.List<com.thuvien.model.PhuongThanhPho> phuongThanhPhos);

	/**
	* Creates a new phuong thanh pho with the primary key. Does not add the phuong thanh pho to the database.
	*
	* @param name the primary key for the new phuong thanh pho
	* @return the new phuong thanh pho
	*/
	public com.thuvien.model.PhuongThanhPho create(long name);

	/**
	* Removes the phuong thanh pho with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho that was removed
	* @throws com.thuvien.NoSuchPhuongThanhPhoException if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.PhuongThanhPho remove(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchPhuongThanhPhoException;

	public com.thuvien.model.PhuongThanhPho updateImpl(
		com.thuvien.model.PhuongThanhPho phuongThanhPho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the phuong thanh pho with the primary key or throws a {@link com.thuvien.NoSuchPhuongThanhPhoException} if it could not be found.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho
	* @throws com.thuvien.NoSuchPhuongThanhPhoException if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.PhuongThanhPho findByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchPhuongThanhPhoException;

	/**
	* Returns the phuong thanh pho with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param name the primary key of the phuong thanh pho
	* @return the phuong thanh pho, or <code>null</code> if a phuong thanh pho with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.PhuongThanhPho fetchByPrimaryKey(long name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the phuong thanh phos.
	*
	* @return the phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.PhuongThanhPho> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.PhuongThanhPho> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.PhuongThanhPho> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the phuong thanh phos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of phuong thanh phos.
	*
	* @return the number of phuong thanh phos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
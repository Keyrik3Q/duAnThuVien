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

import com.thuvien.model.GiaHan;

/**
 * The persistence interface for the gia han service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ADMIN
 * @see GiaHanPersistenceImpl
 * @see GiaHanUtil
 * @generated
 */
public interface GiaHanPersistence extends BasePersistence<GiaHan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GiaHanUtil} to access the gia han persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the gia han in the entity cache if it is enabled.
	*
	* @param giaHan the gia han
	*/
	public void cacheResult(com.thuvien.model.GiaHan giaHan);

	/**
	* Caches the gia hans in the entity cache if it is enabled.
	*
	* @param giaHans the gia hans
	*/
	public void cacheResult(java.util.List<com.thuvien.model.GiaHan> giaHans);

	/**
	* Creates a new gia han with the primary key. Does not add the gia han to the database.
	*
	* @param IdGh the primary key for the new gia han
	* @return the new gia han
	*/
	public com.thuvien.model.GiaHan create(long IdGh);

	/**
	* Removes the gia han with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han that was removed
	* @throws com.thuvien.NoSuchGiaHanException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.GiaHan remove(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchGiaHanException;

	public com.thuvien.model.GiaHan updateImpl(com.thuvien.model.GiaHan giaHan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gia han with the primary key or throws a {@link com.thuvien.NoSuchGiaHanException} if it could not be found.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han
	* @throws com.thuvien.NoSuchGiaHanException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.GiaHan findByPrimaryKey(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.thuvien.NoSuchGiaHanException;

	/**
	* Returns the gia han with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han, or <code>null</code> if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.thuvien.model.GiaHan fetchByPrimaryKey(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the gia hans.
	*
	* @return the gia hans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.thuvien.model.GiaHan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.GiaHan> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.thuvien.model.GiaHan> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the gia hans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of gia hans.
	*
	* @return the number of gia hans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
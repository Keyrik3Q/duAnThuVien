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

package com.thuvien.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GiaHanLocalService}.
 *
 * @author ADMIN
 * @see GiaHanLocalService
 * @generated
 */
public class GiaHanLocalServiceWrapper implements GiaHanLocalService,
	ServiceWrapper<GiaHanLocalService> {
	public GiaHanLocalServiceWrapper(GiaHanLocalService giaHanLocalService) {
		_giaHanLocalService = giaHanLocalService;
	}

	/**
	* Adds the gia han to the database. Also notifies the appropriate model listeners.
	*
	* @param giaHan the gia han
	* @return the gia han that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.GiaHan addGiaHan(com.thuvien.model.GiaHan giaHan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.addGiaHan(giaHan);
	}

	/**
	* Creates a new gia han with the primary key. Does not add the gia han to the database.
	*
	* @param IdGh the primary key for the new gia han
	* @return the new gia han
	*/
	@Override
	public com.thuvien.model.GiaHan createGiaHan(long IdGh) {
		return _giaHanLocalService.createGiaHan(IdGh);
	}

	/**
	* Deletes the gia han with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han that was removed
	* @throws PortalException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.GiaHan deleteGiaHan(long IdGh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.deleteGiaHan(IdGh);
	}

	/**
	* Deletes the gia han from the database. Also notifies the appropriate model listeners.
	*
	* @param giaHan the gia han
	* @return the gia han that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.GiaHan deleteGiaHan(
		com.thuvien.model.GiaHan giaHan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.deleteGiaHan(giaHan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _giaHanLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.GiaHanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.GiaHanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.thuvien.model.GiaHan fetchGiaHan(long IdGh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.fetchGiaHan(IdGh);
	}

	/**
	* Returns the gia han with the primary key.
	*
	* @param IdGh the primary key of the gia han
	* @return the gia han
	* @throws PortalException if a gia han with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.GiaHan getGiaHan(long IdGh)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.getGiaHan(IdGh);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.thuvien.model.GiaHan> getGiaHans(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.getGiaHans(start, end);
	}

	/**
	* Returns the number of gia hans.
	*
	* @return the number of gia hans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGiaHansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.getGiaHansCount();
	}

	/**
	* Updates the gia han in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param giaHan the gia han
	* @return the gia han that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.GiaHan updateGiaHan(
		com.thuvien.model.GiaHan giaHan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.updateGiaHan(giaHan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _giaHanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_giaHanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _giaHanLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.lang.Object[]> findGiaHans(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.findGiaHans(userid, name, ngaymuon, ngaytra,
			Start, ketThuc);
	}

	@Override
	public java.util.List<java.lang.Object[]> findLichSus(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.findLichSus(userid, name, ngaymuon, ngaytra,
			Start, ketThuc);
	}

	@Override
	public long countGiaHans(java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.countGiaHans(userid, name, ngaymuon, ngaytra);
	}

	@Override
	public long countTongs(java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.countTongs(name, ngaymuon, ngaytra);
	}

	@Override
	public long countLichSus(java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.countLichSus(userid, name, ngaymuon, ngaytra);
	}

	@Override
	public java.util.List<java.lang.Object[]> findGiaHanDSs(
		java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.findGiaHanDSs(name, ngaymuon, ngaytra,
			Start, ketThuc);
	}

	@Override
	public long countGiaHanDSs(java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _giaHanLocalService.countGiaHanDSs(name, ngaymuon, ngaytra);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GiaHanLocalService getWrappedGiaHanLocalService() {
		return _giaHanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGiaHanLocalService(
		GiaHanLocalService giaHanLocalService) {
		_giaHanLocalService = giaHanLocalService;
	}

	@Override
	public GiaHanLocalService getWrappedService() {
		return _giaHanLocalService;
	}

	@Override
	public void setWrappedService(GiaHanLocalService giaHanLocalService) {
		_giaHanLocalService = giaHanLocalService;
	}

	private GiaHanLocalService _giaHanLocalService;
}
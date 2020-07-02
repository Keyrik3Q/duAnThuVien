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
 * Provides a wrapper for {@link TheLoaiLocalService}.
 *
 * @author ADMIN
 * @see TheLoaiLocalService
 * @generated
 */
public class TheLoaiLocalServiceWrapper implements TheLoaiLocalService,
	ServiceWrapper<TheLoaiLocalService> {
	public TheLoaiLocalServiceWrapper(TheLoaiLocalService theLoaiLocalService) {
		_theLoaiLocalService = theLoaiLocalService;
	}

	/**
	* Adds the the loai to the database. Also notifies the appropriate model listeners.
	*
	* @param theLoai the the loai
	* @return the the loai that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.TheLoai addTheLoai(
		com.thuvien.model.TheLoai theLoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.addTheLoai(theLoai);
	}

	/**
	* Creates a new the loai with the primary key. Does not add the the loai to the database.
	*
	* @param Id the primary key for the new the loai
	* @return the new the loai
	*/
	@Override
	public com.thuvien.model.TheLoai createTheLoai(long Id) {
		return _theLoaiLocalService.createTheLoai(Id);
	}

	/**
	* Deletes the the loai with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the the loai
	* @return the the loai that was removed
	* @throws PortalException if a the loai with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.TheLoai deleteTheLoai(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.deleteTheLoai(Id);
	}

	/**
	* Deletes the the loai from the database. Also notifies the appropriate model listeners.
	*
	* @param theLoai the the loai
	* @return the the loai that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.TheLoai deleteTheLoai(
		com.thuvien.model.TheLoai theLoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.deleteTheLoai(theLoai);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _theLoaiLocalService.dynamicQuery();
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
		return _theLoaiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _theLoaiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _theLoaiLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _theLoaiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _theLoaiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.thuvien.model.TheLoai fetchTheLoai(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.fetchTheLoai(Id);
	}

	/**
	* Returns the the loai with the primary key.
	*
	* @param Id the primary key of the the loai
	* @return the the loai
	* @throws PortalException if a the loai with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.TheLoai getTheLoai(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.getTheLoai(Id);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the the loais.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.thuvien.model.impl.TheLoaiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of the loais
	* @param end the upper bound of the range of the loais (not inclusive)
	* @return the range of the loais
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.thuvien.model.TheLoai> getTheLoais(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.getTheLoais(start, end);
	}

	/**
	* Returns the number of the loais.
	*
	* @return the number of the loais
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTheLoaisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.getTheLoaisCount();
	}

	/**
	* Updates the the loai in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param theLoai the the loai
	* @return the the loai that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.thuvien.model.TheLoai updateTheLoai(
		com.thuvien.model.TheLoai theLoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.updateTheLoai(theLoai);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _theLoaiLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_theLoaiLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _theLoaiLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.lang.Object[]> findTheLoais(
		java.lang.String name, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.findTheLoais(name, Start, ketThuc);
	}

	@Override
	public long countTheLoais(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _theLoaiLocalService.countTheLoais(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TheLoaiLocalService getWrappedTheLoaiLocalService() {
		return _theLoaiLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTheLoaiLocalService(
		TheLoaiLocalService theLoaiLocalService) {
		_theLoaiLocalService = theLoaiLocalService;
	}

	@Override
	public TheLoaiLocalService getWrappedService() {
		return _theLoaiLocalService;
	}

	@Override
	public void setWrappedService(TheLoaiLocalService theLoaiLocalService) {
		_theLoaiLocalService = theLoaiLocalService;
	}

	private TheLoaiLocalService _theLoaiLocalService;
}
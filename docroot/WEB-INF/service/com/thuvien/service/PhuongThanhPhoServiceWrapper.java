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
 * Provides a wrapper for {@link PhuongThanhPhoService}.
 *
 * @author ADMIN
 * @see PhuongThanhPhoService
 * @generated
 */
public class PhuongThanhPhoServiceWrapper implements PhuongThanhPhoService,
	ServiceWrapper<PhuongThanhPhoService> {
	public PhuongThanhPhoServiceWrapper(
		PhuongThanhPhoService phuongThanhPhoService) {
		_phuongThanhPhoService = phuongThanhPhoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _phuongThanhPhoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_phuongThanhPhoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _phuongThanhPhoService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PhuongThanhPhoService getWrappedPhuongThanhPhoService() {
		return _phuongThanhPhoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPhuongThanhPhoService(
		PhuongThanhPhoService phuongThanhPhoService) {
		_phuongThanhPhoService = phuongThanhPhoService;
	}

	@Override
	public PhuongThanhPhoService getWrappedService() {
		return _phuongThanhPhoService;
	}

	@Override
	public void setWrappedService(PhuongThanhPhoService phuongThanhPhoService) {
		_phuongThanhPhoService = phuongThanhPhoService;
	}

	private PhuongThanhPhoService _phuongThanhPhoService;
}
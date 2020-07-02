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

package com.thuvien.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import com.thuvien.service.base.TheLoaiLocalServiceBaseImpl;
import com.thuvien.service.persistence.TheLoaiFinderUtil;

/**
 * The implementation of the the loai local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link liferay.thuvien.service.TheLoaiLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ADMIN
 * @see liferay.thuvien.service.base.TheLoaiLocalServiceBaseImpl
 * @see liferay.thuvien.service.TheLoaiLocalServiceUtil
 */
public class TheLoaiLocalServiceImpl extends TheLoaiLocalServiceBaseImpl {
	public List<Object[]> findTheLoais(String name, int Start, int ketThuc) throws SystemException {
		return TheLoaiFinderUtil.findTheLoais(name , Start, ketThuc);
	}
	public long countTheLoais(String name) throws SystemException{
		return TheLoaiFinderUtil.countTheLoais(name);
	}
}
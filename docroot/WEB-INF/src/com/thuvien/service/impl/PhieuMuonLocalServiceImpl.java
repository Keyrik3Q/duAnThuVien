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
import com.thuvien.service.base.PhieuMuonLocalServiceBaseImpl;
import com.thuvien.service.persistence.PhieuMuonFinderUtil;

/**
 * The implementation of the phieu muon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link liferay.thuvien.service.PhieuMuonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ADMIN
 * @see liferay.thuvien.service.base.PhieuMuonLocalServiceBaseImpl
 * @see liferay.thuvien.service.PhieuMuonLocalServiceUtil
 */
public class PhieuMuonLocalServiceImpl extends PhieuMuonLocalServiceBaseImpl {
	public List<Object[]> findBaoCaos(String ngaydau, String ngaycuoi,int Start, int ketThuc) throws SystemException {
		return PhieuMuonFinderUtil.findBaoCaos(ngaydau, ngaycuoi, Start, ketThuc);
	}
	public long countPhieuMuons(String ngaydau, String ngaycuoi) throws SystemException{
		return PhieuMuonFinderUtil.countPhieuMuons(ngaydau, ngaycuoi);
	}
	
	public List<Object[]> findTraSachs(String name, int Start, int ketThuc) throws SystemException {
		return PhieuMuonFinderUtil.findTraSachs(name, Start, ketThuc);
	}
	
	public long countTraSachs(String name) throws SystemException{
		return PhieuMuonFinderUtil.countTraSachs(name);
	}
}
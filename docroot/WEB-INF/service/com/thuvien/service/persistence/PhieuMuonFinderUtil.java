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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author ADMIN
 */
public class PhieuMuonFinderUtil {
	public static java.util.List<java.lang.Object[]> findBaoCaos(
		java.lang.String ngaydau, java.lang.String ngaycuoi, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findBaoCaos(ngaydau, ngaycuoi, Start, ketThuc);
	}

	public static long countPhieuMuons(java.lang.String ngaydau,
		java.lang.String ngaycuoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countPhieuMuons(ngaydau, ngaycuoi);
	}

	public static java.util.List<java.lang.Object[]> findTraSachs(
		java.lang.String name, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findTraSachs(name, Start, ketThuc);
	}

	public static long countTraSachs(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countTraSachs(name);
	}

	public static java.util.List<java.lang.Object[]> findThanhPhos(int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findThanhPhos(Start, ketThuc);
	}

	public static PhieuMuonFinder getFinder() {
		if (_finder == null) {
			_finder = (PhieuMuonFinder)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					PhieuMuonFinder.class.getName());

			ReferenceRegistry.registerReference(PhieuMuonFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PhieuMuonFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PhieuMuonFinderUtil.class, "_finder");
	}

	private static PhieuMuonFinder _finder;
}
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
public class GiaHanFinderUtil {
	public static java.util.List<java.lang.Object[]> findGiaHans(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findGiaHans(userid, name, ngaymuon, ngaytra, Start, ketThuc);
	}

	public static long countGiaHans(java.lang.String userid,
		java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countGiaHans(userid, name, ngaymuon, ngaytra);
	}

	public static long countTongs(java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countTongs(name, ngaymuon, ngaytra);
	}

	public static java.util.List<java.lang.Object[]> findLichSus(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findLichSus(userid, name, ngaymuon, ngaytra, Start, ketThuc);
	}

	public static long countLichSus(java.lang.String userid,
		java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countLichSus(userid, name, ngaymuon, ngaytra);
	}

	public static java.util.List<java.lang.Object[]> findGiaHanDSs(
		java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findGiaHanDSs(name, ngaymuon, ngaytra, Start, ketThuc);
	}

	public static long countGiaHanDSs(java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countGiaHanDSs(name, ngaymuon, ngaytra);
	}

	public static GiaHanFinder getFinder() {
		if (_finder == null) {
			_finder = (GiaHanFinder)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					GiaHanFinder.class.getName());

			ReferenceRegistry.registerReference(GiaHanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GiaHanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GiaHanFinderUtil.class, "_finder");
	}

	private static GiaHanFinder _finder;
}
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
public class SachFinderUtil {
	public static java.util.List<java.lang.Object[]> findSachs(
		java.lang.String name, java.lang.String masach, long theloai,
		int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findSachs(name, masach, theloai, Start, ketThuc);
	}

	public static long countSachs(java.lang.String name,
		java.lang.String masach, long theloai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countSachs(name, masach, theloai);
	}

	public static java.util.List<java.lang.Object[]> findMuonSachs(
		java.lang.String name, java.lang.String masach, long[] theloai,
		int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findMuonSachs(name, masach, theloai, Start, ketThuc);
	}

	public static long countMuonSachs(java.lang.String name,
		java.lang.String masach, long[] theloai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countMuonSachs(name, masach, theloai);
	}

	public static SachFinder getFinder() {
		if (_finder == null) {
			_finder = (SachFinder)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					SachFinder.class.getName());

			ReferenceRegistry.registerReference(SachFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(SachFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SachFinderUtil.class, "_finder");
	}

	private static SachFinder _finder;
}
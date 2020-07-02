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
public class TheLoaiFinderUtil {
	public static java.util.List<java.lang.Object[]> findTheLoais(
		java.lang.String name, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findTheLoais(name, Start, ketThuc);
	}

	public static long countTheLoais(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countTheLoais(name);
	}

	public static TheLoaiFinder getFinder() {
		if (_finder == null) {
			_finder = (TheLoaiFinder)PortletBeanLocatorUtil.locate(com.thuvien.service.ClpSerializer.getServletContextName(),
					TheLoaiFinder.class.getName());

			ReferenceRegistry.registerReference(TheLoaiFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TheLoaiFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TheLoaiFinderUtil.class, "_finder");
	}

	private static TheLoaiFinder _finder;
}
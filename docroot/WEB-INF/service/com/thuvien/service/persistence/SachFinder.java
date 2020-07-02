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

/**
 * @author ADMIN
 */
public interface SachFinder {
	public java.util.List<java.lang.Object[]> findSachs(java.lang.String name,
		java.lang.String masach, long theloai, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countSachs(java.lang.String name, java.lang.String masach,
		long theloai)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> findMuonSachs(
		java.lang.String name, java.lang.String masach, long[] theloai,
		int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countMuonSachs(java.lang.String name, java.lang.String masach,
		long[] theloai)
		throws com.liferay.portal.kernel.exception.SystemException;
}
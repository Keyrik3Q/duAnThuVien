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
public interface GiaHanFinder {
	public java.util.List<java.lang.Object[]> findGiaHans(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException;

	public long countGiaHans(java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countTongs(java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> findLichSus(
		java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException;

	public long countLichSus(java.lang.String userid, java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> findGiaHanDSs(
		java.lang.String name, java.lang.String ngaymuon,
		java.lang.String ngaytra, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countGiaHanDSs(java.lang.String name,
		java.lang.String ngaymuon, java.lang.String ngaytra)
		throws com.liferay.portal.kernel.exception.SystemException;
}
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
public interface PhieuMuonFinder {
	public java.util.List<java.lang.Object[]> findBaoCaos(
		java.lang.String ngaydau, java.lang.String ngaycuoi, int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException;

	public long countPhieuMuons(java.lang.String ngaydau,
		java.lang.String ngaycuoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> findTraSachs(
		java.lang.String name, int Start, int ketThuc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countTraSachs(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> findThanhPhos(int Start,
		int ketThuc) throws com.liferay.portal.kernel.exception.SystemException;
}
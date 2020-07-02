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

package com.thuvien.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.thuvien.model.GiaHan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GiaHan in entity cache.
 *
 * @author ADMIN
 * @see GiaHan
 * @generated
 */
public class GiaHanCacheModel implements CacheModel<GiaHan>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{IdGh=");
		sb.append(IdGh);
		sb.append(", NgayGianHan=");
		sb.append(NgayGianHan);
		sb.append(", PhieuMuonId=");
		sb.append(PhieuMuonId);
		sb.append(", TrangThai=");
		sb.append(TrangThai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GiaHan toEntityModel() {
		GiaHanImpl giaHanImpl = new GiaHanImpl();

		giaHanImpl.setIdGh(IdGh);

		if (NgayGianHan == Long.MIN_VALUE) {
			giaHanImpl.setNgayGianHan(null);
		}
		else {
			giaHanImpl.setNgayGianHan(new Date(NgayGianHan));
		}

		giaHanImpl.setPhieuMuonId(PhieuMuonId);

		if (TrangThai == null) {
			giaHanImpl.setTrangThai(StringPool.BLANK);
		}
		else {
			giaHanImpl.setTrangThai(TrangThai);
		}

		giaHanImpl.resetOriginalValues();

		return giaHanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		IdGh = objectInput.readLong();
		NgayGianHan = objectInput.readLong();
		PhieuMuonId = objectInput.readLong();
		TrangThai = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(IdGh);
		objectOutput.writeLong(NgayGianHan);
		objectOutput.writeLong(PhieuMuonId);

		if (TrangThai == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TrangThai);
		}
	}

	public long IdGh;
	public long NgayGianHan;
	public long PhieuMuonId;
	public String TrangThai;
}
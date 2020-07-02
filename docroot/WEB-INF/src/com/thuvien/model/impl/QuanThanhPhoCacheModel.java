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

import com.thuvien.model.QuanThanhPho;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuanThanhPho in entity cache.
 *
 * @author ADMIN
 * @see QuanThanhPho
 * @generated
 */
public class QuanThanhPhoCacheModel implements CacheModel<QuanThanhPho>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{name=");
		sb.append(name);
		sb.append(", Type=");
		sb.append(Type);
		sb.append(", TinhThanhPhoId=");
		sb.append(TinhThanhPhoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuanThanhPho toEntityModel() {
		QuanThanhPhoImpl quanThanhPhoImpl = new QuanThanhPhoImpl();

		quanThanhPhoImpl.setName(name);

		if (Type == null) {
			quanThanhPhoImpl.setType(StringPool.BLANK);
		}
		else {
			quanThanhPhoImpl.setType(Type);
		}

		if (TinhThanhPhoId == null) {
			quanThanhPhoImpl.setTinhThanhPhoId(StringPool.BLANK);
		}
		else {
			quanThanhPhoImpl.setTinhThanhPhoId(TinhThanhPhoId);
		}

		quanThanhPhoImpl.resetOriginalValues();

		return quanThanhPhoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		name = objectInput.readLong();
		Type = objectInput.readUTF();
		TinhThanhPhoId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(name);

		if (Type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Type);
		}

		if (TinhThanhPhoId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TinhThanhPhoId);
		}
	}

	public long name;
	public String Type;
	public String TinhThanhPhoId;
}
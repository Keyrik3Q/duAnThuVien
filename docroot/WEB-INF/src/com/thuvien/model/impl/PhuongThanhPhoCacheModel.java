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

import com.thuvien.model.PhuongThanhPho;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PhuongThanhPho in entity cache.
 *
 * @author ADMIN
 * @see PhuongThanhPho
 * @generated
 */
public class PhuongThanhPhoCacheModel implements CacheModel<PhuongThanhPho>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{name=");
		sb.append(name);
		sb.append(", Type=");
		sb.append(Type);
		sb.append(", QuanThanhPhoId=");
		sb.append(QuanThanhPhoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhuongThanhPho toEntityModel() {
		PhuongThanhPhoImpl phuongThanhPhoImpl = new PhuongThanhPhoImpl();

		phuongThanhPhoImpl.setName(name);

		if (Type == null) {
			phuongThanhPhoImpl.setType(StringPool.BLANK);
		}
		else {
			phuongThanhPhoImpl.setType(Type);
		}

		if (QuanThanhPhoId == null) {
			phuongThanhPhoImpl.setQuanThanhPhoId(StringPool.BLANK);
		}
		else {
			phuongThanhPhoImpl.setQuanThanhPhoId(QuanThanhPhoId);
		}

		phuongThanhPhoImpl.resetOriginalValues();

		return phuongThanhPhoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		name = objectInput.readLong();
		Type = objectInput.readUTF();
		QuanThanhPhoId = objectInput.readUTF();
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

		if (QuanThanhPhoId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(QuanThanhPhoId);
		}
	}

	public long name;
	public String Type;
	public String QuanThanhPhoId;
}
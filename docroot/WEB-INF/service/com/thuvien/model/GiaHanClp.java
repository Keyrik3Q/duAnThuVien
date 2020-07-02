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

package com.thuvien.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.thuvien.service.ClpSerializer;
import com.thuvien.service.GiaHanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMIN
 */
public class GiaHanClp extends BaseModelImpl<GiaHan> implements GiaHan {
	public GiaHanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GiaHan.class;
	}

	@Override
	public String getModelClassName() {
		return GiaHan.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _IdGh;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdGh(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _IdGh;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("IdGh", getIdGh());
		attributes.put("NgayGianHan", getNgayGianHan());
		attributes.put("PhieuMuonId", getPhieuMuonId());
		attributes.put("TrangThai", getTrangThai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long IdGh = (Long)attributes.get("IdGh");

		if (IdGh != null) {
			setIdGh(IdGh);
		}

		Date NgayGianHan = (Date)attributes.get("NgayGianHan");

		if (NgayGianHan != null) {
			setNgayGianHan(NgayGianHan);
		}

		Long PhieuMuonId = (Long)attributes.get("PhieuMuonId");

		if (PhieuMuonId != null) {
			setPhieuMuonId(PhieuMuonId);
		}

		String TrangThai = (String)attributes.get("TrangThai");

		if (TrangThai != null) {
			setTrangThai(TrangThai);
		}
	}

	@Override
	public long getIdGh() {
		return _IdGh;
	}

	@Override
	public void setIdGh(long IdGh) {
		_IdGh = IdGh;

		if (_giaHanRemoteModel != null) {
			try {
				Class<?> clazz = _giaHanRemoteModel.getClass();

				Method method = clazz.getMethod("setIdGh", long.class);

				method.invoke(_giaHanRemoteModel, IdGh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayGianHan() {
		return _NgayGianHan;
	}

	@Override
	public void setNgayGianHan(Date NgayGianHan) {
		_NgayGianHan = NgayGianHan;

		if (_giaHanRemoteModel != null) {
			try {
				Class<?> clazz = _giaHanRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayGianHan", Date.class);

				method.invoke(_giaHanRemoteModel, NgayGianHan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPhieuMuonId() {
		return _PhieuMuonId;
	}

	@Override
	public void setPhieuMuonId(long PhieuMuonId) {
		_PhieuMuonId = PhieuMuonId;

		if (_giaHanRemoteModel != null) {
			try {
				Class<?> clazz = _giaHanRemoteModel.getClass();

				Method method = clazz.getMethod("setPhieuMuonId", long.class);

				method.invoke(_giaHanRemoteModel, PhieuMuonId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrangThai() {
		return _TrangThai;
	}

	@Override
	public void setTrangThai(String TrangThai) {
		_TrangThai = TrangThai;

		if (_giaHanRemoteModel != null) {
			try {
				Class<?> clazz = _giaHanRemoteModel.getClass();

				Method method = clazz.getMethod("setTrangThai", String.class);

				method.invoke(_giaHanRemoteModel, TrangThai);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGiaHanRemoteModel() {
		return _giaHanRemoteModel;
	}

	public void setGiaHanRemoteModel(BaseModel<?> giaHanRemoteModel) {
		_giaHanRemoteModel = giaHanRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _giaHanRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_giaHanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GiaHanLocalServiceUtil.addGiaHan(this);
		}
		else {
			GiaHanLocalServiceUtil.updateGiaHan(this);
		}
	}

	@Override
	public GiaHan toEscapedModel() {
		return (GiaHan)ProxyUtil.newProxyInstance(GiaHan.class.getClassLoader(),
			new Class[] { GiaHan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GiaHanClp clone = new GiaHanClp();

		clone.setIdGh(getIdGh());
		clone.setNgayGianHan(getNgayGianHan());
		clone.setPhieuMuonId(getPhieuMuonId());
		clone.setTrangThai(getTrangThai());

		return clone;
	}

	@Override
	public int compareTo(GiaHan giaHan) {
		long primaryKey = giaHan.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GiaHanClp)) {
			return false;
		}

		GiaHanClp giaHan = (GiaHanClp)obj;

		long primaryKey = giaHan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{IdGh=");
		sb.append(getIdGh());
		sb.append(", NgayGianHan=");
		sb.append(getNgayGianHan());
		sb.append(", PhieuMuonId=");
		sb.append(getPhieuMuonId());
		sb.append(", TrangThai=");
		sb.append(getTrangThai());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.thuvien.model.GiaHan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>IdGh</column-name><column-value><![CDATA[");
		sb.append(getIdGh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayGianHan</column-name><column-value><![CDATA[");
		sb.append(getNgayGianHan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PhieuMuonId</column-name><column-value><![CDATA[");
		sb.append(getPhieuMuonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _IdGh;
	private Date _NgayGianHan;
	private long _PhieuMuonId;
	private String _TrangThai;
	private BaseModel<?> _giaHanRemoteModel;
	private Class<?> _clpSerializerClass = com.thuvien.service.ClpSerializer.class;
}
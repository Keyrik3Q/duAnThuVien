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
import com.thuvien.service.QuanThanhPhoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMIN
 */
public class QuanThanhPhoClp extends BaseModelImpl<QuanThanhPho>
	implements QuanThanhPho {
	public QuanThanhPhoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return QuanThanhPho.class;
	}

	@Override
	public String getModelClassName() {
		return QuanThanhPho.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _name;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _name;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("name", getName());
		attributes.put("Type", getType());
		attributes.put("TinhThanhPhoId", getTinhThanhPhoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long name = (Long)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String Type = (String)attributes.get("Type");

		if (Type != null) {
			setType(Type);
		}

		String TinhThanhPhoId = (String)attributes.get("TinhThanhPhoId");

		if (TinhThanhPhoId != null) {
			setTinhThanhPhoId(TinhThanhPhoId);
		}
	}

	@Override
	public long getName() {
		return _name;
	}

	@Override
	public void setName(long name) {
		_name = name;

		if (_quanThanhPhoRemoteModel != null) {
			try {
				Class<?> clazz = _quanThanhPhoRemoteModel.getClass();

				Method method = clazz.getMethod("setName", long.class);

				method.invoke(_quanThanhPhoRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _Type;
	}

	@Override
	public void setType(String Type) {
		_Type = Type;

		if (_quanThanhPhoRemoteModel != null) {
			try {
				Class<?> clazz = _quanThanhPhoRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_quanThanhPhoRemoteModel, Type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTinhThanhPhoId() {
		return _TinhThanhPhoId;
	}

	@Override
	public void setTinhThanhPhoId(String TinhThanhPhoId) {
		_TinhThanhPhoId = TinhThanhPhoId;

		if (_quanThanhPhoRemoteModel != null) {
			try {
				Class<?> clazz = _quanThanhPhoRemoteModel.getClass();

				Method method = clazz.getMethod("setTinhThanhPhoId",
						String.class);

				method.invoke(_quanThanhPhoRemoteModel, TinhThanhPhoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQuanThanhPhoRemoteModel() {
		return _quanThanhPhoRemoteModel;
	}

	public void setQuanThanhPhoRemoteModel(BaseModel<?> quanThanhPhoRemoteModel) {
		_quanThanhPhoRemoteModel = quanThanhPhoRemoteModel;
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

		Class<?> remoteModelClass = _quanThanhPhoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_quanThanhPhoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			QuanThanhPhoLocalServiceUtil.addQuanThanhPho(this);
		}
		else {
			QuanThanhPhoLocalServiceUtil.updateQuanThanhPho(this);
		}
	}

	@Override
	public QuanThanhPho toEscapedModel() {
		return (QuanThanhPho)ProxyUtil.newProxyInstance(QuanThanhPho.class.getClassLoader(),
			new Class[] { QuanThanhPho.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuanThanhPhoClp clone = new QuanThanhPhoClp();

		clone.setName(getName());
		clone.setType(getType());
		clone.setTinhThanhPhoId(getTinhThanhPhoId());

		return clone;
	}

	@Override
	public int compareTo(QuanThanhPho quanThanhPho) {
		long primaryKey = quanThanhPho.getPrimaryKey();

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

		if (!(obj instanceof QuanThanhPhoClp)) {
			return false;
		}

		QuanThanhPhoClp quanThanhPho = (QuanThanhPhoClp)obj;

		long primaryKey = quanThanhPho.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{name=");
		sb.append(getName());
		sb.append(", Type=");
		sb.append(getType());
		sb.append(", TinhThanhPhoId=");
		sb.append(getTinhThanhPhoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.thuvien.model.QuanThanhPho");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TinhThanhPhoId</column-name><column-value><![CDATA[");
		sb.append(getTinhThanhPhoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _name;
	private String _Type;
	private String _TinhThanhPhoId;
	private BaseModel<?> _quanThanhPhoRemoteModel;
	private Class<?> _clpSerializerClass = com.thuvien.service.ClpSerializer.class;
}
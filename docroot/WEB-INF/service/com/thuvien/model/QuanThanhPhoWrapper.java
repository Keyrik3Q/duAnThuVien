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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QuanThanhPho}.
 * </p>
 *
 * @author ADMIN
 * @see QuanThanhPho
 * @generated
 */
public class QuanThanhPhoWrapper implements QuanThanhPho,
	ModelWrapper<QuanThanhPho> {
	public QuanThanhPhoWrapper(QuanThanhPho quanThanhPho) {
		_quanThanhPho = quanThanhPho;
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

	/**
	* Returns the primary key of this quan thanh pho.
	*
	* @return the primary key of this quan thanh pho
	*/
	@Override
	public long getPrimaryKey() {
		return _quanThanhPho.getPrimaryKey();
	}

	/**
	* Sets the primary key of this quan thanh pho.
	*
	* @param primaryKey the primary key of this quan thanh pho
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_quanThanhPho.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the name of this quan thanh pho.
	*
	* @return the name of this quan thanh pho
	*/
	@Override
	public long getName() {
		return _quanThanhPho.getName();
	}

	/**
	* Sets the name of this quan thanh pho.
	*
	* @param name the name of this quan thanh pho
	*/
	@Override
	public void setName(long name) {
		_quanThanhPho.setName(name);
	}

	/**
	* Returns the type of this quan thanh pho.
	*
	* @return the type of this quan thanh pho
	*/
	@Override
	public java.lang.String getType() {
		return _quanThanhPho.getType();
	}

	/**
	* Sets the type of this quan thanh pho.
	*
	* @param Type the type of this quan thanh pho
	*/
	@Override
	public void setType(java.lang.String Type) {
		_quanThanhPho.setType(Type);
	}

	/**
	* Returns the tinh thanh pho ID of this quan thanh pho.
	*
	* @return the tinh thanh pho ID of this quan thanh pho
	*/
	@Override
	public java.lang.String getTinhThanhPhoId() {
		return _quanThanhPho.getTinhThanhPhoId();
	}

	/**
	* Sets the tinh thanh pho ID of this quan thanh pho.
	*
	* @param TinhThanhPhoId the tinh thanh pho ID of this quan thanh pho
	*/
	@Override
	public void setTinhThanhPhoId(java.lang.String TinhThanhPhoId) {
		_quanThanhPho.setTinhThanhPhoId(TinhThanhPhoId);
	}

	@Override
	public boolean isNew() {
		return _quanThanhPho.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_quanThanhPho.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _quanThanhPho.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_quanThanhPho.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _quanThanhPho.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _quanThanhPho.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_quanThanhPho.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _quanThanhPho.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_quanThanhPho.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_quanThanhPho.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_quanThanhPho.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuanThanhPhoWrapper((QuanThanhPho)_quanThanhPho.clone());
	}

	@Override
	public int compareTo(com.thuvien.model.QuanThanhPho quanThanhPho) {
		return _quanThanhPho.compareTo(quanThanhPho);
	}

	@Override
	public int hashCode() {
		return _quanThanhPho.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.thuvien.model.QuanThanhPho> toCacheModel() {
		return _quanThanhPho.toCacheModel();
	}

	@Override
	public com.thuvien.model.QuanThanhPho toEscapedModel() {
		return new QuanThanhPhoWrapper(_quanThanhPho.toEscapedModel());
	}

	@Override
	public com.thuvien.model.QuanThanhPho toUnescapedModel() {
		return new QuanThanhPhoWrapper(_quanThanhPho.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _quanThanhPho.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _quanThanhPho.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_quanThanhPho.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuanThanhPhoWrapper)) {
			return false;
		}

		QuanThanhPhoWrapper quanThanhPhoWrapper = (QuanThanhPhoWrapper)obj;

		if (Validator.equals(_quanThanhPho, quanThanhPhoWrapper._quanThanhPho)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public QuanThanhPho getWrappedQuanThanhPho() {
		return _quanThanhPho;
	}

	@Override
	public QuanThanhPho getWrappedModel() {
		return _quanThanhPho;
	}

	@Override
	public void resetOriginalValues() {
		_quanThanhPho.resetOriginalValues();
	}

	private QuanThanhPho _quanThanhPho;
}
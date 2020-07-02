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
 * This class is a wrapper for {@link TinhThanhPho}.
 * </p>
 *
 * @author ADMIN
 * @see TinhThanhPho
 * @generated
 */
public class TinhThanhPhoWrapper implements TinhThanhPho,
	ModelWrapper<TinhThanhPho> {
	public TinhThanhPhoWrapper(TinhThanhPho tinhThanhPho) {
		_tinhThanhPho = tinhThanhPho;
	}

	@Override
	public Class<?> getModelClass() {
		return TinhThanhPho.class;
	}

	@Override
	public String getModelClassName() {
		return TinhThanhPho.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("name", getName());
		attributes.put("Type", getType());

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
	}

	/**
	* Returns the primary key of this tinh thanh pho.
	*
	* @return the primary key of this tinh thanh pho
	*/
	@Override
	public long getPrimaryKey() {
		return _tinhThanhPho.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tinh thanh pho.
	*
	* @param primaryKey the primary key of this tinh thanh pho
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tinhThanhPho.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the name of this tinh thanh pho.
	*
	* @return the name of this tinh thanh pho
	*/
	@Override
	public long getName() {
		return _tinhThanhPho.getName();
	}

	/**
	* Sets the name of this tinh thanh pho.
	*
	* @param name the name of this tinh thanh pho
	*/
	@Override
	public void setName(long name) {
		_tinhThanhPho.setName(name);
	}

	/**
	* Returns the type of this tinh thanh pho.
	*
	* @return the type of this tinh thanh pho
	*/
	@Override
	public java.lang.String getType() {
		return _tinhThanhPho.getType();
	}

	/**
	* Sets the type of this tinh thanh pho.
	*
	* @param Type the type of this tinh thanh pho
	*/
	@Override
	public void setType(java.lang.String Type) {
		_tinhThanhPho.setType(Type);
	}

	@Override
	public boolean isNew() {
		return _tinhThanhPho.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tinhThanhPho.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tinhThanhPho.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tinhThanhPho.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tinhThanhPho.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tinhThanhPho.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tinhThanhPho.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tinhThanhPho.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tinhThanhPho.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tinhThanhPho.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tinhThanhPho.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TinhThanhPhoWrapper((TinhThanhPho)_tinhThanhPho.clone());
	}

	@Override
	public int compareTo(com.thuvien.model.TinhThanhPho tinhThanhPho) {
		return _tinhThanhPho.compareTo(tinhThanhPho);
	}

	@Override
	public int hashCode() {
		return _tinhThanhPho.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.thuvien.model.TinhThanhPho> toCacheModel() {
		return _tinhThanhPho.toCacheModel();
	}

	@Override
	public com.thuvien.model.TinhThanhPho toEscapedModel() {
		return new TinhThanhPhoWrapper(_tinhThanhPho.toEscapedModel());
	}

	@Override
	public com.thuvien.model.TinhThanhPho toUnescapedModel() {
		return new TinhThanhPhoWrapper(_tinhThanhPho.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tinhThanhPho.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tinhThanhPho.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tinhThanhPho.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TinhThanhPhoWrapper)) {
			return false;
		}

		TinhThanhPhoWrapper tinhThanhPhoWrapper = (TinhThanhPhoWrapper)obj;

		if (Validator.equals(_tinhThanhPho, tinhThanhPhoWrapper._tinhThanhPho)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TinhThanhPho getWrappedTinhThanhPho() {
		return _tinhThanhPho;
	}

	@Override
	public TinhThanhPho getWrappedModel() {
		return _tinhThanhPho;
	}

	@Override
	public void resetOriginalValues() {
		_tinhThanhPho.resetOriginalValues();
	}

	private TinhThanhPho _tinhThanhPho;
}
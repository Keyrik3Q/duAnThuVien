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
 * This class is a wrapper for {@link PhuongThanhPho}.
 * </p>
 *
 * @author ADMIN
 * @see PhuongThanhPho
 * @generated
 */
public class PhuongThanhPhoWrapper implements PhuongThanhPho,
	ModelWrapper<PhuongThanhPho> {
	public PhuongThanhPhoWrapper(PhuongThanhPho phuongThanhPho) {
		_phuongThanhPho = phuongThanhPho;
	}

	@Override
	public Class<?> getModelClass() {
		return PhuongThanhPho.class;
	}

	@Override
	public String getModelClassName() {
		return PhuongThanhPho.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("name", getName());
		attributes.put("Type", getType());
		attributes.put("QuanThanhPhoId", getQuanThanhPhoId());

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

		String QuanThanhPhoId = (String)attributes.get("QuanThanhPhoId");

		if (QuanThanhPhoId != null) {
			setQuanThanhPhoId(QuanThanhPhoId);
		}
	}

	/**
	* Returns the primary key of this phuong thanh pho.
	*
	* @return the primary key of this phuong thanh pho
	*/
	@Override
	public long getPrimaryKey() {
		return _phuongThanhPho.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phuong thanh pho.
	*
	* @param primaryKey the primary key of this phuong thanh pho
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phuongThanhPho.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the name of this phuong thanh pho.
	*
	* @return the name of this phuong thanh pho
	*/
	@Override
	public long getName() {
		return _phuongThanhPho.getName();
	}

	/**
	* Sets the name of this phuong thanh pho.
	*
	* @param name the name of this phuong thanh pho
	*/
	@Override
	public void setName(long name) {
		_phuongThanhPho.setName(name);
	}

	/**
	* Returns the type of this phuong thanh pho.
	*
	* @return the type of this phuong thanh pho
	*/
	@Override
	public java.lang.String getType() {
		return _phuongThanhPho.getType();
	}

	/**
	* Sets the type of this phuong thanh pho.
	*
	* @param Type the type of this phuong thanh pho
	*/
	@Override
	public void setType(java.lang.String Type) {
		_phuongThanhPho.setType(Type);
	}

	/**
	* Returns the quan thanh pho ID of this phuong thanh pho.
	*
	* @return the quan thanh pho ID of this phuong thanh pho
	*/
	@Override
	public java.lang.String getQuanThanhPhoId() {
		return _phuongThanhPho.getQuanThanhPhoId();
	}

	/**
	* Sets the quan thanh pho ID of this phuong thanh pho.
	*
	* @param QuanThanhPhoId the quan thanh pho ID of this phuong thanh pho
	*/
	@Override
	public void setQuanThanhPhoId(java.lang.String QuanThanhPhoId) {
		_phuongThanhPho.setQuanThanhPhoId(QuanThanhPhoId);
	}

	@Override
	public boolean isNew() {
		return _phuongThanhPho.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_phuongThanhPho.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _phuongThanhPho.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phuongThanhPho.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _phuongThanhPho.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _phuongThanhPho.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phuongThanhPho.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phuongThanhPho.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_phuongThanhPho.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_phuongThanhPho.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phuongThanhPho.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhuongThanhPhoWrapper((PhuongThanhPho)_phuongThanhPho.clone());
	}

	@Override
	public int compareTo(com.thuvien.model.PhuongThanhPho phuongThanhPho) {
		return _phuongThanhPho.compareTo(phuongThanhPho);
	}

	@Override
	public int hashCode() {
		return _phuongThanhPho.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.thuvien.model.PhuongThanhPho> toCacheModel() {
		return _phuongThanhPho.toCacheModel();
	}

	@Override
	public com.thuvien.model.PhuongThanhPho toEscapedModel() {
		return new PhuongThanhPhoWrapper(_phuongThanhPho.toEscapedModel());
	}

	@Override
	public com.thuvien.model.PhuongThanhPho toUnescapedModel() {
		return new PhuongThanhPhoWrapper(_phuongThanhPho.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phuongThanhPho.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _phuongThanhPho.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phuongThanhPho.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhuongThanhPhoWrapper)) {
			return false;
		}

		PhuongThanhPhoWrapper phuongThanhPhoWrapper = (PhuongThanhPhoWrapper)obj;

		if (Validator.equals(_phuongThanhPho,
					phuongThanhPhoWrapper._phuongThanhPho)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PhuongThanhPho getWrappedPhuongThanhPho() {
		return _phuongThanhPho;
	}

	@Override
	public PhuongThanhPho getWrappedModel() {
		return _phuongThanhPho;
	}

	@Override
	public void resetOriginalValues() {
		_phuongThanhPho.resetOriginalValues();
	}

	private PhuongThanhPho _phuongThanhPho;
}
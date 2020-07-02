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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GiaHan}.
 * </p>
 *
 * @author ADMIN
 * @see GiaHan
 * @generated
 */
public class GiaHanWrapper implements GiaHan, ModelWrapper<GiaHan> {
	public GiaHanWrapper(GiaHan giaHan) {
		_giaHan = giaHan;
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

	/**
	* Returns the primary key of this gia han.
	*
	* @return the primary key of this gia han
	*/
	@Override
	public long getPrimaryKey() {
		return _giaHan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gia han.
	*
	* @param primaryKey the primary key of this gia han
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_giaHan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id gh of this gia han.
	*
	* @return the id gh of this gia han
	*/
	@Override
	public long getIdGh() {
		return _giaHan.getIdGh();
	}

	/**
	* Sets the id gh of this gia han.
	*
	* @param IdGh the id gh of this gia han
	*/
	@Override
	public void setIdGh(long IdGh) {
		_giaHan.setIdGh(IdGh);
	}

	/**
	* Returns the ngay gian han of this gia han.
	*
	* @return the ngay gian han of this gia han
	*/
	@Override
	public java.util.Date getNgayGianHan() {
		return _giaHan.getNgayGianHan();
	}

	/**
	* Sets the ngay gian han of this gia han.
	*
	* @param NgayGianHan the ngay gian han of this gia han
	*/
	@Override
	public void setNgayGianHan(java.util.Date NgayGianHan) {
		_giaHan.setNgayGianHan(NgayGianHan);
	}

	/**
	* Returns the phieu muon ID of this gia han.
	*
	* @return the phieu muon ID of this gia han
	*/
	@Override
	public long getPhieuMuonId() {
		return _giaHan.getPhieuMuonId();
	}

	/**
	* Sets the phieu muon ID of this gia han.
	*
	* @param PhieuMuonId the phieu muon ID of this gia han
	*/
	@Override
	public void setPhieuMuonId(long PhieuMuonId) {
		_giaHan.setPhieuMuonId(PhieuMuonId);
	}

	/**
	* Returns the trang thai of this gia han.
	*
	* @return the trang thai of this gia han
	*/
	@Override
	public java.lang.String getTrangThai() {
		return _giaHan.getTrangThai();
	}

	/**
	* Sets the trang thai of this gia han.
	*
	* @param TrangThai the trang thai of this gia han
	*/
	@Override
	public void setTrangThai(java.lang.String TrangThai) {
		_giaHan.setTrangThai(TrangThai);
	}

	@Override
	public boolean isNew() {
		return _giaHan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_giaHan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _giaHan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_giaHan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _giaHan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _giaHan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_giaHan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _giaHan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_giaHan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_giaHan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_giaHan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GiaHanWrapper((GiaHan)_giaHan.clone());
	}

	@Override
	public int compareTo(com.thuvien.model.GiaHan giaHan) {
		return _giaHan.compareTo(giaHan);
	}

	@Override
	public int hashCode() {
		return _giaHan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.thuvien.model.GiaHan> toCacheModel() {
		return _giaHan.toCacheModel();
	}

	@Override
	public com.thuvien.model.GiaHan toEscapedModel() {
		return new GiaHanWrapper(_giaHan.toEscapedModel());
	}

	@Override
	public com.thuvien.model.GiaHan toUnescapedModel() {
		return new GiaHanWrapper(_giaHan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _giaHan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _giaHan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_giaHan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GiaHanWrapper)) {
			return false;
		}

		GiaHanWrapper giaHanWrapper = (GiaHanWrapper)obj;

		if (Validator.equals(_giaHan, giaHanWrapper._giaHan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GiaHan getWrappedGiaHan() {
		return _giaHan;
	}

	@Override
	public GiaHan getWrappedModel() {
		return _giaHan;
	}

	@Override
	public void resetOriginalValues() {
		_giaHan.resetOriginalValues();
	}

	private GiaHan _giaHan;
}
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PhieuMuon service. Represents a row in the &quot;phieumuon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.thuvien.model.impl.PhieuMuonModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.thuvien.model.impl.PhieuMuonImpl}.
 * </p>
 *
 * @author ADMIN
 * @see PhieuMuon
 * @see com.thuvien.model.impl.PhieuMuonImpl
 * @see com.thuvien.model.impl.PhieuMuonModelImpl
 * @generated
 */
public interface PhieuMuonModel extends BaseModel<PhieuMuon> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a phieu muon model instance should use the {@link PhieuMuon} interface instead.
	 */

	/**
	 * Returns the primary key of this phieu muon.
	 *
	 * @return the primary key of this phieu muon
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this phieu muon.
	 *
	 * @param primaryKey the primary key of this phieu muon
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this phieu muon.
	 *
	 * @return the ID of this phieu muon
	 */
	public long getId();

	/**
	 * Sets the ID of this phieu muon.
	 *
	 * @param Id the ID of this phieu muon
	 */
	public void setId(long Id);

	/**
	 * Returns the user ID of this phieu muon.
	 *
	 * @return the user ID of this phieu muon
	 */
	@AutoEscape
	public String getUserId();

	/**
	 * Sets the user ID of this phieu muon.
	 *
	 * @param UserId the user ID of this phieu muon
	 */
	public void setUserId(String UserId);

	/**
	 * Returns the sach ID of this phieu muon.
	 *
	 * @return the sach ID of this phieu muon
	 */
	public long getSachId();

	/**
	 * Sets the sach ID of this phieu muon.
	 *
	 * @param SachId the sach ID of this phieu muon
	 */
	public void setSachId(long SachId);

	/**
	 * Returns the ngay muon of this phieu muon.
	 *
	 * @return the ngay muon of this phieu muon
	 */
	public Date getNgayMuon();

	/**
	 * Sets the ngay muon of this phieu muon.
	 *
	 * @param NgayMuon the ngay muon of this phieu muon
	 */
	public void setNgayMuon(Date NgayMuon);

	/**
	 * Returns the ngay tra of this phieu muon.
	 *
	 * @return the ngay tra of this phieu muon
	 */
	public Date getNgayTra();

	/**
	 * Sets the ngay tra of this phieu muon.
	 *
	 * @param NgayTra the ngay tra of this phieu muon
	 */
	public void setNgayTra(Date NgayTra);

	/**
	 * Returns the so luong of this phieu muon.
	 *
	 * @return the so luong of this phieu muon
	 */
	public long getSoLuong();

	/**
	 * Sets the so luong of this phieu muon.
	 *
	 * @param SoLuong the so luong of this phieu muon
	 */
	public void setSoLuong(long SoLuong);

	/**
	 * Returns the xac nhan of this phieu muon.
	 *
	 * @return the xac nhan of this phieu muon
	 */
	@AutoEscape
	public String getXacNhan();

	/**
	 * Sets the xac nhan of this phieu muon.
	 *
	 * @param XacNhan the xac nhan of this phieu muon
	 */
	public void setXacNhan(String XacNhan);

	/**
	 * Returns the trang thai of this phieu muon.
	 *
	 * @return the trang thai of this phieu muon
	 */
	@AutoEscape
	public String getTrangThai();

	/**
	 * Sets the trang thai of this phieu muon.
	 *
	 * @param TrangThai the trang thai of this phieu muon
	 */
	public void setTrangThai(String TrangThai);

	/**
	 * Returns the tra sach of this phieu muon.
	 *
	 * @return the tra sach of this phieu muon
	 */
	public long getTraSach();

	/**
	 * Sets the tra sach of this phieu muon.
	 *
	 * @param TraSach the tra sach of this phieu muon
	 */
	public void setTraSach(long TraSach);

	/**
	 * Returns the gia han sach of this phieu muon.
	 *
	 * @return the gia han sach of this phieu muon
	 */
	public long getGiaHanSach();

	/**
	 * Sets the gia han sach of this phieu muon.
	 *
	 * @param GiaHanSach the gia han sach of this phieu muon
	 */
	public void setGiaHanSach(long GiaHanSach);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.thuvien.model.PhieuMuon phieuMuon);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.thuvien.model.PhieuMuon> toCacheModel();

	@Override
	public com.thuvien.model.PhieuMuon toEscapedModel();

	@Override
	public com.thuvien.model.PhieuMuon toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
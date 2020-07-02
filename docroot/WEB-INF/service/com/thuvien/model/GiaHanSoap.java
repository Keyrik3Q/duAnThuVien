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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.thuvien.service.http.GiaHanServiceSoap}.
 *
 * @author ADMIN
 * @see com.thuvien.service.http.GiaHanServiceSoap
 * @generated
 */
public class GiaHanSoap implements Serializable {
	public static GiaHanSoap toSoapModel(GiaHan model) {
		GiaHanSoap soapModel = new GiaHanSoap();

		soapModel.setIdGh(model.getIdGh());
		soapModel.setNgayGianHan(model.getNgayGianHan());
		soapModel.setPhieuMuonId(model.getPhieuMuonId());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static GiaHanSoap[] toSoapModels(GiaHan[] models) {
		GiaHanSoap[] soapModels = new GiaHanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GiaHanSoap[][] toSoapModels(GiaHan[][] models) {
		GiaHanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GiaHanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GiaHanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GiaHanSoap[] toSoapModels(List<GiaHan> models) {
		List<GiaHanSoap> soapModels = new ArrayList<GiaHanSoap>(models.size());

		for (GiaHan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GiaHanSoap[soapModels.size()]);
	}

	public GiaHanSoap() {
	}

	public long getPrimaryKey() {
		return _IdGh;
	}

	public void setPrimaryKey(long pk) {
		setIdGh(pk);
	}

	public long getIdGh() {
		return _IdGh;
	}

	public void setIdGh(long IdGh) {
		_IdGh = IdGh;
	}

	public Date getNgayGianHan() {
		return _NgayGianHan;
	}

	public void setNgayGianHan(Date NgayGianHan) {
		_NgayGianHan = NgayGianHan;
	}

	public long getPhieuMuonId() {
		return _PhieuMuonId;
	}

	public void setPhieuMuonId(long PhieuMuonId) {
		_PhieuMuonId = PhieuMuonId;
	}

	public String getTrangThai() {
		return _TrangThai;
	}

	public void setTrangThai(String TrangThai) {
		_TrangThai = TrangThai;
	}

	private long _IdGh;
	private Date _NgayGianHan;
	private long _PhieuMuonId;
	private String _TrangThai;
}
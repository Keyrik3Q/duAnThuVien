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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.thuvien.service.http.PhuongThanhPhoServiceSoap}.
 *
 * @author ADMIN
 * @see com.thuvien.service.http.PhuongThanhPhoServiceSoap
 * @generated
 */
public class PhuongThanhPhoSoap implements Serializable {
	public static PhuongThanhPhoSoap toSoapModel(PhuongThanhPho model) {
		PhuongThanhPhoSoap soapModel = new PhuongThanhPhoSoap();

		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setQuanThanhPhoId(model.getQuanThanhPhoId());

		return soapModel;
	}

	public static PhuongThanhPhoSoap[] toSoapModels(PhuongThanhPho[] models) {
		PhuongThanhPhoSoap[] soapModels = new PhuongThanhPhoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhuongThanhPhoSoap[][] toSoapModels(PhuongThanhPho[][] models) {
		PhuongThanhPhoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhuongThanhPhoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhuongThanhPhoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhuongThanhPhoSoap[] toSoapModels(List<PhuongThanhPho> models) {
		List<PhuongThanhPhoSoap> soapModels = new ArrayList<PhuongThanhPhoSoap>(models.size());

		for (PhuongThanhPho model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhuongThanhPhoSoap[soapModels.size()]);
	}

	public PhuongThanhPhoSoap() {
	}

	public long getPrimaryKey() {
		return _name;
	}

	public void setPrimaryKey(long pk) {
		setName(pk);
	}

	public long getName() {
		return _name;
	}

	public void setName(long name) {
		_name = name;
	}

	public String getType() {
		return _Type;
	}

	public void setType(String Type) {
		_Type = Type;
	}

	public String getQuanThanhPhoId() {
		return _QuanThanhPhoId;
	}

	public void setQuanThanhPhoId(String QuanThanhPhoId) {
		_QuanThanhPhoId = QuanThanhPhoId;
	}

	private long _name;
	private String _Type;
	private String _QuanThanhPhoId;
}
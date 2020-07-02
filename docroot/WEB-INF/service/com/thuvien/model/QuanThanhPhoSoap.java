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
 * This class is used by SOAP remote services, specifically {@link com.thuvien.service.http.QuanThanhPhoServiceSoap}.
 *
 * @author ADMIN
 * @see com.thuvien.service.http.QuanThanhPhoServiceSoap
 * @generated
 */
public class QuanThanhPhoSoap implements Serializable {
	public static QuanThanhPhoSoap toSoapModel(QuanThanhPho model) {
		QuanThanhPhoSoap soapModel = new QuanThanhPhoSoap();

		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setTinhThanhPhoId(model.getTinhThanhPhoId());

		return soapModel;
	}

	public static QuanThanhPhoSoap[] toSoapModels(QuanThanhPho[] models) {
		QuanThanhPhoSoap[] soapModels = new QuanThanhPhoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuanThanhPhoSoap[][] toSoapModels(QuanThanhPho[][] models) {
		QuanThanhPhoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuanThanhPhoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuanThanhPhoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuanThanhPhoSoap[] toSoapModels(List<QuanThanhPho> models) {
		List<QuanThanhPhoSoap> soapModels = new ArrayList<QuanThanhPhoSoap>(models.size());

		for (QuanThanhPho model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuanThanhPhoSoap[soapModels.size()]);
	}

	public QuanThanhPhoSoap() {
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

	public String getTinhThanhPhoId() {
		return _TinhThanhPhoId;
	}

	public void setTinhThanhPhoId(String TinhThanhPhoId) {
		_TinhThanhPhoId = TinhThanhPhoId;
	}

	private long _name;
	private String _Type;
	private String _TinhThanhPhoId;
}
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
 * This class is used by SOAP remote services, specifically {@link com.thuvien.service.http.TinhThanhPhoServiceSoap}.
 *
 * @author ADMIN
 * @see com.thuvien.service.http.TinhThanhPhoServiceSoap
 * @generated
 */
public class TinhThanhPhoSoap implements Serializable {
	public static TinhThanhPhoSoap toSoapModel(TinhThanhPho model) {
		TinhThanhPhoSoap soapModel = new TinhThanhPhoSoap();

		soapModel.setName(model.getName());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static TinhThanhPhoSoap[] toSoapModels(TinhThanhPho[] models) {
		TinhThanhPhoSoap[] soapModels = new TinhThanhPhoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TinhThanhPhoSoap[][] toSoapModels(TinhThanhPho[][] models) {
		TinhThanhPhoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TinhThanhPhoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TinhThanhPhoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TinhThanhPhoSoap[] toSoapModels(List<TinhThanhPho> models) {
		List<TinhThanhPhoSoap> soapModels = new ArrayList<TinhThanhPhoSoap>(models.size());

		for (TinhThanhPho model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TinhThanhPhoSoap[soapModels.size()]);
	}

	public TinhThanhPhoSoap() {
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

	private long _name;
	private String _Type;
}
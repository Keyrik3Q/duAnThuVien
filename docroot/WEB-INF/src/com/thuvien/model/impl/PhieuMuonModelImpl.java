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

package com.thuvien.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.thuvien.model.PhieuMuon;
import com.thuvien.model.PhieuMuonModel;
import com.thuvien.model.PhieuMuonSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PhieuMuon service. Represents a row in the &quot;phieumuon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.thuvien.model.PhieuMuonModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PhieuMuonImpl}.
 * </p>
 *
 * @author ADMIN
 * @see PhieuMuonImpl
 * @see com.thuvien.model.PhieuMuon
 * @see com.thuvien.model.PhieuMuonModel
 * @generated
 */
@JSON(strict = true)
public class PhieuMuonModelImpl extends BaseModelImpl<PhieuMuon>
	implements PhieuMuonModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a phieu muon model instance should use the {@link com.thuvien.model.PhieuMuon} interface instead.
	 */
	public static final String TABLE_NAME = "phieumuon";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "userid", Types.VARCHAR },
			{ "sachid", Types.BIGINT },
			{ "ngaymuon", Types.TIMESTAMP },
			{ "ngaytra", Types.TIMESTAMP },
			{ "soluong", Types.BIGINT },
			{ "xacnhan", Types.VARCHAR },
			{ "trangthai", Types.VARCHAR },
			{ "trasach", Types.BIGINT },
			{ "giahansach", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table phieumuon (id LONG not null primary key,userid VARCHAR(75) null,sachid LONG,ngaymuon DATE null,ngaytra DATE null,soluong LONG,xacnhan VARCHAR(75) null,trangthai VARCHAR(75) null,trasach LONG,giahansach LONG)";
	public static final String TABLE_SQL_DROP = "drop table phieumuon";
	public static final String ORDER_BY_JPQL = " ORDER BY phieuMuon.Id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY phieumuon.id ASC";
	public static final String DATA_SOURCE = "qlthuvienDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.thuvien.model.PhieuMuon"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.thuvien.model.PhieuMuon"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PhieuMuon toModel(PhieuMuonSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PhieuMuon model = new PhieuMuonImpl();

		model.setId(soapModel.getId());
		model.setUserId(soapModel.getUserId());
		model.setSachId(soapModel.getSachId());
		model.setNgayMuon(soapModel.getNgayMuon());
		model.setNgayTra(soapModel.getNgayTra());
		model.setSoLuong(soapModel.getSoLuong());
		model.setXacNhan(soapModel.getXacNhan());
		model.setTrangThai(soapModel.getTrangThai());
		model.setTraSach(soapModel.getTraSach());
		model.setGiaHanSach(soapModel.getGiaHanSach());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<PhieuMuon> toModels(PhieuMuonSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PhieuMuon> models = new ArrayList<PhieuMuon>(soapModels.length);

		for (PhieuMuonSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.thuvien.model.PhieuMuon"));

	public PhieuMuonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _Id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _Id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PhieuMuon.class;
	}

	@Override
	public String getModelClassName() {
		return PhieuMuon.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("UserId", getUserId());
		attributes.put("SachId", getSachId());
		attributes.put("NgayMuon", getNgayMuon());
		attributes.put("NgayTra", getNgayTra());
		attributes.put("SoLuong", getSoLuong());
		attributes.put("XacNhan", getXacNhan());
		attributes.put("TrangThai", getTrangThai());
		attributes.put("TraSach", getTraSach());
		attributes.put("GiaHanSach", getGiaHanSach());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String UserId = (String)attributes.get("UserId");

		if (UserId != null) {
			setUserId(UserId);
		}

		Long SachId = (Long)attributes.get("SachId");

		if (SachId != null) {
			setSachId(SachId);
		}

		Date NgayMuon = (Date)attributes.get("NgayMuon");

		if (NgayMuon != null) {
			setNgayMuon(NgayMuon);
		}

		Date NgayTra = (Date)attributes.get("NgayTra");

		if (NgayTra != null) {
			setNgayTra(NgayTra);
		}

		Long SoLuong = (Long)attributes.get("SoLuong");

		if (SoLuong != null) {
			setSoLuong(SoLuong);
		}

		String XacNhan = (String)attributes.get("XacNhan");

		if (XacNhan != null) {
			setXacNhan(XacNhan);
		}

		String TrangThai = (String)attributes.get("TrangThai");

		if (TrangThai != null) {
			setTrangThai(TrangThai);
		}

		Long TraSach = (Long)attributes.get("TraSach");

		if (TraSach != null) {
			setTraSach(TraSach);
		}

		Long GiaHanSach = (Long)attributes.get("GiaHanSach");

		if (GiaHanSach != null) {
			setGiaHanSach(GiaHanSach);
		}
	}

	@JSON
	@Override
	public long getId() {
		return _Id;
	}

	@Override
	public void setId(long Id) {
		_Id = Id;
	}

	@JSON
	@Override
	public String getUserId() {
		if (_UserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _UserId;
		}
	}

	@Override
	public void setUserId(String UserId) {
		_UserId = UserId;
	}

	@JSON
	@Override
	public long getSachId() {
		return _SachId;
	}

	@Override
	public void setSachId(long SachId) {
		_SachId = SachId;
	}

	@JSON
	@Override
	public Date getNgayMuon() {
		return _NgayMuon;
	}

	@Override
	public void setNgayMuon(Date NgayMuon) {
		_NgayMuon = NgayMuon;
	}

	@JSON
	@Override
	public Date getNgayTra() {
		return _NgayTra;
	}

	@Override
	public void setNgayTra(Date NgayTra) {
		_NgayTra = NgayTra;
	}

	@JSON
	@Override
	public long getSoLuong() {
		return _SoLuong;
	}

	@Override
	public void setSoLuong(long SoLuong) {
		_SoLuong = SoLuong;
	}

	@JSON
	@Override
	public String getXacNhan() {
		if (_XacNhan == null) {
			return StringPool.BLANK;
		}
		else {
			return _XacNhan;
		}
	}

	@Override
	public void setXacNhan(String XacNhan) {
		_XacNhan = XacNhan;
	}

	@JSON
	@Override
	public String getTrangThai() {
		if (_TrangThai == null) {
			return StringPool.BLANK;
		}
		else {
			return _TrangThai;
		}
	}

	@Override
	public void setTrangThai(String TrangThai) {
		_TrangThai = TrangThai;
	}

	@JSON
	@Override
	public long getTraSach() {
		return _TraSach;
	}

	@Override
	public void setTraSach(long TraSach) {
		_TraSach = TraSach;
	}

	@JSON
	@Override
	public long getGiaHanSach() {
		return _GiaHanSach;
	}

	@Override
	public void setGiaHanSach(long GiaHanSach) {
		_GiaHanSach = GiaHanSach;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			PhieuMuon.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PhieuMuon toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PhieuMuon)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PhieuMuonImpl phieuMuonImpl = new PhieuMuonImpl();

		phieuMuonImpl.setId(getId());
		phieuMuonImpl.setUserId(getUserId());
		phieuMuonImpl.setSachId(getSachId());
		phieuMuonImpl.setNgayMuon(getNgayMuon());
		phieuMuonImpl.setNgayTra(getNgayTra());
		phieuMuonImpl.setSoLuong(getSoLuong());
		phieuMuonImpl.setXacNhan(getXacNhan());
		phieuMuonImpl.setTrangThai(getTrangThai());
		phieuMuonImpl.setTraSach(getTraSach());
		phieuMuonImpl.setGiaHanSach(getGiaHanSach());

		phieuMuonImpl.resetOriginalValues();

		return phieuMuonImpl;
	}

	@Override
	public int compareTo(PhieuMuon phieuMuon) {
		long primaryKey = phieuMuon.getPrimaryKey();

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

		if (!(obj instanceof PhieuMuon)) {
			return false;
		}

		PhieuMuon phieuMuon = (PhieuMuon)obj;

		long primaryKey = phieuMuon.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<PhieuMuon> toCacheModel() {
		PhieuMuonCacheModel phieuMuonCacheModel = new PhieuMuonCacheModel();

		phieuMuonCacheModel.Id = getId();

		phieuMuonCacheModel.UserId = getUserId();

		String UserId = phieuMuonCacheModel.UserId;

		if ((UserId != null) && (UserId.length() == 0)) {
			phieuMuonCacheModel.UserId = null;
		}

		phieuMuonCacheModel.SachId = getSachId();

		Date NgayMuon = getNgayMuon();

		if (NgayMuon != null) {
			phieuMuonCacheModel.NgayMuon = NgayMuon.getTime();
		}
		else {
			phieuMuonCacheModel.NgayMuon = Long.MIN_VALUE;
		}

		Date NgayTra = getNgayTra();

		if (NgayTra != null) {
			phieuMuonCacheModel.NgayTra = NgayTra.getTime();
		}
		else {
			phieuMuonCacheModel.NgayTra = Long.MIN_VALUE;
		}

		phieuMuonCacheModel.SoLuong = getSoLuong();

		phieuMuonCacheModel.XacNhan = getXacNhan();

		String XacNhan = phieuMuonCacheModel.XacNhan;

		if ((XacNhan != null) && (XacNhan.length() == 0)) {
			phieuMuonCacheModel.XacNhan = null;
		}

		phieuMuonCacheModel.TrangThai = getTrangThai();

		String TrangThai = phieuMuonCacheModel.TrangThai;

		if ((TrangThai != null) && (TrangThai.length() == 0)) {
			phieuMuonCacheModel.TrangThai = null;
		}

		phieuMuonCacheModel.TraSach = getTraSach();

		phieuMuonCacheModel.GiaHanSach = getGiaHanSach();

		return phieuMuonCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{Id=");
		sb.append(getId());
		sb.append(", UserId=");
		sb.append(getUserId());
		sb.append(", SachId=");
		sb.append(getSachId());
		sb.append(", NgayMuon=");
		sb.append(getNgayMuon());
		sb.append(", NgayTra=");
		sb.append(getNgayTra());
		sb.append(", SoLuong=");
		sb.append(getSoLuong());
		sb.append(", XacNhan=");
		sb.append(getXacNhan());
		sb.append(", TrangThai=");
		sb.append(getTrangThai());
		sb.append(", TraSach=");
		sb.append(getTraSach());
		sb.append(", GiaHanSach=");
		sb.append(getGiaHanSach());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.thuvien.model.PhieuMuon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>Id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UserId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SachId</column-name><column-value><![CDATA[");
		sb.append(getSachId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayMuon</column-name><column-value><![CDATA[");
		sb.append(getNgayMuon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NgayTra</column-name><column-value><![CDATA[");
		sb.append(getNgayTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SoLuong</column-name><column-value><![CDATA[");
		sb.append(getSoLuong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>XacNhan</column-name><column-value><![CDATA[");
		sb.append(getXacNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TrangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TraSach</column-name><column-value><![CDATA[");
		sb.append(getTraSach());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GiaHanSach</column-name><column-value><![CDATA[");
		sb.append(getGiaHanSach());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = PhieuMuon.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PhieuMuon.class
		};
	private long _Id;
	private String _UserId;
	private long _SachId;
	private Date _NgayMuon;
	private Date _NgayTra;
	private long _SoLuong;
	private String _XacNhan;
	private String _TrangThai;
	private long _TraSach;
	private long _GiaHanSach;
	private PhieuMuon _escapedModel;
}
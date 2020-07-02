
package com.thuvien.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import com.thuvien.service.base.GiaHanLocalServiceBaseImpl;
import com.thuvien.service.persistence.GiaHanFinderUtil;

public class GiaHanLocalServiceImpl extends GiaHanLocalServiceBaseImpl {
	public List<Object[]> findGiaHans(String userid,String name, String ngaymuon, String ngaytra,int Start, int ketThuc) throws SystemException {
		return GiaHanFinderUtil.findGiaHans(userid, name, ngaymuon, ngaytra,Start, ketThuc);
	}
	public List<Object[]> findLichSus(String userid,String name, String ngaymuon, String ngaytra,int Start, int ketThuc) throws SystemException {
		return GiaHanFinderUtil.findLichSus(userid, name, ngaymuon,ngaytra, Start, ketThuc);
	}
	public long countGiaHans(String userid,String name, String ngaymuon, String ngaytra) throws SystemException{
		return GiaHanFinderUtil.countGiaHans(userid, name, ngaymuon, ngaytra);
	}
	
	public long countTongs(String name, String ngaymuon, String ngaytra) throws SystemException{
		return GiaHanFinderUtil.countTongs(name, ngaymuon, ngaytra);
	}
	
	public long countLichSus(String userid,String name, String ngaymuon, String ngaytra) throws SystemException{
		return GiaHanFinderUtil.countLichSus(userid, name, ngaymuon, ngaytra);
	}
	
	public List<Object[]> findGiaHanDSs(String name, String ngaymuon, String ngaytra,int Start, int ketThuc) throws SystemException {
		return GiaHanFinderUtil.findGiaHanDSs(name, ngaymuon, ngaytra, Start, ketThuc);
	}
	
	public long countGiaHanDSs(String name, String ngaymuon, String ngaytra) throws SystemException{
		return GiaHanFinderUtil.countGiaHanDSs(name, ngaymuon, ngaytra);
	}
}
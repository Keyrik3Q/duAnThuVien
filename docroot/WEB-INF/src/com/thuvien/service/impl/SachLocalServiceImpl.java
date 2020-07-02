
package com.thuvien.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import com.thuvien.service.base.SachLocalServiceBaseImpl;
import com.thuvien.service.persistence.SachFinderUtil;

public class SachLocalServiceImpl extends SachLocalServiceBaseImpl {
	public List<Object[]> findSachs(String name,String masach,long theloai, int Start, int ketThuc) throws SystemException {
		return SachFinderUtil.findSachs(name, masach, theloai, Start, ketThuc);
	}
	public long countSachs(String name,String masach,long theloai) throws SystemException{
		return SachFinderUtil.countSachs(name, masach, theloai);
	}
	
	public List<Object[]> findMuonSachs(String name,String masach,long[] theloai, int Start, int ketThuc) throws SystemException {
		return SachFinderUtil.findMuonSachs(name, masach, theloai, Start, ketThuc);
	}
	public long countMuonSachs(String name,String masach,long[] theloai) throws SystemException{
		return SachFinderUtil.countMuonSachs(name, masach, theloai);
	}
}
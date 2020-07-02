package com.thuvien;
import com.thuvien.model.PhieuMuon;
import com.thuvien.model.Sach;
import com.thuvien.model.impl.PhieuMuonImpl;
import com.thuvien.service.GiaHanLocalServiceUtil;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class QuanLyLichSuPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException, ParseException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String userid = ParamUtil.get(req, "userid", "");
		String ten = ParamUtil.get(req, "ten", "");
		String ngaymuon = ParamUtil.get(req, "ngaymuon", "");
		String ngaytra = ParamUtil.get(req, "ngaytra", "");
		List<Object[]> data = GiaHanLocalServiceUtil.findLichSus(userid, ten, ngaymuon, ngaytra, Start, ketThuc);
		long tong = GiaHanLocalServiceUtil.countLichSus(userid, ten, ngaymuon, ngaytra);
		System.out.print(tong);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("data", data);
		req.setAttribute("userid", userid);
		req.setAttribute("ten", ten);
		req.setAttribute("ngaymuon", ngaymuon);
		req.setAttribute("ngaytra", ngaytra);
		res.setRenderParameter("jspPage","/html/quanlylichsu/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void delete(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		long id = ParamUtil.getLong(req, "id");
		PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
		PhieuMuonLocalServiceUtil.deletePhieuMuon(phieuMuon);
		res.setRenderParameter("jspPage", "");
	}
	public void duyetmuon(ActionRequest req, ActionResponse res ) throws SystemException, PortalException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		long idsach = ParamUtil.getLong(req, "idsach");
		long idsachmuon = ParamUtil.getLong(req, "idsachmuon");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			phieuMuon.setXacNhan("1");
			PhieuMuonLocalServiceUtil.updatePhieuMuon(phieuMuon);
			Sach sachf = SachLocalServiceUtil.getSach(idsach);
			sachf.setSoLuong(idsachmuon);
			SachLocalServiceUtil.updateSach(sachf);
			res.setRenderParameter("jspPage", "");
	}
	public void tuchoi(ActionRequest req, ActionResponse res ) throws SystemException, PortalException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			req.setAttribute("PhieuMuon", phieuMuon);
			res.setRenderParameter("jspPage", "/html/quanlylichsu/tuchoi.jsp");
	}
	public void savePM(ActionRequest req, ActionResponse res ) throws SystemException, PortalException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			phieuMuon.setTrangThai(ParamUtil.getString(req, "trangthai"));
			phieuMuon.setXacNhan("2");
			PhieuMuonLocalServiceUtil.updatePhieuMuon(phieuMuon);
			res.setRenderParameter("jspPage", "");
	}
	public void detail(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		Sach sachf = SachLocalServiceUtil.getSach(id);
		req.setAttribute("Sach", sachf);
		res.setRenderParameter("jspPage","/html/quanlylichsu/detail.jsp");
	}
}

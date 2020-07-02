package com.thuvien;
import com.thuvien.model.GiaHan;
import com.thuvien.model.PhieuMuon;
import com.thuvien.model.impl.GiaHanImpl;
import com.thuvien.model.impl.PhieuMuonImpl;
import com.thuvien.service.GiaHanLocalServiceUtil;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;





import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class QuanLyGiaHanPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException{
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
		long tong = GiaHanLocalServiceUtil.countGiaHans(userid, ten, ngaymuon, ngaytra);
		List<Object[]> data = GiaHanLocalServiceUtil.findGiaHans(userid, ten, ngaymuon, ngaytra, Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("userid", userid);
		req.setAttribute("ten", ten);
		req.setAttribute("ngaymuon", ngaymuon);
		req.setAttribute("ngaytra", ngaytra);
		req.setAttribute("data", data);
		res.setRenderParameter("jspPage","/html/quanlygiahan/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void giahan(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		long id = ParamUtil.getLong(req, "id");
		GiaHan giaHan = GiaHanLocalServiceUtil.getGiaHan(id);
		req.setAttribute("PhieuMuon", giaHan);
		res.setRenderParameter("jspPage", "/html/quanlygiahan/input.jsp");
	}
	public void savegiahan(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		GiaHan giaHan = GiaHanLocalServiceUtil.getGiaHan(id);
		SimpleDateFormat nt = new SimpleDateFormat("yyyy-MM-dd");
		giaHan.setNgayGianHan(ParamUtil.getDate(req,"ngaygiahan", nt));
		GiaHanLocalServiceUtil.updateGiaHan(giaHan);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlygiahan_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlygiahan_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void tuchoigh(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		GiaHan giaHan = GiaHanLocalServiceUtil.getGiaHan(id);
		req.setAttribute("GiaHan", giaHan);
		res.setRenderParameter("jspPage", "/html/quanlygiahan/tuchoigh.jsp");
	}
	public void savetc(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		GiaHan giaHan = GiaHanLocalServiceUtil.getGiaHan(id);
		giaHan.setTrangThai(ParamUtil.getString(req, "trangthai"));
		GiaHanLocalServiceUtil.updateGiaHan(giaHan);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlygiahan_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlygiahan_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void duyetmuon(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		long idpm = ParamUtil.getLong(req, "idpm");
		SimpleDateFormat nt = new SimpleDateFormat("yyyy-MM-dd");
		Date ngaygiahan = (ParamUtil.getDate(req,"ngaygiahan", nt));
			GiaHan giaHan = GiaHanLocalServiceUtil.getGiaHan(id);
			giaHan.setTrangThai("1");
			GiaHanLocalServiceUtil.updateGiaHan(giaHan);
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(idpm);
			phieuMuon.setNgayTra(ngaygiahan);
			PhieuMuonLocalServiceUtil.updatePhieuMuon(phieuMuon);

			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlygiahan_WAR_ThuVienQuanLyportlet");
			PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlygiahan_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
			url.setWindowState(LiferayWindowState.NORMAL);
			url.setPortletMode(LiferayPortletMode.VIEW);
			url.setParameter("javax.portlet.action", "thuVien");
			res.sendRedirect(url.toString());
	}
}

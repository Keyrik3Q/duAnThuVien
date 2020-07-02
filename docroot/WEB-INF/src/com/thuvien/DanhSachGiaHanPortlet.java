package com.thuvien;
import com.thuvien.model.GiaHan;
import com.thuvien.model.PhieuMuon;
import com.thuvien.model.Sach;
import com.thuvien.model.impl.GiaHanImpl;
import com.thuvien.model.impl.PhieuMuonImpl;
import com.thuvien.service.GiaHanLocalServiceUtil;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import com.liferay.counter.service.CounterLocalServiceUtil;
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

/**
 * Portlet implementation class QuanLyPhieuMuonPortlet
 */
public class DanhSachGiaHanPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException, ParseException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.get(req, "ten", "");
		String ngaymuon = ParamUtil.get(req, "ngaymuon", "");
		String ngaytra = ParamUtil.get(req, "ngaytra", "");
		long tong = GiaHanLocalServiceUtil.countGiaHanDSs(ten, ngaymuon, ngaytra);
		List<Object[]> data = GiaHanLocalServiceUtil.findGiaHanDSs(ten, ngaymuon, ngaytra, Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("ten", ten);
		req.setAttribute("ngaymuon", ngaymuon);
		req.setAttribute("ngaytra", ngaytra);
		req.setAttribute("data", data);
		res.setRenderParameter("jspPage","/html/danhsachgiahan/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void input(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		if(id!=0){
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			req.setAttribute("PhieuMuon", phieuMuon);
		}else if(id==0){
			PhieuMuon phieuMuon = new PhieuMuonImpl();
			req.setAttribute("PhieuMuon", phieuMuon);
		}
		res.setRenderParameter("jspPage","/html/danhsachgiahan/input.jsp");
	}
	public void addgh(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		GiaHan giaHan = new GiaHanImpl();
		giaHan.setIdGh(CounterLocalServiceUtil.increment("GiaHan"));
		giaHan.setPhieuMuonId(ParamUtil.getLong(req, "PhieuMuon"));
		SimpleDateFormat gh = new SimpleDateFormat("yyyy-MM-dd");
		giaHan.setNgayGianHan(ParamUtil.getDate(req,"ngaygiahan", gh));
		System.out.print(giaHan);
		GiaHanLocalServiceUtil.addGiaHan(giaHan);
		PhieuMuon pm = PhieuMuonLocalServiceUtil.getPhieuMuon(ParamUtil.getLong(req, "PhieuMuon"));
		pm.setGiaHanSach(1);
		PhieuMuonLocalServiceUtil.updatePhieuMuon(pm);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "danhsachgiahan_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "danhsachgiahan_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void detail(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		Sach sachf = SachLocalServiceUtil.getSach(id);
		req.setAttribute("Sach", sachf);
		res.setRenderParameter("jspPage","/html/danhsachgiahan/detail.jsp");
	}
}

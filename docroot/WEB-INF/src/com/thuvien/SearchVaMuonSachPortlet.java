package com.thuvien;

import com.thuvien.model.PhieuMuon;
import com.thuvien.model.Sach;
import com.thuvien.model.TheLoai;
import com.thuvien.model.impl.PhieuMuonImpl;
import com.thuvien.model.impl.SachImpl;
import com.thuvien.model.impl.TheLoaiImpl;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;
import com.thuvien.service.TheLoaiLocalServiceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Portlet implementation class QuanLySachPortlet
 */
public class SearchVaMuonSachPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.get(req, "tensach", "");
		String masach = ParamUtil.get(req, "masach", "");
		long[] theloai = ParamUtil.getLongValues(req, "theloai");
		DynamicQuery p = DynamicQueryFactoryUtil.forClass(TheLoaiImpl.class, PortalClassLoaderUtil.getClassLoader());
		long tong = SachLocalServiceUtil.countMuonSachs(ten, masach, theloai);
		List<TheLoai> theLoai = TheLoaiLocalServiceUtil.dynamicQuery(p);
		List<Object[]> data = SachLocalServiceUtil.findMuonSachs(ten, masach, theloai, Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("data", data);
		req.setAttribute("ten", ten);
		req.setAttribute("masach", masach);
		req.setAttribute("theloai", theloai);
		req.setAttribute("theLoai", theLoai);
		res.setRenderParameter("jspPage","/html/searchvamuonsach/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	
	public void detail(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(TheLoaiImpl.class, PortalClassLoaderUtil.getClassLoader());
		List<TheLoai> data = TheLoaiLocalServiceUtil.dynamicQuery(q);
		long id = ParamUtil.getLong(req, "id");
		Sach sachf = SachLocalServiceUtil.getSach(id);
		req.setAttribute("Sach", sachf);
		req.setAttribute("data", data);
		res.setRenderParameter("jspPage","/html/searchvamuonsach/detail.jsp");
	}
	public void muonsach(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		Sach sachf = SachLocalServiceUtil.getSach(id);
		req.setAttribute("Sach", sachf);
		res.setRenderParameter("jspPage","/html/searchvamuonsach/muonsach.jsp");
	}
	public void addby(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		PhieuMuon phieuMuon = new PhieuMuonImpl();
		phieuMuon.setId(CounterLocalServiceUtil.increment("PhieuMuon"));
		phieuMuon.setUserId(ParamUtil.getString(req, "UserId"));
		phieuMuon.setSachId(ParamUtil.getLong(req, "Sach"));
		SimpleDateFormat nm = new SimpleDateFormat("yyyy-MM-dd");
		phieuMuon.setNgayMuon(ParamUtil.getDate(req,"ngaymuon", nm));
		SimpleDateFormat nt = new SimpleDateFormat("yyyy-MM-dd");
		phieuMuon.setNgayTra(ParamUtil.getDate(req,"ngaytra", nt));
		phieuMuon.setSoLuong(ParamUtil.getLong(req,"soluong"));
		PhieuMuonLocalServiceUtil.addPhieuMuon(phieuMuon);

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "searchvamuonsach_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "searchvamuonsach_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
}

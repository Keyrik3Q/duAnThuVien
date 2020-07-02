package com.thuvien;
import com.thuvien.model.PhieuMuon;
import com.thuvien.model.Sach;
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
public class QuanLyPhieuMuonPortlet extends MVCPortlet {
	@SuppressWarnings("unchecked")
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException, ParseException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.get(req, "tennguoidung", "");
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(PhieuMuonImpl.class, PortalClassLoaderUtil.getClassLoader());
		q.setLimit(Start, ketThuc);
		SimpleDateFormat fmd = new SimpleDateFormat("yyyy-MM-dd");
		String ngaymuon = ParamUtil.getString(req, "ngaymuon");
		Date ngaymuon1 = ParamUtil.getDate(req, "14-09-2000" , fmd);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String ngaytra = ParamUtil.getString(req, "ngaytra");
		Date ngaytra1 = ParamUtil.getDate(req, "15-10-2001" , fmt);
		if(!ten.equals("")){
			q.add(PropertyFactoryUtil.forName("UserId").like("%"+ten+"%"));
		}
		if(!ngaymuon.equals("")){
			Date MM = fmd.parse(ngaymuon);
			if(MM.compareTo(ngaymuon1)!=0){
				q.add(PropertyFactoryUtil.forName("NgayMuon").eq(MM));
			}
		}
		if(!ngaytra.equals("")){
			Date NT = fmt.parse(ngaytra);
			if(NT.compareTo(ngaytra1)!=0){
				q.add(PropertyFactoryUtil.forName("NgayTra").eq(NT));
			}
		}
		List<PhieuMuon> data = PhieuMuonLocalServiceUtil.dynamicQuery(q);
		long tong = GiaHanLocalServiceUtil.countTongs(ten, ngaymuon, ngaytra);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("data", data);
		req.setAttribute("ten", ten);
		req.setAttribute("ngaymuon", ngaymuon);
		req.setAttribute("ngaytra", ngaytra);
		res.setRenderParameter("jspPage","/html/quanlyphieumuon/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void delete(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		long id = ParamUtil.getLong(req, "id");
		PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
		PhieuMuonLocalServiceUtil.deletePhieuMuon(phieuMuon);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlyphieumuon_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlyphieumuon_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void duyetmuon(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
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

			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlyphieumuon_WAR_ThuVienQuanLyportlet");
			PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlyphieumuon_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
			url.setWindowState(LiferayWindowState.NORMAL);
			url.setPortletMode(LiferayPortletMode.VIEW);
			url.setParameter("javax.portlet.action", "thuVien");
			res.sendRedirect(url.toString());
	}
	public void tuchoi(ActionRequest req, ActionResponse res ) throws SystemException, PortalException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			req.setAttribute("PhieuMuon", phieuMuon);
			res.setRenderParameter("jspPage", "/html/quanlyphieumuon/tuchoi.jsp");
	}
	public void savePM(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			phieuMuon.setTrangThai(ParamUtil.getString(req, "trangthai"));
			phieuMuon.setXacNhan("2");
			PhieuMuonLocalServiceUtil.updatePhieuMuon(phieuMuon);

			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlyphieumuon_WAR_ThuVienQuanLyportlet");
			PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlyphieumuon_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
			url.setWindowState(LiferayWindowState.NORMAL);
			url.setPortletMode(LiferayPortletMode.VIEW);
			url.setParameter("javax.portlet.action", "thuVien");
			res.sendRedirect(url.toString());
	}
}

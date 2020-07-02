package com.thuvien;

import com.thuvien.model.PhieuMuon;
import com.thuvien.model.Sach;
import com.thuvien.model.impl.PhieuMuonImpl;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;

import java.io.IOException;
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
public class QuanLyTraSachNewPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.get(req, "ten", "");
		long tong = PhieuMuonLocalServiceUtil.countTraSachs(ten);
		long trasach = 0;
		String xacnhan = "1";
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(PhieuMuonImpl.class, PortalClassLoaderUtil.getClassLoader());
		q.setLimit(Start, ketThuc);
		if(!ten.equals("")){
			q.add(PropertyFactoryUtil.forName("UserId").like("%"+ten+"%"));
		}
		q.add(PropertyFactoryUtil.forName("TraSach").eq(trasach));
		q.add(PropertyFactoryUtil.forName("XacNhan").like("%"+xacnhan+"%"));
		List<PhieuMuon> data = PhieuMuonLocalServiceUtil.dynamicQuery(q);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("data", data);
		req.setAttribute("ten", ten);
		res.setRenderParameter("jspPage","/html/quanlytrasachnew/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void delete(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		long id = ParamUtil.getLong(req, "id");
		PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
		PhieuMuonLocalServiceUtil.deletePhieuMuon(phieuMuon);
		res.setRenderParameter("jspPage", "");
	}
	public void duyetmuon(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		long idsach = ParamUtil.getLong(req, "idsach");
		long idsachmuon = ParamUtil.getLong(req, "idsachmuon");
			PhieuMuon phieuMuon = PhieuMuonLocalServiceUtil.getPhieuMuon(id);
			phieuMuon.setTraSach(1);;
			PhieuMuonLocalServiceUtil.updatePhieuMuon(phieuMuon);
			Sach sachf = SachLocalServiceUtil.getSach(idsach);
			sachf.setSoLuong(idsachmuon);
			SachLocalServiceUtil.updateSach(sachf);

			ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlytrasachnew_WAR_ThuVienQuanLyportlet");
			PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlytrasachnew_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
			url.setWindowState(LiferayWindowState.NORMAL);
			url.setPortletMode(LiferayPortletMode.VIEW);
			url.setParameter("javax.portlet.action", "thuVien");
			res.sendRedirect(url.toString());
	}	
}

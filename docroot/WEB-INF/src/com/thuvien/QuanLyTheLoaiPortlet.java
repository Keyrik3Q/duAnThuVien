package com.thuvien;
import com.thuvien.model.TheLoai;
import com.thuvien.model.impl.TheLoaiImpl;
import com.thuvien.service.SachLocalServiceUtil;
import com.thuvien.service.TheLoaiLocalServiceUtil;

import java.io.IOException;
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

public class QuanLyTheLoaiPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.getString(req, "tentheloai");
		long tong = TheLoaiLocalServiceUtil.countTheLoais(ten);
		List<Object[]> data = TheLoaiLocalServiceUtil.findTheLoais(ten, Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("tong", tong);
		req.setAttribute("data", data);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("ten", ten);
		res.setRenderParameter("jspPage","/html/quanlytheloai/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void input(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		if(id!=0){
			TheLoai theLoai = TheLoaiLocalServiceUtil.getTheLoai(id);
			req.setAttribute("TheLoai", theLoai);
		}else if(id==0){
			TheLoai theLoai = new TheLoaiImpl();
			req.setAttribute("TheLoai", theLoai);
		}
		res.setRenderParameter("jspPage","/html/quanlytheloai/input.jsp");
	}
	public void save(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		if(id!=0){
			TheLoai theLoai = TheLoaiLocalServiceUtil.getTheLoai(id);
			theLoai.setTenTheLoai(ParamUtil.getString(req, "tentheloai"));
			TheLoaiLocalServiceUtil.updateTheLoai(theLoai);
		}else if(id==0){
			TheLoai theLoai = new TheLoaiImpl();
			theLoai.setId(CounterLocalServiceUtil.increment("TheLoai"));
			theLoai.setTenTheLoai(ParamUtil.getString(req, "tentheloai"));
			TheLoaiLocalServiceUtil.addTheLoai(theLoai);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlytheloai_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlytheloai_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void deleteTheLoai(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, IOException, PortletModeException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long[] deleteTheLoaiId = ParamUtil.getLongValues(req, "deleteTheLoaiId");
		for(int i=0; i<deleteTheLoaiId.length; i++){
			TheLoai theLoai = TheLoaiLocalServiceUtil.getTheLoai(deleteTheLoaiId[i]);
			TheLoaiLocalServiceUtil.deleteTheLoai(theLoai);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlytheloai_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlytheloai_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	
}

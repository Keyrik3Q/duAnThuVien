package com.thuvien;

import com.thuvien.model.Sach;
import com.thuvien.model.TheLoai;
import com.thuvien.model.impl.SachImpl;
import com.thuvien.model.impl.TheLoaiImpl;
import com.thuvien.service.SachLocalServiceUtil;
import com.thuvien.service.TheLoaiLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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

public class QuanLySachPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ten = ParamUtil.get(req, "tensach", "");
		String masach = ParamUtil.get(req, "masach", "");
		long theloai = ParamUtil.getLong(req, "theloai");
		long tong = SachLocalServiceUtil.countSachs(ten, masach, theloai);
		DynamicQuery p = DynamicQueryFactoryUtil.forClass(TheLoaiImpl.class, PortalClassLoaderUtil.getClassLoader());
		List<TheLoai> theLoai = TheLoaiLocalServiceUtil.dynamicQuery(p);
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(TheLoaiImpl.class, PortalClassLoaderUtil.getClassLoader());
		List<Sach> sachh = SachLocalServiceUtil.dynamicQuery(q);
		List<Object[]> data = SachLocalServiceUtil.findSachs(ten, masach, theloai, Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("data", data);
		req.setAttribute("tong", tong);
		req.setAttribute("cur", cur);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("theLoai", theLoai);
		req.setAttribute("ten", ten);
		req.setAttribute("maSach", masach);
		req.setAttribute("theloai", theloai);
		req.setAttribute("sachh", sachh);
		res.setRenderParameter("jspPage","/html/quanlysach/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void input(ActionRequest req, ActionResponse res) throws PortalException, SystemException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(TheLoaiImpl.class, PortalClassLoaderUtil.getClassLoader());
		List<TheLoai> data = TheLoaiLocalServiceUtil.dynamicQuery(q);
		long id = ParamUtil.getLong(req, "id");
		if(id!=0){
			Sach sachf = SachLocalServiceUtil.getSach(id);
			req.setAttribute("Sach", sachf);
			req.setAttribute("data", data);
		}else if(id==0){
			Sach sachf = new SachImpl();
			req.setAttribute("Sach", sachf);
			req.setAttribute("data", data);
		}
		res.setRenderParameter("jspPage","/html/quanlysach/input.jsp");
	}
	public void save(ActionRequest req, ActionResponse res ) throws SystemException, PortalException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long id = ParamUtil.getLong(req, "id");
		if(id!=0){
			Sach sachf = SachLocalServiceUtil.getSach(id);
			sachf.setTenSach(ParamUtil.getString(req, "tensach"));
			sachf.setTheLoaiId(ParamUtil.getLong(req, "theloaiid"));
			sachf.setSoLuong(ParamUtil.getLong(req, "soluong"));
			sachf.setTrangThai(ParamUtil.getString(req, "trangthai"));
			sachf.setNhaXB(ParamUtil.getString(req, "nhaxb"));
			sachf.setMaSach(ParamUtil.getString(req, "masach"));
			sachf.setKe(ParamUtil.getString(req, "ke"));
			sachf.setTang(ParamUtil.getString(req, "tang"));
			sachf.setMota(ParamUtil.getString(req, "mota"));
			SachLocalServiceUtil.updateSach(sachf);
		}else if(id==0){
			Sach sachf = new SachImpl();
			sachf.setId(CounterLocalServiceUtil.increment("Sach"));
			sachf.setTenSach(ParamUtil.getString(req, "tensach"));
			sachf.setTheLoaiId(ParamUtil.getLong(req, "theloaiid"));
			sachf.setSoLuong(ParamUtil.getLong(req, "soluong"));
			sachf.setTrangThai(ParamUtil.getString(req, "trangthai"));
			sachf.setNhaXB(ParamUtil.getString(req, "nhaxb"));
			sachf.setMaSach(ParamUtil.getString(req, "masach"));
			sachf.setKe(ParamUtil.getString(req, "ke"));
			sachf.setTang(ParamUtil.getString(req, "tang"));
			sachf.setMota(ParamUtil.getString(req, "mota"));
			SachLocalServiceUtil.addSach(sachf);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlysach_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlysach_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
		url.setWindowState(LiferayWindowState.NORMAL);
		url.setPortletMode(LiferayPortletMode.VIEW);
		url.setParameter("javax.portlet.action", "thuVien");
		res.sendRedirect(url.toString());
	}
	public void deleteSach(ActionRequest req, ActionResponse res) throws PortalException, SystemException, WindowStateException, PortletModeException, IOException{
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		long[] deleteSachId = ParamUtil.getLongValues(req, "deleteSachId");
		for(int i=0; i<deleteSachId.length; i++){
			Sach sachf = SachLocalServiceUtil.getSach(deleteSachId[i]);
			SachLocalServiceUtil.deleteSach(sachf);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "quanlysach_WAR_ThuVienQuanLyportlet");
		PortletURL url = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), "quanlysach_WAR_ThuVienQuanLyportlet", plid, PortletRequest.ACTION_PHASE);
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
		res.setRenderParameter("jspPage","/html/quanlysach/detail.jsp");
	}
	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException {

		long id = ParamUtil.getLong(request, "code");

		try {
			Sach Sachf = SachLocalServiceUtil.getSach(id);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("tensach", Sachf != null ? Sachf.getTenSach() : "");
			jsonObject.put("mota", Sachf != null ? Sachf.getMota() : "");
			jsonObject.put("nxb", Sachf != null ? Sachf.getNhaXB() : "" );
			jsonObject.put("theloai", Sachf != null ? TheLoaiLocalServiceUtil.getTheLoai(Sachf.getTheLoaiId()).getTenTheLoai() : "" );
			jsonObject.put("soluong", Sachf != null ? Sachf.getSoLuong() : 0 );
			jsonObject.put("trangthai", Sachf != null ? Sachf.getTrangThai() : "" );
			jsonObject.put("masach", Sachf != null ? Sachf.getMaSach() : "" );
			jsonObject.put("ke", Sachf != null ? Sachf.getKe() : "" );
			jsonObject.put("tang", Sachf != null ? Sachf.getTang() : "" );
			
			response.setContentType("text/javascript");
			response.setCharacterEncoding("UTF-8");

			PrintWriter printWriter;
			printWriter = response.getWriter();
			printWriter.write(jsonObject.toString());

			printWriter.flush();
			printWriter.close();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}
}

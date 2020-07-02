<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />
<%
long plidSach = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlysach_WAR_ThuVienQuanLyportlet");
long plidTheLoai = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlytheloai_WAR_ThuVienQuanLyportlet");
long plidPhieuMuon = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlyphieumuon_WAR_ThuVienQuanLyportlet");
long plidSearVaMuonSach = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"searchvamuonsach_WAR_ThuVienQuanLyportlet");
long plidDanhSachGiaHan = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"danhsachgiahan_WAR_ThuVienQuanLyportlet");
long plidGiaHan = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlygiahan_WAR_ThuVienQuanLyportlet");
long plidTraSach = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlytrasachnew_WAR_ThuVienQuanLyportlet");
long plidLichSu = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlylichsu_WAR_ThuVienQuanLyportlet");
long plidBaoCao = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),"quanlybaocao_WAR_ThuVienQuanLyportlet");

%>
<portlet:defineObjects />

<liferay-portlet:actionURL var="sachURL" name="thuVien" portletName="quanlysach_WAR_ThuVienQuanLyportlet" plid="<%=plidSach %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="theloaiURL" name="thuVien" portletName="quanlytheloai_WAR_ThuVienQuanLyportlet" plid="<%=plidTheLoai %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="phieumuonURL" name="thuVien" portletName="quanlyphieumuon_WAR_ThuVienQuanLyportlet" plid="<%=plidPhieuMuon %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="searchvamuonsachURL" name="thuVien" portletName="searchvamuonsach_WAR_ThuVienQuanLyportlet" plid="<%=plidSearVaMuonSach %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="dsgiahanURL" name="thuVien" portletName="danhsachgiahan_WAR_ThuVienQuanLyportlet" plid="<%=plidDanhSachGiaHan %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="giahanURL" name="thuVien" portletName="quanlygiahan_WAR_ThuVienQuanLyportlet" plid="<%=plidGiaHan %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="trasachURL" name="thuVien" portletName="quanlytrasachnew_WAR_ThuVienQuanLyportlet" plid="<%=plidTraSach %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="lichsuURL" name="thuVien" portletName="quanlylichsu_WAR_ThuVienQuanLyportlet" plid="<%=plidLichSu %>"></liferay-portlet:actionURL>
<liferay-portlet:actionURL var="baocaoURL" name="thuVien" portletName="quanlybaocao_WAR_ThuVienQuanLyportlet" plid="<%=plidBaoCao %>"></liferay-portlet:actionURL>


<li><a href="<%=sachURL%>">Quản Lý Sách</a></li>
<li><a href="<%=theloaiURL%>"> Quản LýThể Loại</a></li>
<li><a href="<%=phieumuonURL%>">Quản Lý Phiếu Mượn</a></li>
<li><a href="<%=searchvamuonsachURL%>">Tìm Kiếm và Mượn Sách</a></li>
<li><a href="<%=dsgiahanURL%>">Danh Sách Gia Hạn</a></li>
<li><a href="<%=giahanURL%>">Quản Lý Gia Hạn</a></li>
<li><a href="<%=trasachURL%>">Quản Lý Trả Sách</a></li>
<li><a href="<%=lichsuURL%>">Lịch Sử Mượn Trả</a></li>
<li><a href="<%=baocaoURL%>">Báo Cáo Thống Kê</a></li>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.thuvien.service.SachLocalServiceUtil"%>
<%@page import="com.thuvien.model.PhieuMuon"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.sun.mail.imap.protocol.Item"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException"%>
<%@page import="javax.portlet.filter.ActionRequestWrapper"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />

<liferay-portlet:actionURL var="phieumuonURL" name="thuVien"></liferay-portlet:actionURL>
<a href="<%=phieumuonURL%>"> «« Quay về </a>
<%	PhieuMuon phieuMuon = (PhieuMuon)request.getAttribute("PhieuMuon");
	SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");%>
<h1 style="text-align: center">Lý Do Từ Chối</h1>
	<table style="background: #0000000d">
	<tr>
		<td style="color:red; width:100px">
			Tên Sách:
		</td>
		<td style="color:red; width:100px">
			Tên Thể Loại:
		</td>
		<td style="color:red; width:100px">
			Người Mượn:
		</td>
		<td style="color:red; width:100px">
			Ngày Mượn:
		</td>
		<td style="color:red; width:100px">
			Ngày Trả:
		</td>
	</tr>
		
		<tr>
			<td>
				<%=SachLocalServiceUtil.getSach(phieuMuon.getSachId()).getTenSach()%>
			</td>
			<td>
				<%=SachLocalServiceUtil.getSach(phieuMuon.getSachId()).getTheLoaiId()%>
			</td>
			<td>
				<%=phieuMuon.getUserId() %>
			</td>
			<td>
				<%=dateFomat.format(phieuMuon.getNgayMuon())%>
			</td>
			<td>
				<%=dateFomat.format(phieuMuon.getNgayTra())%>
			</td>
		</tr>	
	</table>
	<liferay-portlet:actionURL var="savePMURL" name="savePM"></liferay-portlet:actionURL>
	<form name=frm method=POST action="<%=savePMURL%>">
	<input type= "hidden" value="<%=phieuMuon.getId()%>" name="<portlet:namespace/>id">
	<table style="margin-top:20px;">
		<tr>
			<td>
				<aui:input label="nhập lý do từ chối:" type="text" value="<%=phieuMuon.getTrangThai()%>" name="trangthai"></aui:input>
				<aui:button icon="icon-save" type="submit" value="Save"></aui:button>
			</td>
		</tr>
	</table>
	</form>

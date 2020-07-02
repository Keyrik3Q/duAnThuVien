<%@page import="com.thuvien.model.GiaHan"%>
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

<%	PhieuMuon phieuMuon = (PhieuMuon)request.getAttribute("PhieuMuon");
	GiaHan giaHan = (GiaHan)request.getAttribute("GiaHan");
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
	</table>
	<liferay-portlet:actionURL var="savetcURL" name="savetc"></liferay-portlet:actionURL>
	<form name=frm method=POST action="<%=savetcURL%>">
	<input type= "hidden" value="<%=giaHan.getIdGh()%>" name="<portlet:namespace/>id">
	<table style="margin-top:20px;">
		<tr>
			<td>
				<aui:input label="nhập lý do từ chối:" type="text" value="<%=giaHan.getTrangThai()%>" name="trangthai"></aui:input>
				<aui:button icon="icon-save" type="submit" value="Save"></aui:button>
			</td>
		</tr>
	</table>
	</form>

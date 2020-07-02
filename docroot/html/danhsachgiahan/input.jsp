<%@page import="com.thuvien.model.GiaHan"%>
<%@page import="com.thuvien.model.PhieuMuon"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />

	<%
	PhieuMuon phieuMuon = (PhieuMuon)request.getAttribute("PhieuMuon");
	SimpleDateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	%>
<liferay-portlet:actionURL var="giahanURL" name="thuVien"></liferay-portlet:actionURL>
<a href="<%=giahanURL%>"> «« Quay về </a>
<liferay-portlet:actionURL var="addghURL" name="addgh"></liferay-portlet:actionURL>
<form name=frm method=POST action="<%=addghURL%>">
	<aui:input type= "hidden" value="<%=phieuMuon.getId()%>" name="PhieuMuon"></aui:input>
	<table>
		<tr>
			<td>
				<aui:input label="Ngày Gia Hạn:" name="ngaygiahan" type="Date"></aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:button icon="icon-download" type="submit" value="Gia Hạn"></aui:button>
			</td>
		</tr>
	</table>
</form>
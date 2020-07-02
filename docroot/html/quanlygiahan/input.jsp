<%@page import="com.thuvien.model.GiaHan"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />

	<%GiaHan giaHan = (GiaHan)request.getAttribute("PhieuMuon");%>

<liferay-portlet:actionURL var="savegiahanURL" name="savegiahan"></liferay-portlet:actionURL>
<form name=frm method=POST action="<%=savegiahanURL%>">
	<input type= "hidden" value="<%=giaHan.getIdGh()%>" name="<portlet:namespace/>id">
	<table>
		<tr>
			<td>
				<aui:input type="date" value="<%=giaHan.getNgayGianHan()%>" name="ngaygiahan"></aui:input>
				<aui:button type="submit" value="Save"></aui:button>
			</td>
		</tr>
	</table>
</form>
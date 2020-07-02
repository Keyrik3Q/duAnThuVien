<%@page import="com.thuvien.service.SachLocalServiceUtil"%>
<%@page import="com.thuvien.service.PhieuMuonLocalServiceUtil"%>
<%@page import="com.thuvien.model.GiaHan"%>
<%@page import="java.text.SimpleDateFormat"%>
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


<portlet:defineObjects />
<%
	List<GiaHan> data = (List<GiaHan>)request.getAttribute("data");
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
	String ten = GetterUtil.getString(request.getAttribute("ten"),"");
	String user = GetterUtil.getString(request.getAttribute("userid"),"");
	
	SimpleDateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("ten", ten);
	interatorURL.setParameter("userid", user);
%>
<liferay-portlet:actionURL var="giahanURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=giahanURL%>">
	<table>
		<tr>
			<td>
				<aui:input placeholder="nhập tên người mượn" label="Tên Người Mượn:" type="text" value="<%=user %>" name="userid"></aui:input>
			</td>
			<td>
				<aui:input placeholder="nhập tên sách" label="Tên Sách:" type="text" value="<%=ten %>" name="ten"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 12px"></aui:button>
			</td>
		</tr>
	</table>
</aui:form>

<liferay-ui:search-container iteratorURL="<%=interatorURL%>" 
											emptyResultsMessage="khong tim thay" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="java.lang.Object[]"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Người Mượn">
			<%=item[1]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
			<%=item[2]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Hết Hạn">
			<%=item[4]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Gia Hạn">
			<%=item[10]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Xữ Lý Yêu Cầu">
			<liferay-portlet:actionURL var="duyetmuonURL" name="duyetmuon">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[12])%>"/>
				<liferay-portlet:param name="ngaygiahan" value="<%=String.valueOf(item[10])%>"/>
				<liferay-portlet:param name="idpm" value="<%=String.valueOf(item[11])%>"/>
			</liferay-portlet:actionURL>
			<aui:button icon="icon-edit" style="background:#5bb722; color: #fff; text-shadow: 0 -1px 0 rgba(2, 2, 2, 0);border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);" value="Đồng Ý" href="<%=duyetmuonURL%>"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
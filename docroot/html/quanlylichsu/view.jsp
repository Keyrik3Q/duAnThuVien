<%@page import="com.thuvien.service.GiaHanLocalServiceUtil"%>
<%@page import="com.thuvien.service.SachLocalServiceUtil"%>
<%@page import="com.thuvien.model.PhieuMuon"%>
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
	List<Object[]> data = (List<Object[]>)request.getAttribute("data");
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
	String ten = GetterUtil.getString(request.getAttribute("ten"),"");
	String userid = GetterUtil.getString(request.getAttribute("userid"),"");
	String ngaymuon = GetterUtil.getString(request.getAttribute("ngaymuon"),"");
	String ngaytra = GetterUtil.getString(request.getAttribute("ngaytra"),"");
	SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("ten", ten);
	interatorURL.setParameter("ngaymuon", ngaymuon);
	interatorURL.setParameter("ngaytra", ngaytra);
	interatorURL.setParameter("userid", userid);
%>
<liferay-portlet:actionURL var="phieumuonURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=phieumuonURL%>">
	<table>
		<tr>
			<td>
				<aui:input placeholder="nhập tên người dùng" label="Tên Người Dùng:" type="text" value="<%=userid %>" name="userid"></aui:input>
			</td>
			<td>
				<aui:input placeholder="nhập tên sách" label="Tên Sách:" type="text" value="<%=ten %>" name="ten"></aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input label="Ngày Mượn:" name="ngaymuon" value="<%=ngaymuon %>" type="Date"></aui:input>
			</td>
			<td>
				<aui:input label="Ngày Trả:" name="ngaytra" value="<%=ngaytra %>" type="Date" ></aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 12px"></aui:button>
			</td>
		</tr>
	</table>
</aui:form>
<liferay-ui:search-container iteratorURL="<%=interatorURL%>" 
											delta="<%=delta%>" 
											emptyResultsMessage="khong tim thay" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="java.lang.Object[]"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Người Dùng">
			<%=item[1]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
			<liferay-portlet:actionURL var="detailURL" name="detail">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[9])%>"/>
			</liferay-portlet:actionURL>
			<a href="<%=detailURL%>"><%=item[2]%></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Lý Do:">
			<%=item[8]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Mượn">
			<%=item[3]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Trả">
			<%=item[4]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Xác Nhận">
			<%if(item[6].equals("")){%>
				đang xác nhận
			<% }else if(item[6].equals("1")){%>
				cho mượn
			<% }else if(item[6].equals("2")){%>
				đã từ chối
			<%}%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
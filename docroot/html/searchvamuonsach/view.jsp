<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.thuvien.service.TheLoaiLocalServiceUtil"%>
<%@page import="com.thuvien.model.TheLoai"%>
<%@page import="com.thuvien.model.Sach"%>
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
	List<TheLoai> Theloai = (List<TheLoai>)request.getAttribute("theLoai");
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
	String ten = GetterUtil.getString(request.getAttribute("ten"),"");
	String masach = GetterUtil.getString(request.getAttribute("masach"),"");
	long[] theloai = ParamUtil.getLongValues(request, "theloai");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("tensach", ten);
	for(int i=0; i<theloai.length; i++){
		interatorURL.setParameter("theloai", String.valueOf(theloai[i]));
	}
	interatorURL.setParameter("masach", masach);
	
%>
<liferay-portlet:actionURL var="searchvamuonsachURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=searchvamuonsachURL%>">
	<table>
		<tr>
			<td>
				<aui:input placeholder="nhập tên sách" label="Tên Sách:" type="text" value="" name="tensach"></aui:input>
			</td>
			<td>
				<aui:input placeholder="nhập mã sách" label="Mã Sách:" type="text" value="" name="masach"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 12px;"></aui:button>
			</td>
		</tr>
	</table>
	<div style="display: flex;">
		<select id="rightValues" size="4" multiple>
				<%for(int i=0; i<Theloai.size(); i++){ %>
					<%if(theloai.length == (Theloai.get(i).getId())){ %>
						<option value="<%=Theloai.get(i).getId()%>" selected>
							<%=Theloai.get(i).getTenTheLoai() %>
						</option>
					<%}else{ %>
						<option value="<%=Theloai.get(i).getId()%>">
							<%=Theloai.get(i).getTenTheLoai() %>
						</option>
						<%} %>
					<%} %>
			</select>
		<div>
	        <input type="button" id="btnLeft" value="N" ></input>
	        <input type="button" id="btnRight" value="D" ></input>
    	</div>
		<div>
        	<select name="<portlet:namespace />theloai" id="leftValues" size="5" multiple></select>
   		</div>
	</div>	
</aui:form>
<liferay-ui:search-container iteratorURL="<%=interatorURL%>" 
											delta="<%=delta%>" 
											emptyResultsMessage="khong tim thay" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="java.lang.Object[]"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow" keyProperty="[0]">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
		<liferay-portlet:actionURL var="detailURL" name="detail">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[0])%>"/>
			</liferay-portlet:actionURL>
			<a href="<%=detailURL%>"><%=item[1]%></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Thể Loại">
			<%=item[3]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Mã Sách">
			<%=item[2]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Chức năng">
			<liferay-portlet:actionURL var="muonsachURL" name="muonsach">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[0])%>"/>
			</liferay-portlet:actionURL>
			<aui:button icon="icon-download" style="background:#5bb722" type="submit" value="Mượn Sách" href="<%=muonsachURL%>"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
	$("#btnLeft").click(function () {
	    var selectedItem = $("#rightValues option:selected");
	    $("#leftValues").append(selectedItem);
	});
	
	$("#btnRight").click(function () {
	    var selectedItem = $("#leftValues option:selected");
	    $("#rightValues").append(selectedItem);
	});
	
	$("#rightValues").change(function () {
	    var selectedItem = $("#rightValues option:selected");
	    $("#txtRight").val(selectedItem.text());
	});
</script>

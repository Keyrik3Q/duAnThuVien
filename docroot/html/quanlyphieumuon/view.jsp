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
	List<PhieuMuon> data = (List<PhieuMuon>)request.getAttribute("data");
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
	String ten = GetterUtil.getString(request.getAttribute("ten"),"");
	String ngaymuon = GetterUtil.getString(request.getAttribute("ngaymuon"),"");
	String ngaytra = GetterUtil.getString(request.getAttribute("ngaytra"),"");
	SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("tennguoidung", ten);
	interatorURL.setParameter("ngaymuon", ngaymuon);
	interatorURL.setParameter("ngaytra", ngaytra);
%>
<liferay-portlet:actionURL var="phieumuonURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=phieumuonURL%>">
	<table>
		<tr>
			<td>
				<aui:input placeholder="Nhập tên người dùng:" label="Người Dùng:" type="text" value="<%=ten %>" name="tennguoidung"></aui:input>
			</td>
			<td>
				<aui:input label="Ngày Mượn:" name="ngaymuon" type="text" value="<%=ngaymuon %>"></aui:input>
			</td>
			<td>
				<aui:input label="Ngày Trả:" name="ngaytra" type="Date" value="<%=ngaytra %>"></aui:input>
			</td>
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
	<liferay-ui:search-container-row className="com.thuvien.model.PhieuMuon"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Người Dùng">
			<%=item.getUserId()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
			<%=SachLocalServiceUtil.getSach(item.getSachId()).getTenSach()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Mượn">
			<%=dateFomat.format(item.getNgayMuon())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Trả">
			<%=dateFomat.format(item.getNgayTra())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Xác Nhận">
			<%if(item.getXacNhan()==""){%>
				đang xác nhận
			<% }else if(item.getXacNhan().equals("1")){%>
				cho mượn
			<% }else if(item.getXacNhan().equals("2")){%>
				đã từ chối
			<%}%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Kiểm Duyệt">
		<%if(item.getXacNhan()!="" || item.getTrangThai()!=""){%>
			đã xữ lý
			<%}else{ %>
		<%if(item.getXacNhan()=="" && SachLocalServiceUtil.getSach(item.getSachId()).getSoLuong()>item.getSoLuong()){ %>
			<liferay-portlet:actionURL var="duyetmuonURL" name="duyetmuon">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item.getId())%>"/>
				<liferay-portlet:param name="idsach" value="<%=String.valueOf(SachLocalServiceUtil.getSach(item.getSachId()).getId())%>"/>
				<liferay-portlet:param name="idsachmuon" value="<%=String.valueOf(SachLocalServiceUtil.getSach(item.getSachId()).getSoLuong()-item.getSoLuong())%>"/>
			</liferay-portlet:actionURL>
			<aui:button icon="icon-check" style="background:#5bb722" type="submit" value="Đồng Ý" href="<%=duyetmuonURL%>"></aui:button>
			<liferay-portlet:actionURL var="tuchoiURL" name="tuchoi">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item.getId())%>"/>
			</liferay-portlet:actionURL>
			<aui:button icon="icon-minus-sign" style="background: red; color: #fff" value="Từ Chối" href="<%=tuchoiURL%>"></aui:button>
			<%} %>
		<%} %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
	<portlet:resourceURL var="resourceURL" >
</portlet:resourceURL>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<aui:script>
    AUI().use(
        'aui-datepicker-deprecated',
        function(A) {
        	new A.DatePicker({
        	    trigger: '.startDate',
                mask: '%d-%m-%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
    );
	</aui:script>
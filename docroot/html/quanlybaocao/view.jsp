<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.thuvien.service.TheLoaiLocalServiceUtil"%>
<%@page import="com.thuvien.model.TheLoai"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
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
	String ngaydau = GetterUtil.getString(request.getAttribute("ngaydau"));
	String ngaycuoi = GetterUtil.getString(request.getAttribute("ngaycuoi"));
	SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("ngaydau",ngaydau);
	interatorURL.setParameter("ngaycuoi",ngaycuoi);
	
%>
<liferay-portlet:actionURL var="phieumuonURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=phieumuonURL%>">
	<table>
		<tr>
			<td>
				<aui:input label="Từ Ngày:" value="<%=ngaydau %>" name="ngaydau" id="ngaydau" type="Date"></aui:input>
			</td>
			<td>
				<aui:input label="Đến Ngày:" value="<%=ngaycuoi %>" name="ngaycuoi" id="ngaycuoi" type="Date"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" style="margin-bottom: 11px;" type="submit" value="Xem"></aui:button>
			</td>
			<td>
				<liferay-portlet:resourceURL var="xuatfileURL">
					<liferay-portlet:param name="ngaydau" value="<%=String.valueOf(ngaydau)%>"/>
					<liferay-portlet:param name="ngaycuoi" value="<%=String.valueOf(ngaycuoi)%>"/>
				</liferay-portlet:resourceURL>
				<aui:button icon="icon-upload-alt" style="margin-bottom: 11px;background:#5bb722;color: #fff;text-shadow: 0 -1px 0 rgba(2, 2, 2, 0);border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);" type="button" value="XUẤT BÁO CÁO" href="<%=xuatfileURL %>"></aui:button>
			</td>
		</tr>
	</table>
</aui:form>
	<table>
		<tr style="display: inline-block">
			<td style="padding-left: 5px">Tháng</td>
			<td style="padding-left: 385px">Quý</td>
			<td style="padding-left: 135px;">Năm</td>
		</tr>
		<tr style=" display: flex;">
			<td style=" display: flex;">
				<%for(int i=1; i<13; i++){ %>
					<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheck<%=i%>()"><%=i %>
				<%} %>
			</td>	
			<td style=" display: flex;margin-left: 30px">
					<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheckI()">I
					<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheckII()">II
					<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheckIII()">III
					<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheckIV()">IV
			</td>
			<td style="display: flex;margin-left: 30px">
				<input name="radio" type="radio" style="margin-left: 10px;" onclick="RadioCheckV()">Cả Năm
			</td>
		</tr>
	</table>
<liferay-ui:search-container iteratorURL="<%=interatorURL%>"
											delta="<%=delta%>" 
											emptyResultsMessage="Không tìm thấy dữ liệu" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="java.lang.Object[]"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow" keyProperty="id">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
			<%=item[1]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Thể Loại">
			<%=item[2]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Sách Còn">
			<%=item[5]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Sách Đã Mượn">
			<%=item[6]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Mượn">
			<%=dateFomat.format(item[3])%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày Trả">
			<%=dateFomat.format(item[4])%>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>

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
	function RadioCheck1(){
		document.getElementById("<portlet:namespace />ngaydau").value = "2019-01-01";
		document.getElementById("<portlet:namespace />ngaycuoi").value = "2019-01-31";
	};
	function RadioCheck2(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-02-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-02-28";
	};
	function RadioCheck3(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-03-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-03-31";
	};
	function RadioCheck4(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-04-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-04-30";
	};
	function RadioCheck5(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-05-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-05-31";
	};
	function RadioCheck6(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-06-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-06-30";
	};
	function RadioCheck7(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-07-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-07-31";
	};
	function RadioCheck8(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-08-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-08-31";
	};
	function RadioCheck9(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-09-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-09-30";
	};
	function RadioCheck10(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-10-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-10-31";
	};
	function RadioCheck11(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-11-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-11-30";
	};
	function RadioCheck12(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-12-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-12-31";
	};
	function RadioCheckI(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-01-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-03-31";
	};
	function RadioCheckII(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-04-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-06-30";
	};
	function RadioCheckIII(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-07-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-09-30";
	};
	function RadioCheckIV(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-10-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-12-31";
	};
	function RadioCheckV(){
		 document.getElementById("<portlet:namespace />ngaydau").value= "2019-01-01";
		 document.getElementById("<portlet:namespace />ngaycuoi").value= "2019-12-31";
	};
	
</aui:script>
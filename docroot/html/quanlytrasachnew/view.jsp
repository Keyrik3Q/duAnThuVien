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
	SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM");
	String ten = GetterUtil.getString(request.getAttribute("ten"),"");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("ten", ten);
%>
<liferay-portlet:actionURL var="trasachnewURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=trasachnewURL%>">
	<table>
		<tr>
			<td>
				<aui:input placeholder="nhập tên người dùng" label="Tên Người Dùng:" type="text" value="<%=ten %>" name="ten"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 12px;"></aui:button>
			</td>
		</tr>
	</table>
	
	
	<div>  
    <table>
        <tr>
            <td>
                Country :
            </td>
            <td >
                <select id="ddlCountries">
               
                    <option Value="0" Selected>--Select--</option>
                    <option Value="1">Pakistan</option>
                    <option Value="2">India</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                Place :
            </td>
            <td>
                <select id="ddlPlaces">
                    <option Value="0" Selected>--Select--</option>
                    <option Value="1">Islamabad</option>
                    <option Value="1"> Rawalpandi</option>
                    <option Value="1">Lahore</option>
                    <option Value="2"> Agra</option>
                    <option Value="2">Dahli</option>
                    <option Value="2">Mumbai</option>
                </select>
            </td>
        </tr>
    </table>
</div>
	
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        var options = $('[id*=ddlPlaces]').html();
        $('[id*=ddlCountries]').bind('change', function () {
            $('[id*=ddlPlaces]').html(options);
            var country = $('[id*=ddlCountries]').val();
            if (country == 0) return;
            $('[id*=ddlPlaces]').find(':not([value^="' + country + '"]):not([value^="0"])').remove();
        });
    });    
    
    window.onload = function () {
        var parentSelect = document.getElementById("ddlCountries");
        var childSelect = document.getElementById("ddlPlaces");
        var options = [].slice.apply(childSelect, [0]);
        var emptyOption = options[0];
        childSelect.innerHTML = "";
        childSelect.options.add(emptyOption);
        parentSelect.addEventListener("change", function (e) {
            var selectedValue = parentSelect.options[parentSelect.selectedIndex].value;
            childSelect.innerHTML = "";
            childSelect.options.add(emptyOption);
            if (selectedValue == 0) return;
            for (var i = 0; i < options.length; i++) {
                if (options[i].getAttribute("value") == selectedValue) {
                    childSelect.options.add(options[i]);
                }
            }
        });
        return false;
    };          
</script>
	
	
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
		<liferay-ui:search-container-column-text name="Tên Người Dùng">
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
		<liferay-ui:search-container-column-text name="Duyệt Trả Sách">
			<liferay-portlet:actionURL var="duyetmuonURL" name="duyetmuon">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item.getId())%>"/>
				<liferay-portlet:param name="idsach" value="<%=String.valueOf(SachLocalServiceUtil.getSach(item.getSachId()).getId())%>"/>
				<liferay-portlet:param name="idsachmuon" value="<%=String.valueOf(SachLocalServiceUtil.getSach(item.getSachId()).getSoLuong()+item.getSoLuong())%>"/>
			</liferay-portlet:actionURL>
			<aui:button style="background:#5bb722" icon="icon-check" type="submit" value="Chấp Nhận" href="<%=duyetmuonURL%>"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
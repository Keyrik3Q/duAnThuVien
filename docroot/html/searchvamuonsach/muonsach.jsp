<%@page import="com.thuvien.service.TheLoaiLocalServiceUtil"%>
<%@page import="com.thuvien.model.PhieuMuon"%>
<%@page import="com.thuvien.model.Sach"%>
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
	Sach sachM = (Sach)request.getAttribute("Sach");
	PhieuMuon phieuMuon = (PhieuMuon)request.getAttribute("PhieuMuon");
	SimpleDateFormat dateFomat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	ThemeDisplay td = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	User UserId = td.getUser();
	%>


<%Sach sachf = (Sach)request.getAttribute("Sach");%>
<h3 style="text-align: center">Sách Bạn Mượn: <u> <%=sachf.getTenSach() %> </u></h3>
	<table style="background: #0000000d">
		<tr>
			<td style="color:red; width:130px">
				Tên Sách:
			</td>
			<td style="color:red; width:130px">
				Tên Thể Loại:
			</td>
			<td style="color:red; width:130px">
				Trạng Thái:
			</td>
			<td style="color:red; width:130px">
				Nhà Xuất Bản:
			</td>
			<td style="color:red; width:130px">
				Kệ:
			</td>
			<td style="color:red; width:130px">
				Tầng:
			</td>
			<td style="color:red; width:130px">
				Mô Tả:
			</td>
		</tr>
		<tr>
			<td style="width:130px">
				<%=sachf.getTenSach() %>
			</td>
			<td style="width:130px">
				<%=TheLoaiLocalServiceUtil.getTheLoai(sachf.getTheLoaiId()).getTenTheLoai() %>
			</td>
			<td style="width:130px">
				<%=sachf.getTrangThai() %>
			</td>
			<td style="width:130px">
				<%=sachf.getNhaXB() %>
			</td>
			<td style="width:130px">
				<%=sachf.getKe() %>
			</td>
			<td style="width:130px">
				<%=sachf.getTang() %>
			</td>
			<td style="width:130px">
				<%=sachf.getMota() %>
			</td>
		</tr>
	</table>
<liferay-portlet:actionURL var="addbyURL" name="addby"></liferay-portlet:actionURL>
<form name=frm method=POST action="<%=addbyURL%>">
	<aui:input type= "hidden" value="<%=UserLocalServiceUtil.getUser(UserId.getUserId()).getLastName()%>" name="UserId"></aui:input>
	<aui:input type= "hidden" value="<%=sachM.getId()%>" name="Sach"></aui:input>
	<table>
		<tr>
			<td>
				<aui:input label="Ngày Mượn:" name="ngaymuon" value="<%=dateFomat.format(date)%>" type="Date" cssClass="startDate"></aui:input>
			</td>
			<td>
				<aui:input label="Ngày Trả:" type="Date" value="<%=dateFomat.format(date)%>" name="ngaytra"></aui:input>
			</td>
			<td>
				<aui:select label="Số Lượng:" name="soluong">
					<%for(int i=1; i<6; i++){ %>
					<aui:option value="<%=i%>"><%=i %></aui:option>
					<%} %>
				</aui:select>
			</td>
		</tr>
		<tr>
			<td>
				<aui:button icon="icon-download" type="submit" value="Mượn Sách"></aui:button>
			</td>
		</tr>
	</table>
</form>
<aui:script>
    AUI().use(
        'aui-datepicker-deprecated',
        function(A) {
        	new A.DatePicker({
        	    trigger: '.startDate',
                mask: '%Y-%m-%d',
                popover: {
                    zIndex: 1000
                }
            });
        }
    );
</aui:script>
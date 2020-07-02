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
	String tentheloai = GetterUtil.getString(request.getAttribute("ten"),"");
	
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("tentheloai", tentheloai);
%>

<liferay-portlet:actionURL var="inputURL" name="input"></liferay-portlet:actionURL>
<aui:button icon="icon-upload-alt" style="margin-left: 10px;float: right; background:#5bb722" type="submit" value="thêm mới" href="<%=inputURL %>"></aui:button>
<liferay-portlet:actionURL var="theloaiURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=theloaiURL%>">
	<table>
		<tr>
			<td>
				<aui:input label="Tên Thể Loại:" placeholder="nhập tên thể loại" name="tentheloai" type="text" value="<%=tentheloai %>"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 11px;"></aui:button>
			</td>
		</tr>
	</table>
</aui:form>
<liferay-portlet:actionURL var="deleteStudentsURL" name="deleteTheLoai"></liferay-portlet:actionURL>
<aui:form name="fm" method="POST" action="<%=deleteStudentsURL%>">
	<aui:button icon="icon-bitbucket" style="background: #f00;" onClick='<%= renderResponse.getNamespace() + "deleteTheLoai();" %>' type="submit" value="delete"/>
	<aui:input name="deleteTheLoaiId" type="hidden"></aui:input>
<liferay-ui:search-container iteratorURL="<%=interatorURL%>"
											rowChecker="<%=new RowChecker(renderResponse) %>" 
											delta="<%=delta%>" 
											emptyResultsMessage="Không tìm thấy dữ liệu" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="java.lang.Object[]"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow" keyProperty="[0]">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Thể Loại">
			<%=item[1]%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Chức năng">
			<liferay-portlet:actionURL var="updateURL" name="input">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[0])%>"/>
			</liferay-portlet:actionURL>
			<aui:button icon="icon-edit" style="background:#5bb722; color: #fff; text-shadow: 0 -1px 0 rgba(2, 2, 2, 0);border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);" value="Sửa" href="<%=updateURL%>"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
</liferay-ui:search-container>

</aui:form>
	<aui:script>
		Liferay.provide(
			window,
				'<portlet:namespace />deleteTheLoai',
					function() {
					var deleteTheLoaiId = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					if (deleteTheLoaiId && confirm('<%= UnicodeLanguageUtil.get(pageContext, "Nếu thực hiện bạn sẽ xoá") %>')) {
					document.<portlet:namespace />fm.<portlet:namespace />deleteTheLoaiId.value = deleteTheLoaiId;
					submitForm(document.<portlet:namespace />fm, '<%=deleteStudentsURL%>');
					}
					},
				['liferay-util-list-fields']
			);
	</aui:script>
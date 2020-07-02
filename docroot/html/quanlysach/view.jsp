<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.thuvien.service.TheLoaiLocalServiceUtil"%>
<%@page import="com.thuvien.model.TheLoai"%>
<%@page import="com.thuvien.model.Sach"%>
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
	List<TheLoai> Theloai = (List<TheLoai>)request.getAttribute("theLoai");
	List<Sach> Sachk = (List<Sach>)request.getAttribute("sachhh");
	Sach sachkk = (Sach)request.getAttribute("sachkk");
	
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
	String ma = GetterUtil.getString(request.getAttribute("maSach"),"");
	long theloai = GetterUtil.getLong(request.getAttribute("theloai"),0);
	String tensach = GetterUtil.getString(request.getAttribute("ten"),"");
	
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "thuVien");
	interatorURL.setParameter("tensach", tensach);
	interatorURL.setParameter("masach", ma);
	interatorURL.setParameter("theloai", String.valueOf(theloai));
	
%>

<liferay-portlet:actionURL var="inputURL" name="input"></liferay-portlet:actionURL>
<aui:button icon="icon-upload-alt" style="margin-left: 10px; float: right; background:#5bb722" type="submit" value="thêm mới" href="<%=inputURL %>"></aui:button>
<liferay-portlet:actionURL var="sachURL" name="thuVien"></liferay-portlet:actionURL>
<aui:form name="frm" method="POST" action="<%=sachURL%>">
	<table>
		<tr>
			<td>
				<aui:input label="Tên Sách:" placeholder="nhập tên sách" name="tensach" type="text" value="<%=tensach %>" ></aui:input>
			</td>
			<td>
				<aui:select label="Thể Loại:" name="theloai">
					<option>--Vui Lòng Chọn--</option>
					<%for(int i=0; i<Theloai.size(); i++){ %>
						<%if(theloai == Theloai.get(i).getId()){ %>
							<option value="<%=Theloai.get(i).getId()%>" selected>
								<%=Theloai.get(i).getTenTheLoai() %>
							</option>
						<%}else{ %>
							<option value="<%=Theloai.get(i).getId()%>">
								<%=Theloai.get(i).getTenTheLoai() %>
							</option>
							<%} %>
						<%} %>
				</aui:select>
				<td>
			
		</td>
			</td>
			<td>
				<aui:input label="Mã Sách:" placeholder="nhập mã sách" type="text" value="<%=ma %>" name="masach"></aui:input>
			</td>
			<td>
				<aui:button icon="icon-search" type="submit" value="Tìm" style="margin-bottom: 11px;"></aui:button>
			</td>
		</tr>
	</table>
</aui:form>
<liferay-portlet:actionURL var="deleteStudentsURL" name="deleteSach"></liferay-portlet:actionURL>
<aui:form style="width: 100%" name="fm" method="POST" action="<%=deleteStudentsURL%>">
<div style="width: 50%">
	<aui:button icon="icon-bitbucket" style="background: #f00;" onClick='<%= renderResponse.getNamespace() + "deleteSach();" %>' type="submit" value="delete"/>
	<aui:input name="deleteSachId" type="hidden"></aui:input>
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
			<%=String.valueOf(itemIdex + 1+searchContainer.getStart())%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên Sách">
		<liferay-portlet:actionURL var="detailURL" name="detail">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item[0])%>"/>
			</liferay-portlet:actionURL>
			<a onclick="onSearch(<%=String.valueOf(item[0])%>);" ><%=item[1]%></a>
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
</div>
<div style="left: 66%;
    position: absolute;
    top: 47%; display:none" id="divnax">
	<portlet:resourceURL var="resourceURL" >
	<head>
  		<meta charset="UTF-8">
	</head>
	<h3>Chi Tiết Sách <span style="color: red" id="tensach" ></span> </h3>
	<table>	
	<tr>
		<td>
			<span>Mô Tả:</span>	
		</td>
		<td>
			<span style="font-weight: bold;" id="mota"></span>
		</td>
	</tr>
	
	<tr>
		<td>
			<span>Nhà Xuất Bản:</span>	
		</td>
		<td>
			<span style="font-weight: bold;" id="nxb"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Thể Loại:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="theloai"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Số Lượng:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="soluong"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Trạng Thái:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="trangthai"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Mã Sách:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="masach"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Kệ:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="ke"></span>
		</td>
	</tr>
	<tr>
		<td>
			<span>Tầng:</span>			
		</td>
		<td>
			<span style="font-weight: bold;" id="tang"></span>
		</td>
	</tr>
</table>
</portlet:resourceURL>
</div>
<aui:script use="aui-base,aui-node,aui-io-request,liferay-portlet-url">
	Liferay.provide(
			window,
				'<portlet:namespace />deleteSach',
					function() {
					var deleteSachId = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');
					if (deleteSachId && confirm('<%= UnicodeLanguageUtil.get(pageContext, "Nếu thực hiện bạn sẽ xoá") %>')) {
					document.<portlet:namespace />fm.<portlet:namespace />deleteSachId.value = deleteSachId;
					submitForm(document.<portlet:namespace />fm, '<%=deleteStudentsURL%>');
					}
					},
				['liferay-util-list-fields']
			);
	Liferay.provide(
		window, 
		"onSearch", 
		function(a) {
			var code = a;
			var show = document.getElementById("divnax");
				show.style.display = "block";
			var resourceURL = '<%= resourceURL.toString()%>';	
			var ajaxrequest = AUI().io.request(
				resourceURL,
				{
					data: {'<portlet:namespace/>code': code},
					dataType: 'json',
					method: 'post',
					autoLoad: false,
					sync: true,
					on: {
						success: function(data) {
							AUI().one('#tensach').text(this.get('responseData').tensach);
							AUI().one('#mota').text(this.get('responseData').mota);
							AUI().one('#nxb').text(this.get('responseData').nxb);
							AUI().one('#theloai').text(this.get('responseData').theloai);
							AUI().one('#soluong').text(this.get('responseData').soluong);
							AUI().one('#trangthai').text(this.get('responseData').trangthai);
							AUI().one('#masach').text(this.get('responseData').masach);
							AUI().one('#ke').text(this.get('responseData').ke);
							AUI().one('#tang').text(this.get('responseData').tang);
						}
					}
				}
			);
			
			ajaxrequest.start();
		},['liferay-util-window']
	);
</aui:script>
</aui:form>
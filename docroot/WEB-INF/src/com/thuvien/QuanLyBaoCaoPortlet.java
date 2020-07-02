package com.thuvien;
import com.thuvien.model.PhieuMuon;
import com.thuvien.service.GiaHanLocalServiceUtil;
import com.thuvien.service.PhieuMuonLocalServiceUtil;
import com.thuvien.service.SachLocalServiceUtil;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
	
/**
 * Portlet implementation class QuanLyPhieuMuonPortlet
 */
public class QuanLyBaoCaoPortlet extends MVCPortlet {
	public void thuVien(ActionRequest req, ActionResponse res ) throws SystemException, ParseException{
		int Start=0;
		int ketThuc=0;
		Start = (ParamUtil.getInteger(req, "cur",1)-1)*ParamUtil.getInteger(req, "delta", 5);
		ketThuc = Start+ParamUtil.getInteger(req, "delta", 5);
		int cur = ParamUtil.getInteger(req, "cur",1);
		int delta = ParamUtil.getInteger(req, "delta", 5);
		String ngaydau = ParamUtil.getString(req, "ngaydau");
		String ngaycuoi = ParamUtil.getString(req, "ngaycuoi");
		long tong = PhieuMuonLocalServiceUtil.countPhieuMuons(ngaydau, ngaycuoi);
		List<Object[]> data = PhieuMuonLocalServiceUtil.findBaoCaos(ngaydau, ngaycuoi,Start, ketThuc);
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		req.setAttribute("cur", cur);
		req.setAttribute("tong", tong);
		req.setAttribute("delta", delta);
		req.setAttribute("start", Start);
		req.setAttribute("end", ketThuc);
		req.setAttribute("data", data);
		req.setAttribute("ngaydau", ngaydau);
		req.setAttribute("ngaycuoi", ngaycuoi);
		res.setRenderParameter("jspPage","/html/quanlybaocao/view.jsp");
		res.setRenderParameter("cur", String.valueOf(cur));
		res.setRenderParameter("delta", String.valueOf(delta));
	}
	public void serveResource(ResourceRequest req, ResourceResponse res ){
		SessionMessages.add(req, PortalUtil.getPortletId(req)+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Báo Cáo Thống Kê 2019");
	    
	    final Font font = sheet.getWorkbook ().createFont ();
	    font.setFontName ( "Times New Roman" );
	    final CellStyle style = sheet.getWorkbook ().createCellStyle ();
	    style.setFont ( font );
	    font.setFontHeightInPoints((short) 24);
	    sheet.addMergedRegion(new CellRangeAddress(2,2,4,10)); 
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	    
	    Row firstRow = sheet.createRow(2);
	    firstRow.createCell(4).setCellValue("BÁO CÁO THỐNG KÊ 2019");
	    firstRow.getCell((int) 4).setCellStyle(style);
	
	    Row firstRow1 = sheet.createRow(3);
	    CellStyle borderStyle = workbook.createCellStyle();
	    borderStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    borderStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	    borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
	    borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
	    borderStyle.setBorderRight(CellStyle.BORDER_THIN);
	    borderStyle.setBorderTop(CellStyle.BORDER_THIN);
	    borderStyle.setAlignment(CellStyle.ALIGN_CENTER);
	    
	    firstRow1.createCell(4).setCellValue("STT");
	    firstRow1.createCell(5).setCellValue("Tên Sách");
	    firstRow1.createCell(6).setCellValue("Thể Loại");
	    firstRow1.createCell(7).setCellValue("Sách Còn");
	    firstRow1.createCell(8).setCellValue("Sách Đã Mượn");
	    firstRow1.createCell(9).setCellValue("Ngày Mượn");
	    firstRow1.createCell(10).setCellValue("Ngày Trả");
	    for(int i=4; i<11;i++){
	    	firstRow1.getCell(i).setCellStyle(borderStyle);
	    }
		for(int columnPosition = 0; columnPosition< 100; columnPosition++) {
            sheet.autoSizeColumn((int) (columnPosition));
		}
		int i=0;
		int index = 4;
		int batDau=-1;
		int end=-1;
		SimpleDateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");
		String ngaydau = ParamUtil.getString(req, "ngaydau");
		String ngaycuoi = ParamUtil.getString(req, "ngaycuoi");
		List<Object[]> data = null;
		try {
			data = PhieuMuonLocalServiceUtil.findBaoCaos(ngaydau, ngaycuoi, batDau, end);
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		for(Object[] ep : data){
			i++;
			Row firstRow2 = sheet.createRow((int)index);
			CellStyle borderStyle1 = workbook.createCellStyle();
			borderStyle1.setBorderBottom(CellStyle.BORDER_THIN);
			borderStyle1.setBorderLeft(CellStyle.BORDER_THIN);
			borderStyle1.setBorderRight(CellStyle.BORDER_THIN);
			borderStyle1.setBorderTop(CellStyle.BORDER_THIN);
			borderStyle1.setAlignment(CellStyle.ALIGN_CENTER);
			
			firstRow2.createCell((int) 4).setCellValue(i);			
			firstRow2.createCell((int) 5).setCellValue(String.valueOf(ep[1]));		
			firstRow2.createCell((int) 6).setCellValue(String.valueOf(ep[2]));
			firstRow2.createCell((int) 7).setCellValue(String.valueOf(ep[5]));			
			firstRow2.createCell((int) 8).setCellValue(String.valueOf(ep[6]));			
			firstRow2.createCell((int) 9).setCellValue(String.valueOf(dateFomat.format(ep[3])));		
			firstRow2.createCell((int) 10).setCellValue(String.valueOf(dateFomat.format(ep[4])));
			index++;
			for(int j=4; j<11;j++){
		    	firstRow2.getCell(j).setCellStyle(borderStyle1);
		    }
			for(int columnPosition = 0; columnPosition< 100; columnPosition++) {
	            sheet.autoSizeColumn((int) (columnPosition));
			}
		}
		try {
			res.setContentType("application/vnd.ms-excel");
			res.setProperty("Content-Disposition", "attachment; filename=\""+ "xuatbaocao.xlsx" + "\"");
			workbook.write(res.getPortletOutputStream());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
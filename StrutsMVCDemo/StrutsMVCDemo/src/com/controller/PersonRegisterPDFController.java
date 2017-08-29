package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.PersonBean;
import com.dao.PersonRegistrationDao;

public class PersonRegisterPDFController extends Action 
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Called Action :"+request.getParameter("pid"));
		PersonRegistrationDao dao=new PersonRegistrationDao();
		String path=request.getRealPath("/")+"Report\\person.jrxml";
		JasperDesign jasperDesign=JRXmlLoader.load(path);
		JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
		
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(dao.generatePdfReport(request.getParameter("pid")));
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,new HashMap<String,Object>(), beanCollectionDataSource);
		response.setContentType("application/pdf");
		JRPdfExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,response.getOutputStream());
		exporter.exportReport();
		
		return null;
	}
}

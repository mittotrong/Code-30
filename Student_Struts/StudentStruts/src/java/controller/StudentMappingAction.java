/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Data;
import model.StudentFormBean;

import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Administrator
 */
public class StudentMappingAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success",List="list",Add="add",Save="save",Delete="delete",Edit="edit",Update="update";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward StudentList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        ArrayList arr=new Data().getAllStudent();
        request.setAttribute("list", arr);
        return mapping.findForward(List);
    }
    //Add
    public ActionForward StudentAdd(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        return mapping.findForward(Add);
    }
    
     public ActionForward StudentSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data dt=new Data();
        StudentFormBean st=(StudentFormBean) form;
        if (dt.addStudent(st)) 
        {
            System.out.println("ACtion Add Successfully");
        }
        else
        {
            System.out.println("ACtion Add Not Successfully");
        }
        return mapping.findForward(Save);
    }
     //Delete
      public ActionForward StudentDelete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data dt=new Data();
        int id=Integer.parseInt(request.getParameter("id"));
        if (dt.deleteStudent(id)) 
        {
            System.out.println("Action Delete Successfully");
        }
        else
        {
            System.out.println("Action Delete Not Successfully");
        }
        return mapping.findForward(Delete);
    }
      //Load Edit 
      public ActionForward StudentEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        Data dt=new Data();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("ID Student "+ id);
        ArrayList arr=dt.getStudentByID(id);
        request.setAttribute("listEdit", arr);
        return mapping.findForward(Edit);
    }
      //Update 
      public ActionForward StudentUpdate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        StudentFormBean st=(StudentFormBean) form;
        Data dt=new Data();
         if (dt.updateStudent(st)) 
        {
            System.out.println("Action Update Successfully");
        }
        else
        {
            System.out.println("Action Update Not Successfully");
        }
        return mapping.findForward(Update);
    }
      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.taskmanager.dao.XMLDAO;
import org.taskmanager.model.Project;

/**
 *
 * @author Ricardoc
 */
public class ProjectsServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      
      String op = request.getParameter("op");
      String requestURI = request.getRequestURI();
      XMLDAO db = new XMLDAO();        
      response.setContentType("text/html;charset=UTF-8");

      if (op.equals(new String("edit"))) {
        if ((request.getParameter("id")==null)||(request.getParameter("id").length()==0) ) {
          response.sendRedirect(requestURI + "?errormsg=\"Field id is mandatory!\"");      
          return;
        }
        if ((request.getParameter("description")==null)||(request.getParameter("description").length()==0) ) {
          response.sendRedirect(requestURI + "?errormsg=\"Field project is mandatory!\"");      
          return;
        }
      
        Project p = new Project();
        p.setDescription(request.getParameter("description"));
        if ((request.getParameter("notes")!=null) && (request.getParameter("notes").length()>0)) 
          p.setNotes(request.getParameter("notes"));
        
        Integer id = new Integer(request.getParameter("id"));
        if (id==0) {
          id = db.getLastProjectId() + 1;
        }
        
        Project existingp = db.getProjectByDescription(p.getDescription());
        if ((existingp!=null)&&(existingp.getId()!=id)) {
          response.sendRedirect(requestURI + "?errormsg=\"A project with same description exists!\"");   
          return;
        }
        if (!db.removeProject(id))
          throw new ServletException("Unable to update project!");

        p.setId(id);
        db.saveProject(p);
        db.writeXMLFile();        
      }
    
      if (op.equals(new String("delete"))) {
        if ((request.getParameter("id")==null)||(request.getParameter("id").length()==0) ) {
          response.sendRedirect(requestURI + "?errormsg=\"Field id is mandatory!\"");      
          return;
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        Project p = db.getProject(id);
        if (p!=null) {
          if (!db.removeProject(id)) {            
            response.sendRedirect(requestURI + "?errormsg=\"Project was not removed!\"");      
            return;
          }
          else
            db.writeXMLFile();
        }
        else {          
          response.sendRedirect(requestURI + "?errormsg=\"Project id doesn't exists!\"");      
          return;
        }
      
      }
      response.sendRedirect("projects.jsp");
    } 
    catch (Exception ex) {
      throw new ServletException(ex.getMessage());        
    }    

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}

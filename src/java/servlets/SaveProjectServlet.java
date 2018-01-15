/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.taskmanager.dao.XMLDAO;
import org.taskmanager.model.Project;

/**
 *
 * @author Ricardoc
 */
@WebServlet(name = "SaveProjectServlet", urlPatterns = {"/SaveProjectServlet"})
public class SaveProjectServlet extends HttpServlet {

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
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {      
      if ((request.getParameter("id")==null)||(request.getParameter("id").length()==0) ) {
        response.sendRedirect("new_project.jsp?errorf1=\"Field id is mandatory!\"");      
        return;
      }
      if ((request.getParameter("description")==null)||(request.getParameter("description").length()==0) ) {
        response.sendRedirect("new_project.jsp?errorf1=\"Field project is mandatory!\"");      
        return;
      }

      try {
        Project p = new Project();
        p.setDescription(request.getParameter("description"));
        if ((request.getParameter("notes")!=null) && (request.getParameter("notes").length()>0)) 
          p.setNotes(request.getParameter("notes"));

        XMLDAO db = new XMLDAO();
        Integer id = new Integer(request.getParameter("id"));
        if (id==0) {
          id = db.getLastProjectId() + 1;
        }
        p.setId(id);
      } catch (Exception ex) {
        Logger.getLogger(SaveProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      response.sendRedirect("projects.jsp");

      /* TODO output your page here. You may use following sample code. */
      /*
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet SaveProjectServlet</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet SaveProjectServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
      */
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Comment;

import DAO.CommentDao;
import DAO.DaoError;
import Model.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author GuilhermeFCM
 */
@WebServlet(name = "CommentController", urlPatterns = {"/comments"})
public class SelectController extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String id_post = request.getParameter("id_post");
        
        try {
            CommentDao dao = new CommentDao();
            
            if (id != null){
                Comment comment = dao.select(Integer.parseInt(id));
                JSONObject json = new JSONObject()
                    .put("id", comment.getId())
                    .put("idPost", comment.getIdPost())
                    .put("content", comment.getContent())
                    .put("dateTime", comment.getDateTime());
                out.print(json);
            } else {
                ArrayList<Comment> comments = id_post == null ? dao.select() : dao.selectByPost(Integer.parseInt(id_post)) ;
                JSONArray jsonArray = new JSONArray();
                for (Comment comment : comments){
                    JSONObject json = new JSONObject()
                        .put("id", comment.getId())
                        .put("content", comment.getContent())
                        .put("dateTime", comment.getDateTime());

                    if (id_post == null) json.put("idPost", comment.getIdPost());
                    jsonArray.put(json);
                }
                out.print(jsonArray);
            }
        } catch (DaoError ex) { out.print(ex); }
        out.close();
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

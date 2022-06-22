/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Post;

import DAO.DaoError;
import DAO.PostDao;
import Model.Post;
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
@WebServlet(name = "PostController", urlPatterns = {"/posts"})
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
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String filter = request.getParameter("filter");
        
        // Não consegui utilizar o JSON-B ou o JSON-P =)
        try {
            PostDao dao = new PostDao();
            
            if (id != null){
                Post post = dao.select(Integer.parseInt(id));
                JSONObject jsonObject = new JSONObject()
                    .put("id", post.getId())
                    .put("title", post.getTitle())
                    .put("author", post.getAuthor())
                    .put("content", post.getContent())
                    .put("modificationDate", post.getModificationDate());
                out.print(jsonObject);
            } else {
                ArrayList<Post> posts = filter != null ? dao.select(filter) : dao.select();
                JSONArray jsonArray = new JSONArray();
                for (Post post : posts){
                    jsonArray.put(
                        new JSONObject()
                            .put("id", post.getId())
                            .put("title", post.getTitle())
                            .put("author", post.getAuthor())
                            .put("content", post.getContent())
                            .put("modificationDate", post.getModificationDate())
                    );
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

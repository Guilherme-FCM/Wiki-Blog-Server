/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Post;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author GuilhermeFCM
 */
public class PostDao implements DaoInterface<Post>{
    Connection connection;
    
    public PostDao() throws DaoError {
        connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public ArrayList<Post> select()  {
        ArrayList<Post> posts = new ArrayList();
        String query = "select * from posts;";
        
        try {
            Statement stm = connection.createStatement();
            ResultSet result = stm.executeQuery(query);
            
            while(result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                String teacher = result.getString("author");
                String content = result.getString("content");
                Date modification_date = result.getDate("modification_date");
                
                posts.add( new Post(id, title, teacher, content, modification_date) );
            }
            
            stm.close();
            result.close();
        } catch(SQLException ex) {
            System.err.println("Erro de conexão.");
        }
        
        return posts;
    }

    @Override
    public Post select(int i) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Post> select(String string) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Post type) throws DaoError {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Post type) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int i) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Post type) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exit() throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GuilhermeFCM
 */
public class CommentDao implements DaoInterface<Comment> {
    Connection connection;
    
    public CommentDao() throws DaoError {
        connection = new ConnectionFactory().getConnection();
    }
    
    public ArrayList<Comment> selectByPost(int id_post) throws DaoError {
        ArrayList<Comment> comments = new ArrayList();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from comments where id_post = ?;");
            stm.setInt(1, id_post);
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                int idPost = result.getInt("id_post");
                String content = result.getString("content");
                Timestamp dateTime = result.getTimestamp("date_time");
                
                comments.add( new Comment(id, idPost, content, dateTime) );
            }
            stm.close();
            result.close();
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }
        
    @Override
    public ArrayList<Comment> select() throws DaoError {
        ArrayList<Comment> comments = new ArrayList();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from comments;");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                int idPost = result.getInt("id_post");
                String content = result.getString("content");
                Timestamp dateTime = result.getTimestamp("date_time");
                
                comments.add( new Comment(id, idPost, content, dateTime) );
            }
            stm.close();
            result.close();
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;    
    }

    @Override
    public Comment select(int id) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement("select * from comments where id = ?;");
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
            result.next();
            
            int idPost = result.getInt("id_post");
            String content = result.getString("content");
            Timestamp dateTime = result.getTimestamp("date_time");
                
            return new Comment(id, idPost, content, dateTime);
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Comment> select(String filter) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Comment comment) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "insert into comments (id_post, content) values (?, ?);"
            );
            stm.setInt(1, comment.getIdPost());
            stm.setString(2, comment.getContent());
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Comment object) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement(
                "delete from comments where id = ?;"
            );
            stm.setInt(1, id);
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Comment object) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exit() throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

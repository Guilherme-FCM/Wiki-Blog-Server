/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Post;
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
public class PostDao implements DaoInterface<Post>{
    Connection connection;
    
    public PostDao() throws DaoError {
        connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public ArrayList<Post> select()  {
        ArrayList<Post> posts = new ArrayList();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from posts order by modification_date desc;");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                String teacher = result.getString("author");
                String content = result.getString("content");
                Timestamp modification_date = result.getTimestamp("modification_date");
                
                posts.add( new Post(id, title, teacher, content, modification_date) );
            }
            stm.close();
            result.close();
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }

    @Override
    public Post select(int id) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement("select * from posts where id = ?;");
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
            result.next();
            
            String title = result.getString("title");
            String teacher = result.getString("author");
            String content = result.getString("content");
            Timestamp modification_date = result.getTimestamp("modification_date");
            
            stm.close();
            result.close();
            return new Post(id, title, teacher, content, modification_date);
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Post> select(String filter) throws DaoError {
        ArrayList<Post> posts = new ArrayList();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from posts where title ilike '%"+ filter +"%';");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                String teacher = result.getString("author");
                String content = result.getString("content");
                Timestamp modification_date = result.getTimestamp("modification_date");
                
                posts.add( new Post(id, title, teacher, content, modification_date) );
            }
            stm.close();
            result.close();
        } catch(SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posts;
    }

    @Override
    public int insert(Post post) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement(
                "insert into posts (title, author, content) values (?, ?, ?);"
            );
            stm.setString(1, post.getTitle());
            stm.setString(2, post.getAuthor());
            stm.setString(3, post.getContent());
            
            int result = stm.executeUpdate();
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int delete(Post type) throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement(
                "delete from posts where id = ?;"
            );
            stm.setInt(1, id);
            
            int result = stm.executeUpdate();
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int update(Post post) throws DaoError {
        try {
            PreparedStatement stm = connection.prepareStatement(
                "update posts set title = ?, author = ?, content = ?, modification_date = current_timestamp where id = ?;"
            );
            stm.setString(1, post.getTitle());
            stm.setString(2, post.getAuthor());
            stm.setString(3, post.getContent());
            stm.setInt(4, post.getId());
            
            int result = stm.executeUpdate();
            stm.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public void exit() throws DaoError {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

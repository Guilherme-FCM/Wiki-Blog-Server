/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author GuilhermeFCM
 */
public class Comment {
    private int id, idPost;
    private String content;
    private Timestamp dateTime;

    public Comment(int id, int idPost, String content, Timestamp dateTime) {
        this.id = id;
        this.idPost = idPost;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Comment(int id, String content, Timestamp dateTime) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
    }
    
    public Comment(int idPost, String content) {
        this.idPost = idPost;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}

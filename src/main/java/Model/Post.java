/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author GuilhermeFCM
 */
public class Post {
    private int id;
    private String title, author, content;
    private Date modificationDate;

    public Post(int id, String title, String author, String content, Date modificationDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.modificationDate = modificationDate;
    }

    public Post(String title, String author, String content, Date modificationDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.modificationDate = modificationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author GuilhermeFCM
 */
public interface DaoInterface<Type> {
    public ArrayList<Type> select() throws DaoError;
    public Type select(int id) throws DaoError;
    public ArrayList<Type> select(String title) throws DaoError;
    public void insert(Type object) throws DaoError;
    public void delete(Type object) throws DaoError;
    public void delete(int id) throws DaoError;
    public void update(Type object) throws DaoError;
    public void exit() throws DaoError;
}

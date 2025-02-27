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
    public ArrayList<Type> select(String filter) throws DaoError;
    public int insert(Type object) throws DaoError;
    public int delete(Type object) throws DaoError;
    public int delete(int id) throws DaoError;
    public int update(Type object) throws DaoError;
    public void exit() throws DaoError;
}

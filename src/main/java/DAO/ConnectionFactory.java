/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author GuilhermeFCM
 */
public class ConnectionFactory {
    public Connection getConnection() throws DaoError {
        try {
            InitialContext ic= new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/wiki-blog");
            return ds.getConnection();
        } catch (NamingException | SQLException ex) {
            throw new DaoError(ex);
        }
    }
}

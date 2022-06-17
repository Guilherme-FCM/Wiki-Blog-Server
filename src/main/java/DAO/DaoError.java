/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author professor
 */
public class DaoError extends Exception{

    public DaoError() {}

    public DaoError(String message) {
        super("Erro DAO: "+message);
    }

    public DaoError(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoError(Throwable cause) {
        super(cause);
    }

    public DaoError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

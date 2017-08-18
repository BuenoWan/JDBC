/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    
    public boolean openConnection()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Projeto_JDBC","postgres","asd");
            System.out.println("Conexao efetuada com sucesso");
            return true;
        }
        catch(SQLException ex){
            System.out.println(""+ex.getMessage());
            return false;
        }
    }
    
    public boolean closeConnection(){
        try {
            if(this.getPstmt() != null) {
                pstmt.close();
            }
            if(this.getCon() != null) {
                con.close();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
}

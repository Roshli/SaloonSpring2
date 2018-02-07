/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectfinal2;

import com.mycompany.DbConnection.DbConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Roshli
 */
@Repository
public class CustomerDaoImpl implements CustomerDao{
    Connection con = null;
    
    public CustomerDaoImpl()
    {
        con = DbConn.connect();
    }
    
    String sql1 ="Insert Into customer (tpnumber, name, age, address, email) VALUES (?,?,?,?,?)";
    String sql2 = "SELECT tpnumber, name, age,address, email From customer Where tpnumber = ?";
    String sql3 = "SELECT * FROM customer";
    String updateSql = "UPDATE customer set tpnumber = ?, name = ?, age = ?, address = ?, email = ? where tpnumber = ?";
   
    
    public void insertCustomer (Customer c)
    {
        PreparedStatement pst = null;

        
        try {
            pst = con.prepareStatement(sql1);
            pst.setInt(1,c.getTpNumber());
            pst.setString(2, c.getName());
            pst.setInt(3, c.getAge());
            pst.setString(4, c.getAddress());
            pst.setString(5, c.getEmail());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        finally
        {
            try {
               // con.close();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    public void updateCustomer (Customer c)
    {
        PreparedStatement pst = null;

        
        try {
            pst = con.prepareStatement(updateSql);
            pst.setInt(1,c.getTpNumber());
            pst.setString(2, c.getName());
            pst.setInt(3, c.getAge());
            pst.setString(4, c.getAddress());
            pst.setString(5, c.getEmail());
            pst.setInt(6,c.getTpNumber());
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        finally
        {
            try {
               // con.close();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
    
    
    public void closeConnection()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
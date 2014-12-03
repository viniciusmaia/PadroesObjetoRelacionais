/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Vinicius
 */
public class Conexao
{
    public static Connection abreConexao()
    {
        String url = "jdbc:postgresql://localhost:5432/padroesobjetorelacionais";
       
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,"postgres","postgres");
            
            return con;
        }
        catch(java.lang.ClassNotFoundException e)
        {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage ());
        }      
        catch ( SQLException ex )
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
        
        return null;
    }
}

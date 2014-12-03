/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaconcreta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Conexao;

/**
 *
 * @author Vinicius
 */
public class GeraChaves
{
    public static int getProximoId()
    {
        int proximo = 0;
        String query = "select proximoId from chaves_tabelasconcretas";
        Connection con = Conexao.abreConexao();
        
        try
        {
            Statement sq_stmt = con.createStatement();          
            
            ResultSet rs = sq_stmt.executeQuery(query);
            
            while(rs.next())
            {
                proximo = rs.getInt("proximoId");
            }
            
            sq_stmt.close();
            rs.close();
            con.close();
            
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return proximo;
    }
}

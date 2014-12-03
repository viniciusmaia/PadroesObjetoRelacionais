/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chaveestrangeira;

import ChavePrimaria.Livro;
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
public class MapeadorArtista 
{
    public static int insere(Artista objArtista)
    {
        Connection con = Conexao.abreConexao();
        
        int id = -1;
        try
        {
            Statement sq_stmt = con.createStatement();

            String query = "insert into Artistas (Nome) values ('" + objArtista.getNome() + "')";
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            } 
            stmt.close();                       
            sq_stmt.close();
            rs.close();
            con.close();
            
            System.out.println("Registro salvo com sucesso!");
            return id;
        }        
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return id;
    }
    
    public static Artista buscar(int id)
    {
        Artista objArtista = new Artista();
        String nome = null;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select nome from artistas where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
            }
            
            objArtista.setId(id);
            objArtista.setNome(nome);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objArtista;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

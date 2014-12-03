/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chaveestrangeira;

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
public class MapeadorAlbum 
{
    public static int insere(Album objAlbum)
    {
        Connection con = Conexao.abreConexao();
        
        int id = -1;
        try
        {
            Statement sq_stmt = con.createStatement();

            String query = "insert into albuns (Titulo, IdArtista) values ('" + objAlbum.getTitulo();
            query += "'," + objAlbum.getAutor().getId() + ")";
            
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
    
    public static Album buscar(int idAlbum)
    {
        Album objAlbum = new Album();
        Artista objArtista = new Artista();
        String titulo = null, nome = null;
        int idArtista = 0;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select titulo, idArtista from albuns where id = " + idAlbum;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                titulo = rs.getString("titulo");
                idArtista = rs.getInt("idArtista");
            }
            
            objAlbum.setId(idAlbum);
            objAlbum.setTitulo(titulo);
            
            query = "select nome from artistas where id = " + idArtista;
            
            rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
            }
            
            objArtista.setId(idArtista);
            objArtista.setNome(nome);
            
            objAlbum.setAutor(objArtista);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objAlbum;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
    
    public static Album buscarPorTitulo(String titulo)
    {
        Album objAlbum = new Album();
        Artista objArtista = new Artista();
        String nome = null;
        int idArtista = 0, idAlbum = 0;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select id, titulo, idArtista from albuns where titulo = '" + titulo + "'";
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {
                idAlbum = rs.getInt("id");
                titulo = rs.getString("titulo");
                idArtista = rs.getInt("idArtista");
            }
            
            objAlbum.setId(idAlbum);
            objAlbum.setTitulo(titulo);
            
            query = "select nome from artistas where id = " + idArtista;
            
            rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
            }
            
            objArtista.setId(idArtista);
            objArtista.setNome(nome);
            
            objAlbum.setAutor(objArtista);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objAlbum;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

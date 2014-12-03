/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vinicius
 */
public class MapeadorLivro
{
    public static int insere(Livro objLivro)
    {
        Connection con = Conexao.abreConexao();
        
        int id = -1;
        try
        {
            String query = "insert into Livros (Titulo, Preco) values ('" + objLivro.getTitulo();
            query += "'," + objLivro.getPreco() + ")";
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            }                                
            stmt.close();
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
    
    public static Livro buscar(int id)
    {
        Livro objLivro = new Livro();
        double preco = 0;
        String titulo = null;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select titulo, preco from livros where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                titulo = rs.getString("titulo");
                preco = rs.getDouble("preco");
            }
            
            objLivro.setId(id);
            objLivro.setPreco(preco);
            objLivro.setTitulo(titulo);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objLivro;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
    
    public static Livro buscarPorTitulo(String titulo)
    {
        Livro objLivro = new Livro();
        double preco = 0;
        int id = 0;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select id, titulo, preco from livros where titulo = '" + titulo + "'";
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {
                id = rs.getInt("id");
                titulo = rs.getString("titulo");
                preco = rs.getDouble("preco");
            }
            
            objLivro.setId(id);
            objLivro.setPreco(preco);
            objLivro.setTitulo(titulo);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objLivro;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

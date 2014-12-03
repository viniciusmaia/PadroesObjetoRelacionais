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

/*Exemplo do padrão chave primária utilizando uma tabela de chaves*/
public class MapeadorFilme 
{
    public static int insere(Filme objFilme)
    {
        Connection con = Conexao.abreConexao();
        
        int id = 0;
        int proximoId = 0;
        try
        {
            id = MapeadorFilme.getProximoId();
            objFilme.setId(id);
            
            String query = "insert into Filmes (Nome, Id) values ('" + objFilme.getNome();
            query += "'," + objFilme.getId()+ ")";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.execute();
            
            proximoId = id + 1;
            query = "update chavesFilmes set proximoId = " + proximoId;
            
            ps = con.prepareStatement(query);
            
            ps.execute();
            
            ps.close();
            con.close();
            
            System.out.println("Registro salvo com sucesso!");
        }        
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return id;
    }
    
    //Método que busca o proximo Id na tabela de chaves
    public static int getProximoId()
    {
        int proximo = 0;
        String query = "select proximoId from chavesFilmes";
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
    
    public static Filme buscar(int id)
    {
        Filme objFilme = new Filme();
        String nome = null;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select nome from filmes where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
            }
            
            objFilme.setId(id);
            objFilme.setNome(nome);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objFilme;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
    
    public static Filme buscarPorNome(String nome)
    {
        Filme objFilme = new Filme();
        int id = 0;
        Connection con = Conexao.abreConexao();
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "select id, nome from filmes where nome = '" + nome + "'";
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {
                id = rs.getInt("id");
                nome = rs.getString("nome");
            }
            
            objFilme.setId(id);
            objFilme.setNome(nome);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objFilme;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

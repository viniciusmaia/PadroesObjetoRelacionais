/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valorembutido;

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
public class MapeadorPessoa
{
    public static int insere(Pessoa objPessoa)
    {
        Connection con = Conexao.abreConexao();
        Endereco objEndereco = objPessoa.getEndedereco();
        int id = -1;
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "insert into Pessoas (Nome, Rua, Numero, Bairro) values ('" + objPessoa.getNome();
            query += "','" + objEndereco.getRua()+ "','"+ objEndereco.getNumero() + "','";
            query += objEndereco.getBairro() + "')";
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            }                                
            stmt.close();
            sq_stmt.close();
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
    
    public static Pessoa buscar(int id)
    {
        Pessoa objPessoa = new Pessoa();
        Endereco objEndereco = new Endereco();
       
        String nome = null, rua = null, numero = null, bairro = null;
        
        try
        {
            Connection con = Conexao.abreConexao();
            
            Statement sq_stmt = con.createStatement();
            
            String query = "select nome, rua, numero, bairro from Pessoas where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
                numero = rs.getString("numero");
                rua = rs.getString("rua");
                bairro = rs.getString("bairro");
            }
            
            objEndereco.setBairro(bairro);
            objEndereco.setNumero(numero);
            objEndereco.setRua(rua);
            
            objPessoa.setEndereco(objEndereco);
            objPessoa.setNome(nome);
            objPessoa.setId(id);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objPessoa;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
    
    public static Pessoa buscarPorNome(String nome)
    {
        Pessoa objPessoa = new Pessoa();
        Endereco objEndereco = new Endereco();
        
        int Id = -1;
        String rua = null, numero = null, bairro = null;
        
        try
        {
            Connection con = Conexao.abreConexao();
            
            Statement sq_stmt = con.createStatement();
            
            String query = "select id, rua, numero, bairro from Pessoas where nome = '" + nome + "'";
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                Id = rs.getInt("id");
                numero = rs.getString("numero");
                rua = rs.getString("rua");
                bairro = rs.getString("bairro");
            }
            
            objEndereco.setBairro(bairro);
            objEndereco.setNumero(numero);
            objEndereco.setRua(rua);
            
            objPessoa.setEndereco(objEndereco);
            objPessoa.setNome(nome);
            objPessoa.setId(Id);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objPessoa;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

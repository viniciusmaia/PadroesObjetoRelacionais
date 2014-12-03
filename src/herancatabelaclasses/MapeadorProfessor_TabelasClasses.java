/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaclasses;

import heranca.Professor;
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
public class MapeadorProfessor_TabelasClasses
{
    public static int insere(Professor objProfessor)
    {
        Connection con = Conexao.abreConexao();        
        int id = -1;
        try
        {
            
            
            String query = "insert into funcionarios_TabelasClasses (Nome, Salario) values ('";
            query += objProfessor.getNome() + "',"+ objProfessor.getSalario() + ")";
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            } 
            
            query = "insert into Professores_TabelasClasses (Id, Disciplina) values (" + id;
            query += ",'" + objProfessor.getDisciplina() + "')";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.execute();
            
            stmt.close();
            ps.close();
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
    
    public static Professor buscar(int id)
    {
        Professor objProfessor = new Professor();
       
        String nome = null, disciplina = null;
        double salario = 0;    
        try
        {
            Connection con = Conexao.abreConexao();
            
            Statement sq_stmt = con.createStatement();
            
            String query = "select Nome, Salario from Funcionarios_tabelasclasses where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
                salario = rs.getDouble("salario");                
            }
            
            query = "select disciplina from professores_tabelasclasses where id = " + id;
            
            rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                disciplina = rs.getString("disciplina");
            }
            
            objProfessor.setDisciplina(disciplina);
            objProfessor.setSalario(salario);
            objProfessor.setNome(nome);
            objProfessor.setId(id);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objProfessor;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

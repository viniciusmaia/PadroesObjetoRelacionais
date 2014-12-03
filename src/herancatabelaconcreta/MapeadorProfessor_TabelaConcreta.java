/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaconcreta;

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
public class MapeadorProfessor_TabelaConcreta
{
    public static int insere(Professor objProfessor)
    {
        Connection con = Conexao.abreConexao();        
        int id = -1;
        int proximoId = -1;
        try
        {           
            id = GeraChaves.getProximoId();
            
            objProfessor.setId(id);
            
            String query = "insert into Professores_tabelasconcretas (Nome, Salario, Disciplina, Id)";
            query += "values ('" + objProfessor.getNome() + "'," + objProfessor.getSalario();
            query += ",'"+ objProfessor.getDisciplina()+ "'," + objProfessor.getId() + ")";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.execute();            
            
            proximoId = id + 1;
            
            query = "update chaves_TabelasConcretas set proximoId = " + proximoId;
            ps = con.prepareStatement(query);
            
            ps.execute();
            
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
            
            String query = "select Nome, Salario, Disciplina from Professores_tabelasconcretas where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
                salario = rs.getDouble("salario");
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

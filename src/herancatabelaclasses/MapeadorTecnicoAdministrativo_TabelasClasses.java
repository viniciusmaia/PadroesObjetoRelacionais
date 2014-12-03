/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaclasses;

import heranca.TecnicoAdministrativo;
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
public class MapeadorTecnicoAdministrativo_TabelasClasses 
{
    public static int insere(TecnicoAdministrativo objTecnico)
    {
        Connection con = Conexao.abreConexao();        
        int id = -1;
        try
        {
            Statement sq_stmt = con.createStatement();
            
            String query = "insert into funcionarios_TabelasClasses (Nome, Salario) values ('";
            query += objTecnico.getNome() + "',"+ objTecnico.getSalario() + ")";
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next())
            {
                id = rs.getInt(1);
            }
            
            query = "insert into TecnicosAdministrativos_TabelasClasses (Id, Setor) values (" + id;
            query += ",'" + objTecnico.getSetor() + "')";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.execute();
            
            stmt.close();
            ps.close();
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
    
    public static TecnicoAdministrativo buscar(int id)
    {
        TecnicoAdministrativo objProfessor = new TecnicoAdministrativo();
       
        String nome = null, setor = null;
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
            
            query = "select setor from TecnicosAdministrativos_TabelasClasses where id = " + id;
            
            rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                setor = rs.getString("setor");
            }
            
            objProfessor.setSetor(setor);
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

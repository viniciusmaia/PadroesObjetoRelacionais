/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaconcreta;


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
public class MapeadorTecnicoAdministrativo_TabelaConcreta
{
    public static int insere(TecnicoAdministrativo objTecnico)
    {
        Connection con = Conexao.abreConexao();        
        int id = -1, proximoId = -1;
        try
        {           
            id = GeraChaves.getProximoId();
            
            objTecnico.setId(id);
            
            String query = "insert into TecnicosAdministrativos_tabelasconcretas (Nome, Salario, Setor, Id)";
            query += "values ('" + objTecnico.getNome() + "'," + objTecnico.getSalario();
            query += ",'"+ objTecnico.getSetor()+ "'," + objTecnico.getId() + ")";
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
    
    public static TecnicoAdministrativo buscar(int id)
    {
        TecnicoAdministrativo objTecnico = new TecnicoAdministrativo();
       
        String nome = null, setor = null;
        double salario = 0;    
        try
        {
            Connection con = Conexao.abreConexao();
            
            Statement sq_stmt = con.createStatement();
            
            String query = "select Nome, Salario, Setor from TecnicosAdministrativos_tabelasconcretas where id = " + id;
            
            ResultSet rs = sq_stmt.executeQuery(query);
            while(rs.next())
            {                
                nome = rs.getString("nome");
                salario = rs.getDouble("salario");
                setor = rs.getString("setor");
            }
            
            objTecnico.setSetor(setor);
            objTecnico.setSalario(salario);
            objTecnico.setNome(nome);
            objTecnico.setId(id);
            
            sq_stmt.close();
            rs.close();
            con.close();
            
            return objTecnico;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        return null;
    }
}

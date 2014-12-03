/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package executar;

import ChavePrimaria.Filme;
import ChavePrimaria.Livro;
import ChavePrimaria.MapeadorFilme;
import ChavePrimaria.MapeadorLivro;
import chaveestrangeira.Album;
import chaveestrangeira.Artista;
import chaveestrangeira.MapeadorAlbum;
import chaveestrangeira.MapeadorArtista;
import herancatabelaclasses.MapeadorProfessor_TabelasClasses;
import herancatabelaclasses.MapeadorTecnicoAdministrativo_TabelasClasses;
import herancatabelaconcreta.MapeadorProfessor_TabelaConcreta;
import herancatabelaconcreta.MapeadorTecnicoAdministrativo_TabelaConcreta;
import herancatabelaunica.MapeadorProfessor_TabelaUnica;
import herancatabelaunica.MapeadorTecnicoAdministrativo_TabelaUnica;
import heranca.Professor;
import heranca.TecnicoAdministrativo;
import util.Conexao;
import valorembutido.Endereco;
import valorembutido.MapeadorPessoa;
import valorembutido.Pessoa;

/**
 *
 * @author Vinicius
 */
public class PadroesObjetoRelacionais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /*
        
        Professor p = new Professor();
        
        p.setNome("Fidelis");
        p.setSalario(4000);
        p.setDisciplina("Cálculo");
        
        MapeadorProfessor_TabelaConcreta.insere(p);
        
        TecnicoAdministrativo tec = new TecnicoAdministrativo();
        
        tec.setNome("Diego");
        tec.setSalario(2000);
        tec.setSetor("Informática");
        
        MapeadorTecnicoAdministrativo_TabelaConcreta.insere(tec);*/
        
                
        Professor p;
        
        p = MapeadorProfessor_TabelaConcreta.buscar(1);
        
        System.out.println("Id: " + p.getId() + " Nome: " + p.getNome() + " Salario: " + p.getSalario() + " Disciplina: "
                           + p.getDisciplina());
        
        TecnicoAdministrativo t;
        
        t = MapeadorTecnicoAdministrativo_TabelaConcreta.buscar(2);
        
        System.out.println("Id: " + t.getId() + " Nome: " + t.getNome() + " Salario: " + t.getSalario() + " Setor: "
                           + t.getSetor());
    }
    
}

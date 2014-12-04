/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package herancatabelaconcreta;

import heranca.Professor;
import heranca.TecnicoAdministrativo;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class TesteHerancaTabelaConcreta
{
    public static void main(String[] args)
    {
        Professor professor = new Professor();
        TecnicoAdministrativo tecnico = new TecnicoAdministrativo();
        String nome, disciplina, setor;
        double salario;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Informe o nome do professor: ");
        nome = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe o salario do professor: ");
        salario = Double.parseDouble(entrada.nextLine().replace("\n", ""));
        
        System.out.println("Informe a disciplina que o professor ministra: ");
        disciplina = entrada.nextLine().replace("\n", "");
        
        professor.setDisciplina(disciplina);
        professor.setNome(nome);
        professor.setSalario(salario);
        
        MapeadorProfessor_TabelaConcreta.insere(professor);
        
        System.out.println("Informe o nome do técnico administrativo: ");
        nome = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe o salario do técnico administrativo: ");
        salario = Double.parseDouble(entrada.nextLine().replace("\n", ""));
        
        System.out.println("Informe o setor no qual o técnico trabalha: ");
        setor = entrada.nextLine().replace("\n", "");
        
        tecnico.setNome(nome);
        tecnico.setSalario(salario);
        tecnico.setSetor(setor);
        
        MapeadorTecnicoAdministrativo_TabelaConcreta.insere(tecnico);        
    }
}

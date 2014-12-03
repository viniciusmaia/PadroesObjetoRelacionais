/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heranca;

import heranca.Funcionario;

/**
 *
 * @author Vinicius
 */
public class Professor extends Funcionario 
{
    private String Disciplina;

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String Disciplina) {
        this.Disciplina = Disciplina;
    }
    
    
}

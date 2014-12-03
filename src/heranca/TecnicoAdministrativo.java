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
public class TecnicoAdministrativo extends Funcionario
{
    private String Setor;

    public String getSetor() 
    {
        return Setor;
    }

    public void setSetor(String Setor)
    {
        this.Setor = Setor;
    }    
}

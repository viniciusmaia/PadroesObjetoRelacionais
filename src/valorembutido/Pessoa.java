/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valorembutido;

/**
 *
 * @author Vinicius
 */
public class Pessoa 
{
    private int Id;
    private String Nome;
    private Endereco End;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Endereco getEndedereco() {
        return End;
    }

    public void setEndereco(Endereco End) {
        this.End = End;
    }
    
    
}

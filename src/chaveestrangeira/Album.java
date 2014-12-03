/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chaveestrangeira;

/**
 *
 * @author Vinicius
 */
public class Album 
{
    private String Titulo;
    private Artista Autor;
    private int Id;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Artista getAutor() {
        return Autor;
    }

    public void setAutor(Artista Autor) {
        this.Autor = Autor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    
}

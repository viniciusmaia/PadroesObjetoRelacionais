/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chaveestrangeira;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class TesteChaveEstrangeira 
{
    public static void main(String[] args)
    {
        Album objAlbum;
        Artista objArtista = new Artista();
        ArrayList<Album> albuns = new ArrayList<Album>();
        String nome, titulo;
        Scanner entrada = new Scanner(System.in);
        int idArtista, idAlbum;
        
        
        System.out.println("Informe o nome do artista: ");
        nome = entrada.nextLine().replace("\n", "");
        
        objArtista.setNome(nome);
        
        System.out.println("Informe o título do album ou digite s para sair do cadastro de álbuns: ");
        titulo = entrada.nextLine().replace("\n", "");
        
        while (!titulo.equals("s")) 
        {
            objAlbum = new Album();
            
            objAlbum.setTitulo(titulo);
            
            albuns.add(objAlbum);
            
            System.out.println("Informe o título do album ou digite s para sair do cadastro de álbuns: ");
            titulo = entrada.nextLine().replace("\n", "");
        }
        
        idArtista = MapeadorArtista.insere(objArtista);
        
        
        System.out.printf("\nId do último artista cadastro: %d \n",idArtista); 
        
        objArtista.setId(idArtista);
        
        for (Album aux : albuns)
        {
            aux.setAutor(objArtista);
            idAlbum = MapeadorAlbum.insere(aux);
            System.out.printf("\nId do último álbum cadastro: %d\n",idAlbum); 
        }
        
        System.out.printf("\n\nPesquisas...\n\nPesquisa artista por Id... \n\nInforme o Id do artista: ");
        idArtista = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        
        objArtista = MapeadorArtista.buscar(idArtista);
        
        System.out.println("Id do artista: " + objArtista.getId() + " Nome: " + objArtista.getNome());
        
        System.out.printf("\n\nPesquisa artista por nome...\n\nInforme o nome do artista: ");
        nome = entrada.nextLine().replace("\n", "");
        
        objArtista = MapeadorArtista.buscarPorNome(nome);
        
        System.out.println("Id do artista: " + objArtista.getId() + " Nome: " + objArtista.getNome());
        
        
        System.out.printf("\n\nPesquisa album por Id... \n\nInforme o Id do album ou digite um número negativo para sair: ");
        idAlbum = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        
        while (idAlbum > 0)
        {
            objAlbum = MapeadorAlbum.buscar(idAlbum);
            
            System.out.println("Id do album: " + objAlbum.getId() + " Titulo: " + objAlbum.getTitulo() + " Autor: " + objAlbum.getAutor().getNome());
            
            System.out.printf("\nInforme o Id do album ou digite um número negativo para sair: ");
            idAlbum = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        }
        
        System.out.printf("\n\nPesquisa album por Titulo... \n\nInforme o titulo do album ou digite s para sair: ");
        titulo = entrada.nextLine().replace("\n", "");
        
        while (!titulo.equals("s"))
        {
            objAlbum = MapeadorAlbum.buscarPorTitulo(titulo);
            
            System.out.println("Id do album: " + objAlbum.getId() + " Titulo: " + objAlbum.getTitulo() + " Autor: " + objAlbum.getAutor().getNome());
            
            System.out.printf("\n\nPesquisa album por Titulo... \n\nInforme o titulo do album ou digite s para sair: ");
            titulo = entrada.nextLine().replace("\n", "");
        }
    }
}

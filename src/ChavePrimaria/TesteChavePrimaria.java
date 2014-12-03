/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;

import ChavePrimaria.Livro;
import ChavePrimaria.MapeadorLivro;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class TesteChavePrimaria 
{
    public static void main(String[] args)
    {   
        Livro objLivro = new Livro(); 
        Livro l;
        Scanner entrada = new Scanner(System.in);
        int id;
        double preco;
        String titulo;
        
        System.out.println("Informe o título do livro: ");
        titulo = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe o preço: ");
        preco = Double.parseDouble(entrada.nextLine().replace("\n", ""));
        
        objLivro.setPreco(preco);
        objLivro.setTitulo(titulo);
        
        id = MapeadorLivro.insere(objLivro);
        
        System.out.printf("\nId do último cadastro: %d",id);       
        
        System.out.printf("\n\nPesquisas...\n\nPesquisa por Id... \n\nInforme o Id do livro: ");
        id = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        
        l = MapeadorLivro.buscar(id);
        
        System.out.println("Id: " + l.getId() + " Título: " + l.getTitulo());
        
        
        System.out.printf("\n\nPesquisa por Título...\n\nInforme o título do livro: ");
        titulo = entrada.nextLine().replace("\n", "");
        
        l = MapeadorLivro.buscarPorTitulo(titulo);
        
        System.out.println("Id: " + l.getId() + " Título: " + l.getTitulo());
    }
}

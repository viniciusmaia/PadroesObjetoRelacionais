/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;

import ChavePrimaria.Filme;
import ChavePrimaria.MapeadorFilme;
import java.util.Scanner;

/**
 *
 * @author Vinicius
 */
public class TesteChavePrimariaTabelaChaves
{
    public static void main(String[] args)
    {   
        Filme objFilme = new Filme(); 
        Filme f;
        Scanner entrada = new Scanner(System.in);
        int id;
        String nome;
        
        System.out.println("Informe o nome do filme: ");
        nome = entrada.nextLine().replace("\n", "");
                
        objFilme.setNome(nome);
        
        id = MapeadorFilme.insere(objFilme);
        
        System.out.printf("\nId do último cadastro: %d",id);       
        
        System.out.printf("\n\nPesquisas...\n\nPesquisa por Id... \n\nInforme o Id do filme: ");
        id = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        
        f = MapeadorFilme.buscar(id);
        
        System.out.println("Id: " + f.getId() + " Nome: " + f.getNome());
        
        
        System.out.printf("\n\nPesquisa por nome...\n\nInforme o nome do filme: ");
        nome = entrada.nextLine().replace("\n", "");
        
        f = MapeadorFilme.buscarPorNome(nome);
        
        System.out.println("Id: " + f.getId() + " Título: " + f.getNome());
    }
}

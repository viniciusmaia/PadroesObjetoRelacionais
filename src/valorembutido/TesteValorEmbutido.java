/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valorembutido;

import java.util.Scanner;
import valorembutido.Endereco;
import valorembutido.MapeadorPessoa;
import valorembutido.Pessoa;

/**
 *
 * @author Vinicius
 */
public class TesteValorEmbutido
{
    public static void main(String[] args)
    {        
        Pessoa objPessoa = new Pessoa();
        Pessoa p;
        Endereco objEndereco = new Endereco();
        Scanner entrada = new Scanner(System.in);
        String nome, bairro, numero, rua;        
        int idPessoa;
        
        System.out.println("Informe o nome da pessoa: ");
        nome = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe a rua: ");
        rua = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe o número: ");
        numero = entrada.nextLine().replace("\n", "");
        
        System.out.println("Informe o bairro: ");
        bairro = entrada.nextLine().replace("\n", "");
        
        objPessoa.setNome(nome);
        objEndereco.setBairro(bairro);
        objEndereco.setRua(rua);
        objEndereco.setNumero(numero);
        
        objPessoa.setEndereco(objEndereco);
        
        idPessoa = MapeadorPessoa.insere(objPessoa);
        
        System.out.printf("\nId do último cadastro: %d",idPessoa);       
        
        System.out.printf("\n\nPesquisas...\n\nPesquisa por Id... \n\nInforme o Id da pessoa: ");
        idPessoa = Integer.parseInt(entrada.nextLine().replace("\n", ""));
        
        p = MapeadorPessoa.buscar(idPessoa);
        objEndereco = p.getEndedereco();
        
        System.out.println("Id: " + p.getId() + " Nome: " + p.getNome());
        System.out.printf("Endereço: \nRua: %s Número: %s Bairro: %s", objEndereco.getRua(), objEndereco.getNumero(), objEndereco.getBairro());
        
        System.out.printf("\n\nPesquisa por nome...\n\nInforme o nome da pessoa: ");
        nome = entrada.nextLine().replace("\n", "");
        
        p = MapeadorPessoa.buscarPorNome(nome);
        objEndereco = p.getEndedereco();
        
        System.out.println("Id: " + p.getId() + " Nome: " + p.getNome());
        System.out.printf("Endereço: \nRua: %s Número: %s Bairro: %s \n", objEndereco.getRua(), objEndereco.getNumero(), objEndereco.getBairro());
    }
}

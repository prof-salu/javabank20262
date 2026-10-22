package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;
import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteColecoes01 {
    public static void main(String[] args) {
        //Array de CONTAS com no maximo 5 contas
        //Um array não pode ter seu tamanho alterado apos a criação
        Conta vetorContas[] = new Conta[5];
        //Acessamos um array atraves de suas posições (index)
        //Onde a primeira posição SEMPRE é a posição ZERO

        try{
            vetorContas[0] = new Corrente(1001, "Ana", 500);
            vetorContas[1] = new Corrente(1002, "Marcia", 600);
            vetorContas[2] = new Poupanca(1003, "Pedro", 1);
            vetorContas[3] = new Poupanca(1004, "Bruna", 0.75);
            vetorContas[4] = new Corrente(1005, "Juca", 900);
            vetorContas[5] = new Corrente(1006, "Marilha", 1000);//Erro! Fora do limite do array
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("So temos espaço para 5 contas.");
        }

        for(int i = 0; i < vetorContas.length;i++){
            vetorContas[i].depositar(100);
            System.out.println(vetorContas[i]);
        }

        System.out.println();

        for(Conta c : vetorContas){
            c.depositar(50);
            System.out.println(c);
        }
    }
}
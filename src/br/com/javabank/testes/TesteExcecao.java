package br.com.javabank.testes;

import java.io.IOException;
import java.util.Scanner;

public class TesteExcecao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        System.out.println("Informe um numero: ");

        try{
            numero = Integer.parseInt(entrada.nextLine());
            System.out.println("Dobro do informado: " + numero * 2);

            int numeros[] = {1,2,3};
            System.out.println(numeros[2]);
            String nome = null;
            System.out.println("Nome: " + nome.toLowerCase());

        }catch(NumberFormatException e){
            System.out.println("Erro: Apenas valores inteiros");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Erro: Posição inválida no vetor");
        }catch(NullPointerException e){
            System.out.println("Erro: Valor nulo ou não inicializado");
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }

        System.out.println("Fim do programa.");
    }
}

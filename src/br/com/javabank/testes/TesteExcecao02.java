package br.com.javabank.testes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteExcecao02 {
    public static void main(String[] args) {
        File arquivo = new File("arquivo_secreto.txt");

        Scanner entrada = new Scanner(System.in);
        try {
            //exceção CHECKED (Exception)
            entrada = new Scanner(arquivo);
            while(entrada.hasNext()){
                System.out.println(entrada.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado");
        } finally {
            entrada.close();
            System.out.println("Fim do programa");
        }
    }
}

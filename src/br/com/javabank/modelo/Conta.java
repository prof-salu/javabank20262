package br.com.javabank.modelo;

import java.util.Objects;

public abstract class Conta{
    //ENCAPSULAMENTO
    //public --> qualquer classe tem acesso a todos os membros
    //private --> apenas a propria classe tem acesso aos membros
    private int numero;
    private String titular;
    protected double saldo;
    //Membros estáticos pertencem a classe, são compartilhados entre as instancias
    //e podem ser acessados diretamente pela propria classe.
    private static int totalContas = 0;

    //Constante
    public final String CODIGO_BANCO = "1234";

    //Construtor
    public Conta(){
        //Contrutor vazio (default)
        totalContas++;
    }

    public Conta(int numero, String titular){
        //Construtor com parametros
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        totalContas++;
    }

    public static int getTotalContas(){
        return Conta.totalContas;
    }

    //GET --> retornar o valor de uma propriedade
    public String getTitular(){
        return this.titular;
    }

    public int getNumero(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    //SET --> alterar o valor de uma propriedade
    public void setTitular(String titular){
        //this --> aponta para a propria classe
        if(titular.length() > 1){
            this.titular = titular;
        }else{
            System.out.println("O titular deve possuir pelo 2 caracteres");
        }
    }

    public boolean depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    public abstract boolean sacar(double valor);

    public final boolean transferir(double valor, Conta favorecido){
        if(sacar(valor) == true){
            favorecido.depositar(valor);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Conta --> Número: %d | Titular: %s | Saldo: R$%.2f",
                             numero, titular, saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero && Objects.equals(titular, conta.titular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, titular);
    }
}

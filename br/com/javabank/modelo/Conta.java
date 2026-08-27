package br.com.javabank.modelo;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public boolean depositar(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    public boolean sacar(double valor){
        // && ==> AND
        // || ==> OR
        // !  ==> NOT
        if(valor > 0 && valor <= saldo){
            saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }
}

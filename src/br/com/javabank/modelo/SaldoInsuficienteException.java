package br.com.javabank.modelo;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException() {
        super("Erro 1004: Saldo insuficiente para a operação.");
    }
}

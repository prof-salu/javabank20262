package br.com.javabank.modelo;

public abstract class Especial extends Conta{
    @Override
    public boolean sacar(double valor) {
        return false;
    }
}

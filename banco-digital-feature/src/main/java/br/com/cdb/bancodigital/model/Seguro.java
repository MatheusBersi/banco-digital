package br.com.cdb.bancodigital.model;

public abstract class Seguro {
    protected double valorApolice;

    public Seguro(double valorApolice) {
        this.valorApolice = valorApolice;
    }

    public abstract double calcularTaxa();
} 

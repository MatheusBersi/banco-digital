package br.com.cdb.bancodigital.enuns;

import java.util.Random;

public enum Bandeira {
	
	VISA("Visa"),
	MASTERCARD("Mastercard"),
	ELO("elo"),
	HIPERCARD("Hipercard"),
	ALELO("Alelo"),
	AMERICANEXPRESS("Americanexpress");

    private final String descricao;

    Bandeira(String descricao) {
        this.descricao = descricao;
    }

	public String getDescricao() {
        return this.name() + " (" + this.descricao + ")";
    }

    private static final Random random = new Random();

    public static Bandeira gerarBandeiraAleatoria() {
        return Bandeira.values()[random.nextInt(Bandeira.values().length)];
    }

	public String getGerarBandeira() {
		 return Bandeira.gerarBandeiraAleatoria().getGerarBandeira();
	}
}

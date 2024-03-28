package br.com.cdb.bancodigital.model;

import br.com.cdb.bancodigital.annotations.Autor;

/*
 * 
 * 
 */

@Autor (nome = "Ezau")

public abstract class Cartao {
	
	protected int id;
	protected String numero;
	protected int cvv;
	protected String bandeira;
	protected boolean ativo;

	
	public Cartao(int id, String numero, String bandeira, int cvv, boolean ativo ) {
		this.id = id;
		this.numero = numero;
		this.cvv = cvv;
		this.bandeira = bandeira;
		this.ativo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void ativar() {
		this.ativo = true;
	}

	public void desativar() {
		this.ativo = false;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
}

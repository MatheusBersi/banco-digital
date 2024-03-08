package br.com.cdb.bancodigital.entity;


import java.util.Random;

public class Comum extends ClienteBase{
	
	public Comum(String nome, long cpf, String endereco, int dataNascimento, String senha, int idComum) {
		super(nome, cpf, endereco, dataNascimento, senha, idComum);
	}
	
	public int init() {
		Random random = new Random();
		getIdComum() = random.nextInt(100);
		return idComum;
	}







}

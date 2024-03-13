package br.com.cdb.bancodigital.entity;

public class Comum extends ClienteBase{
	
	public Comum(String nome, long cpf, String endereco, int dataNascimento, String senha, int idComum) {
		super(nome, cpf, endereco, dataNascimento, senha, idComum);
	}
	
	@Override
	public String toString() {
		return idComum +" "+ nome +" "+ cpf +" "+ endereco +" "+ dataNascimento +" "+ senha;	
	}

}

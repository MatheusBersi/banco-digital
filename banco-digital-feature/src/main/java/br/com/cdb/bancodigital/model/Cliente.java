package br.com.cdb.bancodigital.model;


import java.time.LocalDate;

public class Cliente extends ClienteBase{
	
	public Cliente(String nome, String cpf, String logradouro, int numero, String complemento,
			String bairro, String cidade, String estado, String cep, LocalDate dataNascimento, String tipoCliente) {
		super(nome, cpf, logradouro, numero, complemento, bairro, cidade, estado, cep, dataNascimento, tipoCliente);
	}
}

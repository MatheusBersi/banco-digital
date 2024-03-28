package br.com.cdb.bancodigital.model;

import br.com.cdb.bancodigital.annotations.Autor;

/*
 * 
 * 
 */

@Autor (nome = "Ezau")

public class CartaoDebito extends Cartao {
	
	
	public CartaoDebito(int id, String numero, String bandeira, int cvv, boolean ativo) {
		super(id ,numero, bandeira, cvv, ativo);
	}
	
	@Override
	public String toString() {
		return "\n\n** Cartão de Debito gerado com sucesso! **\n"+"\nID do Cartão: " + id + "\nNúmero do cartão: "+numero +"\nCódigo de segurança: " +cvv +"\nBandeira: "
	+ bandeira +  "\nAtivo: " + (ativo ? "Sim" : "Não");
	}
	
	public String statusDoCartao() {
		return "\n\n** Status do Cartão de Debito **\n"+"\nID do Cartão: " + id + "\nNúmero do cartão: "+numero +"\nBandeira: "
	+ bandeira +  "\nAtivo: " + (ativo ? "Sim" : "Não");
	}
}

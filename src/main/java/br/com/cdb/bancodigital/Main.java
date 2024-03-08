package br.com.cdb.bancodigital;

import br.com.cdb.bancodigital.dao.ComumDAO;
import br.com.cdb.bancodigital.entity.Comum;

public class Main {

	public static void main(String[] args) {
		
		Comum cliente = new Comum("João", 56165116, "Rua das Flores, 52", 14121996, "sdfds");
		ComumDAO lista = new ComumDAO();
		
		lista.abrirContaCorrente(cliente);
		lista.verCliente();

	}

}

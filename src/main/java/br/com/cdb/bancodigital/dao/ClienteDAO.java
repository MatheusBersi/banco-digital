package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.entity.Comum;

public interface ClienteDAO {
	
	public void abrirContaCorrente(Comum cliente);
	public void abrirContaPoupanca(Comum cliente);
	public void verCliente();

}

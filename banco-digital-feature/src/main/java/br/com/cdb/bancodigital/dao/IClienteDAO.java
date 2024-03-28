package br.com.cdb.bancodigital.dao;

import java.util.HashMap;
import java.util.Set;

import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;

public interface IClienteDAO {

	public static final ContaCorrente contaCorrente = new ContaCorrente();
	public static final ContaPoupanca contaPoupanca = new ContaPoupanca();

	HashMap<Integer, Cliente> listaClientes = new HashMap<>();
	Set<Integer> chaves = listaClientes.keySet();

	public void addCliente(Integer i, Cliente cliente);
	public void verCliente();

}

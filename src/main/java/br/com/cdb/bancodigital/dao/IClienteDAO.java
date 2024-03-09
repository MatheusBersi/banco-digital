package br.com.cdb.bancodigital.dao;

import java.util.ArrayList;

import br.com.cdb.bancodigital.conta.ContaCorrente;
import br.com.cdb.bancodigital.conta.ContaPoupanca;
import br.com.cdb.bancodigital.entity.Cliente;

public interface IClienteDAO {

	public static final ContaCorrente contaCorrente = new ContaCorrente();
	public static final ContaPoupanca contaPoupanca = new ContaPoupanca();

	ArrayList<Cliente> listaClientes = new ArrayList<>();

	public void addCliente(Cliente cliente);
	public void verCliente();

}

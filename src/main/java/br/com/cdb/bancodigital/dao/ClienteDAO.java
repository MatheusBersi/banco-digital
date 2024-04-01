package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.model.Cliente;

public class ClienteDAO implements IClienteDAO {

	private int i;
	private Cliente cliente;

	public ClienteDAO() {

	}

	@Override
	public void addCliente(Cliente cliente) {
		listaClientes.put(i++, cliente);
	}

	public Cliente loginCpf(String cpf) {
		for (Cliente cliente : listaClientes.values()) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		System.out.println("CPF não encontrado. Verifique se digitou corretamente ou cadastre-se.");
		return null;
	}

	public Cliente loginSenha(String cpf, String senha) {
		Cliente cliente = loginCpf(cpf);
		if (cliente != null && cliente.getSenha().equals(senha)) {
			System.out.println("Login realizado com sucesso!");
			return cliente;
		} else {
			System.out.println("Senha incorreta. Tente novamente.");
			return null;
		}
	}

	public void verCliente() {
		for (Cliente cliente : listaClientes.values()) {
			System.out.println(cliente);
				
			}

	}

	public Cliente pixCpf(String cpf) {
		for (Cliente cliente : listaClientes.values()) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}

		}
		return null;
	}
}

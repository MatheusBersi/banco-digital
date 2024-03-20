package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.model.Cliente;

public class ClienteDAO implements IClienteDAO {
	
	public ClienteDAO() {
		
	}	

	@Override
	public void addCliente(Integer i, Cliente cliente) {
		listaClientes.put(i, cliente);
	}

	@Override
	public void verCliente() {

		for (Integer chave : chaves) {
			if (chave != null)
				System.out.println(listaClientes.get(chave));
		}
	}
}

package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.entity.Cliente;

public class ClienteDAO implements IClienteDAO{

	@Override
	public void addCliente(Cliente cliente) {
		listaClientes.add(cliente);		
	}
	
	@Override
	public void verCliente() {
		for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
	}
	
	

	

}

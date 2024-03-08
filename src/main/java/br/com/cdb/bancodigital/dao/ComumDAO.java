package br.com.cdb.bancodigital.dao;

import java.util.ArrayList;

import br.com.cdb.bancodigital.entity.Comum;

public class ComumDAO implements ClienteDAO{
	
	ArrayList<Comum> comum = new ArrayList<>();

	@Override
	public void abrirContaCorrente(Comum cliente) {
		comum.add(cliente);
		
	}

	@Override
	public void abrirContaPoupanca(Comum cliente) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void verCliente() {
		for (Comum i : comum) {
			System.out.println(i);
		}
	}
	

}

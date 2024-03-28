package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.dtos.SeguroFraudeDTO;
import br.com.cdb.bancodigital.model.CartaoCredito;

import br.com.cdb.bancodigital.utils.Menu;

public class SeguroFraudeDAO implements ICartaoDAO {


	public static void exibirSeguroFraude() {
		for (CartaoCredito cartao : cartaoCredito) {
			System.out.println("Cartão ID: " + cartao.getId());
			switch (Menu.getTipoCliente()) {
			case "Conta Comum":
				System.out.println("Seguro Fraude: " + (SeguroFraudeDTO.isSeguroFraudeAtivo() ? "Ativo\n" : "Inativo\n"));
				break;
			case "Conta Super":
				System.out.println("Seguro Fraude: " + (SeguroFraudeDTO.isSeguroFraudeAtivo() ? "Ativo\n" : "Inativo\n"));
				break;
			case "Conta Premium":
				System.out.println("Seguro Fraude: " + (SeguroFraudeDTO.isSeguroFraudeAtivo() ? "Ativo\n" : "Ativo\n"));
				break;
			}
		}
	}

	@Override
	public void gerarCartao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void verCartoesSalvos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ativarCartao(int idCartao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void desativarCartao(int idCartao) {
		// TODO Auto-generated method stub

	}
}

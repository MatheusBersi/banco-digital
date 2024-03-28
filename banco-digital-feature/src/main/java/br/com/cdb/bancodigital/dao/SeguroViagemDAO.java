package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.dtos.SeguroViagemDTO;
import br.com.cdb.bancodigital.model.CartaoCredito;
import br.com.cdb.bancodigital.utils.Menu;

public class SeguroViagemDAO implements ICartaoDAO {

	public static void ativarSeguroViagem(int idCartao) {
		for (CartaoCredito cartao : cartaoCredito) {
			if (cartao.getId() == idCartao) {
				if (Menu.getTipoCliente().equals("Conta Premium")) {
					System.out.println(
							"O seguro viagem do cartão " + idCartao + " já está ativo porque a conta é premium.");
				} else if (SeguroViagemDTO.isSeguroViagemAtivo()) {
					System.out.println("O seguro viagem do cartão " + idCartao + " já está ativo.");
				} else {
					SeguroViagemDTO.ativarSeguroViagem();
					System.out.println("Seguro viagem do cartão " + idCartao + " ativado com sucesso!\n");
				}
				break;
			}
		}
	}

	public static void desativarSeguroViagem(int idCartao) {
		for (CartaoCredito cartao : cartaoCredito) {
			if (cartao.getId() == idCartao) {
				if (!SeguroViagemDTO.isSeguroViagemAtivo()) {
					System.out.println("O seguro viagem do cartão " + idCartao + " já está desativado.\n");
				} else {
					SeguroViagemDTO.desativarSeguroViagem();
					System.out.println("Seguro viagem do cartão " + idCartao + " desativado.\n");
				}
				break;
			}
		}
	}

	public static void exibirSeguroViagem() {
		for (CartaoCredito cartao : cartaoCredito) {
			System.out.println("\nCartão ID: " + cartao.getId());
			switch (Menu.getTipoCliente()) {
			case "Conta Comum":
				System.out.println("Seguro Viagem: " + (SeguroViagemDTO.isSeguroViagemAtivo() ? "Ativo" : "Inativo"));
				break;
			case "Conta Super":
				System.out.println("Seguro Viagem: " + (SeguroViagemDTO.isSeguroViagemAtivo() ? "Ativo" : "Inativo"));
				break;
			case "Conta Premium":
				System.out.println("Seguro Viagem: " + (SeguroViagemDTO.isSeguroViagemAtivo() ? "Ativo" : "Ativo"));
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

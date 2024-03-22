package br.com.cdb.bancodigital.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cdb.bancodigital.model.CartaoCredito;
import br.com.cdb.bancodigital.usecase.GerarCartaoCreditoUseCase;

public class CartaoDAO {

	private List<CartaoCredito> cartoesSalvos = new ArrayList<>();

	public void gerarEVerCartao() {

		if (!cartoesSalvos.isEmpty()) {
			System.out.println("Já existe um cartão criado. Não é possível criar outro.");
			return;
		}

		GerarCartaoCreditoUseCase gerar = new GerarCartaoCreditoUseCase(0, null, null, 0, false);
		String numCartao = gerar.getNumero();
		int numCvv = gerar.getCvv();
		String bandeira = gerar.gerarBandeira();

		int id = cartoesSalvos.size() + 1;

		CartaoCredito novoCartao = new CartaoCredito(id, numCartao, bandeira, numCvv, false);

		cartoesSalvos.add(novoCartao);

		System.out.println(novoCartao.getId() + ", " + novoCartao.toString());
	}

	public void verCartoesSalvos() {
		for (CartaoCredito cartao : cartoesSalvos) {
			System.out.println("ID do Cartão: " + cartao.getId() + ", " + cartao.statusDoCartao());
		}

	}

	public void ativarCartao(int idCartao) {
		for (CartaoCredito cartao : cartoesSalvos) {
			if (cartao.getId() == idCartao) {
				if (cartao.isAtivo()) {
					System.out.println("O cartão " + idCartao + " já está ativado.");
				} else {
					cartao.ativar();
					System.out.println("Cartão " + idCartao + " ativado.");
				}
				break;
			}
		}
	}

	public void desativarCartao(int idCartao) {
		for (CartaoCredito cartao : cartoesSalvos) {
			if (cartao.getId() == idCartao) {
				if (!cartao.isAtivo()) {
					System.out.println("O cartão " + idCartao + " já está desativado.");
				} else {
					cartao.desativar();
					System.out.println("Cartão " + idCartao + " desativado.");
				}
				break;
			}
		}
	}
}

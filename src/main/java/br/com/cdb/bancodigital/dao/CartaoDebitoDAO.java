package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.model.CartaoDebito;
import br.com.cdb.bancodigital.usecase.GerarCartaoDebitoUseCase;

public class CartaoDebitoDAO implements ICartaoDAO {

	
	

	public void gerarCartao() {

		if (!cartaoDebito.isEmpty()) {
			System.out.println("Já existe um cartão criado. Não é possível criar outro.");
			return;
		}

		GerarCartaoDebitoUseCase gerar = new GerarCartaoDebitoUseCase(0, null, null, 0, false);
		String numCartao = gerar.getNumero();
		int numCvv = gerar.getCvv();
		String bandeira = gerar.gerarBandeira();

		int id = cartaoDebito.size() + 2;

		CartaoDebito novoCartao = new CartaoDebito(id, numCartao, bandeira, numCvv, false);

		cartaoDebito.add(novoCartao);

		System.out.println(novoCartao.toString());
	}

	public void verCartoesSalvos() {
		for (CartaoDebito cartao : cartaoDebito) {
			System.out.println(cartao.statusDoCartao());
		}

	}

	public void ativarCartao(int idCartao) {
		for (CartaoDebito cartao : cartaoDebito) {
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
		for (CartaoDebito cartao : cartaoDebito) {
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

package br.com.cdb.bancodigital.dao;

import br.com.cdb.bancodigital.annotations.Autor;
import br.com.cdb.bancodigital.model.CartaoCredito;
import br.com.cdb.bancodigital.usecase.GerarCartaoCreditoUseCase;
import br.com.cdb.bancodigital.utils.Menu;

/*
 * 
 * 
 */

@Autor(nome = "Ezau")

public class CartaoCreditoDAO implements ICartaoDAO {

	public void gerarCartao() {

		if (!cartaoCredito.isEmpty()) {
			System.out.println("Já existe um cartão criado. Não é possível criar outro.");
			return;
		}

		GerarCartaoCreditoUseCase gerar = new GerarCartaoCreditoUseCase(0, null, null, 0, false);
		String numCartao = gerar.getNumero();
		int numCvv = gerar.getCvv();
		String bandeira = gerar.gerarBandeira();

		int id = cartaoCredito.size() + 1;

		double limite;
		switch (Menu.getTipoCliente()) {
		case "Conta Comum":
			limite = 1000.0;
			break;
		case "Conta Super":
			limite = 5000.0;
			break;
		case "Conta Premium":
			limite = 10000.0;
			break;
		default:
			limite = 0.0;
		}

		CartaoCredito novoCartao = new CartaoCredito(id, numCartao, bandeira, numCvv, false, limite, false);

		cartaoCredito.add(novoCartao);

		System.out.println(novoCartao.toString());
	}

	public void verCartoesSalvos() {
		for (CartaoCredito cartao : cartaoCredito) {
			System.out.println(cartao.statusDoCartao());
			System.out.println("Limite: " + cartao.getLimite());
			System.out.println("Atenção seu cartão possui taxas:"
					+ "\nAo exeder 80% do valor gasto é cobrado um total de de 5% de utilização");
		}

	}

	public void ativarCartao(int idCartao) {
		for (CartaoCredito cartao : cartaoCredito) {
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
		for (CartaoCredito cartao : cartaoCredito) {
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

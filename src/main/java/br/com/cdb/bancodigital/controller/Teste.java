package br.com.cdb.bancodigital.controller;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;
import br.com.cdb.bancodigital.utils.Menu;

public class Teste {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Menu menu = new Menu();
		ClienteDAO listaCliente = new ClienteDAO();
		

		int opcao = 0;
		while (opcao != 9) {
			System.out.println("Seja Bem Vindo ao AMAN BANK");
			System.out.println("[1] Login\n" + "[2] Cadastrar\n" + "[9] Sair");
			opcao = input.nextInt();
			input.nextLine();
			if (opcao == 1) {
				menu.menuLogin();
				// lógica para o login
			} else if (opcao == 2) {
				boolean cadastro = menu.menuCadastro(input);
				if (cadastro) {
					Cliente cliente = new Cliente(menu.getNome(), menu.getCpf(), menu.getLogradouro(), menu.getNumero(),
							menu.getComplemento(), menu.getBairro(), menu.getCidade(), menu.getEstado(), menu.getCep(),
							menu.getDataNascimento(), "COMUM");
					cliente.init();
					System.out.println("aperte 1");
					int aperte = input.nextInt();
					if(aperte == 1) {
						cliente.exibirDados();
					}
					menu.abrirConta(input);
				} else {
					// lógica caso o cadastro não tenha sido realizado com sucesso
				}

			}
		}

		menu.menuLogin();

//		menu.telaInicial();
//		if(!menu.getMaiorIdade()) {
//			menu.telaInicial();
//		}

		Cliente cliente = new Cliente(menu.getNome(), menu.getCpf(), menu.getLogradouro(), menu.getNumero(),
				menu.getComplemento(), menu.getBairro(), menu.getCidade(), menu.getEstado(), menu.getCep(),
				menu.getDataNascimento(), "COMUM");
		cliente.init();

		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();

		contaCorrente.initNumAgencia();
		contaCorrente.initNumConta();

		cliente.setContaCorrente(contaCorrente);
		cliente.setContaPoupanca(contaPoupanca);

		contaPoupanca.setNumAgencia(contaCorrente.getNumAgencia());
		contaPoupanca.initNumConta();

		contaCorrente.depositar(BigDecimal.valueOf(10000));
		contaCorrente.cobrarMensalidade();

		contaPoupanca.depositar(BigDecimal.valueOf(999.99));
		contaPoupanca.render();

		listaCliente.addCliente(1, cliente);

//		contaCorrente.verSaldo();
//		contaPoupanca.verSaldo();

		if (contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0
				&& contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0
				|| contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0
						&& contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0) {
			cliente.setTipoConta("SUPER");
		} else if (contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0
				| contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0) {
			cliente.setTipoConta("PREMIUM");
		}

		listaCliente.verCliente();
		cliente.exibirDados();

//		 String dataString = "25-01-2024";

//	        // Definindo o formato da data
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//	        // Parse da string para LocalDate usando o formato definido
//	        LocalDate data = LocalDate.parse(dataString, formatter);
//
//	        // Formatando a data para o formato desejado
//	        String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//	        // Exibindo a data formatada
//	        System.out.println("Data inserida: " + dataFormatada);

	}

}

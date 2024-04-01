package br.com.cdb.bancodigital.controller;

import java.time.LocalDate;
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

		ContaPoupanca contaP = null;
		ContaCorrente contaC = null;
		
		int opcao = 0;
		
		while(opcao != 9) {
			opcao = menu.telaInicial(input);
			if (opcao == 1) {
				menu.logar(input, contaC, contaP);
				
			} else if (opcao == 2) {
				boolean cadastro = menu.menuCadastro(input);
				if (cadastro) {
					Cliente cliente = new Cliente(menu.getNome(), menu.getCpf(), menu.getLogradouro(), menu.getNumero(),
							menu.getComplemento(), menu.getBairro(), menu.getCidade(), menu.getEstado(), menu.getCep(),
							menu.getDataNascimento(), "COMUM");
//					Cliente cliente = new Cliente("Matheus", "43787772820", "Rua Fernandes", 13,
//							"", "Vila Ester", "São Paulo", "SP", "08330280",
//							LocalDate.of(2024, 1, 25), "COMUM");
					cliente.init();
					menu.cadastrarSenha(input, cliente);
					listaCliente.addCliente(cliente);
					System.out.println(cliente.getSenha());
					int escolha = menu.abrirConta(input);
					switch(escolha) {
					case 1:
						contaP = null;
						contaC = menu.abrirContaCorrente(cliente, contaP);
//						contaCorrente.initNumAgencia();
//						contaCorrente.initNumConta();
						cliente.setContaCorrente(contaC);
//						System.out.println("Conta Corrente criada com sucesso!!"
//								+ "Dados da Conta"
//								+ "Número da Agência: " + contaCorrente.getNumAgencia()
//								+ "Número da Conta Corrente: " + contaCorrente.getNumConta());
						
						break;
						
					case 2:
						contaC = null;
						contaP = menu.abrirContaPoupanca(cliente, contaC);
//						contaPoupanca.initNumAgencia();
//						contaPoupanca.initNumConta();
//						cliente.setContaPoupanca(contaPoupanca);
						cliente.setContaPoupanca(contaP);
//						System.out.println("Conta Poupança criada com sucesso!!"
//								+ "Dados da Conta"
//								+ "Número da Agência: " + contaPoupanca.getNumAgencia()
//								+ "Número da Conta Poupança: " + contaPoupanca.getNumConta());
						
						break;
						
					case 3:
						contaC = null;
						contaP = null;
						contaC = menu.abrirContaCorrente(cliente, contaP);
						cliente.setContaCorrente(contaC);
						contaP = menu.abrirContaPoupanca(cliente, contaC);
						cliente.setContaPoupanca(contaP);
//						ContaCorrente contaCorrente2 = new ContaCorrente();
//						contaCorrente2.initNumAgencia();
//						contaCorrente2.initNumConta();
//						cliente.setContaCorrente(contaCorrente2);
//						
//						ContaPoupanca contaPoupanca2 = new ContaPoupanca();
//						contaPoupanca2.setNumAgencia(contaCorrente2.getNumAgencia());
//						contaPoupanca2.initNumConta();
//						cliente.setContaPoupanca(contaPoupanca2);
						
//						System.out.println("Conta Corrente e Conta Poupança criadas com sucesso!!"
//								+ "Dados das Contas"
//								+ "Número da Agência: " + contaCorrente2.getNumAgencia()
//								+ "Número da Conta Corrente: " + contaCorrente2.getNumConta()
//								+ "Número da Conta Poupança: " + contaPoupanca2.getNumConta());
						
					case 9:
						break;
					}
					
					
				}

			}
			else if(opcao == 3) {			
				listaCliente.verCliente();
			}
//			else {
//				System.out.println("Encerrando...");
//			}
		}

//		menu.menuLogin();
//
//		menu.telaInicial();
//		if(!menu.getMaiorIdade()) {
//			menu.telaInicial();
//		}
//
//		Cliente cliente = new Cliente(menu.getNome(), menu.getCpf(), menu.getLogradouro(), menu.getNumero(),
//				menu.getComplemento(), menu.getBairro(), menu.getCidade(), menu.getEstado(), menu.getCep(),
//				menu.getDataNascimento(), "COMUM");
//		cliente.init();
//
//		ContaCorrente contaCorrente = new ContaCorrente();
//		ContaPoupanca contaPoupanca = new ContaPoupanca();
//
//		contaCorrente.initNumAgencia();
//		contaCorrente.initNumConta();
//
//		cliente.setContaCorrente(contaCorrente);
//		cliente.setContaPoupanca(contaPoupanca);
//
//		contaPoupanca.setNumAgencia(contaCorrente.getNumAgencia());
//		contaPoupanca.initNumConta();
//
//		contaCorrente.depositar(BigDecimal.valueOf(10000));
//		contaCorrente.cobrarMensalidade();
//
//		contaPoupanca.depositar(BigDecimal.valueOf(999.99));
//		contaPoupanca.render();
//
//		listaCliente.addCliente(1, cliente);

//		contaCorrente.verSaldo();
//		contaPoupanca.verSaldo();
//
//		if (contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0
//				&& contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0
//				|| contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0
//						&& contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0) {
//			cliente.setTipoConta("SUPER");
//		} else if (contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0
//				| contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0) {
//			cliente.setTipoConta("PREMIUM");
//		}
//
//		listaCliente.verCliente();
//		cliente.exibirDados();
//
//		 String dataString = "25-01-2024";
//
//	         Definindo o formato da data
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


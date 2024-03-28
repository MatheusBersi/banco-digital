package br.com.cdb.bancodigital.utils;

import java.util.Scanner;

import br.com.cdb.bancodigital.dao.CartaoCreditoDAO;
import br.com.cdb.bancodigital.dao.CartaoDebitoDAO;
import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.Conta;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;

import java.io.PrintStream;
import java.util.HashMap;

public class Menu2 {
	
	public Menu2() {
		
	}
	
	static Scanner input = new Scanner(System.in);

	//MENU INICIAL
	public static void menuInicial()  {
	
		int numInicio;
		System.out.println("SEJA BEM-VINDO AO AMAN, SEU BANCO DIGITAL\n"
						   +"Qual será seu modo de entrada?\n"
						   +"[1] Login\n"
						   +"[2] Cadastre-se\n");
		numInicio = input.nextInt();
		
		switch (numInicio) {
		//LOGIN
		case 1:
			System.out.println("Digite seu nome:\n");
			String nome = input.nextLine();
			//ADICIONAR VERIFICAÇÃO DE NOME
//			if (listaClientes.containsKey(nome)) {
//				System.out.println("Cliente encontrado!\n"
//								   + "Seja Bem-Vindo " +nome);
//			}
//			else {
//				System.out.println("Cliente não encontrado, efetue o cadastro");
//				menuInicial();
//				
//			}
			//CADASTRO
		case 2:
			menuCadastro();
		
			break;	
		}
		
	
		
		
	}
		//MENU CADASTRO
		public static void menuCadastro() {
			System.out.println("Insira seu nome completo:\n");
			String nome = input.nextLine();
			
			System.out.println("Insira seu CPF:\n");
			String cpf = input.nextLine();
			
			System.out.println("Insira sua data de nascimento seguindo exatamente o modelo (ano, mês, dia):\n");
			String dataNascimento = input.nextLine();
			
			System.out.println("Insira seu CEP:\n");
			long cep = input.nextLong();
			
			System.out.println("insira sua renda:\n");
			long renda = input.nextLong();
			
			System.out.println("Agota crie uma senha:\n");
			String senha = input.nextLine();
			
			System.out.println("Defina qual será seu tipo de conta:\n"							   
							   +"Conta Comum\n"
							   +"Conta Super\n"
							   +"Conta Premium\n");
			String tipoConta = input.nextLine();
			
			//CRIAR VALIDADOR DE CRIAÇÃO DE CONTA BASEADO NA RENDA
			
		} //foi
		
		
	
		//MENU CONTA
		public static void menuConta() {
			int numConta ;
			System.out.println("Em que etapa deseja prosseguir?\n"
							   +"[1] Consultar taxas mensais\n"
							   +"[2] Consultar rendimentos atuais\n"
							   +"[3] Configurar cartões\n"
							   +"[4] Conta poupança\n"
							   +"[5] Conta corrente\n"
							   +"[6] Seguros\n");
			numConta = input.nextInt();
			
			switch (numConta) {
			case 1:
				System.out.println("TAXAS MENSAIS\n"
								  + "Cliente Comum: R$12,00\n"
								  +"Cliente Super: R$8,00\n"
								  +"Cliente Premium: Sem taxa!");
				
			case 2:
				System.out.println("RENDIMENTO DA POUPANÇA DE ACORDO COM SUA CONTA"
								  + "Conta comum: 0,5%"
								  + "COnta super: 0,7%"
								  + "Conta premium: 0,9%");
			case 3:
				//TERMINAR MENU DOS CARTÕES
				menuCriarCartao();
				
				
			case 4:
				//TERMINAR MENU DAS CONTAS POUPANÇA
				menuContaPoupança();
			case 5:
				//TERMINAR MENU DAS CONTAS CORRENTE
				menuContaCorrente(null);
			case 6:
			menuSeguros();
			
			break;
			}
			
		}
		
		
		//MENU CRIAÇÃO CARTÃO
			public static void menuCriarCartao() {
					CartaoCreditoDAO cartaoCreditoDao = new CartaoCreditoDAO();
					CartaoDebitoDAO cartaoDebitoDao = new CartaoDebitoDAO();
					
					String conf;
					
						
					
					    do {
					    	try {
							System.out.println("Digite uma opção:" + "\n1 - Gerar cartao" + "\n2 - ativar cartão" 
							+ "\n3 - desativar cartao" + "\n4 - status dos cartões");
							int escolha = input.nextInt();
							
					
							if(escolha == 1) {
								if( escolha == 1) {
									System.out.println("1 - Gerar crédito?" + "\n2 - Gerar Debito?");
									escolha = input.nextInt();
								}if(escolha == 1) {
									cartaoCreditoDao.gerarCartao();
								}else if(escolha == 2){
									cartaoDebitoDao.gerarCartao();
								}
								
							}else if(escolha == 2) {
								
								System.out.println("Digite o ID do cartão que deseja ativar:");
								int idCartao = input.nextInt();
								cartaoCreditoDao.ativarCartao(idCartao);
								cartaoDebitoDao.ativarCartao(idCartao);
								
							}else if(escolha == 3) {
								
								System.out.println("Digite o ID do cartão que deseja desativar:");
								int idCartao = input.nextInt();
								cartaoCreditoDao.desativarCartao(idCartao);
								cartaoDebitoDao.desativarCartao(idCartao);
								
							}else if(escolha == 4) {
								
								cartaoCreditoDao.verCartoesSalvos();
								cartaoDebitoDao.verCartoesSalvos();
							}else {
								
								System.out.println("Opção inválida!");
							}
						
				 
					    	}catch(Exception InputMismatchException) {
					    		
								System.out.println("Erro, coloque um número ao invés de uma letra");
								
							}
					    	
					    	input.nextLine();
							System.out.println("concuido? (S/N): ");
							 conf  = input.nextLine();
							 
						}while (!conf.equals("s"));
						
						System.out.println("Obrigado!");
						//ADICIONAR OPÇÃO MUDAR SENHA (EZAÚ)
		}		
						
				
		


		
		
		//MENU CONTA CORRENTE
			public static void menuContaCorrente(Conta contaCorrente) {
			int numContaCorrente;
			System.out.println("CONTA CORRENTE\n"
							   + "[1] Exibir saldo\n"
							   + "[2] Fazer transferências\n"
							   + "[3] PIX\n"
							   + "[4] Depósito\n");
			numContaCorrente = input.nextInt();
			
			if (numContaCorrente == 1)  {
				System.out.println(contaCorrente.getSaldo());
			}
			else if(numContaCorrente == 2)  {
				//IMPLEMENTAR TRANSFERÊNCIA E CRIAR MENU TRANSFERÊNCIA (MATHEUS)
			}
			else if(numContaCorrente == 3)  {
				//IMPLEMENTAR/CRIAR PIX E MENU PIX (MATHEUS)
			}
			else if(numContaCorrente == 4)  {
				//IMPELEMENTAR DEPÓSITO E CRIAR MENU DEPOSITAR (MATHEUS)
			}
			
		}
		
		//MENU CONTA POUPANÇA			
		public static void menuContaPoupança() {
					int numContaCorrente;
					System.out.println("CONTA CORRENTE\n"
									   + "[1] Exibir saldo\n"
									   + "[2] Fazer transferências\n"
									   + "[3] PIX\n"
									   + "[4] Depósito\n");
					numContaCorrente = input.nextInt();
					
					if (numContaCorrente == 1)  {
						System.out.println("Ver saldo");
					}
					else if(numContaCorrente == 2)  {
						//IMPLEMENTAR TRANSFERÊNCIA E CRIAR MENU TRANSFERÊNCIA
					}
					else if(numContaCorrente == 3)  {
						//IMPLEMENTAR/CRIAR PIX E MENU PIX
					}
					else if(numContaCorrente == 4)  {
						//IMPELEMENTAR DEPÓSITO E CRIAR MENU DEPOSITAR
					}
					
				}
		
		//MENU SEGURO
		public static void menuSeguros() {
			int numSeguro;
			System.out.println("[1] Seguros ideais\n"
					  +"[2] Rever informações\n"
					  +"[3] Acionar seguro\n");
			numSeguro = input.nextInt();
			
			switch (numSeguro) {
			case 1:
				System.out.println("Para clientes comum e super: R$50,00\n" 
					+ "Para clientes premium: incluso no plano\n");
				
			case 2:
				System.out.println("Para clientes comum e super: R$50,00\n" 
						+ "Para clientes premium: incluso no plano\n");
					
			case 3:
				//CRIAR SEGURO
							}
			
					 
		}
		
		


}
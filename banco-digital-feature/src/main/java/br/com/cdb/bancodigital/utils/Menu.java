package br.com.cdb.bancodigital.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.cdb.bancodigital.annotations.Autor;
import br.com.cdb.bancodigital.annotations.SubAutor;
import br.com.cdb.bancodigital.dao.CartaoCreditoDAO;
import br.com.cdb.bancodigital.dao.CartaoDebitoDAO;
import br.com.cdb.bancodigital.dao.ICartaoDAO;
import br.com.cdb.bancodigital.dao.SeguroFraudeDAO;
import br.com.cdb.bancodigital.dao.SeguroViagemDAO;
//import br.com.cdb.bancodigital.dao.SeguroFraudeDAO;
//import br.com.cdb.bancodigital.dao.SeguroViagemDAO;
import br.com.cdb.bancodigital.model.CartaoCredito;
import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;

/*
 * 
 */
@Autor(nome = "Matheus")
@SubAutor(nome = "Ezaú" + "Miguel" + "Roberto" + "Andre")

public class Menu {

	private static final Scanner input = new Scanner(System.in);
	private String nome;
	private String cpf;
	private boolean maiorIdade;
	private LocalDate dataNascimento;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private int numero;
	private String complemento;
	private String cep;
	private boolean validar = false;
	private String senha = null;
	private boolean senhaValida = false;
	private Cliente cliente;
	private static String tipoCliente;
	private static ContaCorrente contaCorrente;
	private static ContaPoupanca contaPoupanca = new ContaPoupanca();

//	public void menuLogin() {
//
//	}

	public boolean menuCadastro(Scanner input) {

		boolean voltar = inserirNome(input);
		if (!voltar) {
			return false;
		} else {
			boolean voltar1 = inserirCpf(input);
			if (!voltar1) {
				return false;
			} else {
				maiorIdade = inserirDataNascimento(input);
				if (!maiorIdade) {
					return false;
				} else {
					boolean voltar2 = inserirCep(input);
					if (!voltar2) {
						return false;
					}
					boolean voltar3 = inserirRenda(input);
					if (!voltar3) {
						return false;
					} else {
						System.out.println("Confirme seus dados:");
						exibirDados();
						System.out.println("Seus dados estão corretos?\n" + "[1] Sim\n" + "[2] Não");
						int confirmar = input.nextInt();
						input.nextLine();
						if (confirmar == 1) {
							cliente = new Cliente(nome, cpf, logradouro, numero, complemento, bairro, cidade, estado,
									cep, dataNascimento, tipoCliente);
							cadastrarSenha(input, cliente);
							System.out.println("Cadastro realizado com sucesso!!\n");

						} else if (confirmar == 2) {
							System.out.println("Você será redirecionado para o início do cadastro...");
							menuCadastro(input);
						}
						return true;
					}

				}

			}

		}

	}

	public boolean inserirRenda(Scanner input) {
		System.out.println("Insira sua renda mensal:");
		double renda = input.nextDouble();
		input.nextLine();

		if (renda <= 1500) {
			tipoCliente = "Conta Comum";
		} else if (renda >= 1501 && renda <= 3000) {
			tipoCliente = "Conta Super";
		} else {
			tipoCliente = "Conta Premium";
		}

		return true;
	}

	public static void setTipoCliente(String tipoCliente) {
		Menu.tipoCliente = tipoCliente;
	}

	public void abrirConta(Scanner input) {
		Cliente cliente = new Cliente(nome, cpf, logradouro, numero, complemento, bairro, cidade, estado, cep,
				dataNascimento, tipoCliente);

		System.out.println(
				"Escolha o tipo de conta de deseja abrir:\n" + "[1] Conta Corrente\n" + "[2] Conta Poupança\n");
		int escolha = input.nextInt();

		switch (escolha) {
		case 1:
			ContaCorrente contaCorrente = abrirContaCorrente(cliente, null);
			cliente.setContaCorrente(contaCorrente);
			System.out.println("Conta Corrente criada com sucesso!\n" + "Número da Conta Corrente: "
					+ contaCorrente.getNumConta() + "\nNúmero da Agência: " + contaCorrente.getNumAgencia());
			break;

		case 2:
			ContaPoupanca contaPoupanca = abrirContaPoupanca(cliente, null);
			cliente.setContaPoupanca(contaPoupanca);
			System.out.println("Conta Poupança criada com sucesso!\n" + "Número da Conta Poupança: "
					+ contaPoupanca.getNumConta() + "\nNúmero da Agência: " + contaPoupanca.getNumAgencia());
			break;
		default:
			System.out.println("Escolha uma das opções.");
			abrirConta(input);
			break;
		}
		System.out.println(cliente.toString());
	}

	public ContaCorrente abrirContaCorrente(Cliente cliente, ContaPoupanca contaPoupanca) {
		ContaCorrente contaCorrente = new ContaCorrente();

		if (contaPoupanca == null) {
			contaCorrente.initNumAgencia();
			contaCorrente.initNumConta();
			cliente.setContaCorrente(contaCorrente);
		} else {
			contaCorrente.initNumAgencia();
			contaCorrente.setNumAgencia(contaPoupanca.getNumAgencia());
			cliente.setContaCorrente(contaCorrente);
		}
		return contaCorrente;
	}

	public ContaPoupanca abrirContaPoupanca(Cliente cliente, ContaCorrente contaCorrente) {
		ContaPoupanca contaPoupanca = new ContaPoupanca();

		if (contaCorrente == null) {
			contaPoupanca.initNumAgencia();
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);
		} else {
			contaPoupanca.setNumAgencia(contaCorrente.getNumAgencia());
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);
		}
		return contaPoupanca;
	}

	public void cadastrarSenha(Scanner input, Cliente cliente) {

		while (!senhaValida) {
			System.out.println("Crie uma senha (deve conter mais de 8 caracteres, mínimo 1 letra "
					+ "maiúscula, 1 letra minúscula e 1 símbolo especial):");
			senha = input.nextLine();
			senhaValida = validarSenha(senha);
			if (!senhaValida) {
				System.out.println("Senha inválida! Tente novamente.");
			}
		}

		System.out.println("Digite novamente:");
		String confirmarSenha = input.nextLine();
		if (confirmarSenha.equals(senha)) {
			System.out.println("Senha cadastrada com sucesso!");
			cliente.setSenha(senha);
		} else {
			System.out.println("As senhas não correspondem, tente novamente.");
			cadastrarSenha(input, cliente);
		}
	}

	public boolean validarSenha(String senha) {
		return senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	}

	public boolean inserirNome(Scanner input) {
		do {
			System.out.println("Insira seu nome completo:				[0]Sair");
			nome = input.nextLine();
			if (nome.equals("0")) {
				System.exit(0);
			} else {
				validar = ClienteValidator.validarNome(nome);
			}
		} while (!validar);
		return true;

	}

	public boolean inserirCpf(Scanner input) {

		do {
			System.out.println("Insira seu CPF (apenas números):			[0]Sair");
			cpf = input.nextLine();
			if (cpf.equals("0")) {
				System.exit(0);
			}
			validar = ClienteValidator.validarCpf(cpf);

		} while (!validar);
		return true;
	}

	public boolean inserirCep(Scanner input) {

		int opcao = 0;
		while (opcao != 1 && opcao != 2 && opcao != 9) {
			System.out.println("Insira as informações do seu endereço:			[9]Sair\n" + "[1] Buscar pelo CEP\n"
					+ "[2] Não sei meu CEP");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
			case 1:
				boolean cep1 = CepConsulta.consultarCep();

				if (!cep1) {
					inserirCep(input);
				} else {
					logradouro = CepConsulta.getLogradouro();
					bairro = CepConsulta.getBairro();
					cidade = CepConsulta.getCidade();
					estado = CepConsulta.getEstado();
					cep = CepConsulta.getCep();
				}

				enderecoCorreto(input);

				break;

			case 2:
				digitarEndereco(input);
				break;

			case 9:
				System.exit(0);

			default:
				System.out.println("Selecione uma das opções.");
				break;

			}
		}
		if (opcao == 9) {
			System.exit(0);
		}
		return true;

	}

	private void enderecoCorreto(Scanner input) {
		int opcao2 = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			try {
				System.out.println("O endereço está correto?\n" + "[1] Sim\n" + "[2] Não");
				opcao2 = input.nextInt();
				input.nextLine();

				if (opcao2 != 1 && opcao2 != 2) {
					System.out.println("Escolha uma das opções.");
				} else {
					entradaValida = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Escolha uma das opções.");
				input.nextLine();
			}
		}

		switch (opcao2) {

		case 1:
			System.out.println("Insira o número:");
			numero = input.nextInt();
			input.nextLine();
			System.out.println("Insira o complemento (se não houver aperte Enter):");
			complemento = input.nextLine();
			break;

		case 2:
			digitarEndereco(input);
			break;

		default:
			System.out.println("Selecione uma das opções.");
			break;
		}
	}

	public void digitarEndereco(Scanner input) {
		int opcao = 0;
		while (opcao != 1) {
			System.out.println("Insira o logradouro:");
			logradouro = input.nextLine();
			System.out.println("Insira o número:");
			numero = input.nextInt();
			System.out.println("Insira o complemento:");
			complemento = input.nextLine();
			input.nextLine();
			System.out.println("Insira o bairro:");
			bairro = input.nextLine();
			System.out.println("Insira a cidade:");
			cidade = input.nextLine();
			System.out.println("Insira o estado:");
			estado = input.nextLine();
			cep = "";
			System.out.println("Logradouro: " + logradouro + "\nNúmero: " + numero +"\nComplemento: "+complemento+ "\nBairro: " + bairro
					+ "\nCidade: " + cidade + "\nEstado: " + estado);
			System.out.println("O endereço está correto?\n" + "[1] Sim\n" + "[2] Não");
			opcao = input.nextInt();
			if (opcao != 1 && opcao != 2) {
				System.out.println("Escolha uma das opções.");
			}
		}

	}

	public boolean inserirDataNascimento(Scanner input) {

		try {
			System.out.println("Insira sua data de nascimento (formato dd/mm/aaaa):	[0]Sair");
			String data = input.nextLine();
			if (data.equals("0")) {
				System.exit(0);
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dataNascimento = LocalDate.parse(data, formatter);
				LocalDate dataAtual = LocalDate.now();
				Period periodo = Period.between(dataNascimento, dataAtual);
				int idade = periodo.getYears();
				if (idade >= 18) {
					return true;
				} else {
					System.out.println("É necessário ser maior de idade, sentimos muito.");
					return false;
				}
			}

		} catch (DateTimeParseException e) {
			System.out.println("Formato de data inválido. Por favor, insira a data no formato dd/mm/aaaa.");
			inserirDataNascimento(input);
		}
		return true;
	}

	public void exibirDados() {

		System.out.println("\n*** DADOS PESSOAIS ***");
		System.out.println("+--------------------------------------+");
		System.out.printf("|Nome: %-30s |\n", nome);
		System.out.printf("|CPF: %-31s |\n", cpf);
		System.out.printf("|Data de Nascimento: %-18s |\n", dataNascimento);
		System.out.println("+--------------------------------------+");
		System.out.println("\n*** ENDEREÇO ***");
		System.out.println("+--------------------------------------+");
		System.out.printf("|Logradouro: %-24s |\n", logradouro);
		System.out.printf("|Número: %-29d |\n", numero);
		System.out.printf("|Complemento: %-21s |\n", complemento);
		System.out.printf("|Bairro: %-27s |\n", bairro);
		System.out.printf("|Cidade: %-27s |\n", cidade);
		System.out.printf("|Estado: %-27s |\n", estado);
		System.out.printf("|CEP: %-31s |\n", cep);
		System.out.println("+--------------------------------------+");
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public boolean getMaiorIdade() {
		return maiorIdade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public static String getTipoCliente() {
		return tipoCliente;
	}

	/*
	 * 
	 */
	@Autor(nome = "Miguel")
	@SubAutor(nome = "Ezaú" + "Miguel" + "Roberto" + "Andre")

	public static void menuConta() {
		int numConta;
		while (true) {
			System.out.println(
					"Em que etapa deseja prosseguir?\n" + "[1] Informações da conta\n" + "[2] Consultar taxas mensais\n"
							+ "[3] Consultar rendimentos atuais\n" + "[4] Seguros\n" + "[5] Configurar cartões");
			numConta = input.nextInt();

			switch (numConta) {
			case 1:
				contaInfo();
				break;
			case 2:
				consultarTaxas();
				break;
			case 3:
				consultarRendimentos();
				break;
			case 4:
				menuSeguros();
				break;

			case 5:
				menuCriarCartao();
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}

	public static void consultarTaxas() {
		switch (tipoCliente) {
		case "Conta Comum":
			System.out.println("TAXAS MENSAIS CONTA COMUM" + "\nCesta de Serviços: R$12,00" + "\nNo período de 30 dias corridos será cobrado uma taxa de R$13,00" + "\nFique atento! Mantenha sua conta corrente com saldo positivo.");
			break;
		case "Conta Super":
			System.out.println("TAXAS MENSAIS CONTA SUPER" + "\nCesta de Serviços: R$8,00" + "\nNo período de 30 dias corridos será cobrado uma taxa de R$8,00" +"\nFique atento! Mantenha sua conta corrente com saldo positivo.");
			break;
		case "Conta Premium":
			System.out.println("TAXAS MENSAIS CONTA PREMIUM" + "\nSem taxa!");
			break;
		}
	}

	public static void consultarRendimentos() {

		double saldo = contaPoupanca.getSaldo().doubleValue();

		double rendimento;
		double saldoPrevisto;
		switch (tipoCliente) {
		case "Conta Comum":
			rendimento = saldo * 0.005;
			saldoPrevisto = saldo + (30 * rendimento);
			System.out.println("RENDIMENTO DA POUPANÇA DE ACORDO COM SUA CONTA" + "\nConta comum: 0,5%\n"
					+ "Rendimento: " + rendimento + "\n" + "Saldo previsto em 30 dias: " + saldoPrevisto + "\n");
			break;
		case "Conta Super":
			rendimento = saldo * 0.007;
			saldoPrevisto = saldo + (30 * rendimento);
			System.out.println("RENDIMENTO DA POUPANÇA DE ACORDO COM SUA CONTA" + "\nConta super: 0,7%\n"
					+ "Rendimento: " + rendimento + "\n" + "Saldo previsto em 30 dias: " + saldoPrevisto + "\n");
			break;
		case "Conta Premium":
			rendimento = saldo * 0.009;
			saldoPrevisto = saldo + (30 * rendimento);
			System.out.println("RENDIMENTO DA POUPANÇA DE ACORDO COM SUA CONTA" + "\nConta premium: 0,9%\n"
					+ "Rendimento: " + rendimento + "\n" + "Saldo previsto em 30 dias: " + saldoPrevisto + "\n");
			break;
		}
	}

	// INFORMAÇÕES DA CONTA
	public static void contaInfo() {
		int numInfo;
		System.out.println("\nGostaria de ver as informações de qual conta?:" + "\n[1] Conta Corrente"
				+ "\n[2] Conta Poupança" + "\n[0] Voltar");
		numInfo = input.nextInt();

		if (numInfo == 1) {
			if (contaCorrente == null) {
				contaCorrente = new ContaCorrente();
			}
			if (contaCorrente.getNumConta() == 0) {
				contaCorrente.initNumConta();
			}
			if (contaCorrente.getNumAgencia() == 0) {
				contaCorrente.initNumAgencia();
			}
			menuContaCorrente(contaCorrente);
		} else if (numInfo == 2) {
			if (contaPoupanca == null) {
				contaPoupanca = new ContaPoupanca();
			}
			if (contaPoupanca.getNumConta() == 0) {
				contaPoupanca.initNumConta();
			}
			if (contaPoupanca.getNumAgencia() == 0) {
				contaPoupanca.initNumAgencia();
			}
			menuContaPoupanca(contaPoupanca);
		}

		if (numInfo == 0) {
			menuConta();
		}
	}

	// MENU CRIAÇÃO CARTÃO
	public static void menuCriarCartao() {
		CartaoCreditoDAO cartaoCreditoDao = new CartaoCreditoDAO();
		CartaoDebitoDAO cartaoDebitoDao = new CartaoDebitoDAO();

		String conf;

		do {
			try {
				System.out.println("Digite uma opção:" + "\n[1] - Gerar cartao" + "\n[2] - ativar cartão"
						+ "\n[3] - desativar cartao" + "\n[4] - status dos cartões" + "\n[5] Realizar compra");
				int escolha = input.nextInt();

				if (escolha == 1) {
					if (escolha == 1) {
						System.out.println("[1] - Gerar crédito?" + "\n[2] - Gerar Debito?");
						escolha = input.nextInt();
					}
					if (escolha == 1) {
						cartaoCreditoDao.gerarCartao();
					} else if (escolha == 2) {
						cartaoDebitoDao.gerarCartao();
					}

				} else if (escolha == 2) {

					System.out.println("Digite o ID do cartão que deseja ativar:");
					int idCartao = input.nextInt();
					cartaoCreditoDao.ativarCartao(idCartao);
					cartaoDebitoDao.ativarCartao(idCartao);

				} else if (escolha == 3) {

					System.out.println("Digite o ID do cartão que deseja desativar:");
					int idCartao = input.nextInt();
					cartaoCreditoDao.desativarCartao(idCartao);
					cartaoDebitoDao.desativarCartao(idCartao);

				} else if (escolha == 4) {

					cartaoCreditoDao.verCartoesSalvos();
					cartaoDebitoDao.verCartoesSalvos();

				} else if (escolha == 5) {
					System.out.println("Digite o ID do cartão que deseja usar para a compra:");
					int idCartao = input.nextInt();
					System.out.println("Digite o valor da compra:");
					double valorCompra = input.nextDouble();
					for (CartaoCredito cartao : ICartaoDAO.cartaoCredito) {
						if (cartao.getId() == idCartao) {
							cartao.realizarCompra(valorCompra);
							break;
						}
					}

				} else {
					System.out.println("Opção inválida!");
				}

			} catch (Exception InputMismatchException) {

				System.out.println("Erro, coloque um número ao invés de uma letra");

			}

			input.nextLine();
			System.out.println("concuido? (S/N): ");
			conf = input.nextLine();

		} while (!conf.equals("s"));

		System.out.println("Obrigado!");
	}

	// MENU CONTA CORRENTE
	public static void menuContaCorrente(ContaCorrente contaCorrente) {

		System.out.println("*** CONTA CORRENTE ***\n");
		System.out.println(contaCorrente.infoConta());

		int numContaCorrente;
		System.out.println("O que gostaria de fazer?\n" + "[1] Exibir saldo\n" + "[2] Fazer transferências\n"
				+ "[3] PIX\n" + "[4] Depósito\n" + "[0] voltar");
		numContaCorrente = input.nextInt();

		switch (numContaCorrente) {
		case 1:
			System.out.println("\nSaldo Atual: " + contaCorrente.getSaldo() + "\n");
			break;
		case 2:
			if (contaPoupanca != null) {
				System.out.println("Digite o valor que deseja transferir para a conta poupança:");
				BigDecimal valorTransferencia = input.nextBigDecimal();
				contaCorrente.transferir(contaPoupanca, valorTransferencia);
			} else {
				System.out
						.println("A conta poupança ainda não foi criada. Por favor, crie a conta poupança primeiro.\n");
			}
			break;
		case 4:
			System.out.println("Digite o valor que deseja depositar:");
			BigDecimal valorDeposito = input.nextBigDecimal();
			contaCorrente.depositar(valorDeposito);
			System.out
					.println("\nDepósito realizado com sucesso. Seu novo saldo é: " + contaCorrente.getSaldo() + "\n");
			break;
		default:
			System.out.println("\nOpção inválida");
			break;
		}
		if (numContaCorrente == 0) {
			menuConta();
		}
	}

	// MENU CONTA POUPANÇA
	public static void menuContaPoupanca(ContaPoupanca contaPoupanca) {

		System.out.println("*** CONTA POUPANÇA ***\n");
		System.out.println(contaPoupanca.infoConta());

		int numContaPoupanca;
		System.out.println("O que gostaria de fazer?\n" + "[1] Exibir saldo\n" + "[2] Fazer transferências\n"
				+ "[3] Depósito\n" + "[0] voltar");
		numContaPoupanca = input.nextInt();

		switch (numContaPoupanca) {

		case 1:// Exibe Saldo

			System.out.println("\nSaldo Atual: " + contaPoupanca.getSaldo() + "\n");

			break;

		case 2:// Faz Tranferências

			if (contaCorrente != null) {
				System.out.println("Digite o valor que deseja transferir para a conta corrente:");
				BigDecimal valorTransferencia = input.nextBigDecimal();
				contaPoupanca.transferir(contaCorrente, valorTransferencia);
			} else {
				System.out
						.println("A conta corrente ainda não foi criada. Por favor, crie a conta corrente primeiro.\n");
			}

		case 3:// Faz Depósito

			System.out.println("Digite o valor que deseja depositar:");
			BigDecimal valorDeposito = input.nextBigDecimal();
			contaPoupanca.depositar(valorDeposito);
			System.out
					.println("\nDepósito realizado com sucesso. Seu novo saldo é: " + contaPoupanca.getSaldo() + "\n");

			break;

		default:

			System.out.println("\nOpção inválida");

			break;
		}
		if (numContaPoupanca == 0) {

			menuConta();
		}

	}

	// MENU SEGURO
	public static void menuSeguros() {
		int numSeguro;
		String escolha;
		System.out.println("Escolha entre as opções: " + "\n[1] - Ver seguros" + "\n[2] - Seus seguros"
				+ "\n[3] - Desativar seguro");
		numSeguro = input.nextInt();
		switch (numSeguro) {
		case 1:
			  System.out.println("\n*** SEGURO VIAGEM ***"
			            + "\nAdicione o seguro à sua fatura por apenas R$ 50,00 por mês e tenha tranquilidade durante suas viagens"
			            + "\nGostaria de ativar? (S/N): ");
			  	input.nextLine();
			    escolha = input.nextLine();
			    if (escolha.equalsIgnoreCase("S") || escolha.equals("s")) {
			        System.out.println("Digite o ID do cartão que deseja ativar o seguro:");
			        int idCartao = input.nextInt();
			        input.nextLine();
			        SeguroViagemDAO.ativarSeguroViagem(idCartao);
			        SeguroViagemDAO.exibirSeguroViagem();
			    	SeguroFraudeDAO.exibirSeguroFraude();
			    } else if (escolha.equalsIgnoreCase("N") || escolha.equals("n")) {
			        System.out.println("Ok, nos vemos em outra hora!");
			    }
			    break;
		case 2:
			SeguroViagemDAO.exibirSeguroViagem();
			SeguroFraudeDAO.exibirSeguroFraude();
			break;
		case 3:
			System.out.println("Digite o ID do cartão que deseja desativar o seguro:");
			int idCartao = input.nextInt();
			SeguroViagemDAO.desativarSeguroViagem(idCartao);
			break;
		}
	}

}
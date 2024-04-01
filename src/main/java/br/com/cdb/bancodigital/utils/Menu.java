package br.com.cdb.bancodigital.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.enuns.EstadoBrasileiro;
import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;

public class Menu {

	public Menu() {

	}

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
	private ContaCorrente contaC;

//	ContaCorrente contaC = new ContaCorrente();
	ContaPoupanca contaP = new ContaPoupanca();
	ClienteDAO clienteDAO = new ClienteDAO();
	

	public int telaInicial(Scanner input) {
		int opcao = 0;
		while (opcao != 9) {
			try {
				System.out.println("Seja Bem Vindo ao AMAN BANK");
				System.out.println("[1] Login\n" + "[2] Cadastrar\n" + "[9] Sair");
				opcao = input.nextInt();
				input.nextLine();
				if (opcao == 1 || opcao == 2 || opcao == 3) {
					return opcao;
				} else {
					System.out.println("Escolha uma das opções");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
				input.nextLine();
			}
		}
		return opcao;
	}

	public void logar(Scanner input, ContaCorrente contaC, ContaPoupanca contaP) {
		 System.out.print("CPF: ");
		    String cpf = input.nextLine();
		    
		    System.out.print("Senha: ");
		    String senha = input.nextLine();
		    
		    
		    cliente = clienteDAO.loginSenha(cpf, senha);
		    
		    if (cliente == null) {
		        telaInicial(input);
		    } else {
		    	menuLogin(input);
		    }
	        
	}
	
	public void menuLogin(Scanner input) {
		int escolha = 0;
		while(escolha != 9) {
			System.out.println("[1] Depósito"
					+ "[2] Pix"
					+ "[9] Sair");
			escolha = input.nextInt();
			switch (escolha) {
			case 1:
				System.out.print("Valor do Depósito: R$");
				BigDecimal valorDeposito = input.nextBigDecimal();
				contaC = cliente.getContaCorrente();
				contaC.depositar(valorDeposito);
				System.out.println(cliente.toString()); 
				break;
				
			case 2:
				System.out.print("Valor do Pix: R$");
				BigDecimal valorPix = input.nextBigDecimal();
				input.nextLine();
				System.out.print("CPF:");
				String cpfPix = input.nextLine();
				Cliente clienteRecebedor = clienteDAO.pixCpf(cpfPix);
				ContaCorrente Cc = clienteRecebedor.getContaCorrente();
				Cc.depositar(valorPix);
				
				
			}
		}
		
	}

	public boolean menuCadastro(Scanner input) {
	    boolean voltar = inserirNome(input);
	    if (!voltar) {
	        return false;
	    }
	    boolean voltar1 = inserirCpf(input);
	    if (!voltar1) {
	        return false;
	    }
	    maiorIdade = inserirDataNascimento(input);
	    if (!maiorIdade) {
	        return false;
	    }
	    boolean voltar2 = inserirCep(input);
	    if (!voltar2) {
	        return false;
	    }
	    
	    System.out.println("Confirme seus dados:");
	    exibirDados();
	    
	    int confirmar = 0;
	    while (confirmar != 1 && confirmar != 2) {
	        try {
	            System.out.println("Seus dados estão corretos?\n" + "[1] Sim\n" + "[2] Não");
	            confirmar = input.nextInt();
	            input.nextLine();
	            if (confirmar == 2) {
	                System.out.println("Você será redirecionado para o início do cadastro...");
	            
	            } else if (confirmar != 1) {
	                System.out.println("Por favor, selecione uma opção válida.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Por favor, insira apenas números.");
	            input.nextLine();
	        }
	    }

	    return confirmar == 1;
	}

	public int abrirConta(Scanner input) {
		int escolha = 0;
		boolean continuar = true;

		while (continuar) {
			System.out.println("Escolha o tipo de conta que deseja abrir:\n" + "[1] Conta Corrente\n"
					+ "[2] Conta Poupança\n" + "[3] Conta Corrente e Conta Poupança\n" + "[9] Sair");

			try {
				escolha = input.nextInt();
				input.nextLine();

				if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 9) {
					continuar = false; 
				} else {
					System.out.println("Escolha uma das opções");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
				input.nextLine(); 
			}
		}

		return escolha;
	}
//		switch (escolha) {
//		case 1:
//			abrirContaCorrente(cliente, contaPoupanca);
//			System.out.println("Conta Corrente criada com sucesso!\n" + "Número da Conta Corrente: "
//					+ contaCorrente.getNumConta() + "\nNúmero da Agência: " + contaCorrente.getNumAgencia());
//			break;
//
//		case 2:
//			abrirContaPoupanca(cliente, contaCorrente);
//			System.out.println("Conta Poupança criada com sucesso!\n" + "Número da Conta Poupança: "
//					+ contaPoupanca.getNumConta() + "\nNúmero da Agência: " + contaPoupanca.getNumAgencia());
//			break;
//
//		case 3:
//
//			break;
//
//		case 9:
//			// telaInicial(input);
//
//		default:
//			System.out.println("Escolha uma das opções.");
//			abrirConta(input);
//			break;
//		}
//		System.out.println(cliente.toString());

	public ContaCorrente abrirContaCorrente(Cliente cliente, ContaPoupanca contaP) {

		if (contaP == null) {
			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.initNumAgencia();
			contaCorrente.initNumConta();
			cliente.setContaCorrente(contaCorrente);
			return contaCorrente;

		} else {
			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.initNumAgencia();
			contaCorrente.setNumAgencia(contaP.getNumAgencia());
			cliente.setContaCorrente(contaCorrente);
			return contaCorrente;
		}

	}


	@SuppressWarnings("null")
	public ContaPoupanca abrirContaPoupanca(Cliente cliente, ContaCorrente contaC) {

		if (contaC == null) {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			contaPoupanca.initNumAgencia();
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);
			return contaPoupanca;
			

		} else {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			contaPoupanca.setNumAgencia(contaC.getNumAgencia());
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);
			return contaPoupanca;

		}

	}

	public void cadastrarSenha(Scanner input, Cliente cliente) {

		do {
			System.out.println("Crie uma senha (deve conter mais de 8 caracteres, mínimo 1 letra "
					+ "maiúscula, 1 letra minúscula e 1 símbolo especial):");
			senha = input.nextLine();
			senhaValida = validarSenha(senha);
			if (!senhaValida) {
				System.out.println("Senha inválida! Tente novamente.");
			}
		} while (!senhaValida);

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
			System.out.println("Insira seu nome completo:				[9]Sair");
			nome = input.nextLine();
			if (nome.equals("9")) {
				return false;
			} else {
				validar = ClienteValidator.validarNome(nome);

			}
		} while (!validar);
		return true;

	}

	public boolean inserirCpf(Scanner input) {

		do {
			System.out.println("Insira seu CPF (apenas números):			[9]Sair");
			cpf = input.nextLine();
			if (cpf.equals("9")) {
				return false;
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
				return false;

			default:
				System.out.println("Selecione uma das opções.");
				break;

			}
		}
		if (opcao == 9) {
			return false;
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
			try {
				boolean numeroValido = false;
				while (!numeroValido) {
					System.out.println("Insira o número:");
					numero = input.nextInt();
					input.nextLine();
					System.out.println("Insira o complemento (se não houver aperte Enter):");
					complemento = input.nextLine();
					numeroValido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Número inválido. Por favor, insira um número válido.");
				input.nextLine();
				enderecoCorreto(input);
			}
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
	    boolean confirmarLogradouro;
	    boolean confirmarNumero;
	    boolean confirmarBairro;
	    boolean confirmarCidade;
	    boolean confirmarEstado;

	    try {
	        int opcao = 0;
	        while (opcao != 1 && opcao != 2) {
	            do {
	                confirmarLogradouro = inserirLogradouro(input);
	            } while (!confirmarLogradouro);
	            do {
	                confirmarNumero = inserirNumero(input);
	            } while (!confirmarNumero);
	            System.out.println("Insira o complemento (se não houver aperte Enter):");
	            complemento = input.nextLine();
	            do {
	                confirmarBairro = inserirBairro(input);
	            } while (!confirmarBairro);
	            do {
	                confirmarCidade = inserirCidade(input);
	            } while (!confirmarCidade);
	            do {
	                confirmarEstado = inserirEstado(input);
	            } while (!confirmarEstado);
	            cep = "Não informado.";
	            opcao = perguntarSeEnderecoEstaCorreto(input);
	            if (opcao == 2) {
	                System.out.println("Você será redirecionado para o início do cadastro do endereço...");
	                input.nextLine();
	                digitarEndereco(input);
	            }
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Entrada inválida. Por favor, insira um número.");
	        input.nextLine();
	        digitarEndereco(input);
	    }
	}

	private int perguntarSeEnderecoEstaCorreto(Scanner input) {
	    int opcao = 0;
	    boolean opcaoValida = false;

	    while (!opcaoValida) {
	        try {
	            System.out.println("Logradouro: " + logradouro + "\nNúmero: " + numero + "\nBairro: " + bairro
	                    + "\nCidade: " + cidade + "\nEstado: " + estado);
	            System.out.println("O endereço está correto?\n" + "[1] Sim\n" + "[2] Não");
	            opcao = input.nextInt();
	            opcaoValida = opcao == 1 || opcao == 2;
	        } catch (InputMismatchException e) {
	            System.out.println("Entrada inválida. Por favor, insira um número.");
	            input.nextLine();
	        }
	    }
	    
	    return opcao;
	}


	public boolean inserirLogradouro(Scanner input) {
		System.out.println("Insira o logradouro:");
		logradouro = input.nextLine();
		if (logradouro == null | logradouro.isEmpty()) {
			return false;
		} else if (!logradouro.matches("[\\p{L}\\s]{5,}")) {
			System.out.println("Insira um logradouro válido.");
			return false;
		}

		return logradouro.matches("[\\p{L}\\s]{5,}");

	}

	public boolean inserirNumero(Scanner input) {
		boolean numeroValido = false;
		while (!numeroValido) {
			try {
				System.out.println("Insira o número:");
				numero = input.nextInt();
				input.nextLine();
				if (numero > 99999) {
					System.out.println("Digite um número válido");
				} else {
					numeroValido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Insira apenas números.");
				input.nextLine();
			}
		}
		return true;
	}

	public boolean inserirBairro(Scanner input) {
		System.out.println("Insira o bairro:");
		bairro = input.nextLine();
		if (bairro == null | bairro.isEmpty()) {
			return false;
		} else if (!bairro.matches("[\\p{L}\\s]{2,}")) {
			System.out.println("Insira um bairro válido.");
			return false;
		}

		return bairro.matches("[\\p{L}\\s]{2,}");

	}

	public boolean inserirCidade(Scanner input) {
		System.out.println("Insira a cidade:");
		cidade = input.nextLine();
		if (cidade == null | cidade.isEmpty()) {
			return false;
		} else if (!cidade.matches("[\\p{L}\\s]{2,}")) {
			System.out.println("Insira uma cidade válida.");
			return false;
		}

		return cidade.matches("[\\p{L}\\s]{2,}");
	}

	public boolean inserirEstado(Scanner input) {
		System.out.println("Insira o Estado:");
		String estadoDigitado = input.nextLine();

		EstadoBrasileiro estadoEncontrado = null;
		for (EstadoBrasileiro lista : EstadoBrasileiro.values()) {
			if (lista.getDescricao().equalsIgnoreCase(estadoDigitado)
					| lista.getSigla().equalsIgnoreCase(estadoDigitado)) {
				estadoEncontrado = lista;
				break;
			}
		}

		if (estadoEncontrado != null) {
			estado = estadoEncontrado.getSigla();
			return true;
		} else {
			System.out.println("Estado não encontrado.");
			return false;
		}
	}

	public boolean inserirDataNascimento(Scanner input) {

		try {
			System.out.println("Insira sua data de nascimento (formato dd/mm/aaaa):	[9]Sair");
			String data = input.nextLine();
			if (data.equals("9")) {
				return false;
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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = dataNascimento.format(formatter);

		System.out.println("+--------------------------------------+");
		System.out.printf("| Nome: %-30s |\n", nome);
		System.out.printf("| CPF: %-31s |\n", cpf);
		System.out.printf("| Data de Nascimento: %-18s |\n", dataFormatada); // Utiliza a data formatada
		System.out.println("| Endereço:");
		System.out.printf("|   Logradouro: %-24s |\n", logradouro);
		System.out.printf("|   Número: %-29d |\n", numero);
		System.out.printf("|   Complemento: %-21s |\n", complemento);
		System.out.printf("|   Bairro: %-27s |\n", bairro);
		System.out.printf("|   Cidade: %-27s |\n", cidade);
		System.out.printf("|   Estado: %-27s |\n", estado);
		System.out.printf("|   CEP: %-31s |\n", cep);
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

}

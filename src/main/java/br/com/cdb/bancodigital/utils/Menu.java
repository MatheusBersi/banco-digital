package br.com.cdb.bancodigital.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;

	public void menuLogin() {

	}

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
					} else {
						System.out.println("Confirme seus dados:");
						exibirDados();
						System.out.println("Seus dados estão corretos?\n" + "[1] Sim\n" + "[2] Não");
						int confirmar = input.nextInt();
						input.nextLine();
						if (confirmar == 1) {
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

	public void abrirConta(Scanner input) {

		System.out.println("Escolha o tipo de conta de deseja abrir:\n" + "[1] Conta Corrente\n"
				+ "[2] Conta Poupança\n" + "[3] Conta Corrente e Conta Poupança\n" + "[9] Sair");
		int escolha = input.nextInt();

		switch (escolha) {
		case 1:
			abrirContaCorrente(cliente, contaPoupanca);
			System.out.println("Conta Corrente criada com sucesso!\n" + "Número da Conta Corrente: "
					+ contaCorrente.getNumConta() + "\nNúmero da Agência: " + contaCorrente.getNumAgencia());
			break;

		case 2:
			abrirContaPoupanca(cliente, contaCorrente);
			System.out.println("Conta Poupança criada com sucesso!\n" + "Número da Conta Poupança: "
					+ contaPoupanca.getNumConta() + "\nNúmero da Agência: " + contaPoupanca.getNumAgencia());
			break;

		case 3:

			break;

		case 9:
			// telaInicial(input);

		default:
			System.out.println("Escolha uma das opções.");
			abrirConta(input);
			break;
		}
		System.out.println(cliente.toString());
	}

	public void abrirContaCorrente(Cliente cliente, ContaPoupanca contaPoupanca) {

		if (contaPoupanca == null) {
			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.initNumAgencia();
			contaCorrente.initNumConta();
			cliente.setContaCorrente(contaCorrente);

		} else {
			ContaCorrente contaCorrente = new ContaCorrente();
			contaCorrente.initNumAgencia();
			contaCorrente.setNumAgencia(contaPoupanca.getNumAgencia());
			cliente.setContaCorrente(contaCorrente);

		}

	}

	@SuppressWarnings("null")
	public void abrirContaPoupanca(Cliente cliente, ContaCorrente contaCorrente) {

		if (contaCorrente == null) {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			contaPoupanca.setNumAgencia(contaCorrente.getNumAgencia());
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);

		} else {
			ContaPoupanca contaPoupanca = new ContaPoupanca();
			contaPoupanca.initNumAgencia();
			contaPoupanca.initNumConta();
			cliente.setContaPoupanca(contaPoupanca);

		}

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
			input.nextLine();
			System.out.println("Insira o bairro:");
			bairro = input.nextLine();
			System.out.println("Insira a cidade:");
			cidade = input.nextLine();
			System.out.println("Insira o estado:");
			estado = input.nextLine();
			cep = "";
			System.out.println("Logradouro: " + logradouro + "\nNúmero: " + numero + "\nBairro: " + bairro
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
		System.out.println("+--------------------------------------+");
		System.out.printf("| Nome: %-30s |\n", nome);
		System.out.printf("| CPF: %-31s |\n", cpf);
		System.out.printf("| Data de Nascimento: %-18s |\n", dataNascimento);
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

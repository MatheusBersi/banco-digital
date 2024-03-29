package br.com.cdb.bancodigital.utils;

import java.time.LocalDate;
import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.model.Cliente;

public class ClienteValidator {

	private String nome;
	private String cpf;
	private String endRua;
	private int endNum;
	private String endComple;
	private String cidade;
	private String estado;
	private long cep;
	private LocalDate dataNascimento;

	public ClienteValidator() {

	}

	public static boolean validarNome(String nome) {
		if (nome.length() < 2 || nome.length() > 100 || !nome.matches("[a-zA-Z\\s]+")) {
			System.out.println("Nome inválido. Este campo deve conter apenas letras,"
					+ " não insira números ou caracteres especiais.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean validarCpf(String cpf) {
		for (Cliente cliente : ClienteDAO.listaClientes.values()) {
			if (cliente.getCpf().equals(cpf)) {
				System.out.println("CPF já cadastrado");
				return false;
			}
		}
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if (erros.size() > 0) {
			System.out.println("CPF inválido.");
			return false;
		} else {
			return true;
		}

	}

//	public static boolean validarDataNascimento(LocalDate dataNascimento) {

//		if (dataNascimento > data) {
//			return false;
//		} else {
//			return true;
//		}
//
//	}

}

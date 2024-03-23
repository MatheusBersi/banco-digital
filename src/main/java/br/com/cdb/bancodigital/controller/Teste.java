package br.com.cdb.bancodigital.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.model.Cliente;
import br.com.cdb.bancodigital.model.ContaCorrente;
import br.com.cdb.bancodigital.model.ContaPoupanca;
import br.com.cdb.bancodigital.utils.ClienteValidator;
import br.com.cdb.bancodigital.utils.Menu;

public class Teste {

	public static void main(String[] args) {

		ClienteDAO listaCliente = new ClienteDAO();
		
//		Menu.menuCadastro();
		
		
		Cliente cliente = new Cliente("Matheus Bersi", "43787772820", "Rua das Flores, 25", LocalDate.of(1996, 12, 14),
				"COMUM", "senha123");
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
		
		ClienteValidator.validarNome("Matheus");
		ClienteValidator.validarCpf("10640027814");



//		contaCorrente.verSaldo();
//		contaPoupanca.verSaldo();
		
		if(contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0 && contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0 
				|| contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(1000)) >= 0 && contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) < 0) {
			cliente.setTipoConta("SUPER");
		}
		else if(contaCorrente.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0 | contaPoupanca.getSaldo().compareTo(BigDecimal.valueOf(10000)) >= 0) {
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

//incluso HashMap
//incluso alteração de Tipos
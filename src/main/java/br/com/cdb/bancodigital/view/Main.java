package br.com.cdb.bancodigital.view;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cdb.bancodigital.conta.ContaCorrente;
import br.com.cdb.bancodigital.conta.ContaPoupanca;
import br.com.cdb.bancodigital.dao.ClienteDAO;
import br.com.cdb.bancodigital.entity.Cliente;

public class Main {

	public static void main(String[] args) {
		
		ClienteDAO listaCliente = new ClienteDAO();
		Cliente cliente = new Cliente("Matheus Bersi", "58469957420", "Rua das Flores, 25",
				LocalDate.of(1996, 12, 14),	"COMUM", "senha123");
		cliente.init();
		
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		
		contaCorrente.initNumAgencia();
		contaCorrente.initNumConta();
		
		cliente.setContaCorrente(contaCorrente);
		cliente.setContaPoupanca(contaPoupanca);
		
		contaPoupanca.setNumAgencia(contaCorrente.getNumAgencia());
		contaPoupanca.initNumConta();
		
		contaCorrente.depositar(BigDecimal.valueOf(10));
		contaCorrente.depositar(BigDecimal.valueOf(1000));
		
		contaPoupanca.depositar(BigDecimal.valueOf(1000));
		contaPoupanca.render();
		
		listaCliente.addCliente(cliente);	
		
		listaCliente.verCliente();
		

		
	}

}

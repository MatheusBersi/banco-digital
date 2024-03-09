package br.com.cdb.bancodigital.conta;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Conta {
	
	private int numConta = 0;
	private int numAgencia = 0;
	private BigDecimal saldo = BigDecimal.ZERO;
	
	public int initNumConta() {
		Random random = new Random();
		numConta = random.nextInt(10000, 99999);
		return numConta;
	}
	
	public int initNumAgencia() {
		Random random = new Random();
		numAgencia = random.nextInt(1000, 9999);
		return numAgencia;
	}
	
	public void sacar() {
		
	}
	
	public void depositar(BigDecimal valor) {
		this.saldo = saldo.add(valor);
	}
	
	public void pix() {
		
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void imprimirInformacoes(ContaCorrente contaCorrente) {
		System.out.println("+----------------------------------------+");
        System.out.println("| Conta Corrente: ");
        System.out.printf("|  Agência: %-29d |\n", numAgencia);
        System.out.printf("|  Conta: %-31d |\n", numConta);
        System.out.printf("|  Saldo: R$ %-26.2f |\n", saldo);
    }
	
	public void imprimirInformacoes(ContaPoupanca contaPoupanca) {
		System.out.println("+----------------------------------------+");
        System.out.println("| Conta Poupança: ");
        System.out.printf("|  Agência: %-29d |\n", numAgencia);
        System.out.printf("|  Conta: %-31d |\n", numConta);
        System.out.printf("|  Saldo: R$ %-26.2f |\n", saldo);
        
    }
	
	

}

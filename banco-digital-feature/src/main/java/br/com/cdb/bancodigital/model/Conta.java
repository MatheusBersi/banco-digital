package br.com.cdb.bancodigital.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public abstract class Conta {
	
	private double depositar;
	private int numConta = 0;
	private int numAgencia = 0;
	protected BigDecimal saldo = BigDecimal.ZERO;
	
	public int initNumConta() {
		Random random = new Random();
		numConta = random.nextInt(10000, 99999);
		return numConta;
	}
	
	public double getDepositar() {
		return depositar;
	}

	public void setDepositar(double depositar) {
		this.depositar = depositar;
	}

	
	public int initNumAgencia() {
		Random random = new Random();
		numAgencia = random.nextInt(1000, 9999);
		return numAgencia;
	}
	
	public void sacar(BigDecimal valor) {
		this.saldo = saldo.subtract(valor);
	}
	
	public void depositar(BigDecimal valorDeposito) {
		this.saldo = saldo.add(valorDeposito);
	}
	
	public void pix() {
		
	}
		
	public String verSaldo() {
		@SuppressWarnings("deprecation")
		NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String saldoFormatado = formato.format(saldo);
        return saldoFormatado;
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
}

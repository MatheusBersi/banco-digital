package br.com.cdb.bancodigital.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
	
	private BigDecimal taxaMensal = BigDecimal.valueOf(30);
	private String tipoCliente;

	public void cobrarMensalidade() {
		setSaldo(getSaldo().subtract(taxaMensal));
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public void transferir(ContaPoupanca contaPoupanca, BigDecimal valor) {
	    if (this.saldo.compareTo(valor) >= 0) {
	        this.saldo = this.saldo.subtract(valor);
	        contaPoupanca.depositar(valor);
	        System.out.println("Transferência realizada com sucesso." + "\nSaldo atual: "+ getSaldo());
	    } else {
	        System.out.println("Saldo insuficiente para realizar a transferência.");
	    }
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+----------------------------------------+\n");
	    sb.append("|Conta Corrente: \n");
	    sb.append(String.format("|Agência: %-29d |\n", getNumAgencia()));
	    sb.append(String.format("|Conta: %-31d |\n", getNumConta()));
	    sb.append(String.format("|Saldo: R$ %-26.2f |\n", getSaldo()));
	    return sb.toString();
	}
	
	public String infoConta() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+----------------------------------------+\n");
	    sb.append(String.format("|Agência: %-29d |\n", getNumAgencia()));
	    sb.append(String.format("|Conta: %-31d |\n", getNumConta()));
	    sb.append("+----------------------------------------+\n");
	    return sb.toString();
	}

}

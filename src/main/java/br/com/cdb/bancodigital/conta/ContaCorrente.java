package br.com.cdb.bancodigital.conta;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
	
	private BigDecimal taxaMensal = BigDecimal.valueOf(30);
	
	public void cobrarMensalidade() {
		setSaldo(getSaldo().subtract(taxaMensal));
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+----------------------------------------+\n");
	    sb.append("| Conta Corrente: \n");
	    sb.append(String.format("|  Agência: %-29d |\n", getNumAgencia()));
	    sb.append(String.format("|  Conta: %-31d |\n", getNumConta()));
	    sb.append(String.format("|  Saldo: R$ %-26.2f |\n", getSaldo()));
	    return sb.toString();
	}

}

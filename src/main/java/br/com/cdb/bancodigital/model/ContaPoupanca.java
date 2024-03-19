package br.com.cdb.bancodigital.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
	
	private BigDecimal taxaRendimento = BigDecimal.valueOf(0.1115/12);
	
	public void render() {
		setSaldo(getSaldo().multiply(taxaRendimento).add(getSaldo()));
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("+----------------------------------------+\n");
	    sb.append("| Conta Poupança: \n");
	    sb.append(String.format("|  Agência: %-29d |\n", getNumAgencia()));
	    sb.append(String.format("|  Conta: %-31d |\n", getNumConta()));
	    sb.append(String.format("|  Saldo: R$ %-26.2f |\n", getSaldo()));
	    return sb.toString();
	}

}

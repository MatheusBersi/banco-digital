package br.com.cdb.bancodigital.model;

import br.com.cdb.bancodigital.annotations.Autor;

/*
 * 
 * 
 */

@Autor(nome = "Ezau")

public class CartaoCredito extends Cartao {

	protected double limite;
	private double totalGastoNoMes;
    protected boolean contaPremium;
	

	public CartaoCredito(int id, String numero, String bandeira, int cvv, boolean ativo, double limite, boolean contaPremium) {
		super(id, numero, bandeira, cvv, ativo);
		this.limite = limite;
		this.contaPremium = contaPremium;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void adicionarGasto(double valor) {
		this.totalGastoNoMes += valor;
	}

	public double calcularTaxaUtilizacao() {
		if (this.totalGastoNoMes > 0.8 * this.limite) {
			return 0.05 * this.totalGastoNoMes;
		} else {
			return 0.0;
		}
	}
 
	 public void realizarCompra(double valor) {
		    double novoTotal = this.totalGastoNoMes + valor;
		    if (novoTotal > 0.8 * this.limite) {
		        valor += 0.05 * valor;
		        System.out.println("Alerta! Você atingiu 80% do seu limite de crédito." + "\nPróximas compras será cobrado um total de 5% de taxa de utilização!");
		    }
		    if (valor > this.limite) {
		        System.out.println("Compra não autorizada. Limite de crédito excedido.");
		    } else {
		        this.limite -= valor;
		        this.adicionarGasto(valor);
		        System.out.println("\nCompra realizada com sucesso! Seu saldo atual é " + this.limite);
		    }
		}
	 
//   public boolean isContaPremium() {
//   return contaPremium;
//}

//public void setContaPremium(boolean contaPremium) {
//   this.contaPremium = contaPremium;
//}
	
	
	@Override
	public String toString() {
		return "\n\n** Cartão de Credito gerado com sucesso! **\n" + "\nID do Cartão: " + id + "\nNúmero do cartão: "
				+ numero + "\nCódigo de segurança: " + cvv + "\nBandeira: " + bandeira + "\nAtivo: "
				+ (ativo ? "Sim" : "Não");
	}

	public String statusDoCartao() {
		return "\n\n** Status do Cartão de Crédito **\n" + "\nID do Cartão: " + id + "\nNúmero do cartão: " + numero
				+ "\nBandeira: " + bandeira + "\nAtivo: " + (ativo ? "Sim" : "Não");
	}
}

package br.com.cdb.bancodigital.dtos;

public class SeguroViagemDTO {
    private  boolean seguroViagem;
    private double valorSeguroViagem;
    private static boolean seguroViagemAtivo;
	private static boolean contaPremium;

    public  boolean isSeguroViagem() {
        return seguroViagem;
    }
    
    public boolean getSeguroViagem() {
        return seguroViagem;
    }

    public void setSeguroViagem(boolean seguroViagem) {
        this.seguroViagem = seguroViagem;
    }

    public double getValorSeguroViagem() {
        return valorSeguroViagem;
    }

    public void setValorSeguroViagem(double valorSeguroViagem) {
        this.valorSeguroViagem = valorSeguroViagem;
    }

    public static boolean isSeguroViagemAtivo() {
        return seguroViagemAtivo;
    }

    public static void setSeguroViagemAtivo(boolean seguroViagemAtivo) {
        SeguroViagemDTO.seguroViagemAtivo = seguroViagemAtivo;
    }
    
    public static void ativarSeguroViagem() {
		if (contaPremium) {
			SeguroViagemDTO.seguroViagemAtivo = true;
			System.out.println("\nSeguro de viagem ativado gratuitamente para conta premium.");
		} else {
			SeguroViagemDTO.seguroViagemAtivo = true;
		}
	}
    
    public static void desativarSeguroViagem() {
		SeguroViagemDTO.seguroViagemAtivo = false;
	}
    
	public void aplicarRegrasSeguro(String tipoCliente) {
		switch (tipoCliente) {
		case "Conta Premium":
			this.seguroViagem = true;
			this.valorSeguroViagem = 0.0;
			break;
		case "Conta Comum":
		case "Conta Super":
			this.seguroViagem = false;
			this.valorSeguroViagem = 50.0;
			break;
		default:
			throw new IllegalArgumentException("Tipo de cliente desconhecido: " + tipoCliente);
		}
	}

}

package br.com.cdb.bancodigital.dtos;

public class SeguroFraudeDTO {
	
	private double valorSeguroFraude;
	protected static boolean seguroFraudeAtivo = true;
	
	
	public double getValorSeguroFraude() {
		return valorSeguroFraude;
	}
	
	public void setValorSeguroFraude(double valorSeguroFraude) {
		this.valorSeguroFraude = valorSeguroFraude;
	}
	
	public void aplicarRegrasSeguro(String tipoCliente) {
		this.valorSeguroFraude = 5000.0;
	}

	public static boolean isSeguroFraudeAtivo() {
		return seguroFraudeAtivo;
	}

	public static void setSeguroFraudeAtivo(boolean seguroFraudeAtivo) {
		SeguroFraudeDTO.seguroFraudeAtivo = seguroFraudeAtivo;
	}

}

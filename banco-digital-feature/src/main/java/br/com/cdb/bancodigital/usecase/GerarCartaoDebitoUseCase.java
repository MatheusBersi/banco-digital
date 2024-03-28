package br.com.cdb.bancodigital.usecase;

import java.util.Random;

import br.com.cdb.bancodigital.annotations.Autor;
import br.com.cdb.bancodigital.enuns.Bandeira;
import br.com.cdb.bancodigital.model.CartaoDebito;

/*
 * 
 * 
 */

@Autor (nome = "Ezau")

public class GerarCartaoDebitoUseCase extends CartaoDebito {

	public GerarCartaoDebitoUseCase(int id, String numero, String bandeira, int cvv, boolean ativo) {
		super(id, numero, bandeira, cvv, ativo);
	}
	
	private static final Random random = new Random();
	@Override
	public String getNumero() {
	    if (numero == null) {
	      int[] numeros = new int[4];

	      for (int i = 0; i < numeros.length; i++) {
	        numeros[i] = random.nextInt(10000);
	        while (numeros[i] < 1000) {
	          numeros[i] = random.nextInt(10000);
	        }

	        if (numeros[i] <= 1000) {
	          numeros[i] += 9999;
	        }
	      }

	      StringBuilder numeroFormatado = new StringBuilder();
	      for (int i = 0; i < numeros.length; i++) {
	        numeroFormatado.append(numeros[i]);
	        if (i < numeros.length - 1) {
	          numeroFormatado.append(" ");
	        }
	      }
	      this.numero = numeroFormatado.toString();
	    }
	    return numero;
	  }
	
	public int getCvv() {
		cvv = random.nextInt(999);
		if(cvv < 100) {
			cvv += random.nextInt(999);
		}
		return cvv;
	}
	public String gerarBandeira() {
		  Bandeira bandeira = Bandeira.gerarBandeiraAleatoria();
		  return bandeira.name().toLowerCase();
		}

}

package br.com.cdb.bancodigital.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class CepConsulta {

	private static String logradouro;
	private static String bairro;
	private static String cidade;
	private static String estado;
	private static String cep;

	public static boolean consultarCep() {
		try {
	
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite o CEP: ");
			cep = reader.readLine().trim();

			String urlStr = "https://viacep.com.br/ws/" + cep + "/json/";
			@SuppressWarnings("deprecation")
			URL url = new URL(urlStr);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Falha ao acessar o serviço: " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder response = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				response.append(output);
			}

			JSONObject json = new JSONObject(response.toString());
			logradouro = json.getString("logradouro");
			bairro = json.getString("bairro");
			cidade = json.getString("localidade");
			estado = json.getString("uf");
			cep = json.getString("cep");
			
			System.out.println("Logradouro: " + logradouro);
			System.out.println("Bairro: " + bairro);
			System.out.println("Cidade: " + cidade);
			System.out.println("Estado: " + estado);

			conn.disconnect();
			br.close();
			return true;
		} catch (Exception e) {
			System.out.println("CEP inválido.");
			return false;
		}

	}

	public static String getLogradouro() {
		return logradouro;
	}

	public static String getBairro() {
		return bairro;
	}

	public static String getCidade() {
		return cidade;
	}

	public static String getEstado() {
		return estado;
	}
	
	public static String getCep() {
		return cep;
	}

}

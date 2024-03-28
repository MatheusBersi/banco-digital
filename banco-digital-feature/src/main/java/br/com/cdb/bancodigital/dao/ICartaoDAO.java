package br.com.cdb.bancodigital.dao;
import java.util.ArrayList;
import java.util.List;
import br.com.cdb.bancodigital.annotations.Autor;
import br.com.cdb.bancodigital.model.CartaoCredito;
import br.com.cdb.bancodigital.model.CartaoDebito;

/*
 * 
 * 
 */

@Autor (nome = "Ezau")

public interface ICartaoDAO {
	
	public static final List<CartaoCredito> cartaoCredito = new ArrayList<>();
	public static final List<CartaoDebito> cartaoDebito = new ArrayList<>();

	
	
	public void gerarCartao();
	public void verCartoesSalvos();
	public void ativarCartao(int idCartao);
	public void desativarCartao(int idCartao);
	
}
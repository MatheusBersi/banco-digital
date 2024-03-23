package br.com.cdb.bancodigital.controller;

import java.util.Scanner;

import br.com.cdb.bancodigital.dao.CartaoCreditoDAO;
import br.com.cdb.bancodigital.dao.CartaoDebitoDAO;

//import br.com.cdb.bancodigital.utils.ClienteValidator;

/*
 * Main de teste usado pelo Ezaú para testar os códigos do cartão!
 */

public class Main {

	public static void main(String[] args) {
		
Scanner input = new Scanner(System.in);
		
		CartaoCreditoDAO cartaoCreditoDao = new CartaoCreditoDAO();
		CartaoDebitoDAO cartaoDebitoDao = new CartaoDebitoDAO();
		
		String conf;
		
			
		
		    do {
		    	try {
				System.out.println("Digite uma opção:" + "\n1 - Gerar cartao" + "\n2 - ativar cartão" 
				+ "\n3 - desativar cartao" + "\n4 - status dos cartões");
				int escolha = input.nextInt();
				
		
				if(escolha == 1) {
					if( escolha == 1) {
						System.out.println("1 - Gerar crédito?" + "\n2 - Gerar Debito?");
						escolha = input.nextInt();
					}if(escolha == 1) {
						cartaoCreditoDao.gerarCartao();
					}else if(escolha == 2){
						cartaoDebitoDao.gerarCartao();
					}
					
				}else if(escolha == 2) {
					
					System.out.println("Digite o ID do cartão que deseja ativar:");
					int idCartao = input.nextInt();
					cartaoCreditoDao.ativarCartao(idCartao);
					cartaoDebitoDao.ativarCartao(idCartao);
					
				}else if(escolha == 3) {
					
					System.out.println("Digite o ID do cartão que deseja desativar:");
					int idCartao = input.nextInt();
					cartaoCreditoDao.desativarCartao(idCartao);
					cartaoDebitoDao.desativarCartao(idCartao);
					
				}else if(escolha == 4) {
					
					cartaoCreditoDao.verCartoesSalvos();
					cartaoDebitoDao.verCartoesSalvos();
				}else {
					
					System.out.println("Opção inválida!");
				}
			
	 
		    	}catch(Exception InputMismatchException) {
		    		
					System.out.println("Erro, coloque um número ao invés de uma letra");
					
				}
		    	
		    	input.nextLine();
				System.out.println("concuido? (S/N): ");
				 conf  = input.nextLine();
				 
			}while (!conf.equals("s"));
			
			System.out.println("Obrigado!");
		
		
	}
}

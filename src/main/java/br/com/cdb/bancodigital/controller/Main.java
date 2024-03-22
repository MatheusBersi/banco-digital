package br.com.cdb.bancodigital.controller;

<<<<<<< HEAD
import br.com.cdb.bancodigital.utils.Menu;
=======
import java.util.Scanner;

import br.com.cdb.bancodigital.dao.CartaoDAO;

//import br.com.cdb.bancodigital.utils.ClienteValidator;
>>>>>>> a716dc9 (Cartão de credito criado)

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD

		Menu menu = new Menu();
		
		menu.menuCadastro();
		

		

	}

}

=======
		
		Scanner input = new Scanner(System.in);
		
		CartaoDAO gerar = new CartaoDAO();
		
		String conf;
		
			
		
		    do {
		    	try {
				System.out.println("Digite uma opção:" + "\n1 - Gerar cartao" + "\n2 - ativar cartão" 
				+ "\n3 - desativar cartao" + "\n4 - status do cartao");
				int escolha = input.nextInt();
				
		
				if(escolha == 1) {
					
					gerar.gerarEVerCartao();
					
				}else if(escolha == 2) {
					
					System.out.println("Digite o ID do cartão que deseja ativar:");
					int idCartao = input.nextInt();
					gerar.ativarCartao(idCartao);
					
				}else if(escolha == 3) {
					
					System.out.println("Digite o ID do cartão que deseja desativar:");
					int idCartao = input.nextInt();
					gerar.desativarCartao(idCartao);
					
				}else if(escolha == 4) {
					
					gerar.verCartoesSalvos();
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
>>>>>>> a716dc9 (Cartão de credito criado)

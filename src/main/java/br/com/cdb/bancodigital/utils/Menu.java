package br.com.cdb.bancodigital.utils;

import java.util.Scanner;

<<<<<<< HEAD
public class Menu {
	
=======

import br.com.cdb.bancodigital.model.Cartao;

public class Menu {
	
	
	
>>>>>>> a716dc9 (Cartão de credito criado)
	public Menu() {
		
	}
	
<<<<<<< HEAD
		static Scanner input = new Scanner(System.in);
		
		public static void menuCadastro() {
			System.out.println("Insira seu nome completo:");
			String nome = input.nextLine();
			
=======
		Scanner input = new Scanner(System.in);
		
		public void menuCadastro() {
			System.out.println("Escolha uma opção: " + "\n1 - gerar cartão" + "\n2 - Ver cartão.");
			int escolha = input.nextInt();
			if ( escolha == 1 ) {
				System.out.println("...");
			}else if(escolha == 2) {
		
			}
>>>>>>> a716dc9 (Cartão de credito criado)
		}
	

}

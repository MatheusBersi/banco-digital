package br.com.cdb.bancodigital.controller;

import java.util.Scanner;

import br.com.cdb.bancodigital.utils.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Menu menu = new Menu();
		
		while (true) {
			System.out.println("\n *** SEJA BEM-VINDO AO AMAN BANK, SEU BANCO DIGITAL ***\n" + "\n- Abra sua conta no Aman e comece a aproveitar as vantagens de um banco digital completo!\n" + 
							   "Podemos prosseguir com seu cadastro? (S/N):");
			String inicio = input.nextLine();
			if (inicio.equals("s") || inicio.equals("S")) {
				menu.menuCadastro(input);
			}else {
				System.out.println("Sem problemas! O Aman Bank estará aqui quando você estiver pronto para aproveitar as vantagens de um banco digital completo");
				break;
			}
				menu.abrirConta(input);
				Menu.menuConta();
				break;
			}

		}

	}


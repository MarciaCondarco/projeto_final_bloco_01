package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	public static void main(String[] args) {
	
		int opcao;
		
		while(true) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND +"*****************************************");
			System.out.println("	Loja de Roupa Devas		 ");
			System.out.println(Cores.TEXT_GREEN + "*****************************************");
			System.out.println("                          		 ");
			System.out.println(Cores.TEXT_CYAN + "	1 - Adicionar novos dados roupa 	 ");
			System.out.println(Cores.TEXT_CYAN + "	2 - Listar todas as roupas		 ");
			System.out.println(Cores.TEXT_CYAN + "	3 - Buscar roupa por genero 	 	 ");
			System.out.println(Cores.TEXT_CYAN + "	4 - Atualizar dados das roupas 	 ");
			System.out.println(Cores.TEXT_CYAN + "	5 - Apagar dados das roupas		 ");
			System.out.println(Cores.TEXT_CYAN + "	0 - Sair	 		 	 ");
			System.out.println(Cores.TEXT_CYAN + "                          		 ");
			System.out.println(Cores.TEXT_GREEN + "*****************************************"  + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + "Entre com a opção desejada: ");
			System.out.println("										");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("digite um numero entre 0 e 5");
				leia.nextLine();
			}
			
			if(opcao == 0) {
				System.out.println("\nObrigada pela preferência, volte sempre!!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch(opcao) {
				case 1:
					System.out.println("Adicionar novos dados roupa\n\n");
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as roupas \n\n");
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da roupa - por genero - masculino | feminino\n\n");
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar os dados da roupa\n\n");
					keyPress();
					break;
				case 5:
					System.out.println("Apagar dados da roupa\n\n");
					keyPress();
					break;
				default:
					System.out.println("\nOpção invalida\n");
					keyPress();
					break;
				
			}
			
		}

	}
	public static void sobre() {
		System.out.println("*****************************************");
		System.out.println("Projeto Desenvolvido por:");
		System.out.println("Marcia Condarco");
		System.out.println("https://github.com/MarciaCondarco");
		System.out.println("*****************************************");
	}
	public static void keyPress() {
		System.out.println(Cores.TEXT_GREEN + "\nPressione enter para continuar ...");
		leia.nextLine();
	}

	}


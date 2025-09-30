package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.RoupaController;
import projeto_final_bloco_01.model.Roupa;
import projeto_final_bloco_01.model.RoupaInfantil;
import projeto_final_bloco_01.model.RoupaParaAdulto;
import projeto_final_bloco_01.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final RoupaController roupaController = new RoupaController();
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
					System.out.println("Adicionar novos dados roupa \n\n");	
					cadastrarroupa();
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as roupas \n\n");
					listarroupas();
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da roupa \n\n");
					procurarRoupaPorNumero();
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar os dados da roupa \n\n");
					atualizarRoupa();
					keyPress();
					break;
				case 5:
					System.out.println("Apagar dados da roupa \n\n");
					deletarConta();
					keyPress();
					break;
				default:
					System.out.println("\nOpção invalida\n");
					keyPress();
					break;
				
			}
			
			
		}

	}
	public static void sobre
	() {
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
	
	private static void listarroupas() {
		//executa os metodos de lista da controladora
		roupaController.listarTodas();
	}
	private static void cadastrarroupa() {
		
		System.out.print("Qual nome da peça:  ");
		String nome  = leia.nextLine();
		
		System.out.print("Digite o genero 1 - adulto | 2 - Infantil   ");
		int genero = leia.nextInt();
		
		System.out.print("Digite a faixa etaria: ");
		int etaria = leia.nextInt();
			if(genero == 2 && etaria>=12) {
				System.out.println("opa!!! a idade informada não é mais infantil");
				return;
			}
		
		System.out.print("Digite o preco: ");
		float preco = leia.nextFloat();
		

		
		switch(genero) {
		case 1 -> {
			
			System.out.print("Qual estilo?  ");
			leia.skip("\\R");
			String estilo  = leia.nextLine();
			roupaController.cadastrar(new RoupaParaAdulto(roupaController.gerarNumero(), nome, genero, etaria,  preco, estilo));
			//chamando o metodo cadastrar, cria o objeto roupacorrente que os parametros
		}
		case 2 -> {
			System.out.print("Qual personagem: ");
			leia.skip("\\R");
			String personagem = leia.nextLine();
			roupaController.cadastrar(new RoupaInfantil(roupaController.gerarNumero(), nome, genero, etaria,  preco, personagem));
			
			
		}
		default -> System.out.println("Tipo de roupa inválida!");
		}

	}
	private static void deletarConta() {
		System.out.print("Digite o numero da roupa: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		//criando o objeto da classe conta
		Roupa roupa = roupaController.buscarNaCollection(numero);
		if(roupa != null)
		{
			System.out.print("\nTem certeza que deseja excluir esta roupa? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("s")) {
				roupaController.deletar(numero);
			}
			else {
				System.out.println("\nOperação cancelada!");
			}
		}else {
			System.out.printf("\na roupa %d não foi encontrada", numero);
		}
	}
	private static void atualizarRoupa() {
		//pedir para digitar o numero 
		
		System.out.print("Digite o numero de cadastro da roupa: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		//criando o objeto da classe conta
		Roupa roupa = roupaController.buscarNaCollection(numero);
			if(roupa != null) {
			
			String nome = roupa.getNome();
			int genero = roupa.getGenero();
			int etaria = roupa.getEtaria();
			float preco= roupa.getPreco();

			System.out.printf("Qual nome da peça?: ", nome);
			String entrada = leia.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;
			// ? -> if operador ternario
			//converter string para inteiro -> converção de dados
	
			System.out.printf("Digite a faixa etaria: ", etaria);
			entrada = leia.nextLine();
			etaria = entrada.isEmpty() ? etaria : Integer.parseInt(entrada);
			
			System.out.printf("Digite o preco: ", preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));//subtitui a virgula por ponto antes de converter para float
			
			switch(genero) {
			case 1 -> {
				//RoupaParaAdulto é uma herança de conta
				String estilo = ((RoupaParaAdulto)roupa).getEstilo();//casting -> transforma o objeto
				System.out.printf("qual novo estilo para a roupa?  ", estilo);
				entrada = leia.nextLine();
				estilo = entrada.isEmpty() ? estilo : entrada;
				roupaController.atualizar(new RoupaParaAdulto(numero, nome, genero, etaria, preco, estilo));
				//chamando o metodo atualizar, cria o objeto RoupaParaAdulto que os parametros
			}
			case 2 -> {
				String personagem = ((RoupaInfantil)roupa).getPersonagem();
				System.out.printf("qual personagem vai ser baseado a roupa: ", personagem);
				entrada = leia.nextLine();
				personagem = entrada.isEmpty() ? personagem : entrada;
				roupaController.atualizar(new RoupaInfantil(numero, nome, genero,  etaria,  preco, personagem));
				
				
			}
			default -> System.out.println("Tipo de roupa inválida!");
			}
		}else {
			System.out.printf("\sua roupa %d não foi encontrada", numero);
		}
	}
	private static void procurarRoupaPorNumero() {
		System.out.print("Digite o numero da roupa: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		roupaController.procurarPorNumero(numero);
	}

}


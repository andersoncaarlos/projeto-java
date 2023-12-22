package aplicativo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entidades.Acessorio;
import entidades.Iphone;
import produto.controller.ProdutoController;
import utilidades.Cores;

public class Menu {

	static int senhaDeAcesso = 0000;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int opcao, tipo, quantidade;
		String nome, cor;
		double preco;

		ProdutoController produtos = new ProdutoController();

		while (true) {
			System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND
					+ "-------------------------------------------------------------------");
			System.out.println("                                                                   ");
			System.out.println("\t\tSWELL STORE - Venda de iPhones e Acessórios Apple  ");
			System.out.println("                                                                   ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("\t\tEntrar Como Vendedor ou Cliente?                   ");
			System.out.println("\t\t1 - Vendedor | 2 - Cliente  | 3 - Sair             ");
			System.out
					.println("                                                                   " + Cores.TEXT_RESET);

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 3) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nSWELL STORE - VOLTE SEMPRE! ");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {
				System.out.print("Digite a senha de acesso: ");
				int senha = sc.nextInt();
				
				while (senha != senhaDeAcesso) {
					System.out.println("Senha incorreta, tente novamente! ");
					senha = sc.nextInt();
				}
				
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMenu de Opções - Vendedor");
				System.out.println("\n1 - Adicionar Produto ao Estoque");
				System.out.println("2 - Listar Todos os Produtos");
				System.out.println("3 - Remover Produto do Estoque");
				System.out.println("4 - Atualizar Preço de Produto no Estoque" + Cores.TEXT_RESET);
				System.out.print("\nDigite a opção desejada: ");
				opcao = sc.nextInt();

				switch (opcao) {
				case 1 -> {
					do {
						System.out.print("\nDigite o tipo do Produto (1- iPhone ou 2- Acessório)?: ");
						tipo = sc.nextInt();
					} while (tipo < 1 && tipo > 2);
					sc.nextLine();
					System.out.println("Digite o nome do produto: ");
					nome = sc.nextLine();
					System.out.println("Digite a cor do produto: ");
					cor = sc.nextLine();
					System.out.println("Digite o preço do produto: ");
					preco = sc.nextDouble();
					System.out.println("Digite a quantidade: ");
					quantidade = sc.nextInt();

					if (tipo == 1) {
						System.out.println("Digite a capacidade de armazenamento: ");
						int gb = sc.nextInt();
						produtos.adicionarProduto(
								new Iphone(tipo, produtos.geradorId(), nome, cor, preco, quantidade, gb));
					} else {
						produtos.adicionarProduto(
								new Acessorio(tipo, produtos.geradorId(), nome, cor, preco, quantidade));
					}
				}
				case 2 -> {
					System.out.println("\nProdutos disponíveis no estoque: \n");
					produtos.listarProdutos();
				}
				
				
				}
			}
			case 2 -> {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMenu de Opções - Cliente");
				System.out.println("\n1 - Consultar Produtos e Preços");
				System.out.println("2 - Comprar Produto");
			}
			}			
		}
	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Anderson Silva");
		System.out.println("E-COMMERCE LOJA SWELL STORE");
		System.out.println("https://github.com/andersoncaarlos/projeto-java");
		System.out.println("***********************************************************");

	}

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}

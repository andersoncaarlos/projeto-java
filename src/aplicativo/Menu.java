package aplicativo;

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
		String nome;
		double preco;

		ProdutoController produtos = new ProdutoController();

		// Teste de produtos
		Iphone p1 = new Iphone(1, produtos.geradorId(), "iPhone XR", 1700, 5, 64);
		produtos.criarProduto(p1);
		Iphone p2 = new Iphone(2, produtos.geradorId(), "iPhone 11", 1980, 5, 128);
		produtos.criarProduto(p2);
		Iphone p3 = new Iphone(3, produtos.geradorId(), "iPhone 12 Pro Max", 3500, 10, 256);
		produtos.criarProduto(p3);
		Acessorio p4 = new Acessorio(4, produtos.geradorId(), "AirPods", 900, 10);
		produtos.criarProduto(p4);
		Acessorio p5 = new Acessorio(5, produtos.geradorId(), "Apple Watch SE 44mm", 1800, 7);
		produtos.criarProduto(p5);

		System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND
				+ "-------------------------------------------------------------------");
		System.out.println("                                                                   ");
		System.out.println("\t\tSWELL STORE - Venda de iPhones e Acessórios Apple  ");
		System.out.println("                                                                   ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\tEntrar Como Vendedor ou Cliente?                   ");
		System.out.println("\t\t1 - Vendedor | 2 - Cliente  | 3 - Sair             ");
		System.out.println("                                                                   " + Cores.TEXT_RESET);

		try {
			opcao = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nDigite valores inteiros!");
			sc.nextLine();
			opcao = 0;
		}

		if (opcao == 3) {
			System.out.println(Cores.TEXT_WHITE_BOLD + "\nSWELL STORE AGREDECE A VISITA - VOLTE SEMPRE! ");
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
			while (true) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMenu de Opções - Vendedor");
				System.out.println("\n1 - Adicionar Produto ao Estoque");
				System.out.println("2 - Listar Todos os Produtos");
				System.out.println("3 - Remover Produto do Estoque");
				System.out.println("4 - Atualizar Preço de Produto no Estoque");
				System.out.println("5 - Sair " + Cores.TEXT_RESET);
				System.out.print("\nDigite a opção desejada: ");
				opcao = sc.nextInt();

				switch (opcao) {
				case 1 -> {
					System.out.println("Produto já existe no estoque? (1 - Sim | 2 - Não)");
					int op = sc.nextInt();

					if (op == 1) {
						produtos.listarProdutos();
						System.out.print(Cores.TEXT_RESET + "\nDigite o ID do produto: ");
						int idProduto = sc.nextInt();
						System.out.print("\nDigite a quantidade de produtos que vão ser acrescentado ao estoque: ");
						int qntd = sc.nextInt();
						produtos.acrescentarProduto(idProduto, qntd);
					} 
					else {
						do {
							System.out.println("\nDigite o tipo do Produto (1- iPhone ou 2- Acessório)?: ");
							tipo = sc.nextInt();
						} while (tipo < 1 && tipo > 2);
						sc.nextLine();
						System.out.println("Digite o nome do produto: ");
						nome = sc.nextLine();
						System.out.println("Digite o preço do produto: ");
						preco = sc.nextDouble();
						System.out.println("Digite a quantidade: ");
						quantidade = sc.nextInt();

						if (tipo == 1) {
							System.out.println("Digite a capacidade de armazenamento: ");
							int gb = sc.nextInt();
							produtos.criarProduto(new Iphone(tipo, produtos.geradorId(), nome, preco, quantidade, gb));
						} else {
							produtos.criarProduto(new Acessorio(tipo, produtos.geradorId(), nome, preco, quantidade));
						}
					}
				}
				case 2 -> {
					System.out.println("\nProdutos disponíveis no estoque: \n");
					produtos.listarProdutos();
				}
				case 3 -> {
					System.out.print("Digite o ID do produto a ser removido: ");
					int apagarProduto = sc.nextInt();
					produtos.removerProduto(apagarProduto);
				}
				case 4 -> {
					System.out.print("Digite o ID do produto a ser alterado o preço: ");
					int id = sc.nextInt();
					System.out.println("Digite o novo valor: ");
					double valor = sc.nextDouble();
					produtos.atualizarPreco(id, valor);
				}
				case 5 -> {
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nPrograma Finalizado com Sucesso!");
					sobre();
					sc.close();
					System.exit(0);
				}
				}
			}
		}
		case 2 -> {
			while (true) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMenu de Opções - Cliente");
				System.out.println("\n1 - Consultar Produtos e Preços");
				System.out.println("2 - Comprar Produto");
				System.out.println("3 - Sair" + Cores.TEXT_RESET);
				System.out.print("\nDigite a opção desejada: ");
				opcao = sc.nextInt();

				switch (opcao) {
				case 1 -> {
					System.out.println(Cores.TEXT_YELLOW_BOLD + "\nProdutos:\n");
					produtos.listarProdutos();
				}
				case 2 -> {
					System.out.println("Selecione o ID do produto desejado: ");
					int compra = sc.nextInt();
					produtos.comprarProduto(compra);
				}
				case 3 -> {
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nSiga nosso instagram: @swellstore.sp \n"
							+ "SWELL STORE AGRADECE A VISITA - VOLTE SEMPRE!");
					sobre();
					sc.close();
					System.exit(0);
				}
				}
			}
		}
		}
	}

	private static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Anderson Silva");
		System.out.println("E-COMMERCE LOJA SWELL STORE - VENDA DE IPHONES E ACESSÓRIOS APPLE");
		System.out.println("https://github.com/andersoncaarlos/projeto-java");
		System.out.println("***********************************************************");

	}


}

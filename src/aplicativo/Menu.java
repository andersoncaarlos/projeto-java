package aplicativo;

import java.util.Locale;
import java.util.Scanner;

import utilidades.Cores;



public class Menu {
	
	static int senhaDeAcesso = 0000;
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println(Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND
				         + "-------------------------------------------------------");
		System.out.println("                                                       ");
		System.out.println("\t\tSWELL STORE - Venda de iPhones e Acessórios Apple  ");
		System.out.println("                                                       ");
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\tEntrar Como Vendedor ou Cliente?       ");
		System.out.println("\t\t1 - Vendedor | 2 - Cliente             " );
		System.out.println("                                                       " + Cores.TEXT_RESET);
		int opcao = sc.nextInt();
		
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
				System.out.println("2 - Remover Produto do Estoque");
				System.out.println("3 - Atualizar Preço de Produto no Estoque" + Cores.TEXT_RESET);
				System.out.print("\nDigite a opção desejada: ");
				opcao = sc.nextInt();
			}
			case 2 -> {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMenu de Opções - Cliente");
				System.out.println("\n1 - Consultar Produtos e Preços");
				System.out.println("2 - Comprar Produto");		
			}
		}
		
		
		
		sc.close();
	}

}

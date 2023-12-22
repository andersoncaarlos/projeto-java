package produto.controller;

import produto.repository.ProdutoRepository;
import utilidades.Cores;

import java.util.ArrayList;
import entidades.Produto;

public class ProdutoController implements ProdutoRepository {
	
	ArrayList<Produto> produtos = new ArrayList<>();
	int id = 0;
	
	
	@Override
	public void criarProduto(Produto produto) {
		produtos.add(produto);
		System.out.println("Produto adicionado ao estoque!");		
	}

	@Override
	public void listarProdutos() {
		for (Produto item : produtos) {
			System.out.println(item);
		}
		
	}

	@Override
	public void removerProduto(int id) {
		var produto = buscarNoEstoque(id);
		
		if (produto != null) {
			if (produtos.remove(produto) == true) {
				System.out.println("\nO produto ID: " + id + " foi removido do estoque!");
			}
		}
		else {
			System.out.println("\nO produto de ID: " + id + " não foi encontrado!");
		}
		
	}
	@Override
	public void atualizarPreco(int id, double preco) {
		for (Produto item : produtos) {
			if (id == item.getId()) {
				item.setPreco(preco);
			}
		}
		
	}
	
	@Override
	public void acrescentarProduto(int id, int quantidade) {
		for (Produto item : produtos) {
			if (id == item.getId()) {
				item.setQuantidade(item.getQuantidade() + quantidade);
			}
		}
		System.out.println("Produtos adicionados ao estoque!");		
	}

	@Override
	public void comprarProduto(int id) {
		var produto = buscarNoEstoque(id);
		
		if (produto != null) {
			produto.setQuantidade(produto.getQuantidade() - 1);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Compra efetuada com sucesso, acompanhe o andamento do seu pedido por e-mail!" + Cores.TEXT_RESET);		
		}		
		else {
			System.out.println("\nO produto de ID: " + id + " não foi encontrado!");
		}
	}
	
	public int geradorId() {
		return ++ id;
	}
	
	public Produto buscarNoEstoque (int numero) {
		for (var produto : produtos) {
			if (produto.getId() == numero) {
				return produto;
			}
		}
		return null;
	}
}

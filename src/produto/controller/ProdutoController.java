package produto.controller;

import produto.repository.ProdutoRepository;
import java.util.ArrayList;
import entidades.Produto;

public class ProdutoController implements ProdutoRepository {
	
	ArrayList<Produto> produtos = new ArrayList<>();
	int id = 0;
	
	
	@Override
	public void adicionarProduto(Produto produto) {
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
		for (Produto item : produtos) {
			if (id == item.getId()) {
				produtos.remove(id);
			}
			else {
				System.out.println("Produto não encontrado!");
			}
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
	public void comprarProduto(int id) {
		for (Produto item : produtos) {
			if (id == item.getId()) {
				item.setQuantidade(-1);
			}
		}
		System.out.println("Compra efetuada com sucesso, acompanhe o andamento do seu pedido por e-mail!");		
	}
	
	public int geradorId() {
		return ++ id;
	}
}

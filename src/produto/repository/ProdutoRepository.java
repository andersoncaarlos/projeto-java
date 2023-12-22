package produto.repository;

import entidades.Produto;

public interface ProdutoRepository {
	
	public void adicionarProduto(Produto produto);
	public void listarProdutos();
	public void removerProduto(int id);
	public void atualizarPreco(int id, double preco);
	
	public void comprarProduto(int id);
	
}

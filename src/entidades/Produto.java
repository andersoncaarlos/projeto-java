package entidades;

import utilidades.Cores;

public abstract class Produto {
	
	private int tipo;
	private int id;
	private String nome;
	private double preco;
	private int quantidade;
	
	
	public Produto(int tipo, int id, String nome, double preco, int quantidade) {
		this.tipo = tipo;
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	
	public int setId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return Cores.TEXT_CYAN_BOLD + "ID: "+ id + " | Nome: " + nome + " | Preço: " + preco + " | Quantidade: " + quantidade;
	}
	
	public void adicionarProduto(Produto produto) {
		
	}
	
	
	
}

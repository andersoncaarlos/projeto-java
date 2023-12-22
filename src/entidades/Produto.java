package entidades;

public abstract class Produto {
	
	private String nome;
	private String cor;
	private double preco;
	
	public Produto(String nome, String cor, double preco) {
		this.nome = nome;
		this.cor = cor;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
	
}

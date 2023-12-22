package entidades;

public abstract class Produto {
	
	private int tipo;
	private int id;
	private String nome;
	private String cor;
	private double preco;
	private int quantidade;
	
	
	public Produto(int tipo, int id, String nome, String cor, double preco, int quantidade) {
		this.tipo = tipo;
		this.id = id;
		this.nome = nome;
		this.cor = cor;
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
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto: Nome = " + nome + ", Cor = " + cor + ", Preço = " + preco;
	}
	
	public void adicionarProduto(Produto produto) {
		
	}
	
	
	
}

package entidades;

import utilidades.Cores;

public class Iphone extends Produto {

	private int gb;
	
	public Iphone(int tipo, int id, String nome, double preco, int quantidade, int gb) {
		super(tipo, id, nome, preco, quantidade);
		this.gb = gb;
	}

	public int getGb() {
		return gb;
	}

	public void setGb(int gb) {
		this.gb = gb;
	}


	@Override
	public String toString() {
		return Cores.TEXT_GREEN_BOLD + "ID: "+ getId() + " | Nome: " + getNome() + " | Quantidade: " + getQuantidade() + " | Preço: " + getPreco() + " | Capacidade de Armazenamento: " + gb + "gb";
	}

}

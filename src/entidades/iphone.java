package entidades;

public class Iphone extends Produto {

	private int gb;
	
	public Iphone(int tipo, int id, String nome, String cor, double preco, int quantidade, int gb) {
		super(tipo, id, nome, cor, preco, quantidade);
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
		return "iPhone [Capacidade de Armazenamento: " + gb;
	}
	
	

}

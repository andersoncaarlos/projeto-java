package entidades;

public class iphone extends Produto {

	private int gb;
	
	public iphone(String nome, String cor, double preco, int gb) {
		super(nome, cor, preco);
		this.gb = gb;
	}

	public int getGb() {
		return gb;
	}

	public void setGb(int gb) {
		this.gb = gb;
	}
	
	

}

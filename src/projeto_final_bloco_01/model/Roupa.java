package projeto_final_bloco_01.model;

public abstract class Roupa {
	
	private String genero;
	private int tipo;
	private int etaria;
	private float preco;
	
	public Roupa(String genero, int tipo, int etaria, float preco) {
		this.genero = genero;
		this.tipo = tipo;
		this.etaria = etaria;
		this.preco = preco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEtaria() {
		return etaria;
	}

	public void setEtaria(int etaria) {
		this.etaria = etaria;
	}
	
	public void visualizar() {

		String tipo = "1";
		
		switch(this.tipo) {
			case 1 -> tipo = "Adulto";
			case 2 -> tipo = "Infantil";
			default -> tipo = "Desconhecido";
		}
		
		System.out.println("\n***********************************************");
		System.out.println("Dados da roupa");
		System.out.println("*************************************************");
		System.out.printf("Genero: %s%n", this.genero);
		System.out.printf("categoria da roupa: %s%n", tipo);
		System.out.printf("faixa etaria: %d%n", this.etaria);
		System.out.printf("preço: %.2f%n", this.preco);	
	}
	
}

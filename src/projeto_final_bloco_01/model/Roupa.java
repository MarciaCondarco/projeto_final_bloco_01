package projeto_final_bloco_01.model;

public abstract class Roupa {
	
	private int numero;
	private String nome;
	private int genero;
	private int etaria;
	private float preco;
	
	public Roupa(int numero, String nome, int genero, int etaria, float preco ) {
		this.nome = nome;
		this.genero = genero;
		this.etaria = etaria;
		this.preco = preco;
		this.numero = numero;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEtaria() {
		return etaria;
	}

	public void setEtaria(int etaria) {
		this.etaria = etaria;
	}
	
	public void visualizar() {

		String genero = "";
		
		switch(this.genero) {
			case 1 -> genero = "Adulto";
			case 2 -> genero = "Infantil";
			default -> genero = "Desconhecido";
		}
		
		System.out.println("\n***********************************************");
		System.out.println("Dados da roupa");
		System.out.println("*************************************************");
		System.out.printf("ID: %d%n", this.numero);
		System.out.printf("nome da roupa: %s%n", this.nome);
		System.out.printf("categoria da roupa: %s%n", genero);
		System.out.printf("faixa etaria: %d%n", this.etaria);
		System.out.printf("preço: %.2f%n", this.preco);	
	}
	
}

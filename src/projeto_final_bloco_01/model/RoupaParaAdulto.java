package projeto_final_bloco_01.model;

public class RoupaParaAdulto extends Roupa {

	
	private String estilo;
	
	public RoupaParaAdulto(int numero, String nome, int genero, int etaria, float preco, String estilo) {
		super( numero,  nome,  genero,  etaria,  preco);
		this.estilo = estilo;
		
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		//metodo super -> pega/puxa todo o metodo para a classe contacorrente
		System.out.printf("O estilo da roupas é: %s", this.estilo);
		// o limite só acrescenta
	}

}

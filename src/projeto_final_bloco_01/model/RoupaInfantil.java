package projeto_final_bloco_01.model;

public class RoupaInfantil extends Roupa{

	private String personagem;
	
	public RoupaInfantil(int numero, String nome, int genero,  int etaria, float preco, String personagem) {
		super(numero,nome, genero, etaria, preco);
		this.personagem = personagem;
		
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		//metodo super -> pega/puxa todo o metodo para a classe contacorrente
		System.out.printf("O personagem  para as roupas é: %s", this.personagem);
	}
}

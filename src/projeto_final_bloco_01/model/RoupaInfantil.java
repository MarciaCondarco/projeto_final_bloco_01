package projeto_final_bloco_01.model;

public class RoupaInfantil extends Roupa{

	String personagem;
	
	public RoupaInfantil(String genero, int tipo, int etaria, float preco, String personagem) {
		super(genero, tipo, etaria, preco);
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
		System.out.printf("O personagem  para as roupas é: %d", this.personagem);
	}
}

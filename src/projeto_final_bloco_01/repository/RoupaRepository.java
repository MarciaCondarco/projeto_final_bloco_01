package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Roupa;

public interface RoupaRepository {
	// CRUD da Conta
		public void listarTodas();
		public void cadastrar(Roupa roupa);
	   	public void procurarPorNumero(int numero);
		public void atualizar(Roupa roupa);
		public void deletar(int numero);
}

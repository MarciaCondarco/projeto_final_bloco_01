package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Roupa;
import projeto_final_bloco_01.repository.RoupaRepository;

public class RoupaController implements RoupaRepository{

	private List<Roupa> listaRoupas = new ArrayList<Roupa>();
	
	int numero = 0 ; //controlar o numero das contas
	
	@Override
	public void listarTodas() {
		for(var roupa:listaRoupas) {
			roupa.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Roupa roupa) {
		listaRoupas.add(roupa);
		System.out.println("\nConta Cadastrada com sucesso! ");
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		var roupa = buscarNaCollection(numero);
		
		if(roupa != null) {
			roupa.visualizar();
		}
		else {
			System.out.printf("\nroupa não encontrada");
		}
		
	}

	@Override
	public void atualizar(Roupa roupa) {
		var buscarRoupa = buscarNaCollection(roupa.getNumero());
		
		if(buscarRoupa != null) {
			//
			listaRoupas.set(listaRoupas.indexOf(buscarRoupa), roupa);
			System.out.printf("\nA roupa atualizada com sucesso!!");
		}
		else {
			System.out.printf("\nA  ");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var roupa = buscarNaCollection(numero);
		
		if(roupa != null) {
			if(listaRoupas.remove(roupa) == true) {
				System.out.printf("A roupa com id %d foi deleta com sucesso%n", numero);
			}
		}
		else {
			System.out.printf("\nA roupa com id %d não foi encontrada%n", numero);
		}
		
	}
	public Roupa buscarNaCollection(int numero) {
		for(var roupa: listaRoupas) { //percorre a conta do vetor listar conta
			if(roupa.getNumero() == numero) { //compara com o numero da conta 
				return roupa;//returna conta
			}
		}
		return null;//caso não acha nada no for
	}

	public int gerarNumero() {
		return ++ numero;
	}
}

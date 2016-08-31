package br.objective;

import java.util.ArrayList;
import java.util.List;

import br.objective.singleton.MacacoSingleton;
import br.objective.singleton.TubaraoSingleton;

public class Animal {

	private String nome;

	private Boolean ehAquatico;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getEhAquatico() {
		return ehAquatico;
	}

	public void setEhAquatico(Boolean ehAquatico) {
		this.ehAquatico = ehAquatico;
	}

	public static Animal criaAnimal(String nome, boolean ehAquatico) {
		Animal animal = new Animal();
		animal.setNome(nome);
		animal.setEhAquatico(ehAquatico);
		return animal;
	}

	public static List<Animal> getAnimais(List<Animal> animais,
			boolean ehAquatico) {
		List<Animal> listaFiltradaAnimais = new ArrayList<Animal>();
		for (Animal animal : animais) {
			if (animal.getEhAquatico() == ehAquatico) {
				listaFiltradaAnimais.add(animal);
			}
		}
		return listaFiltradaAnimais;
	}

	public static List<Animal> reordenaListaAnimal(String nomeAnimal,
			boolean ehAquatico, List<Animal> animais) {
		if (nomeAnimal != null && !nomeAnimal.isEmpty()) {
			animais.add(Animal.criaAnimal(nomeAnimal, ehAquatico));
		}
		animais.remove(MacacoSingleton.getMacaco());
		animais.remove(TubaraoSingleton.getTubarao());

		animais.add(MacacoSingleton.getMacaco());
		animais.add(TubaraoSingleton.getTubarao());
		return animais;
	}
}

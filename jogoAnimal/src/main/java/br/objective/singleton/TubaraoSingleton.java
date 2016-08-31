package br.objective.singleton;

import br.objective.Animal;

public class TubaraoSingleton {

	private static Animal tubarao;

	private TubaraoSingleton() {

	}

	public static Animal getTubarao() {
		if (tubarao == null) {
			tubarao = new Animal();
			tubarao.setNome("Tubarão");
			tubarao.setEhAquatico(true);
		}
		return tubarao;
	}
}

package br.objective.singleton;

import br.objective.Animal;

public class MacacoSingleton {

	private static Animal macaco;

	private MacacoSingleton() {

	}

	public static Animal getMacaco() {
		if (macaco == null) {
			macaco = new Animal();
			macaco.setNome("Macaco");
			macaco.setEhAquatico(false);
		}
		return macaco;
	}
}

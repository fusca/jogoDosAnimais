package br.objective;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.objective.singleton.MacacoSingleton;
import br.objective.singleton.TubaraoSingleton;

public class AnimalTest {

	private static final String MACACO = "Macaco";
	private static final String TUBARAO = "Tubarao";
	private static final String PEIXE = "Peixe";
	private static final String GATO = "Gato";
	private static final String CACHORRO = "cachorro";
	private Animal macaco;
	private Animal tubarao;
	private Animal peixe;
	private Animal gato;
	private Animal cachorro;
	private List<Animal> animaisAquaticos;
	private List<Animal> animaisNaoAquaticos;
	private List<Animal> animais;
	private List<Animal> animaisReordenados;

	@Before
	public void init() {
		animais = new ArrayList<Animal>();
		animaisReordenados = new ArrayList<Animal>();
		criaAnimais();
		animaisAquaticos = new ArrayList<Animal>();
		animaisNaoAquaticos = new ArrayList<Animal>();
	}

	private void criaAnimais() {
		macaco = Animal.criaAnimal(MACACO, false);
		tubarao = Animal.criaAnimal(TUBARAO, true);
		peixe = Animal.criaAnimal(PEIXE, true);
		gato = Animal.criaAnimal(GATO, false);
		cachorro = Animal.criaAnimal(CACHORRO, false);

		animais.add(macaco);
		animais.add(tubarao);
		animais.add(peixe);
		animais.add(gato);
		animais.add(cachorro);

		animaisReordenados.add(macaco);
		animaisReordenados.add(tubarao);
		animaisReordenados.add(peixe);
		animaisReordenados.add(gato);
		animaisReordenados.add(cachorro);

	}

	@Test
	public void testGetSetter() {
		assertFalse(macaco.getEhAquatico());
		assertEquals(macaco.getNome(), MACACO);
	}

	@Test
	public void testGetAnimais() {

		assertTrue(Animal.getAnimais(animais, false).size() == 3);
		assertTrue(Animal.getAnimais(animais, true).size() == 2);

		animaisAquaticos.add(tubarao);
		animaisAquaticos.add(peixe);
		assertEquals(Animal.getAnimais(animais, true), animaisAquaticos);

		animaisNaoAquaticos.add(macaco);
		animaisNaoAquaticos.add(gato);
		animaisNaoAquaticos.add(cachorro);
		assertEquals(Animal.getAnimais(animais, false), animaisNaoAquaticos);

	}

	@Test
	public void testReordenarAnimal() {

		Animal.reordenaListaAnimal(null, true, animais);
		animaisReordenados.add(MacacoSingleton.getMacaco());
		animaisReordenados.add(TubaraoSingleton.getTubarao());

		assertEquals(animais, animaisReordenados);

	}
}

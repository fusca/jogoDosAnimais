package br.objective.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TubaraoSingletonTest {

	private static final String TUBARAO = "Tubarão";
	
	@Test
	public void testSingleton(){
		assertEquals(TubaraoSingleton.getTubarao().getNome(), TUBARAO);
		assertTrue(TubaraoSingleton.getTubarao().getEhAquatico());
	}
}

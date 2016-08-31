package br.objective.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class MacacoSingletonTest {

	private static final String MACACO = "Macaco";
	
	@Test
	public void testSingleton(){
		assertEquals(MacacoSingleton.getMacaco().getNome(), MACACO);
		assertFalse(MacacoSingleton.getMacaco().getEhAquatico());
	}
}

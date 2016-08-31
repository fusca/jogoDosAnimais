package br.objective.arvore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NoTest {

	private static final Integer RAIZ = 0;
	private static final Integer FILHO = 1;
	private static final Integer NETO =  2;
	private static final String QUESTAO_INICIAL = "O animal que você pensou vive na água?";
	private static final String QUESTAO_ANIMAL = "O animal que você pensou é um %s?";
	private static final String TUBARAO = "Tubarão";
	private static final String MACACO = "Macaco";
	private static final String GOLFINHO = "Golfinho";
	private static final String PEIXE = "Peixe";
	private static final String TO_STRING = "No [nivel="+RAIZ+", questao=" + QUESTAO_INICIAL + "]";

	@Test
	public void testGetSetter() {
		No no = new No();
		no.setNivel(RAIZ);
		no.setQuestao(QUESTAO_INICIAL);

		assertTrue(no.getNivel() == RAIZ);
		assertEquals(no.getQuestao(), QUESTAO_INICIAL);
		assertEquals(no.toString(), TO_STRING);

		no.insere(no, String.format(QUESTAO_ANIMAL, TUBARAO), TUBARAO, true);
		no.insere(no, String.format(QUESTAO_ANIMAL, MACACO), MACACO, false);

		validaNoFilho(no.getNoAfirmativo(), FILHO, String.format(QUESTAO_ANIMAL, TUBARAO), TUBARAO);
		validaNoFilho(no.getNoNegativo(), FILHO, String.format(QUESTAO_ANIMAL, MACACO), MACACO);

		No noFilho = no.getNoAfirmativo();
		noFilho.insere(noFilho, String.format(QUESTAO_ANIMAL, PEIXE), PEIXE, true);
		noFilho.insere(noFilho, String.format(QUESTAO_ANIMAL, GOLFINHO), GOLFINHO, false);

		validaNoFilho(noFilho.getNoAfirmativo(), NETO, String.format(QUESTAO_ANIMAL, PEIXE), PEIXE);
		validaNoFilho(noFilho.getNoNegativo(), NETO, String.format(QUESTAO_ANIMAL, GOLFINHO), GOLFINHO);

		no.percorreArvore(no);
	}

	private void validaNoFilho(No noFilho, Integer nivel, String questao, String nomeAnimal) {
		assertTrue(noFilho.getNivel() == nivel);
		assertEquals(noFilho.getQuestao(), questao);
		assertEquals(noFilho.getNomeAnimal(), nomeAnimal);
		assertNull(noFilho.getNoAfirmativo());
		assertNull(noFilho.getNoNegativo());

	}

}

package br.objective.arvore;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ArvoreBinariaAppTest {

	private static final String QUESTAO_INICIAL = "O animal que você pensou vive na água?";
	private static final String QUESTAO_ANIMAL = "O animal que você pensou é um %s?";
	private static final String TUBARAO = "Tubarão";
	private static final String MACACO = "Macaco";

	@Test
	public void testExecucaoArvoreSemNo() {
		ArvoreBinariaApp app = new ArvoreBinariaApp();
		app.executaArvore(null);
	}

	@Test
	public void testExecucaoArvoreComNo() {
		ArvoreBinariaApp app = new ArvoreBinariaApp();

		No no = new No();
		no.setQuestao(QUESTAO_INICIAL);

		no.insere(no, String.format(QUESTAO_ANIMAL, TUBARAO), TUBARAO, true);
		no.insere(no, String.format(QUESTAO_ANIMAL, MACACO), MACACO, false);

		app.executaArvore(no);
	}

	@Test
	public void testAdicionarNo() {
		ArvoreBinariaApp app = new ArvoreBinariaApp();

		No no = new No();
		no.setQuestao(QUESTAO_INICIAL);
		assertNull(no.getNoAfirmativo());
		assertNull(no.getNoNegativo());
		app.telaAdicionarNo(no);

		assertNotNull(no.getNoAfirmativo());
		assertNotNull(no.getNoNegativo());
	}
}

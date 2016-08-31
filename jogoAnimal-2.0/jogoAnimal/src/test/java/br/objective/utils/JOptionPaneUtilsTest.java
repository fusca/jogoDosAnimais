package br.objective.utils;

import org.junit.Test;

public class JOptionPaneUtilsTest {

	private static final Object TEXTO = "TEXTO";
	private static final String TITULO = "TITULO";

	@Test
	public void testShowConfirmDialog() {
		JOptionPaneUtils.showConfirmDialog(TEXTO, TITULO);
	}

	@Test
	public void testShowMessageDialog() {
		JOptionPaneUtils.showMessageDialog(TEXTO, TITULO);
	}

	@Test
	public void testShowInputDialog() {
		JOptionPaneUtils.showInputDialog(TEXTO.toString(), TITULO);
	}
}

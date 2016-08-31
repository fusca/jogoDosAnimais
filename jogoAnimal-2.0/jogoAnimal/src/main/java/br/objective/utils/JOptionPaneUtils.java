package br.objective.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
* Singleton para utiliza��o de recursos visuais.
* @author fusca
* @since 26/11/2013
*/
public final class JOptionPaneUtils {
	private static final JFrame FRAME = new JFrame("");

	/**
	 * Singleton
	 */
	private JOptionPaneUtils(){

	}
	/**
	 * Exibe uma tela com as op��es de confirma��o (SIM/N�O)
	 * @param label
	 * @param titulo
	 * @return
	 */
	public static boolean showConfirmDialog(Object label, String titulo) {
		if (JOptionPane.showConfirmDialog(FRAME, label, titulo,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	/**
	 * Exibe uma tela s� com instru��es. A a��o permitida � um OK.
	 * @param label
	 * @param titulo
	 */
	public static void showMessageDialog(Object label, String titulo) {
		JOptionPane.showMessageDialog(FRAME, label, titulo,
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Exibe uma tela com um campo de texto para que o usu�rio insira uma informa��o.
	 * @param label
	 * @param titulo
	 * @return
	 */
	public static String showInputDialog(String label, String titulo) {
		return JOptionPane.showInputDialog(FRAME, label, titulo,
				JOptionPane.QUESTION_MESSAGE);

	}
}

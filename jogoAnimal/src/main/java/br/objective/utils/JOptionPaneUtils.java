package br.objective.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class JOptionPaneUtils {
	private static final JFrame FRAME = new JFrame("");

	public static boolean showConfirmDialog(Object label, String titulo) {
		if (JOptionPane.showConfirmDialog(FRAME, label, titulo,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	public static void showMessageDialog(Object label, String titulo) {
		JOptionPane.showMessageDialog(FRAME, label, titulo,
				JOptionPane.PLAIN_MESSAGE);
	}

	public static String showInputDialog(String label, String titulo) {
		return JOptionPane.showInputDialog(FRAME, label, titulo,
				JOptionPane.QUESTION_MESSAGE);

	}
}

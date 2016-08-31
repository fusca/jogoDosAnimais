package br.objective;

import java.util.ArrayList;
import java.util.List;

import br.objective.singleton.MacacoSingleton;
import br.objective.singleton.TubaraoSingleton;
import br.objective.utils.JOptionPaneUtils;

/**
 * 
 * @author fusca
 * @since 20/11/2013
 */
public class App {
	private static final String LABEL_PRIMEIRA_TELA = "Pense em um animal.";
	private static final String LABEL_SEGUNDA_TELA = "O animal que você pensou vive na água?";
	private static final String TITULO_ANIMAL = "Animal";
	private static final String TITULO_QUESTAO = "Questão";
	private static final String TITULO_DESISTO = "Desisto";
	private static final Object LABEL_TERCEIRA_TELA = "O animal que você pensou é ";
	private static final String LABEL_ACERTEI = "Acertei \\o/ !!!!";
	private static final String LABEL_QUAL_ANIMAL = "Qual animal você pensou?";
	private static List<Animal> animais = new ArrayList<Animal>();

	public static void main(String[] args) {
		valoresIniciais();
		executaAplicacao();
	}

	private static void valoresIniciais() {
		animais.add(MacacoSingleton.getMacaco());
		animais.add(TubaraoSingleton.getTubarao());
	}

	private static void executaAplicacao() {
		telaPenseEmUmAnimal();
		if (telaPerguntaAnimalEhAquatico()) {
			deduzirAnimais(true);
		} else {
			deduzirAnimais(false);
		}
		executaAplicacao();
	}

	private static void deduzirAnimais(boolean ehAquatico) {
		boolean encontrou = false;
		for (Animal animal : Animal.getAnimais(animais, ehAquatico)) {
			if (telaDeduzUmAnimal(animal.getNome())) {
				telaAcertei();
				encontrou = true;
				break;
			}
		}
		if (!encontrou) {
			telaAdicionarAnimal(ehAquatico);
		}
	}

	private static void telaAdicionarAnimal(boolean ehAquatico) {
		String nomeAnimal = JOptionPaneUtils.showInputDialog(LABEL_QUAL_ANIMAL,
				TITULO_DESISTO);
		animais = Animal.reordenaListaAnimal(nomeAnimal, ehAquatico, animais);
	}

	private static void telaAcertei() {
		JOptionPaneUtils.showMessageDialog(LABEL_ACERTEI, TITULO_ANIMAL);
	}

	private static boolean telaDeduzUmAnimal(String nomeAnimal) {
		return JOptionPaneUtils.showConfirmDialog(LABEL_TERCEIRA_TELA
				+ nomeAnimal, TITULO_QUESTAO);
	}

	private static boolean telaPerguntaAnimalEhAquatico() {
		return JOptionPaneUtils.showConfirmDialog(LABEL_SEGUNDA_TELA,
				TITULO_QUESTAO);
	}

	private static void telaPenseEmUmAnimal() {
		JOptionPaneUtils.showMessageDialog(LABEL_PRIMEIRA_TELA, TITULO_ANIMAL);
	}

}

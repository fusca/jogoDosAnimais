package br.objective.arvore;

import br.objective.utils.JOptionPaneUtils;

/**
 * Classe executora (main).
 * @author fusca
 * @since 26/11/2013
 */
public class ArvoreBinariaApp {
	private static final String LABEL_PRIMEIRA_TELA = "Pense em um animal.";
	private static final String TITULO_ANIMAL = "Animal";
	private static final String TITULO_QUESTAO = "Questão";
	private static final String TITULO_DESISTO = "Desisto";
	private static final String LABEL_ACERTEI = "Acertei \\o/ !!!!";
	private static final String QUESTAO_INICIAL = "O animal que você pensou vive na água?";
	private static final String QUESTAO_ANIMAL = "O animal que você pensou é um %s?";
	private static final String TUBARAO = "Tubarão";
	private static final String MACACO = "Macaco";
	private static final String LABEL_QUAL_ANIMAL = "Qual animal você pensou?";
	private static final String TITULO_COMPLETE = "Complete a comparação";
	private static final String LABEL_QUESTAO_COMPARATIVA = "Um(a) %s  _______ mas um(a) %s não.";
	private static No noRaiz;

	/**
	 * Inicia a aplicacao.</br>
	 * <strong>1 - carrega os valores iniciais</strong>
	 * <strong>2 - executa a aplicação</strong>
	 * @param args
	 */
	public static void main(String[] args) {
		valoresIniciais();
		executaAplicacao();
	}

	/**
	 * Metodo para invocar a tela inicial e executar as pesquisas na arvore binaria de perguntas.
	 */
	private static void executaAplicacao() {
		telaPenseEmUmAnimal();
		executaArvore(noRaiz);
		executaAplicacao();
	}

	/**
	 * Insere os valores iniciais no nó raiz.</br>
	 * Insere a pergunta se o animal vive na agua</br>
	 * Insere a questao se o animal é um tubarão ou macaco</br>
	 */
	private static void valoresIniciais() {
		noRaiz = new No();
		noRaiz.setQuestao(QUESTAO_INICIAL);
		noRaiz.insere(noRaiz, String.format(QUESTAO_ANIMAL, TUBARAO), TUBARAO,
				true);
		noRaiz.insere(noRaiz, String.format(QUESTAO_ANIMAL, MACACO), MACACO,
				false);
	}

	/**
	 * Executa a arvore binária de perguntas baseado nos valores iniciais e valores cadastro pelo usuario.
	 */
	public static void executaArvore(No no) {
		if (no != null) {
			if (telaTentarAdivinhar(no)) {
				if (no.getNoAfirmativo() == null) {
					telaAcertei();
				} else {
					executaArvore(no.getNoAfirmativo());
				}
			} else {
				if (no.getNoNegativo() == null) {
					telaAdicionarNo(no);
				} else {
					executaArvore(no.getNoNegativo());
				}
			}
		} else {
			return;
		}

	}

	/**
	 * Tela que informa que o sistema adivinou o animal pensado.
	 */
	private static void telaAcertei() {
		JOptionPaneUtils.showMessageDialog(LABEL_ACERTEI, TITULO_ANIMAL);
	}

	/**
	 * Tela que precisa de uma acao do usuario para uma questão.
	 */
	private static boolean telaTentarAdivinhar(No noSelecionado) {
		return JOptionPaneUtils.showConfirmDialog(noSelecionado.getQuestao(),
				TITULO_QUESTAO);
	}

	/**
	 * Tela que permite o usuario adicionar um animal e uma questao sobre este animal.
	 */
	public static void telaAdicionarNo(No no) {
		String nomeAnimal = JOptionPaneUtils.showInputDialog(LABEL_QUAL_ANIMAL,
				TITULO_DESISTO);

		String questao = JOptionPaneUtils.showInputDialog(
				String.format(LABEL_QUESTAO_COMPARATIVA, nomeAnimal,
						no.getNomeAnimal()), TITULO_COMPLETE);

		no.setQuestao("O animal que você pensou " + questao + "?");
		no.insere(no, String.format(QUESTAO_ANIMAL, nomeAnimal),
				nomeAnimal, true);
		no.insere(no, String.format(QUESTAO_ANIMAL, no.getNomeAnimal()),
				no.getNomeAnimal(), false);

	}

	/**
	 * Tela informativa para o usuario pensar em um animal.
	 */
	private static void telaPenseEmUmAnimal() {
		JOptionPaneUtils.showMessageDialog(LABEL_PRIMEIRA_TELA, TITULO_ANIMAL);
	}

}

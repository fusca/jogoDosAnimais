package br.objective.arvore;

/**
* Arvore binária onde seus nós possuem itens de afirmacoes e negacoes.
* @author fusca
* @since 26/11/2013
*/
public class No {

	private Integer nivel = 0;
	private String questao;
	private String nomeAnimal;
	private No noAfirmativo;
	private No noNegativo;

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public No getNoAfirmativo() {
		return noAfirmativo;
	}

	public void setNoAfirmativo(No noAfirmativo) {
		this.noAfirmativo = noAfirmativo;
	}

	public No getNoNegativo() {
		return noNegativo;
	}

	public void setNoNegativo(No noNegativo) {
		this.noNegativo = noNegativo;
	}

	/**
	 * Insere um nó na arvore binária. </br>
	 * Caso seja uma resposta afirmativa, adiciona no ramo esquerdo da arvore.</br>
	 * Caso seja uma resposta negativa, adiciona no ramo direito da arvore.</br>
	 * @param no
	 * @param questao
	 * @param nomeAnimal
	 * @param afirmativo
	 */
	public void insere(No no, String questao, String nomeAnimal, boolean afirmativo) {
		No noFilho = new No();
		noFilho.setQuestao(questao);
		noFilho.setNomeAnimal(nomeAnimal);
		noFilho.setNivel(no.getNivel() + 1);
		if (afirmativo) {
			no.setNoAfirmativo(noFilho);
		} else {
			no.setNoNegativo(noFilho);
		}
	}

	/**
	 * Metodo recursivo para percorrer todos os nós da arvore.
	 * @param no
	 */
	public void percorreArvore(No no) {
		if (no != null) {
			percorreArvore(no.getNoAfirmativo());
			percorreArvore(no.getNoNegativo());
		}
	}


	/**
	 * Exibe as informações do nó.
	 */
	@Override
	public String toString() {
		return "No [nivel=" + nivel + ", questao=" + questao + "]";
	}

}

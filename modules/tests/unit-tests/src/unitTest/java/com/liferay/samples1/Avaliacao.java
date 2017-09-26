package com.liferay.samples1;

public class Avaliacao {

	public String avaliar(IEstudante aluno) {
		if (aluno.getNotaProva() >= 7) {
			if (aluno.getNotaTrabalho() >= 7) {
				return "Aprovado";
			} else {
				return "Precisara repor a nota do trabalho";
			}
		} else {
			return "Tera de fazer Prova de Recuperacao";
		}
	}
}
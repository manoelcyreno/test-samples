package com.liferay.samples1.unit.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.liferay.samples1.Avaliacao;
import com.liferay.samples1.IEstudante;

public class Teste {

	Avaliacao avaliacao = new Avaliacao();
	IEstudante aluno = mock(IEstudante.class);

	@Test
	public void testeAlunoAprovado() {
		when(aluno.getNotaProva()).thenReturn(7.0);
		when(aluno.getNotaTrabalho()).thenReturn(7.0);

		String resultado = avaliacao.avaliar(aluno);

		Assert.assertEquals("Aprovado", resultado);
	}

	@Test
	public void testeAlunoReporNotaTrabalho() {
		when(aluno.getNotaProva()).thenReturn(7.0);
		when(aluno.getNotaTrabalho()).thenReturn(6.9);

		String resultado = avaliacao.avaliar(aluno);

		Assert.assertEquals("Precisara repor a nota do trabalho", resultado);
	}

	@Test
	public void testeAlunoDeRecuperacao() {
		when(aluno.getNotaProva()).thenReturn(6.9);
		when(aluno.getNotaTrabalho()).thenReturn(0.0);

		String resultado = avaliacao.avaliar(aluno);

		Assert.assertEquals("Tera de fazer Prova de Recuperacao", resultado);
	}
}
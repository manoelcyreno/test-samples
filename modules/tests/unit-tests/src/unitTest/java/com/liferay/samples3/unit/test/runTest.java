package com.liferay.samples3.unit.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import testeApp.portlet.TesteAppPortlet;

public class runTest {

	TesteAppPortlet tap = new TesteAppPortlet();
	IText text = mock(IText.class);

	@Test
	public void testAppWithText() {
		when(text.getSomeText()).thenReturn("something");

		String result = tap.getText(text.getSomeText());

		Assert.assertTrue(result.toString().contains("Hello"));
	}

	@Test
	public void testAppWithoutText() {
		when(text.getSomeText()).thenReturn("");

		String result = tap.getText(text.getSomeText());

		Assert.assertTrue(result.toString().contains("Error"));
	}
	
	@Test
	public void testAppWithNullText() {
		when(text.getSomeText()).thenReturn(null);

		String result = tap.getText(text.getSomeText());

		Assert.assertTrue(result.toString().contains("Error"));
	}

}
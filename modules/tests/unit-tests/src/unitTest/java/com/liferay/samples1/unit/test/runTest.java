package com.liferay.samples1.unit.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.liferay.samples1.Evaluation;
import com.liferay.samples1.IStudent;

public class runTest {

	Evaluation evaluation = new Evaluation();
	IStudent student = mock(IStudent.class);

	@Test
	public void testStudentApproved() {
		when(student.getTestGrade()).thenReturn(7.0);
		when(student.getWorkGrade()).thenReturn(7.0);

		String result = evaluation.evaluate(student);

		Assert.assertEquals("Approved", result);
	}

	@Test
	public void testStudentResetTheJob() {
		when(student.getTestGrade()).thenReturn(7.0);
		when(student.getWorkGrade()).thenReturn(6.9);

		String result = evaluation.evaluate(student);

		Assert.assertEquals("You will need to reset the job", result);
	}

	@Test
	public void testStudentProofOfRecovery() {
		when(student.getTestGrade()).thenReturn(6.9);
		when(student.getWorkGrade()).thenReturn(0.0);

		String result = evaluation.evaluate(student);

		Assert.assertEquals("You will have to take proof of recovery", result);
	}
}
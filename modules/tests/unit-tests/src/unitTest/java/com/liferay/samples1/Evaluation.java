package com.liferay.samples1;

public class Evaluation {

	public String evaluate(IStudent student) {
		if (student.getTestGrade() >= 7) {
			if (student.getWorkGrade() >= 7) {
				return "Approved";
			} else {
				return "You will need to reset the job";
			}
		} else {
			return "You will have to take proof of recovery";
		}
	}
}
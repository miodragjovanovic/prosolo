package com.name.no.helper;

public class DepartmentAverage {

	private String department;
	private double avgGrade;

	public DepartmentAverage(String department, double avgGrade) {
		this.department = department;
		this.avgGrade = avgGrade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getAverageGrade() {
		return avgGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.avgGrade = averageGrade;
	}

}

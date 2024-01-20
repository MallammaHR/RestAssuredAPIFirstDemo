package com.pojo;

public class Employee 
{
	/**
	 * firstname-string
	 * lastName=string
	 * gender-string
	 * age-int
	 * salary-double 
	 */
	//Declartion
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	
	//call gettert() to get value and setter()-to set Value
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	

	
	
}

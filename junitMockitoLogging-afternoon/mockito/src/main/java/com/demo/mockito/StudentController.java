package com.demo.mockito;

public class StudentController {
	Student student;
	public String getFullName(Student student)
	{
		return student.getFirstName()+" "+student.getLastName();
	}
	public int getStudentRollNumber(Student student)
	{
		return student.getId();
	}
	public String getStudentAge(Student student)
	{
		return student.getFirstName()+" "+student.getLastName() + " is " + student.getAge() +" years old.";
	}
}

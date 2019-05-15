package com.student.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="studentresttable")
public class StudentBean {
@Id
@GeneratedValue
Integer studentId;	
	
@Column(name="name")
String studentName;

@Column(name="rollno")
String rollNo;

@Column(name="caoaching_fee")
@NotNull
Double studentFee;

public Integer getStudentId() {
	return studentId;
}

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getRollNo() {
	return rollNo;
}

public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}

public Double getStudentFee() {
	return studentFee;
}

public void setStudentFee(Double studentFee) {
	this.studentFee = studentFee;
}

@Override
public String toString() {
	return "StudentBean [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo
			+ ", studentFee=" + studentFee + ", getStudentId()=" + getStudentId() + ", getStudentName()="
			+ getStudentName() + ", getRollNo()=" + getRollNo() + ", getStudentFee()=" + getStudentFee()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}




}

package com.nagarro.hrmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="employeedetail")
public class Employee {
	
	@Id
	@Column(name="empcode")
	private int empcode;
	
	@Column(name="empname")
	private String empname;
	
	@Column(name="emploc")
	private String emploc;
	
	@Column(name="empmail")
	private String empmail;
	
	@Column(name="empdob")
	private String empdob;
	
	public Employee() {
		super();
	}
	
	public Employee(int empcode, String empname, String emploc, String empmail, String empdob) {
		super();
		this.empcode = empcode;
		this.empname = empname;
		this.emploc = emploc;
		this.empmail = empmail;
		this.empdob = empdob;
	}
	public int getEmpcode() {
		return empcode;
	}

	public String getEmpname() {
		return empname;
	}

	public String getEmploc() {
		return emploc;
	}

	public String getEmpmail() {
		return empmail;
	}

	public String getEmpdob() {
		return empdob;
	}

	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public void setEmploc(String emploc) {
		this.emploc = emploc;
	}

	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}

	public void setEmpdob(String empdob) {
		this.empdob = empdob;
	}

	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", empname=" + empname + ", emploc=" + emploc + ", empmail=" + empmail
				+ ", empdob=" + empdob + "]";
	}
	
}

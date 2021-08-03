package jo.secondstep.tables;

import java.sql.Date;
import java.util.Locale;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Date hireDate;
	private double salary;
	
	private int jobId;
	private int managerId;
	private int departmentId;
	
	public Employee(int id, String firstName, String lastName, String email, String phone, Date hireDate, double salary,
			int job, int manager, int department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
		this.jobId = job;
		this.managerId = manager;
		this.departmentId = department;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getPhone() {
		return phone;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public double getSalary() {
		return salary;
	}

	public int getJobId() {
		return jobId;
	}

	public int getManagerId() {
		return managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH,"%d\t%-25s%-25s\t%-35s\t%-16s\t%s\t%.0f\t%d\t%d\t%d",
				id,firstName,lastName,email,phone,hireDate,salary,
				jobId,managerId,departmentId);
	}

	
	
}
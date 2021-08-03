package jo.secondstep.tables;

import java.util.Locale;

public class Dependent {

	private int id;
	private String firstName;
	private String lastName;
	private String relationship;
	private int employeeId;
	
	public Dependent(int id, String firstName, String lastName, String relationship, int employeeId) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.relationship = relationship;
		this.employeeId = employeeId;
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

	public String getRelationship() {
		return relationship;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH,"%d\t%-25s%-25s\t%-25s\t%d",
				id,firstName,lastName,relationship,employeeId);
	}
	
}

package jo.secondstep.tables;

public class Department {

	private int id;
	private String name;
	private int locationId;
	
	public Department(int id, String name, int location) {

		this.id = id;
		this.name = name;
		this.locationId = location;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLocationId() {
		return locationId;
	}

	@Override
	public String toString() {
		
		return String.format("%d\t%-30s %d", id,name,locationId);
	}

	
	
}

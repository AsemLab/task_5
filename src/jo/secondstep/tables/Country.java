package jo.secondstep.tables;

public class Country {

	private String id;
	private String name;
	private int regionId;
	
	public Country(String id, String name, int regionId) {
	
		this.id = id;
		this.name = name;
		this.regionId = regionId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRegionId() {
		return regionId;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%-40s\t%d", id,name,regionId);
	}
	
	
}

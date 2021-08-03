package jo.secondstep.tables;

public class Location {

	private int id;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
	
	public Location(int id, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
		
		this.id = id;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	public int getId() {
		return id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public String getCountryId() {
		return countryId;
	}

	@Override
	public String toString() {
		return String.format("%d\t%-40s\t%-12s\t%-30s\t%-25s\t%s", id,streetAddress,postalCode,city,stateProvince,countryId);
	}
	
	
	
	
}


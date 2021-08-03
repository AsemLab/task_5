package jo.secondstep.tables;

public class Region {
	private int id;
	private String name;

	public Region(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("%d\t%s", id,name);
	}
	
}

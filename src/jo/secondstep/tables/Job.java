package jo.secondstep.tables;

import java.util.Locale;

public class Job {
	
	private int id;
	private String title;
	private double minSalary;
	private double maxSalary;
	
	public Job(int id, String title, double min_salary, double max_salary) {
		this.id = id;
		this.title = title;
		this.minSalary = min_salary;
		this.maxSalary = max_salary;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	@Override
	public String toString() {
		return String.format(Locale.ENGLISH,"%d\t%-35s\t%.0f\t%.0f",id,title,minSalary, maxSalary);
	}
	
	

}

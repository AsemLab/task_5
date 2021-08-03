package jo.secondstep.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;

import jo.secondstep.tables.Employee;
import jo.secondstep.tables.Job;

public class Clinet {

	final static String URL = "jdbc:sqlserver://localhost;databaseName=hrsystem;integratedSecurity=true";

	public static void main(String[] args) {

		try {
			Connection c = DriverManager.getConnection(URL);
			Statement s = c.createStatement();

			List<String> jobs = getJobsMore5000(s);

			for (String j : jobs) {
				System.out.println(j);
			}
			System.out.println("------------------------------");
			System.out.println(getTotalSalaries(s));
			System.out.println("------------------------------");
			
			Map<String,Double> countries = getCountriesWithCost(s);
			
			for(String country: countries.keySet()) {
				System.out.println(country+"\t"+countries.get(country));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static List<Job> getAllJobs(Statement statement) throws SQLException {
		String query = "SELECT * FROM jobs order by max_salary desc";
		ResultSet result = statement.executeQuery(query);

		List<Job> jobs = new ArrayList<Job>();

		while (result.next()) {
			int id = result.getInt("job_id");
			String title = result.getString("job_title");
			int min = result.getInt("min_salary");
			int max = result.getInt("max_salary");
			jobs.add(new Job(id, title, min, max));
		}

		return jobs;
	}

	public static List<Employee> getAllEmployees(Statement statement) throws SQLException {
		String query = "SELECT * FROM employees";
		ResultSet result = statement.executeQuery(query);

		List<Employee> employees = new ArrayList<Employee>();

		while (result.next()) {
			int id = result.getInt("employee_id");
			String fN = result.getString("first_name");
			String lN = result.getString("last_name");
			String email = result.getString("email");
			String phone = result.getString("phone_number");

			Date hireDate = result.getDate("hire_date");
			double salary = result.getDouble("salary");
			int jobId = result.getInt("job_id");
			int managerId = result.getInt("manager_id");
			int departmentId = result.getInt("department_id");

			employees.add(new Employee(id, fN, lN, email, phone, hireDate, salary, jobId, managerId, departmentId));
		}

		return employees;
	}

	/* 1.Retrieve all job titles that have minimum salary 5000 */
	public static List<String> getJobsMore5000(Statement statement) {
		String query = "select job_title title from jobs" + " where min_salary > 5000";

		List<String> jobs = new ArrayList<>();
		ResultSet result;
		try {
			result = statement.executeQuery(query);
			while (result.next()) {
				jobs.add(result.getString("title"));
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return jobs;
	}

	/* 2.Total salaries in IT department */
	public static double getTotalSalaries(Statement statement) {
		String query = "select sum(e.salary)  total from employees e"
				+ "	join departments d on e.department_id = d.department_id"
				+ "	where d.department_name = 'IT'";

		double total = 0;
		ResultSet result;
		try {
			result = statement.executeQuery(query);

			result.next();
			total = result.getDouble("total");
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return total;
	}

	/*	3.Report showing the cost for each department in all countries.	*/
	public static Map<String,Double> getCountriesWithCost(Statement statement) {
		String query = "select c1.country_name, d.department_name, sum(e.salary) costs from employees e "
				+ "join departments d on e.department_id = d.department_id "
				+ "join locations l on d.location_id = l.location_id "
				+ "join countries c1 on c1.country_id = l.country_id "
				+ "group by c1.country_name, d.department_name "
				+ "order by c1.country_name , d.department_name";

		Map<String,Double> countries = new HashMap<>();
		
		ResultSet result;
		try {
			result = statement.executeQuery(query);
			while (result.next()) {
				String countryName = result.getString("country_name");
				String departmentName = result.getString("department_name");
				double cost = result.getDouble("costs");
				
				countries.put(countryName+" "+departmentName,cost);
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return countries;
	}

	
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String connectionString = "jdbc:mysql://localhost:3306/employees";
		final String SELECT_QUERY = "SELECT * FROM employees LIMIT 20";

		try {
			Connection conn = DriverManager.getConnection(connectionString, "f55m818", "none");
			System.out.println("Connected successfully!");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_QUERY);
			ResultSetMetaData m = rs.getMetaData();

			while (rs.next()) {
				System.out.println(
						"emp_no: " + rs.getInt("emp_no") + ", dob: " + rs.getString(2) + ", first name: " + rs.getString(3));
			}
			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("Error connecting to the database.");
			e.printStackTrace();
		}
	}

}

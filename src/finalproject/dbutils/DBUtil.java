package finalproject.dbutils;

import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import finalproject.beans.Course;
import finalproject.beans.CourseList;
import finalproject.beans.Enrollment;
import finalproject.beans.EnrollmentList;
import finalproject.beans.Student;

public class DBUtil {
	
	private Connection connection = null;
	private final String[] DB_INFO = getConnection();
	
	// Loading DB INFO from connection.txt file
	public String[] getConnection() {
		String[] info = new String[4];
		try {
			File file = new File(this.getClass().getResource("").getFile() + "\\connection.txt");
			Scanner myReader = new Scanner(file);
			int count = 0;
			while (myReader.hasNextLine()) {
				info[count] = myReader.nextLine();
				count++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Connection file not found.");
			e.printStackTrace();
		}
		return info;
	}

	private void startConnection() {
		try {
			Class.forName(DB_INFO[0]);

			connection = DriverManager.getConnection(DB_INFO[1], DB_INFO[2], DB_INFO[3]);
		} catch (ClassNotFoundException e) {
			System.out.println("[DB] Class not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("[DB] SQL error");
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("[DB] Unable to close connection.");
			e.printStackTrace();
		}
	}

	/*======================================== Student ========================================*/
	// Check for SSN
	public Student getStudentInfo(String ssn) {
		startConnection();
		String sqlQuery = "SELECT * FROM Students "
				+ "WHERE ssn = ?";
		Student studentInfo = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				studentInfo = new Student(resultSet.getString(1), 
						resultSet.getString(2), 
						checkMiddleName(resultSet.getString(3)), 
						resultSet.getString(4), 
						resultSet.getString(5), 
						resultSet.getString(6), 
						formatPhone(resultSet.getString(7)), 
						resultSet.getString(8), 
						resultSet.getString(9));
				System.out.println("[DB] Retrieved Student Info");
				return studentInfo;
			}

			preparedStatement.close();
			resultSet.close();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String checkMiddleName(String middleName) {
		if (middleName == null) {
			return "";
		} else {
			return middleName;
		}
	}
	
	private String formatPhone(String phone) {
		if (phone.contains("(") && phone.contains(")") || phone.contains("-")) {
			return phone;
		}
		return String.valueOf(phone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
	}
	
	// Get Student Enrollment List
	public EnrollmentList getStudentCourses(String ssn) {
		startConnection();
		String sqlQuery = "SELECT c.courseID, c.title, e.grade "
				+ "FROM Course c, Enrollment e "
				+ "WHERE e.courseId = c.courseID and e.ssn = ? "
				+ "ORDER BY c.title";
		Queue<Enrollment> enrollment = new LinkedList<Enrollment>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				enrollment.add(new Enrollment(resultSet.getString(1), 
						resultSet.getString(2),
						resultSet.getString(3)));
			}

			System.out.println("[DB] Retrieved Student Enrolled Courses");

			preparedStatement.close();
			resultSet.close();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new EnrollmentList(enrollment);
	}

	/*======================================== Courses ========================================*/
	// Get Course List
	public CourseList getCourses() {
		startConnection();
		String sqlQuery = "SELECT courseID, title, numOfCredits " 
				+ "FROM Course "
				+ "ORDER BY title";
		Queue<Course> courseInfo = new LinkedList<Course>();

		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				courseInfo.add(new Course(resultSet.getString(1), 
						resultSet.getString(2),
						resultSet.getString(3)));
			}

			System.out.println("[DB] Retrieved Courses List");

			statement.close();
			resultSet.close();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new CourseList(courseInfo);
	}

	// Add Course to Student
	public boolean addCourse(String ssn, String courseID, String grade) {
		startConnection();
		String sqlQuery = "INSERT INTO Enrollment "
				+ "VALUES(?, ?, GETDATE(), ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);
			preparedStatement.setString(3, grade);

			if (!findCourse(ssn, courseID)) {
				preparedStatement.executeUpdate();
				System.out.println("[DB] Added CourseID: " + courseID + 
						" with Grade: " + grade);
				preparedStatement.close();
				closeConnection();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return false;
	}

	// Delete Course from Student
	public boolean delCourse(String ssn, String courseID) {
		startConnection();
		String sqlQuery = "DELETE FROM Enrollment "
				+ "WHERE ssn = ? and courseId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);

			if (findCourse(ssn, courseID)) {
				preparedStatement.executeUpdate();
				System.out.println("[DB] Removed Course: " + courseID);
				preparedStatement.close();
				closeConnection();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return false;
	}
	
	// Find Course from Student
	private boolean findCourse(String ssn, String courseID) {
		String sqlQuery = "SELECT * FROM Enrollment "
				+ "WHERE ssn = ? and courseID = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("[DB] Found Course: " + courseID);
				preparedStatement.close();
				resultSet.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

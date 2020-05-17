package finalproject.beans;

public class Enrollment {

	private String courseID;
	private String title;
	private String grade;

	public Enrollment(String courseID, String title, String grade) {
		this.courseID = courseID;
		this.title = title;
		this.grade = grade;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getTitle() {
		return title;
	}

	public String getGrade() {
		return grade;
	}
	
}

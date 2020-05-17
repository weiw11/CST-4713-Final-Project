package finalproject.beans;

public class Course {
	
	private String courseID;
	private String title;
	private String numOfCredits;
	
	public Course(String courseID, String title, String numOfCredits) {
		this.courseID = courseID;
		this.title = title;
		this.numOfCredits = numOfCredits;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getTitle() {
		return title;
	}

	public String getNumOfCredits() {
		return numOfCredits;
	}
	
}

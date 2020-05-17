package finalproject.beans;

import java.util.Queue;

public class CourseList {

	private Queue<Course> courses;
	private String output = "";

	public CourseList(Queue<Course> courses) {
		this.courses = courses;
	}

	public Queue<Course> getCourses() {
		return courses;
	}

	public String getOutput() {
		for (Course e:courses) {
			output += 
					"						" + // Fixes HTML alignment
					"<option value=\"" + e.getCourseID() + "\">" + 
					e.getTitle() + " [" + e.getNumOfCredits() + "] " + 
					"</option>\r\n";
		}
		// Clears excess lines
		return output.substring(0, output.length()-2);
	}
	
	public String findCourseTitle(String courseID) {
		for (Course course:courses) {
			if (course.getCourseID().equals(courseID)) {
				return course.getTitle();
			}
		}
		return null;
	}
}

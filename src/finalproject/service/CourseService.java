package finalproject.service;

import finalproject.beans.CourseList;

public interface CourseService {
	public CourseList getCourses();
	public boolean addCourse(String ssn, String courseID, String grade);
	public boolean delCourse(String ssn, String courseID);
}

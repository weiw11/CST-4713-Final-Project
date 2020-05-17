package finalproject.util;

import finalproject.beans.CourseList;
import finalproject.dbutils.DBUtil;
import finalproject.service.CourseService;

public class CourseUtil implements CourseService {
	
	@Override
	public CourseList getCourses() {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getCourses();
	}

	@Override
	public boolean addCourse(String ssn, String courseID, String grade) {
		DBUtil dbUtil = new DBUtil();
		if (dbUtil.addCourse(ssn, courseID, grade)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delCourse(String ssn, String courseID) {
		DBUtil dbUtil = new DBUtil();
		if (dbUtil.delCourse(ssn, courseID)) {
			return true;
		} else {
			return false;
		}
	}

}

package finalproject.util;

import finalproject.beans.EnrollmentList;
import finalproject.dbutils.DBUtil;
import finalproject.service.EnrollmentService;

public class EnrollmentUtil implements EnrollmentService {

	@Override
	public EnrollmentList getStudentCourses(String ssn) {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getStudentCourses(ssn);
	}

}

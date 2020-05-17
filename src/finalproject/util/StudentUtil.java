package finalproject.util;

import finalproject.beans.Student;
import finalproject.dbutils.DBUtil;
import finalproject.service.StudentService;

public class StudentUtil implements StudentService {

	@Override
	public Student getStudentInfo(String ssn) {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getStudentInfo(ssn);
	}
}

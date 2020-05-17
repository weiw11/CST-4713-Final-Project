package finalproject.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalproject.beans.CourseList;
import finalproject.beans.EnrollmentList;
import finalproject.beans.Student;
import finalproject.service.CourseService;
import finalproject.service.EnrollmentService;
import finalproject.service.StudentService;
import finalproject.util.CourseUtil;
import finalproject.util.EnrollmentUtil;
import finalproject.util.StudentUtil;
import finalproject.util.URLHolder;

@WebServlet("/final-validate-login")
public class Validate extends HttpServlet {
	
	private StudentService studentService = new StudentUtil();
	private EnrollmentService enrollmentService = new EnrollmentUtil();
	private CourseService courseService = new CourseUtil();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address;
		String ssn = request.getParameter("ssn").trim();
		
		System.out.println("Input SSN: " + ssn);
		
		Student studentInfo = null;
		EnrollmentList enrollmentList = null;
		
		if (ssn.isEmpty()) {
			ssn = "";
		} else {
			studentInfo = studentService.getStudentInfo(ssn);
			enrollmentList = enrollmentService.getStudentCourses(ssn);
		}
		
		// Sets session
		HttpSession session = request.getSession();
		session.setAttribute("student", studentInfo);
		
		if (session.getAttribute("courses") == null) {
			CourseList courseList = courseService.getCourses();
			session.setAttribute("courses", courseList);
		}
		
		if (ssn == "") {
			request.setAttribute("invalidInput", "[EMPTY]");
			address = URLHolder.ERROR_LOGIN.getUrl();
		} else if (studentInfo != null) {
			session.setAttribute("enrollment", enrollmentList);
			address = URLHolder.SUCCESS.getUrl();
		} else {
			request.setAttribute("invalidInput", ssn);
			address = URLHolder.ERROR_LOGIN.getUrl();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}

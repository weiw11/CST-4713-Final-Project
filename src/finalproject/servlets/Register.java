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
import finalproject.util.CourseUtil;
import finalproject.util.EnrollmentUtil;
import finalproject.util.URLHolder;

@WebServlet("/final-validate-register")
public class Register extends HttpServlet {
	
	private EnrollmentService enrollmentService = new EnrollmentUtil();
	private CourseService courseService = new CourseUtil();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("student");
		String ssn = student.getSsn();
		String courseID = request.getParameter("courseID");
		String grade = request.getParameter("grade");
		
		if (courseService.addCourse(ssn, courseID, grade)) {
			// Refresh session with new value
			EnrollmentList enrollmentList = enrollmentService.getStudentCourses(ssn);
			HttpSession session = request.getSession();
			session.setAttribute("enrollment", enrollmentList);
			
			response.sendRedirect(URLHolder.SUCCESS.getUrl());
		} else {
			request.setAttribute("invalidCourseID", courseID);
			request.setAttribute("invalidCourseGrade", grade);
			CourseList courseList = (CourseList) request.getSession().getAttribute("courses");
			request.setAttribute("invalidCourseTitle", courseList.findCourseTitle(courseID));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(URLHolder.ERROR_REGISTER.getUrl());
			dispatcher.forward(request, response);
		}
	}
}

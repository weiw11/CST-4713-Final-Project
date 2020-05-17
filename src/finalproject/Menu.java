package finalproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/final-menu-redirector")
public class Menu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action").toLowerCase();
		String courseID = request.getParameter("courses");
		String grade = request.getParameter("grade");

		String address = "";

		switch (action) {
			case "drop": 
				address = "final-validate-drop?courseID=" + courseID;
				break;
			case "register": 
				address = "final-validate-register?courseID=" + courseID + "&grade=" + grade;
				break;
			case "exit": 
				response.sendRedirect("MyRegist.jsp");
				break;
			default: 
				response.sendRedirect("MyRegist.jsp");
            	break;
		}
		
		if (!address.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}
}

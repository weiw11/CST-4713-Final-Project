package finalproject.beans;

import java.util.Queue;

public class EnrollmentList {
	
	private Queue<Enrollment> enrollments;
	private String output = "";
	
	public EnrollmentList(Queue<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public Queue<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public String getOutput() {
		if (output.equals("")) {
			for (Enrollment e:enrollments) {
				output += 
						"			<tr>\r\n" + 
						"				<td>" + e.getCourseID() + "</td>\r\n" + 
						"				<td>" + e.getTitle() + "</td>\r\n" + 
						// Apply Grade Color?
						useColor(true, e.getGrade()) + 
						"			</tr>\r\n";
			}
		}
		// Clears excess lines
		return output.substring(0, output.length()-2);
	}
	
	private String useColor(boolean color, String grade) {
		if (!color) {
			return "				<td>" + grade + "</td>\r\n";
		} else {
			return colorGrade(grade);
		}
	}
	
	private String colorGrade(String grade) {
		String color = "";
		switch (grade) {
			case "A": 
				color = "style=\"background-color:#00FF00;\"";
				break;
			case "B": 
				color = "style=\"background-color:#7FFF00;\"";
				break;
			case "C": 
				color = "style=\"background-color:#FFFF00;\"";
				break;
			case "D": 
				color = "style=\"background-color:#FFFF00;\"";
				break;
			case "F": 
				color = "style=\"background-color:#FF0000;\"";
				break;
			default: 
				color = "style=\"background-color:#FFFF00;\"";
	        	break;
		}
		return "<td " + color + ">" + grade + "</td>";
	}

}

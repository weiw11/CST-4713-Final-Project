package finalproject.util;

public enum URLHolder {
	ERROR_LOGIN("/WEB-INF/registrationError/LoginError.jsp"),
	ERROR_DROP("/WEB-INF/registrationError/EnrollDropError.jsp"),
	ERROR_REGISTER("/WEB-INF/registrationError/EnrollRegisterError.jsp"),
	SUCCESS("MyRegist.jsp");
			
	private String url;;

	URLHolder(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
}

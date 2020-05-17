package finalproject.beans;

public class Student {
	
	private String ssn;
	private String firstName, middleName, lastName;
	private String fullName;
	private String birthDate;
	private String street;
	private String phone;
	private String zipCode;
	private String deptId;
	
	public Student(String ssn, String firstName, String middleName, String lastName, String birthDate, String street, String phone, String zipCode, String deptId) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fullName = firstName + " " + middleName + " " + lastName;
		this.birthDate = birthDate;
		this.street = street;
		this.phone = phone;
		this.zipCode = zipCode;
		this.deptId = deptId;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	public String toString() {
		return "Firstname: " + firstName + " | Lastname: " + lastName;
	}
	
}

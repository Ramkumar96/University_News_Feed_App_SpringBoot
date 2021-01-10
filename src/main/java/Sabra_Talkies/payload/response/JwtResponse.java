package Sabra_Talkies.payload.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String firstname;
	private String lastname;
	private String gender;
	private String birthOfDate;
	private String district;
	private String username;
	private String email;
	private String academicYear;
	private String facultyId ;
	private String departmentId;
	private Boolean acceptedByAdmin;
	private Boolean rejectedByAdmin;
	private List<String> roles;

	public JwtResponse(String accessToken,Long id, String firstname,
					   String lastname, String gender, String birthOfDate,
					   String district, String username, String email, String academicYear,
					   String facultyId, String departmentId, Boolean acceptedByAdmin,
					   Boolean rejectedByAdmin, List<String> roles) {
		this.token = accessToken;
		this.type = type;
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthOfDate = birthOfDate;
		this.district = district;
		this.username = username;
		this.email = email;
		this.academicYear = academicYear;
		this.facultyId = facultyId;
		this.departmentId = departmentId;
		this.acceptedByAdmin = acceptedByAdmin;
		this.rejectedByAdmin = rejectedByAdmin;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() { return firstname; }

	public void setFirstname(String firstname) { this.firstname = firstname; }

	public String getLastname() { return lastname; }

	public void setLastname(String lastname) { this.lastname = lastname; }

	public String getGender() { return gender; }

	public void setGender(String gender) { this.gender = gender; }

	public String getBirthOfDate() { return birthOfDate; }

	public void setBirthOfDate(String birthOfDate) { this.birthOfDate = birthOfDate; }

	public String getDistrict() { return district; }

	public void setDistrict(String district) { this.district = district; }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getAcademicYear() { return academicYear; }

	public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }

	public String getFacultyId() { return facultyId; }

	public void setFacultyId(String facultyId) { this.facultyId = facultyId; }

	public String getDepartmentId() { return departmentId; }

	public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

	public Boolean getAcceptedByAdmin() { return acceptedByAdmin; }

	public void setAcceptedByAdmin(Boolean acceptedByAdmin) { this.acceptedByAdmin = acceptedByAdmin; }

	public Boolean getRejectedByAdmin() { return rejectedByAdmin; }

	public void setRejectedByAdmin(Boolean rejectedByAdmin) { this.rejectedByAdmin = rejectedByAdmin; }

	public void setRoles(List<String> roles) { this.roles = roles; }

	public List<String> getRoles() {
		return roles;
	}
}

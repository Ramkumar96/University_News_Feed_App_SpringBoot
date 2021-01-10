package Sabra_Talkies.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	private String lastname;

	private String gender;

	private String birthOfDate;

	private String district;

	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@Size(max = 120)
	private String password;

	private String academicYear;

	private String facultyId ;

	private String departmentId;

	private Boolean acceptedByAdmin;

	private Boolean rejectedByAdmin;

	private String resetPasswordToken;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();


	public User() {
	}


	public User(String firstname, String lastname, String gender, String birthOfDate,
				String district,String username,String email,String password, String academicYear,
				String facultyId, String departmentId, Boolean acceptedByAdmin,
				Boolean rejectedByAdmin, String resetPasswordToken) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthOfDate = birthOfDate;
		this.district = district;
		this.username = username;
		this.email = email;
		this.password = password;
		this.academicYear = academicYear;
		this.facultyId = facultyId;
		this.departmentId = departmentId;
		this.acceptedByAdmin = acceptedByAdmin;
		this.rejectedByAdmin = rejectedByAdmin;
		this.resetPasswordToken = resetPasswordToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(String birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Boolean getAcceptedByAdmin() {
		return acceptedByAdmin;
	}

	public void setAcceptedByAdmin(Boolean acceptedByAdmin) {
		this.acceptedByAdmin = acceptedByAdmin;
	}

	public Boolean getRejectedByAdmin() {
		return rejectedByAdmin;
	}

	public void setRejectedByAdmin(Boolean rejectedByAdmin) {
		this.rejectedByAdmin = rejectedByAdmin;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}

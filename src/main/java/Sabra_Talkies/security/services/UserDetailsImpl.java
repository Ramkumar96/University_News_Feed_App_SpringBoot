package Sabra_Talkies.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Sabra_Talkies.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstname;

	private String lastname;

	private String gender;

	private String birthOfDate;

	private String district;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private String academicYear;

	private String facultyName;

	private String departmentName;

	private Boolean acceptedByAdmin;

	private Boolean rejectedByAdmin;

	private String resetPasswordToken;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String firstname, String lastname, String gender,
						   String birthOfDate, String district, String username, String email,
						   String password, String academicYear, String facultyName,
						   String departmentName, Boolean acceptedByAdmin, Boolean rejectedByAdmin,
						   String resetPasswordToken, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthOfDate = birthOfDate;
		this.district = district;
		this.username = username;
		this.email = email;
		this.password = password;
		this.academicYear = academicYear;
		this.facultyName = facultyName;
		this.departmentName = departmentName;
		this.acceptedByAdmin = acceptedByAdmin;
		this.rejectedByAdmin = rejectedByAdmin;
		this.resetPasswordToken = resetPasswordToken;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(),
				user.getFirstname(),
				user.getLastname(),
				user.getGender(),
				user.getBirthOfDate(),
				user.getDistrict(),
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(),
				user.getAcademicYear(),
				user.getFacultyName(),
				user.getDepartmentName(),
				user.getAcceptedByAdmin(),
				user.getRejectedByAdmin(),
				user.getResetPasswordToken(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() { return id; }

	public String getFirstname() { return firstname; }

	public String getLastname() { return lastname; }

	public String getGender() { return gender; }

	public String getBirthOfDate() { return birthOfDate; }

	public String getDistrict() { return district; }

	@Override
	public String getUsername() { return username; }

	public String getEmail() { return email; }

	@Override
	public String getPassword() { return password; }

	public String getAcademicYear() { return academicYear; }

	public String getFacultyName() {
		return facultyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Boolean getAcceptedByAdmin() { return acceptedByAdmin; }

	public Boolean getRejectedByAdmin() { return rejectedByAdmin; }

	public String getResetPasswordToken() { return resetPasswordToken;}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}

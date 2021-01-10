package Sabra_Talkies.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

    private String firstname;

    private String lastname;

    private String gender;

    private String birthOfDate;

    private String district;

    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String academicYear;

    private String facultyId ;

    private String departmentId;

    private Boolean acceptedByAdmin;

    private Boolean rejectedByAdmin;

    private String resetPasswordToken;
    
    private Set<String> role;


    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getBirthOfDate() { return birthOfDate; }

    public void setBirthOfDate(String birthOfDate) { this.birthOfDate = birthOfDate;}

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

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

    public String getResetPasswordToken() { return resetPasswordToken; }

    public void setResetPasswordToken(String resetPasswordToken) { this.resetPasswordToken = resetPasswordToken;}

    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}

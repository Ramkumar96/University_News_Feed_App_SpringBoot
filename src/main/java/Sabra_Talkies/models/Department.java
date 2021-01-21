package Sabra_Talkies.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(	name = "department")
public class Department {

    @Id
    private String departmentId;

    private String facultyId;

    private String departmentName;

    public Department() {
    }

    public Department(String departmentId, String facultyId, String departmentName) {
        this.departmentId = departmentId;
        this.facultyId = facultyId;
        this.departmentName = departmentName;

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}

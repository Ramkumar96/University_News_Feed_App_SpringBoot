package Sabra_Talkies.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {

    @Id
    private String facultyId;

    private String facultyName;

    public Faculty() {
    }

    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public String getFacultyId() { return facultyId; }

    public void setFacultyId(String facultyId) { this.facultyId = facultyId; }

    public String getFacultyName() { return facultyName; }

    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
}

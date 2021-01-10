package Sabra_Talkies.controllers;

import Sabra_Talkies.models.Department;
import Sabra_Talkies.models.Faculty;
import Sabra_Talkies.repository.DepartmentRepository;
import Sabra_Talkies.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/faculty")
public class FacultyContoller {

    @Autowired
    FacultyRepository facultyRepository;

    public FacultyContoller( FacultyRepository facultyRepository){
        super();
        this.facultyRepository = facultyRepository;
}

    @GetMapping("/allfaculties")
    public List<Faculty> getAllFaculties(){
        return facultyRepository.findAll();
    }
}

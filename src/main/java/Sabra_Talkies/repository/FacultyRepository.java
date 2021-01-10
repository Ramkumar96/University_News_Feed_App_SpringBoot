package Sabra_Talkies.repository;

import Sabra_Talkies.models.Department;
import Sabra_Talkies.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty , String> {

    Optional<Faculty> findById(String facultyId);
}

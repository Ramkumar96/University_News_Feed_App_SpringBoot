package Sabra_Talkies.repository;

import Sabra_Talkies.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , String> {

    Optional<Department> findById(String departmentId);
}

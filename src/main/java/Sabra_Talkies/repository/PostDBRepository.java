package Sabra_Talkies.repository;

import Sabra_Talkies.models.PostDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDBRepository extends JpaRepository<PostDB, String> {

}
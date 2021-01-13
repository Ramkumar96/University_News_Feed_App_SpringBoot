package Sabra_Talkies.repository;

import Sabra_Talkies.models.CommentDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentDB, String> {
}

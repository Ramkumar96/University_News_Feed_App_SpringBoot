package Sabra_Talkies.repository;

import Sabra_Talkies.models.LikesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikesDB, String> {
}

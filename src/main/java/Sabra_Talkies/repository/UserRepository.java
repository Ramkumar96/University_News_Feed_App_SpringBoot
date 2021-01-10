package Sabra_Talkies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sabra_Talkies.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	User findByEmail(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	public User findByResetPasswordToken(String token);
}

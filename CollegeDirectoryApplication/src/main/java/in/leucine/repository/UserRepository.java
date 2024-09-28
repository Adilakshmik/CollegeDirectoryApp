package in.leucine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.leucine.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);


}

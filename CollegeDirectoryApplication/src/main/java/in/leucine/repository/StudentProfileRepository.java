package in.leucine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.leucine.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long>{

}

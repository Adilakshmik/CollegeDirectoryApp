package in.leucine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.leucine.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	public List<Enrollment>findByStudent_StudentId(Long studentId);

}

package in.leucine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.leucine.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}

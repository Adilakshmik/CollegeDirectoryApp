package in.leucine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.leucine.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}

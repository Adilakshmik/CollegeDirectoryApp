package in.leucine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.leucine.dto.DepartmentDTO;
import in.leucine.entity.Department;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Add a new department
    public Department addDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setDepartmentId(departmentDTO.getDepartmentId());
        department.setName(departmentDTO.getName());
        return departmentRepository.save(department);
    }

    // Update an existing department
    public Department updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        department.setName(departmentDTO.getName());
        return departmentRepository.save(department);
    }

    // Delete a department
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        departmentRepository.delete(department);
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    }
}
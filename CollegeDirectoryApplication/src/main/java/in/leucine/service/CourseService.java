package in.leucine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.leucine.dto.CourseDTO;
import in.leucine.entity.Course;
import in.leucine.entity.Department;
import in.leucine.entity.FacultyProfile;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.CourseRepository;
import in.leucine.repository.DepartmentRepository;
import in.leucine.repository.FacultyProfileRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    // Create a new course
    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());

        // Fetch and set Department
        Department department = departmentRepository.findById(courseDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + courseDTO.getDepartmentId()));
        course.setDepartment(department);

        // Fetch and set FacultyProfile
        FacultyProfile facultyProfile = facultyProfileRepository.findById(courseDTO.getFacultyId())
                .orElseThrow(() -> new ResourceNotFoundException("Faculty member not found with ID: " + courseDTO.getFacultyId()));
        course.setFaculty(facultyProfile);

        return courseRepository.save(course);
    }

    // Get a course by ID
    public Course getCourse(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + courseId));
    }

    // Delete a course by ID
    public void deleteCourse(Long courseId) {
        Course course = getCourse(courseId); // This will throw ResourceNotFoundException if not found
        courseRepository.delete(course);
    }
}
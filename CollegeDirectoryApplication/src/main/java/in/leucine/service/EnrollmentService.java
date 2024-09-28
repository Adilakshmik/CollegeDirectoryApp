package in.leucine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.leucine.dto.EnrollmentDTO;
import in.leucine.entity.Course;
import in.leucine.entity.Enrollment;
import in.leucine.entity.StudentProfile;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.CourseRepository;
import in.leucine.repository.EnrollmentRepository;
import in.leucine.repository.StudentProfileRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentProfileRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Enroll a student in a course
    public Enrollment enrollStudent(EnrollmentDTO enrollmentDTO) {
        StudentProfile student = studentRepository.findById(enrollmentDTO.getStudentId())
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        
        Course course = courseRepository.findById(enrollmentDTO.getCourseId())
            .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        
        return enrollmentRepository.save(enrollment);
    }

    // Withdraw a student from a course
    public void withdrawStudent(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }

    // Get all enrollments for a specific student
    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudent_StudentId(studentId);
    }
}
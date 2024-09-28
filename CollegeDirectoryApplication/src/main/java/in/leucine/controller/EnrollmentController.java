package in.leucine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.leucine.dto.EnrollmentDTO;
import in.leucine.entity.Enrollment;
import in.leucine.service.EnrollmentService;

@RestController
@RequestMapping("/api/auth/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/student")
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentService.enrollStudent(enrollmentDTO);
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> withdrawStudent(@PathVariable Long studentId) {
        enrollmentService.withdrawStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        return ResponseEntity.ok(enrollments);
    }
}
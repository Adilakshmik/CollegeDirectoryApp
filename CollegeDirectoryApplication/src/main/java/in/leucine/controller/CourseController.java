package in.leucine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.leucine.dto.CourseDTO;
import in.leucine.entity.Course;
import in.leucine.service.CourseService;

@RestController
@RequestMapping("/api/auth/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

   
    @PostMapping
    @PreAuthorize("hasRole('FACULTY_MEMBER') or hasRole('ADMINISTRATOR')")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = courseService.createCourse(courseDTO);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

   
    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourse(@PathVariable Long courseId) {
        try {
            Course course = courseService.getCourse(courseId);
            return ResponseEntity.ok(course);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found with ID: " + courseId);
        }
    }

    
    @DeleteMapping("/{courseId}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        try {
            courseService.deleteCourse(courseId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
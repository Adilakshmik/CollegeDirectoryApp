package in.leucine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.leucine.dto.CourseDTO;
import in.leucine.dto.UserDTO;
import in.leucine.entity.Course;
import in.leucine.entity.User;
import in.leucine.service.AdministratorService;

@RestController
@RequestMapping("/api/auth/admin")
@PreAuthorize("hasRole('ADMINISTRATOR')")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    // Manage Users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        User user = administratorService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updatedUser = administratorService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        administratorService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = administratorService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Manage Courses
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        Course course = administratorService.createCourse(courseDTO);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        administratorService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    // Other management functions (departments, faculty, etc.)
}

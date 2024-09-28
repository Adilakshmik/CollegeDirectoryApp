package in.leucine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.leucine.dto.CourseDTO;
import in.leucine.dto.UserDTO;
import in.leucine.entity.Course;
import in.leucine.entity.User;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.CourseRepository;
import in.leucine.repository.UserRepository;

@Service
public class AdministratorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Create a new user (admin, faculty, student, etc.)
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());  // Normally, you'd hash the password
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());  // Update password after hashing
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new course
    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        return courseRepository.save(course);
    }

    // Delete a course
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        courseRepository.delete(course);
    }

    // Additional methods for managing departments, faculty, etc.
}


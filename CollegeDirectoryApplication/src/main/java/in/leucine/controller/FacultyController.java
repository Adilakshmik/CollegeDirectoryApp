package in.leucine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.leucine.dto.FacultyDTO;
import in.leucine.entity.FacultyProfile;
import in.leucine.entity.User;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.FacultyProfileRepository;
import in.leucine.repository.UserRepository;
import in.leucine.service.FacultyService;

@RestController
@RequestMapping("/api/auth/faculty")
public class FacultyController {
	
    @Autowired
    private FacultyService facultyService;
    
    @Autowired
    private FacultyProfileRepository facultyRepository;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public FacultyProfile addFaculty(FacultyDTO facultyDTO) {
        FacultyProfile faculty = new FacultyProfile();
        
        // Set fields from DTO
        faculty.setDepartment(facultyDTO.getDepartment());
        faculty.setOfficeHours(facultyDTO.getOfficeHours());
        faculty.setPhoto(facultyDTO.getPhoto());

        // Fetch the User entity based on userId
        User user = userRepository.findById(facultyDTO.getUserId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        faculty.setUser(user);

        // Save and return the faculty profile
        return facultyRepository.save(faculty);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyProfile> getFaculty(@PathVariable Long id) {
    	FacultyProfile faculty = facultyService.getFacultyById(id);
        return ResponseEntity.ok(faculty);
    }

    // Other methods (update, delete, list all faculty)
}


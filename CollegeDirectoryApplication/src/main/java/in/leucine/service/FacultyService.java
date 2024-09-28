package in.leucine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.leucine.dto.FacultyDTO;
import in.leucine.entity.FacultyProfile;
import in.leucine.exceptionhandler.ResourceNotFoundException;
import in.leucine.repository.FacultyProfileRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyProfileRepository facultyRepository;

    // Add a new faculty member
    public FacultyProfile addFaculty(FacultyDTO facultyDTO) {
        FacultyProfile faculty = new FacultyProfile();
        //faculty.setName(facultyDTO.getName());
        faculty.setDepartment(facultyDTO.getDepartment());
        // Set additional properties
        return facultyRepository.save(faculty);
    }

    // Update an existing faculty member
    public FacultyProfile updateFaculty(Long id, FacultyDTO facultyDTO) {
        FacultyProfile faculty = facultyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
        //faculty.setName(facultyDTO.getName());
        faculty.setDepartment(facultyDTO.getDepartment());
        // Update additional properties
        return facultyRepository.save(faculty);
    }

    // Delete a faculty member
    public void deleteFaculty(Long id) {
        FacultyProfile faculty = facultyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Faculty not found"));
        facultyRepository.delete(faculty);
    }

    // Get all faculty members
    public List<FacultyProfile> getAllFaculty() {
        return facultyRepository.findAll();
    }

	public FacultyProfile getFacultyById(Long id) {
		Optional<FacultyProfile> byId = facultyRepository.findById(id);
		FacultyProfile facultyProfile = byId.get();
		return facultyProfile;
	}
}
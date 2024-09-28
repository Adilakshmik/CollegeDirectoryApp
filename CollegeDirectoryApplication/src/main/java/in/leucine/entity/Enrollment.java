package in.leucine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name="studentId")
    private StudentProfile student;

    
    
    @ManyToOne
    @JoinColumn(name = "courseId")  // Optionally add join column name
    private Course course;

	
	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public StudentProfile getStudent() {
		return student;
	}

	public void setStudent(StudentProfile student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    
    


}

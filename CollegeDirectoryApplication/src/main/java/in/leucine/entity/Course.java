package in.leucine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name="departmentId")
	    private Department department;

	    @ManyToOne
	    @JoinColumn(name="facultyId")
	    private FacultyProfile faculty;
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public FacultyProfile getFaculty() {
			return faculty;
		}

		public void setFaculty(FacultyProfile faculty) {
			this.faculty = faculty;
		}
	    

}

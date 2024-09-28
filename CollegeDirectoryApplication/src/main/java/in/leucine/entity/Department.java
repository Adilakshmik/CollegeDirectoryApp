package in.leucine.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long departmentId;

	    private String name;
	    private String description;
	    
	    @OneToMany
		private List<StudentProfile> student;
	    @OneToMany
		private List<AdministratorProfile> admin;
	    @OneToMany
		private List<FacultyProfile> faculty;
	    @OneToMany
		private List<Course> course;
	    
		public Long getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    
	    

}

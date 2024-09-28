package in.leucine.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class FacultyProfile {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long facultyId;

	    @OneToOne
	    @JoinColumn(name = "userId")
	    private User user;

	    private String photo;
	    
	    @ManyToOne
	    @JoinColumn(name = "departmentId")
	    private Department department;
	    
	    @OneToMany(mappedBy = "faculty")
	    private List<Course> course;

	    

		public List<Course> getCourse() {
			return course;
		}

		public void setCourse(List<Course> course) {
			this.course = course;
		}

		private String officeHours;

		public Long getFacultyId() {
			return facultyId;
		}

		public void setFacultyId(Long facultyId) {
			this.facultyId = facultyId;
		}

		

		

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public String getOfficeHours() {
			return officeHours;
		}

		public void setOfficeHours(String officeHours) {
			this.officeHours = officeHours;
		}


}

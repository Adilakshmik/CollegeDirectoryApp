package in.leucine.dto;

public class CourseDTO {
	
	 private String title;
	    private String description;
	    private Long departmentId;
	    private Long facultyId;
	    
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
		public Long getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}
		public Long getFacultyId() {
			return facultyId;
		}
		public void setFacultyId(Long facultyId) {
			this.facultyId = facultyId;
		}

	    

}

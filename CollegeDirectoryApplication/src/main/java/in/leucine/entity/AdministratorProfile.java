package in.leucine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class AdministratorProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId; 

    private String photo; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department; 

    @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "userId")
    private User user; 

   

   public String getPhoto() {
        return photo;
    }

    public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

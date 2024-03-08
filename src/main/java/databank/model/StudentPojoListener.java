/********************************************************************************************************2*4*w*
 * File:  StudentPojoListener.java Course materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.model;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;



public class StudentPojoListener {
	@PrePersist
	// Called before persist to add the dates
	public void setCreatedOnDate(StudentPojo student) {
		LocalDateTime now = LocalDateTime.now();
		student.setCreated(now);
		student.setUpdated(now);
	}

	@PreUpdate
	// Called before update to update the date
	public void setUpdatedDate(StudentPojo student) {
		student.setUpdated(LocalDateTime.now());
	}

}

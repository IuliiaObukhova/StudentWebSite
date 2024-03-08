/********************************************************************************************************2*4*w*
 * File:  StudentPojo.java Course materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;


@ViewScoped
@Entity(name = "Student")
@Table(name = "student", catalog = "databank", schema = "")
@Access(AccessType.FIELD)
@EntityListeners({ StudentPojoListener.class }) // 17
@NamedQuery(name = StudentPojo.STUDENT_FIND_ALL, query = "SELECT s FROM Student s")
@NamedQuery(name = StudentPojo.STUDENT_FIND_ID, query = "SELECT s FROM Student s WHERE s.id = :param1")
public class StudentPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String STUDENT_FIND_ALL = "Student.findAll";
	public static final String STUDENT_FIND_ID = "Student.findById";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "last_name")
	private String lastName;
	@Basic
	@Column(name = "first_name")
	private String firstName;
	@Basic
	@Column(name = "email")
	private String email;
	@Basic
	@Column(name = "phone")
	private String phoneNumber;

	@Column(name = "created")
	private LocalDateTime created;

	@Column(name = "updated")
	private LocalDateTime updated;
	@Version
	private int version = 1;
	@Transient
	private boolean editable;
	@Basic
	@Column(name = "program")
	private String program;// 18.1

	public StudentPojo() {
		super();
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id new value for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the value for lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName new value for lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the value for firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName new value for firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		// Only include member variables that really contribute to an object's identity
		// i.e. if variables like version/updated/name/etc. change throughout an
		// object's lifecycle,
		// they shouldn't be part of the hashCode calculation
		return prime * result + Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		/*
		 * Enhanced instanceof - yeah! As of JDK 14, no need for additional 'silly'
		 * cast: if (animal instanceof Cat) { Cat cat = (Cat) animal; cat.meow(); //
		 * Other class Cat operations ... } Technically, 'otherStudentPojo' is a
		 * <i>pattern</i> that becomes an in-scope variable binding. Note: Need to watch
		 * out just-in-case there is already a 'otherStudentPojo' variable in-scope!
		 */
		if (obj instanceof StudentPojo otherStudentPojo) {
			// See comment (above) in hashCode(): compare using only member variables that
			// are
			// truly part of an object's identity.
			return Objects.equals(this.getId(), otherStudentPojo.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id = ").append(getId());
		if (getLastName() != null) {
			builder.append(", ").append("lastName = ").append(getLastName());
		}
		if (getFirstName() != null) {
			builder.append(", ").append("firstName = ").append(getFirstName());
		}
		if (getPhoneNumber() != null) {
			builder.append(", ").append("phoneNumber = ").append(getPhoneNumber());
		}
		if (getEmail() != null) {
			builder.append(", ").append("email = ").append(getEmail());
		}
		if (getCreated() != null) {
			builder.append(", ").append("created = ").append(getCreated());
		}
		if (getUpdated() != null) {
			builder.append(", ").append("updated = ").append(getUpdated());
		}
		if (getProgram() != null) {
			builder.append(",").append("program =").append(getProgram());
		}
		builder.append("]");
		return builder.toString();
	}

}

package databank.ejb;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import databank.model.StudentPojo;

@Singleton
public class StudentService {
	@PersistenceContext(name = "PU_DataBank")
	protected EntityManager em; // connects Java to the database

	public List<StudentPojo> readAll() {

		// Use the named JPQL query from the StudentPojo class to grab all the students
		TypedQuery<StudentPojo> allStudentsQuery = em.createNamedQuery(StudentPojo.STUDENT_FIND_ALL, StudentPojo.class);
		// Execute the query and return the result/s.
		return allStudentsQuery.getResultList();

	}
	@Transactional
	public StudentPojo create(StudentPojo student) {

		// *03
		em.persist(student);
		return student;
	}

	public StudentPojo readById(int studentId) {

		// *03
		return em.find(StudentPojo.class, studentId);
	}
	@Transactional
	public StudentPojo update(StudentPojo studentWithUpdates) {
		//if (readById(studentWithUpdates.getId())==null) {
		//return null;
		//}
		// *03
		try {
		StudentPojo mergedStudentPojo = em.merge(studentWithUpdates);
		
		return mergedStudentPojo;
		}
		catch (OptimisticLockException e) {
			return null;
		}
	}
	@Transactional
	public void delete(int studentId) {
		StudentPojo student = readById(studentId);
		if (student != null) {
			em.refresh(student);
			em.remove(student);
		}
	}
}

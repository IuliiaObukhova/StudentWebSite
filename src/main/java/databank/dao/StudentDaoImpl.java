/********************************************************************************************************2*4*w*
 * File:  StudentDaoImpl.java Course materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databank.ejb.StudentService;
import databank.model.StudentPojo;

/**
 * Description: Implements the C-R-U-D API for the database
 * 
 */
@Named
@ApplicationScoped
public class StudentDaoImpl implements StudentDao, Serializable {
	/** explicitly set serialVersionUID */
	private static final long serialVersionUID = 1L;

	// Get the log4j2 logger for this class
	private static final Logger LOG = LogManager.getLogger();


	@EJB
	protected StudentService studentService;

	@Override
	public List<StudentPojo> readAllStudents() {
		LOG.debug("reading all students");

		return studentService.readAll();
	}

	
	//@Transactional
	@Override
	public StudentPojo createStudent(StudentPojo student) {
		LOG.debug("creating a student = {}", student);

		return studentService.create(student);
	}

	@Override
	public StudentPojo readStudentById(int studentId) {
		LOG.debug("read a specific student = {}", studentId);

		return studentService.readById(studentId);
	}

	//@Transactional
	@Override
	public StudentPojo updateStudent(StudentPojo studentWithUpdates) {
		LOG.debug("updating a specific student = {}", studentWithUpdates);

		return studentService.update(studentWithUpdates);
	}

	//@Transactional
	@Override
	public void deleteStudentById(int studentId) {
		LOG.debug("deleting a specific studentID = {}", studentId);
		
		LOG.debug("deleting a specific student = {}", studentId);
		studentService.delete(studentId);
	}

}

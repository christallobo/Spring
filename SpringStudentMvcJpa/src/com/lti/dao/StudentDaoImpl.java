package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	private EntityManager entityMangaer;
	public StudentDaoImpl(){
		entityMangaer=JpaUtils.getEntityManager();
	}
	
	@Override
	public int createStudent(Student student) {
		entityMangaer.getTransaction().begin();
		entityMangaer.persist(student);
		entityMangaer.getTransaction().commit();
		return 1;
	}

	@Override
	public Student readStuentByRollNumber(int rollNumber) {
		return entityMangaer.find(Student.class,rollNumber);
	
	}

	@Override
	public int updateStudent(Student student) {
		
		return 0;
	}

	@Override
	public int deleteStudentByRollNumber(int rollNumber) {
		
		
		return 0;
	}

	@Override
	public List<Student> AllStudents() {
		String jpql="From Student";
		TypedQuery<Student> tquery=entityMangaer.createQuery(jpql,Student.class);
		return tquery.getResultList();
	}

}

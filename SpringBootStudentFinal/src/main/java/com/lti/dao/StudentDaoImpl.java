package com.lti.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	@PersistenceContext
	private EntityManager entityMangaer;
	public StudentDaoImpl(){
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int createStudent(Student student) {
		entityMangaer.persist(student);
		return 1;
	}

	@Override
	public Student readStuentByRollNumber(int rollNumber) {
		return entityMangaer.find(Student.class,rollNumber);
	
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateStudent(Student student) {
		String q="update Student s set s.studentName='"+student.getStudentName()+"',s.studentScore="
				+student.getStudentScore()+"where s.rollNumber="+student.getRollNumber();
		Query query=entityMangaer.createQuery(q);
		return query.executeUpdate();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteStudentByRollNumber(int rollNumber) {
		
		//int result=entityMangaer.remove();
		String q="Delete from Student s where s.rollNumber=:rollNumber";
		Query query=entityMangaer.createQuery(q);
		query.setParameter("rollNumber", rollNumber);
		int result = query.executeUpdate();
		entityMangaer.clear();
		return result;
	}
	
	
	@Override
	public void beginTransaction(){
	
	}
	
	@Override
	public void commitTransaction(){
		
	}
	@Override

	public void rollBackTransaction(){
		entityMangaer.getTransaction().rollback();
	}

	@Override
	public List<Student> AllStudents() {
		String jpql="From Student";
		TypedQuery<Student> tquery=entityMangaer.createQuery(jpql,Student.class);
		return tquery.getResultList();
	}
	

	
}

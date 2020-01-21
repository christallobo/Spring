package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		String q="update Student s set s.studentName='"+student.getStudentName()+"',s.studentScore="
				+student.getStudentScore()+"where s.rollNumber="+student.getRollNumber();
		Query query=entityMangaer.createQuery(q);
		return query.executeUpdate();
	}

	@Override
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
		entityMangaer.getTransaction().begin();
	}
	
	@Override
	public void commitTransaction(){
		entityMangaer.getTransaction().commit();
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

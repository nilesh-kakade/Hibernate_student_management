package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Student;

public class Studentdao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveStudent(Student s1) {
		entityTransaction.begin();
		entityManager.persist(s1);
		entityTransaction.commit();
		System.out.println("All good");
		
		
		
	}

	public Student getStudent(int id) {
		return entityManager.find(Student.class,id);
	}

	public void getAllStudent() {
		String sql = "Select s From Student s";

		Query query = entityManager.createQuery(sql);

		List<Student> students = query.getResultList();

		for (Student s : students) {
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getEmail());
		}
	}

	public void updateStudent(int id) {
		Student s1 = entityManager.find(Student.class,id);

		if (s1 != null) {
			s1.setName("manoj");
			s1.setEmail("manoj@gmail.com");
			entityTransaction.begin();
			entityManager.merge(s1);
			entityTransaction.commit();

		} else {
			System.out.println("Entity not found");

		}
		

	}

	public void deleteStudent(int id) {
		Student s1 = entityManager.find(Student.class, id);

		entityTransaction.begin();
		entityManager.remove(s1);
		entityTransaction.commit();
	}
}

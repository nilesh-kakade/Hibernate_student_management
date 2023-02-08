package com.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dao.Studentdao;
import com.jsp.dto.Student;

public class TestStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(null);
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

// create 
		Student s1=new Student();
		s1.setId(1);
		s1.setName("nilesh");
		s1.setEmail("nilesh@gmail.com");
//		
		Studentdao studentdao=new Studentdao();
		studentdao.saveStudent(s1);

//get students
		int id = 1;
//		Student s1 = studentdao.getStudent(id);
//		System.out.println(s1.getId());
//		System.out.println(s1.getEmail());
//		System.out.println(s1.getName());
//		
//update students
//		int id = 1;
//		studentdao.updateStudent(id);
		
//delete student
//		int id = 1;
//		studentdao.deleteStudent(id);
		
//get All students
//		studentdao.getAllStudent();
		

	}

}

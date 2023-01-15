package com.ty.one_to_one_person_pancard_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_person_pancard_uni.dto.Person;
import com.ty.one_to_one_person_pancard_uni.dto.Pancard;



public class PersonCRUD {
		
		public EntityManager getEntityManager() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			return entityManagerFactory.createEntityManager();
			
		}

		
		public void savePerson(Person person) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			entityTransaction.begin();
			Pancard pancard=person.getPancard();
			
			entityManager.persist(pancard);
			entityManager.persist(person);
			entityTransaction.commit();
			System.out.println("Inserted Successfully");
		
		}
		
		public void updatePerson(int id, String name  ) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Person person=entityManager.find(Person.class, id);
			
			if(person!=null) {
			person.setName(name);

			
			entityTransaction.begin();
			Pancard pancard=person.getPancard();
			pancard.setName(name);
			
			entityManager.merge(pancard);
			entityManager.merge(person);
			entityTransaction.commit();
			System.out.println("Updated Successfully");
			}
			else {
				System.out.println("id not present");
			}
		}
		
		public void deletePerson(int id) {
			EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Person person=entityManager.find(Person.class, id);
			
			if(person!=null) {
			entityTransaction.begin();
			Pancard pancard=person.getPancard();
			
			entityManager.remove(pancard);
			entityManager.remove(person);
			
			entityTransaction.commit();
			System.out.println("deleted Successfully");
			}
			else {
				 System.out.println("the id is not present");
			}
			
			
		}
		
		public Person getPersonById(int id) {
			EntityManager entityManager=getEntityManager();
			Person person=entityManager.find(Person.class, id);
			return person;
			
		}
		
		public List<Person> getAllPerson(){
			EntityManager entityManager=getEntityManager();
			Query query=entityManager.createQuery("select p from Person p");
			List<Person> list=query.getResultList();
			return list;
		}

}

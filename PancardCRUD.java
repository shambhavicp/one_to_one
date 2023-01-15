package com.ty.one_to_one_person_pancard_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_person_pancard_uni.dto.Pancard;
import com.ty.one_to_one_person_pancard_uni.dto.Person;

public class PancardCRUD {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		
	}


	public void savePancard(Pancard pancard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();

		entityManager.persist(pancard);
		
		entityTransaction.commit();
		System.out.println("Inserted Successfully");
	
	}
	
	public void updatePancard(int pid, String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Pancard pancard=entityManager.find(Pancard.class, pid);
		
		if(pancard!=null) {
		pancard.setName(name);
		
		entityTransaction.begin();
		
		entityManager.merge(pancard);
		
		entityTransaction.commit();
		
		System.out.println("Updated Successfully");
		}
		else {
			System.out.println("pancard id not present");
		}
	}
	
	public void deletePancard(int pid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Pancard pancard=entityManager.find(Pancard.class, pid);
		
		if(pancard!=null) {
		entityTransaction.begin();
		
		entityManager.remove(pancard);
		
		entityTransaction.commit();
		System.out.println("deleted Successfully");
		}
		else {
			 System.out.println("the pancard id is not present");
		}
		
		
	}
	
	public Pancard getPancardByPanId(int pid) {
		EntityManager entityManager=getEntityManager();
		Pancard pancard=entityManager.find(Pancard.class, pid);
		return pancard;
		
	}
	
	public List<Pancard> getAllPancard(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Pancard p");
		List<Pancard> list=query.getResultList();
		return list;
	}

	

}

package com.ty.one_to_one_person_pancard_uni.controller;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.one_to_one_person_pancard_uni.dao.PancardCRUD;
import com.ty.one_to_one_person_pancard_uni.dao.PersonCRUD;
import com.ty.one_to_one_person_pancard_uni.dto.Pancard;
import com.ty.one_to_one_person_pancard_uni.dto.Person;


public class PersonPancardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		
		Person person=new Person();
		Pancard pancard=new Pancard();
		PancardCRUD pancardcrud =new PancardCRUD();
		PersonCRUD personcrud=new PersonCRUD();
		
		
		Scanner scanner=new Scanner(System.in);
		boolean exit =true;
		do {
			System.out.println(" To which table u want to perform CRUD operation \n 1.Person \n 2.Pancard \n 3.exit");
			System.out.println("Enter your choice ");
			int choice=scanner.nextInt();
			
			switch(choice) {
			
			case 1:{
				boolean exits =true;
				
				do {
				System.out.println("Which Operation u want to perform ");
				System.out.println(" 1.Insert data \n 2.Update data \n 3.Delete data \n 4.Get the Person data by id \n 5.Get all data \n 6.Exit ");
				System.out.println("Enter your choice ");
				int choice1=scanner.nextInt();
				
				switch(choice1) {
				
				case 1:{
					System.out.println("Enter the id");
					int id =scanner.nextInt();
					
					System.out.println("Enter the name");
					String name=scanner.next();
					
					System.out.println("Enter the phone");
					long phone=scanner.nextLong();
					
					System.out.println("Enter the address");
					String address=scanner.next();
					
					
					person.setId(id);
					person.setName(name);
					person.setPhone(phone);
					person.setAddress(address);
					
					System.out.println("Enter PanCard Id");
					int pid=scanner.nextInt();
					
					System.out.println("Enter the Pancard name");
					String pancardName= scanner.next();
					
					System.out.println("Enter the address");
					String pancardAddress=scanner.next();
					
					
					pancard.setPid(pid);
					pancard.setName(pancardName);
					pancard.setAddress(pancardAddress);
					
					person.setPancard(pancard);
					
					personcrud.savePerson(person);
					
				}
				break;
				
				case 2:{
					
					System.out.println("Enter the id to be updated");
					int id =scanner.nextInt();
					
					System.out.println("Enter the name");
					String name=scanner.next();
					
		
					
					personcrud.updatePerson(id, name);
					
					
				}
				break;
				
				case 3:{
					System.out.println("Enter the id to be deleted");
					int id =scanner.nextInt();
					
					personcrud.deletePerson(id);
					
				}
				break;
				
				case 4:{
					System.out.println("Enter the id to get the details");
					int id =scanner.nextInt();
					
					System.out.println(personcrud.getPersonById(id));
					
				}
				break;
				
				case 5:{
					System.out.println(personcrud.getAllPerson()); 
				}
				break;
				
				case 6:{
					exits=false;
					System.out.println("Thank u");
					
				}
				break;
				
				default : System.out.println("Invalid choice");
				}
				
				}while(exits);
				
			}
			break;
			case 2:{
				boolean exits =true;
				
				do {
				System.out.println("Which Operation u want to perform ");
				System.out.println(" 1.Insert data \n 2.Update data \n 3.Delete data \n 4.Get the Person data by id \n 5.Get all data \n 6.Exit ");
				System.out.println("Enter your choice ");
				
				int choice1=scanner.nextInt();
				
				switch(choice1) {
				
				case 1:{
					
					System.out.println("Enter PanCard Id");
					int pid=scanner.nextInt();
					
					System.out.println("Enter the Pancard name");
					String pancardName= scanner.next();
					
					System.out.println("Enter the address");
					String pancardAddress=scanner.next();
					
					
					pancard.setPid(pid);
					pancard.setName(pancardName);
					pancard.setAddress(pancardAddress);
					
					pancardcrud.savePancard(pancard);
					
				}
				break;
				
				case 2:{
					
					System.out.println("Enter the pancard id to be updated");
					int pid =scanner.nextInt();
					
					System.out.println("Enter the name");
					String name=scanner.next();
					
					pancardcrud.updatePancard(pid, name);
					
					
				}
				break;
				
				case 3:{
					System.out.println("Enter the pancard id to be deleted");
					int pid =scanner.nextInt();
					
					pancardcrud.deletePancard(pid);
					
				}
				break;
				
				case 4:{
					System.out.println("Enter the pancard id to get the details");
					int pid =scanner.nextInt();
					
					System.out.println(pancardcrud.getPancardByPanId(pid));
					
				}
				break;
				
				case 5:{
					System.out.println(pancardcrud.getAllPancard()); 
				}
				break;
				
				case 6:{
					exits=false;
					System.out.println("Thank u");
					
				}
				break;
				
				default : System.out.println("Invalid choice");
				}
				
				}while(exits);
				
			}
			break;
			
			case 3:{
				exit=false;
				System.out.println("Thank you");
			}
			break;
			default : System.out.println("Invalid choice");
			
			}
			
		}while(exit);
		
		
	}

}

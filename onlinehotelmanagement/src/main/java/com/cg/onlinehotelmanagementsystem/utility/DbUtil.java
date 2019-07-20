package com.cg.onlinehotelmanagementsystem.utility;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class DbUtil {
  private static EntityManagerFactory entityManagerFactory=null;
  private static EntityManager entityManager=null;
	public static EntityManager getConnection() {
	  
	  if(entityManagerFactory==null) {
		  
		  entityManagerFactory=Persistence.createEntityManagerFactory("module");
		  entityManager=entityManagerFactory.createEntityManager();
		   }
	 
	 
	  return entityManager;
	  }

  }

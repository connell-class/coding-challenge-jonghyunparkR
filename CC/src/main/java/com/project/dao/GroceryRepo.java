package com.project.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.pojo.GroceryList;

@Transactional
@Repository
public class GroceryRepo {
		
	public GroceryRepo() {
		
	}
		
	  static {
	        try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	  
		@Autowired
		public GroceryRepo(SessionFactory sesFact) {
			super();
			this.sesFact = sesFact;
		}
		
	private SessionFactory sesFact;
	
	//insert GroceryList
	public void insertGL (GroceryList gl) {
		sesFact.getCurrentSession().save(gl);
	}
	//find all grocery list
	public List<GroceryList> allGL() {
		Session ses = sesFact.getCurrentSession();
		return ses.createQuery("from GroceryList", GroceryList.class).list();
	}
	
	//Delete Grocery List
    public void deleteGL (GroceryList gl) {
        
        sesFact.getCurrentSession().delete(gl);
    }
	

}

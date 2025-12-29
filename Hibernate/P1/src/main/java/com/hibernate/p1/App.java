package com.hibernate.p1;

//import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//creating student
    	Student st=new Student();
    	st.setId(101);
    	st.setName("ankit");
    	st.setCity("bhagalpur");
    	System.out.println(st);
    	
    	/*
    	Address ad=new Address();
    	ad.setStreet("street2");
    	ad.setCity("kolkata");
    	ad.setOpen(false);
    	ad.setAddedDate(new Date());
    	ad.setX(124.59);
    	
    	//reading image
    	FileInputStream fis=new FileInputStream("src/main/java/l13.jpg");
    	byte[] data=new byte[fis.available()];
    	fis.read(data);
    	ad.setImage(data);
    	fis.close();*/
    	
    	Session session = factory.openSession();
    	Transaction tx=session.beginTransaction();
    	session.save(st);
    	//session.save(ad);
    	tx.commit();
    	//session.getTransaction().commit();
    	session.close();
    }
}

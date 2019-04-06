package com.bk.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bk.Student.StudentEntity;

public class HiberClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Boolean flag = false;
		// create the Object of Configuration Class
		Configuration cfg = new Configuration();
		// get Session Factory Object
		cfg.configure("com/bk/config/HibernetConfig.xml");
		// build session Factory
		SessionFactory factory = cfg.buildSessionFactory();
		// Get Session Object
		Session ses = factory.openSession();
		StudentEntity ety = new StudentEntity();
		ety.setSNO(101);
		ety.setAddrs("Hyd");
		ety.setSname("Bika");
		try {
			tx = ses.beginTransaction();
			ses.save(ety);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Tx Commited");
			} else {
				tx.rollback();
				System.out.println("Tx-RollBack");
			}
			ses.close();
			factory.close();

		}

	}

}

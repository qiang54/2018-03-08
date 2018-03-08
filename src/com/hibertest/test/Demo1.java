package com.hibertest.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

/**
 * 测试：查询方式
 * @author qiang
 *
 */
public class Demo1 {

	/**
	 * 查询某个联系人属于哪个客户
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Linkman l = session.get(Linkman.class, 1L);
		System.out.println("---------------------");
		System.out.println(l.getCustomer().getCust_name());
		
		
		tr.commit();
	}
	/**
	 * 通过OID测试
	 */
	@Test
	public void run(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Customer c = session.get(Customer.class, 1L);
		System.out.println(c.getLinkmans().size());
		
		
		tr.commit();
	}
}

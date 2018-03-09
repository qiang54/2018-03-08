package com.hibertest.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

/**
	 * 演示HQL的基本查询
	 * @author Administrator
	 */
	public class Demo2 {
		
		/**
		 * HQL查询
		 * 1.inner join c.linkmans//JavaBean 中set集合
		 * 2.HQL返回值Object[]数组
		 * 3.inner join fetch c.linkmans 即可封装对象//fetch 迫切连接
		 */
		@Test
		public void run1(){
			Session session = HibernateUtils.getCurrentSession();
			Transaction tr = session.beginTransaction();
			List<Customer> list = session.createQuery("from Customer c inner join fetch c.linkmans").list();
			
			//必须手动解决
			Set<Customer> set = new HashSet<>(list);
			for (Customer customer : set) {
				System.out.println(customer);
			}
			/*List<Object[]> list = session.createQuery("from Customer c inner join c.linkmans").list();
			
			for (Object[] objects : list) {
				System.out.println(Arrays.toString(objects));
			}
*/			tr.commit();
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

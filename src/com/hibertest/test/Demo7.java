package com.hibertest.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.uitls.HibernateUtils;

/**
 * 鏌ヨ鐨勭瓥鐣�
 * @author Administrator
 */
public class Demo7 {
	
	/**
	 * fetch:subselect  閲囩敤瀛愭煡璇㈢殑鏂瑰紡
	 * lazy:false  涓嶅欢杩熷姞杞�
	 */
	@SuppressWarnings("all")
	@Test
	public void run6(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getLinkmans().size());
		}
		tr.commit();
	}
	
	/**
	 * fetch:subselect  閲囩敤瀛愭煡璇㈢殑鏂瑰紡
	 * lazy:true  榛樿寤惰繜鍔犺浇
	 */
	@SuppressWarnings("all")
	@Test
	public void run5(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer").list();
		for (Customer customer : list) {
			System.out.println(customer.getLinkmans().size());
		}
		tr.commit();
	}
	
	/**
	 * fetch鏄細join	閲囩敤鐨勮揩鍒囧乏杩炴帴杩涜鐨勬煡璇�
	 * lazy锛氫粈涔堟槸鍊硷紝閮芥槸涓�鏍风殑鏁堟灉
	 */
	@Test
	public void run4(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍏堟煡璇�1鍙峰鎴�
		Customer c1 = session.get(Customer.class, 1L);
		// 鐪嬪鎴蜂笅鎵�鏈夌殑鑱旂郴浜�
		System.out.println(c1.getLinkmans().size());
		tr.commit();
	}
	
	/**
	 * fetch鏄細select 榛樿鐨凷QL璇彞鏍煎紡
	 * lazy:extra 鍙婂叾鐨� 寤惰繜鍔犺浇
	 */
	@Test
	public void run3(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍏堟煡璇�1鍙峰鎴�
		Customer c1 = session.get(Customer.class, 1L);
		// 鐪嬪鎴蜂笅鎵�鏈夌殑鑱旂郴浜�
		System.out.println(c1.getLinkmans().size());
		tr.commit();
	}
	
	/**
	 * fetch鏄細select 榛樿鐨凷QL璇彞鏍煎紡
	 * lazy:false 涓嶅欢杩熷姞杞�
	 */
	@Test
	public void run2(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍏堟煡璇�1鍙峰鎴�
		Customer c1 = session.get(Customer.class, 1L);
		// 鐪嬪鎴蜂笅鎵�鏈夌殑鑱旂郴浜�
		System.out.println(c1.getLinkmans().size());
		tr.commit();
	}
	
	/**
	 * 榛樿鍊硷細fetch鏄細select lazy:true
	 */
	@Test
	public void run1(){
		// 鏌ヨ瀹㈡埛
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍏堟煡璇�1鍙峰鎴�
		Customer c1 = session.get(Customer.class, 1L);
		// 鐪嬪鎴蜂笅鎵�鏈夌殑鑱旂郴浜�
		System.out.println(c1.getLinkmans().size());
		tr.commit();
	}
}

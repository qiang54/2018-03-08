package com.hibertest.test;

import java.util.List;

import org.hibernate.Query;
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
	 * 投影查询
	 * javaBean提供相应的构造方法
	 * 必须自己创建相应无参构造方法
	 * HQL语句变化
	 */
	@Test
	public void run6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query qr = session.createQuery("select new Linkman(lkm_name,lkm_gender) from Linkman ");
		
	     
		List<Linkman> list = qr.list();
		for (Linkman linkman : list) {
			System.out.println(linkman.toString());
		}
		tr.commit();
	}
	/**
	 * 按条件查询
	 * setParameter(int ,object) 通用查询方法
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query qr = session.createQuery("from Linkman l where l.lkm_id > ?");
		
	     //qr.setString(0, "男");	//从0开始，注意
	     //qr.setString("gender", "女");//:gender 为占位符，相当于？
		//qr.setLong(0, 2L);
		
		qr.setParameter(0, 2L);
	     
		List<Linkman> list = qr.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		tr.commit();
	}
	/**
	 * f分页查询
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Query qr = session.createQuery("from Linkman ");
		
		//
		/*qr.setFirstResult(0);//从第一页开始
		qr.setMaxResults(3);//每页显示3条数据
*/		
		qr.setFirstResult(3);//从第2页开始
		qr.setMaxResults(3);
		
		List<Linkman> list = qr.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		tr.commit();
	}
	/**
	 * 有别名的方式
	 * c为Customer 的别名，
	 * order by 属性 asc/desc
	 * HQL不可出现*
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		List<Customer> list = session.createQuery("from Customer c order by c.cust_id desc").list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tr.commit();
	}
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

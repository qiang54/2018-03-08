package com.hibertest.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.uitls.HibernateUtils;

/**
 * HQL鐨勫琛ㄧ殑鏌ヨ
 * @author Administrator
 */
public class Demo5 {
	
	/**
	 * 鏁版嵁鐨勯噸澶嶇殑闂
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍐呰繛鎺ョ殑鏌ヨ
		Query query = session.createQuery("from Customer c inner join fetch c.linkmans");
		// 榛樿鐨勮繑鍥炲�兼槸鏁扮粍
		List<Customer> list = query.list();
		// 鎵嬪姩瑙ｅ喅锛岀紪绋嬩腑閮戒娇鐢ㄨ繖绉嶆柟寮忚В鍐抽噸澶嶇殑闂
		Set<Customer> set = new HashSet<Customer>(list);
		for (Customer customer : set) {
			System.out.println(customer);
		}
		tr.commit();
	}
	
	/**
	 * 鏁版嵁榛樿杩斿洖鐨勬暟缁勶紝鎶婃暟鎹皝瑁呭埌瀵硅薄涓�
	 * 鎻愪緵鍏抽敭瀛楋細fetch 杩垏杩炴帴锛屼娇鐢╢etch鍏抽敭瀛楋紝鎶婃暟鎹皝瑁呭埌瀵硅薄涓�
	 */
	@Test
	public void run2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍐呰繛鎺ョ殑鏌ヨ
		Query query = session.createQuery("from Customer c inner join fetch c.linkmans");
		// 榛樿鐨勮繑鍥炲�兼槸鏁扮粍
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tr.commit();
	}
	
	/**
	 * 鏌ヨ鐨勫鎴凤紝瀹㈡埛鍜岃仈绯讳汉鏈夊叧鑱斿晩
	 * select * from cst_customer c,cst_linkman l where c.id = l.id;
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍐呰繛鎺ョ殑鏌ヨ
		Query query = session.createQuery("from Customer c inner join c.linkmans");
		// 榛樿鐨勮繑鍥炲�兼槸鏁扮粍
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		tr.commit();
	}

}

package com.hibertest.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibertest.domain.Linkman;
import com.hibertest.uitls.HibernateUtils;

/**
 * SQL鐨勬煡璇㈢殑鏂瑰紡
 * @author Administrator
 */
public class Demo4 {
	
	/**
	 * 鎶婃暟鎹皝瑁呭埌瀵硅薄涓�
	 */
	@Test
	public void run2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍒涘缓鐨勬槸SQL鐨勬煡璇㈢殑鎺ュ彛
		SQLQuery query = session.createSQLQuery("select * from cst_linkman");
		// 閫氳繃鏂规硶璁剧疆
		query.addEntity(Linkman.class);
		List<Linkman> list = query.list();
		for (Linkman linkman : list) {
			System.out.println(linkman);
		}
		
		tr.commit();
	}
	
	/**
	 * 娴嬭瘯SQL璇彞鐨勬煡璇�
	 */
	@Test
	public void run1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		// 鍒涘缓鐨勬槸SQL鐨勬煡璇㈢殑鎺ュ彛
		SQLQuery query = session.createSQLQuery("select * from cst_linkman");
		// 鏌ヨ鏁版嵁
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		tr.commit();
		
	}

}

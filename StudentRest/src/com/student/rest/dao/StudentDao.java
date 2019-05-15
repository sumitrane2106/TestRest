package com.student.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.rest.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveStudent(StudentBean s){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public StudentBean getStudentById(Integer id){
		Session session = sessionFactory.openSession();
		StudentBean data = (StudentBean)session.get(StudentBean.class, id);
		return data;		
	}
	
	public List<StudentBean> load(){
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from StudentBean");
		List<StudentBean> list = q.list();
		return list;
		
	}
	
	public List<StudentBean> getDetails(String cl,String name){
		Session session = sessionFactory.openSession();
		Criteria crt=session.createCriteria(StudentBean.class);
		crt.add(Restrictions.eq(cl, name));
		List<StudentBean> list = crt.list();
		return list;
		
	}
	public StudentBean getDetailsById(String cl,Integer id){
		Criteria crt = sessionFactory.openSession().createCriteria(StudentBean.class);
		crt.add(Restrictions.eq(cl, id));
		StudentBean details= (StudentBean)crt.list();
		return details;
		
	}
}

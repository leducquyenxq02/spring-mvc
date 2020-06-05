package com.edu.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.User;


@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public void update(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public User getUser(String userName) {
		final Session session = sessionFactory.openSession();
		final User user = (User) session.get(User.class, userName);
		session.close();
		return user;
	}

	public void delete(User user) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(User.class).list();
		session.close();
		return list;
	}

	public List<User> getUser(String userName, String password) {
		final Session session = sessionFactory.openSession();
		//câu lệnh này là dùng câu lệnh nguyên thủy. nếu thay đổi tên table là die  query. nên đổi sang hql
		//final String query = "select * from user where userName= :user_name and password= :pass";
		final String hql = "FROM User U where U.userName= :user_name and U.pass= :pass";
		
		Query query = session.createQuery(hql);
		query.setParameter("user_name", userName);
		query.setParameter("pass", password);
		final List list = query.list();
		session.close();
		return list;
	}
}

package com.edu.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.Department;

@Repository
public class DepartmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Department department) throws Exception {
		Session session = null;
		Transaction beginTransaction = null;
		try {
			session = sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			session.save(department);
			beginTransaction.commit();
		} catch (final Exception e) {
			if (beginTransaction != null) {
				beginTransaction.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void update(Department department) throws Exception {
		Session session = null;
		Transaction beginTransaction = null;
		try {
			session = sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			session.update(department);
			beginTransaction.commit();
		} catch (final Exception e) {
			if (beginTransaction != null) {
				beginTransaction.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartment(int departmentId) {
		final Session session = sessionFactory.openSession();
		final Department department = (Department) session.get(Department.class, departmentId);
		session.close();
		return department;
	}

	public void delete(Department department) {
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(department);
		session.getTransaction().commit();
		session.close();
	}

	public List<Department> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(Department.class).list();
		session.close();
		return list;
	}
}

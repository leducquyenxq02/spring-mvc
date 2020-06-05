package com.edu.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Employee getEmployee(int id) {
		final Session session = sessionFactory.openSession();
		final Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}

	public void delete(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Employee> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(Employee.class).list();
		session.close();
		return list;
	}
	
	public List<Employee> getEmplyeeByDepartment(String department) {
		final Session session = sessionFactory.openSession();
		final String query = "select * from employee where departmentId= :departmentId";
		final SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setString("catalogue", department);
		final List list = sqlQuery.list();
		session.close();
		System.out.println(list);
		return list;
	}
	
	public List<Employee> search(String name) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = session.createCriteria(Employee.class);
		createCriteria.add(Restrictions.eqOrIsNull("name", name));
		final List list = createCriteria.list();
		session.close();
		return list;
	}
}

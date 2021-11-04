package com.springboot.demo.employee.dao;

import com.springboot.demo.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;


    @Override

    public List<Employee> findall() {
        // get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Create query
        Query<Employee> theQuery = currentSession.createQuery("from Employee",
                Employee.class);


        return theQuery.getResultList();
    }

    @Override

    public Employee find(int Eid) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, Eid);
    }

    @Override

    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);


    }

    @Override

    public void delete(int Eid) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where id=:employeeID");
        query.setParameter("employeeID", Eid);

        query.executeUpdate();

    }
}
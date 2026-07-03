package com.example.employee.service;

import com.example.employee.model.Employee;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateEmployeeService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    /**
     * Method to CREATE an employee in the database using native Hibernate Session.
     * Shows the boilerplate transaction, session opening, error handling, and closing.
     */
    public Integer addEmployee(Employee employee) {
        // Manually opening the Hibernate Session
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        Transaction tx = null;
        Integer employeeID = null;

        try {
            // Begin transaction
            tx = session.beginTransaction();
            
            // Persist the entity
            session.persist(employee);
            
            // Commit transaction
            tx.commit();
            
            employeeID = employee.getId();
        } catch (Exception e) {
            // Rollback on failure
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Always close session
            if (session.isOpen()) {
                session.close();
            }
        }
        return employeeID;
    }
}

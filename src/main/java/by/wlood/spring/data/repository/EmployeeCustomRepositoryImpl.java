package by.wlood.spring.data.repository;

import by.wlood.spring.data.model.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findByFirstnameOrLastname(String firstname, String lastname) {
        String queryStr = "SELECT e FROM Employee e WHERE e.firstname = :firstname OR e.lastname = :lastname";
        TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }
}

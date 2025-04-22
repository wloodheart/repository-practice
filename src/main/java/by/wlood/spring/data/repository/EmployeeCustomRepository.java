package by.wlood.spring.data.repository;

import by.wlood.spring.data.model.entity.Employee;

import java.util.List;

public interface EmployeeCustomRepository {
    List<Employee> findByFirstnameOrLastname(String firstname, String lastname);
}

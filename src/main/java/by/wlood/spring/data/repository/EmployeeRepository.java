package by.wlood.spring.data.repository;

import by.wlood.spring.data.model.entity.Department;
import by.wlood.spring.data.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstname(String firstname);

    List<Employee> findByLastname(String lastname);

    List<Employee> findByFirstnameAndLastname(String firstname, String lastname);

    Optional<Employee> findByEmail(String email);

    List<Employee> findAllByDepartment(Department department);

}

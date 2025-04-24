package by.wlood.spring.data.repository;

import by.wlood.spring.data.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentQueryRepository extends JpaRepository<Department, Long> {

    @Query("SELECT e FROM Department e JOIN FETCH e.employees WHERE e.id = :id")
    List<Department> queryById(@Param("id") Long id);

    @Query("SELECT e FROM Department e JOIN FETCH e.employees WHERE e.name = :name")
    List<Department> queryByName(@Param("name") String name);

}

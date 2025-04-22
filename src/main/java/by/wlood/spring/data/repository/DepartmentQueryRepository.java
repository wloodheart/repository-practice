package by.wlood.spring.data.repository;

import by.wlood.spring.data.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentQueryRepository extends JpaRepository<Department, Long> {

    @Query("SELECT e FROM Department e JOIN FETCH e.relatedEntities WHERE e.id = :id")
    Optional<Department> queryById(@Param("id") Long id);

    @Query("SELECT e FROM Department e JOIN FETCH e.relatedEntities WHERE e.name = :name")
    Optional<Department> queryByName(@Param("name") String name);

}

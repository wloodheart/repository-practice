package by.wlood.spring.data.service.impl;

import by.wlood.spring.data.model.entity.Department;
import by.wlood.spring.data.repository.DepartmentQueryRepository;
import by.wlood.spring.data.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentQueryRepository departmentQueryRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentQueryRepository departmentQueryRepository) {
        this.departmentQueryRepository = departmentQueryRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentQueryRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentQueryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentQueryRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department existing = getDepartmentById(id);
        existing.setName(department.getName());
        return departmentQueryRepository.save(existing);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentQueryRepository.deleteById(id);
    }
}


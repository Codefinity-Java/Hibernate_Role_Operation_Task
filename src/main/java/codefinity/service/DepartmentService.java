package codefinity.service;

import codefinity.model.Department;

import java.util.List;

public interface DepartmentService {
    Department add(Department department);

    Department getById(int id);

    String getDepartmentNameById(int id);

    List<Department> getAll();
}

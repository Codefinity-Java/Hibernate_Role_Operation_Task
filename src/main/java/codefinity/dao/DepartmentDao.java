package codefinity.dao;

import codefinity.model.Department;

import java.util.List;

public interface DepartmentDao {
    Department add(Department department);

    Department getById(int id);

    List<Department> getAll();
}

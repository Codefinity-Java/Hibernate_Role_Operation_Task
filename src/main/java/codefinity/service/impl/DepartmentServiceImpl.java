package codefinity.service.impl;

import codefinity.dao.DepartmentDao;
import codefinity.dao.impl.DepartmentDaoImpl;
import codefinity.model.Department;
import codefinity.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public Department add(Department department) {
        return departmentDao.add(department);
    }

    @Override
    public Department getById(int id) {
        Department department = departmentDao.getById(id);
        if (department != null) {
            return departmentDao.getById(id);
        } else {
            throw new NoSuchElementException("Can't get department by ID " + id);
        }
    }

    @Override
    public String getDepartmentNameById(int id) {
        Department department = getById(id);
        String departmentName = department.getName();
        if (departmentName != null) {
            return departmentName;
        } else {
            throw new NullPointerException("The department's name is null, " +
                    "or there is no name for an department with ID " + id);
        }
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }
}

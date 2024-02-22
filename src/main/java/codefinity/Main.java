package codefinity;

import codefinity.model.Department;
import codefinity.service.DepartmentService;
import codefinity.service.EmployeeService;
import codefinity.service.impl.DepartmentServiceImpl;
import codefinity.service.impl.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();

        Department department = departmentService.getById(2);

        System.out.println("Before: " + employeeService.getById(2));

        employeeService.setDepartmentById(2, department);

        System.out.println("After: " + employeeService.getById(2));
    }
}

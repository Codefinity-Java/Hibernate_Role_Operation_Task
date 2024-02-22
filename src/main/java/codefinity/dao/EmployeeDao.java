package codefinity.dao;

import codefinity.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {
    Employee add(Employee employee);

    Employee getById(int id);

    List<Employee> getEmployeesHiredInASpecificTimeframe(Date startDate, Date endDate);

    List<Employee> getAll();

    List<Employee> getEmployeesWithSalaryMoreThan(Double salary);

    Employee setDepartmentById(int employeeId, int departmentId);
}

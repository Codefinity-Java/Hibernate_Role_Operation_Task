package codefinity.service.impl;

import codefinity.dao.EmployeeDao;
import codefinity.dao.impl.EmployeeDaoImpl;
import codefinity.model.Department;
import codefinity.model.Employee;
import codefinity.model.Role;
import codefinity.service.DepartmentService;
import codefinity.service.EmployeeService;
import codefinity.service.RoleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    private final DepartmentService departmentService = new DepartmentServiceImpl();

    private final RoleService roleService = new RoleServiceImpl();

    @Override
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee getById(int id) {
        Employee employee = employeeDao.getById(id);
        if (employee != null) {
            return employeeDao.getById(id);
        } else {
            throw new NoSuchElementException("Can't get employee by ID " + id);
        }
    }

    @Override
    public String getEmployeeNameById(int id) {
        Employee employee = getById(id);
        String employeeName = employee.getName();
        if (employeeName != null) {
            return employeeName;
        } else {
            throw new NullPointerException("The employee's name is null, " +
                    "or there is no name for an employee with ID " + id);
        }
    }

    @Override
    public List<Employee> getEmployeesHiredInASpecificTimeframe(String startDate, String endDate) {
        LocalDate from = dateParser(startDate);
        LocalDate to = dateParser(endDate);
        return employeeDao.getEmployeesHiredInASpecificTimeframe(from, to);
    }

    @Override
    public List<String> getEmployeesNamesHiredInASpecificTimeframe(String startDate, String endDate) {
        List<Employee> employees = getEmployeesHiredInASpecificTimeframe(startDate, endDate);
        return employees.stream().map(Employee::getName).toList();
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> getEmployeesWithSalaryMoreThan(Double salary) {
        return employeeDao.getEmployeesWithSalaryMoreThan(salary);
    }

    @Override
    public Employee setDepartmentById(int employeeId, int departmentId) {
        return employeeDao.setDepartmentById(employeeId, departmentId);
    }

    @Override
    public Employee setDepartmentById(int employeeId, Department department){
        if (department == null) {
            throw new NullPointerException("The department is null!");
        }
        List<Department> departments = departmentService.getAll();
        if (departments.contains(department)) {
            int departmentId = department.getId();
            return setDepartmentById(employeeId, departmentId);
        } else {
            throw new NoSuchElementException("No such department found in the database!");
        }
    }

    @Override
    public Employee setRoleById(int employeeId, int roleId) {
        return null;
    }

    @Override
    public Employee setRoleById(int employeeId, Role role) {
        return null;
    }


    private LocalDate dateParser(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}

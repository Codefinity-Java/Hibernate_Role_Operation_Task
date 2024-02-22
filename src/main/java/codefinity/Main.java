package codefinity;

import codefinity.model.Department;
import codefinity.model.Employee;
import codefinity.model.Role;
import codefinity.service.DepartmentService;
import codefinity.service.EmployeeService;
import codefinity.service.RoleService;
import codefinity.service.impl.DepartmentServiceImpl;
import codefinity.service.impl.EmployeeServiceImpl;
import codefinity.service.impl.RoleServiceImpl;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        RoleService roleService = new RoleServiceImpl();

        Department marketing = new Department();
        marketing.setLocation("Head Office");
        marketing.setName("Marketing");
        departmentService.add(marketing);

        Department it = new Department();
        it.setName("Development");
        it.setLocation("IT Office");
        departmentService.add(it);

        Role marketer = new Role();
        marketer.setName("Marketing Specialist");
        marketer.setDescription("A dynamic role focused on developing and implementing strategies to promote brand " +
                "awareness and drive product sales. Responsibilities include market research, content creation, " +
                "and campaign management to enhance engagement and achieve business goals.");
        roleService.add(marketer);

        Role developer = new Role();
        developer.setName("Software Engineer");
        developer.setDescription("A software engineer writes and maintains " +
                "the code for computer applications and systems.");
        roleService.add(developer);

        Employee john = new Employee();
        john.setName("John");
        john.setSalary(55000.00);
        john.setHireDate(LocalDate.of(2021, 10, 5));
        john.setDepartment(marketing);
        employeeService.add(john);

        employeeService.setRoleById(1, 1);

        Employee bob = new Employee();
        bob.setName("Bob");
        bob.setSalary(70000.00);
        bob.setDepartment(it);
        bob.setHireDate(LocalDate.of(2022, 2, 18));

        Role bobsRole = roleService.getById(2);
        bob.setRole(bobsRole);

        employeeService.add(bob);

        System.out.println(employeeService.getAll());
    }
}

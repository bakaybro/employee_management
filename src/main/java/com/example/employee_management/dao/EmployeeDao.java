package com.example.employee_management.dao;

import com.example.employee_management.pojo.Department;
import com.example.employee_management.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> employeeMap = null;

    static {
        employeeMap = new HashMap<>();

        employeeMap.put(1001,new Employee(1001,"a","123@123.com",1,new Department(101,"Управление образования")));
        employeeMap.put(1002,new Employee(1002,"b","234@123.com",1,new Department(101,"Отдел маркетинга")));
        employeeMap.put(1003,new Employee(1003,"c","345@123.com",1,new Department(101,"Учебно-исследовательский отдел")));
        employeeMap.put(1004,new Employee(1004,"d","456@123.com",1,new Department(101,"Операции")));
        employeeMap.put(1005,new Employee(1005,"e","567@123.com",1,new Department(101,"Отдел логистики")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    public void deleteEmployeeById(Integer id) {
        employeeMap.remove(id);
    }
}

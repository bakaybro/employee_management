package com.example.employee_management.dao;

import com.example.employee_management.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<>();

        departmentMap.put(101, new Department(101, "Управление образование"));
        departmentMap.put(102, new Department(102, "Отдел маркетинга"));
        departmentMap.put(103, new Department(103, "Учебно-иследовательский отдел"));
        departmentMap.put(104, new Department(104, "Операции"));
        departmentMap.put(105, new Department(105, "Отдел логистики"));
    }

    public Collection<Department> getAllDepartments() {
        return departmentMap.values();
    }

    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }
}

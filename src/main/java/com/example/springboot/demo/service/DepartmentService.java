package com.example.springboot.demo.service;

import com.example.springboot.demo.entity.Department;
import com.example.springboot.demo.errors.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department udpateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
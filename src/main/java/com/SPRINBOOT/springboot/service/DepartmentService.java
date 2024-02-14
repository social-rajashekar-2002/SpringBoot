package com.SPRINBOOT.springboot.service;

import java.util.List;

import com.SPRINBOOT.springboot.Error.DepartmentNotFoundException;
import com.SPRINBOOT.springboot.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    Department fetchDataById(Long departmrntId)throws DepartmentNotFoundException;

    void DeleteDataById(Long departmrntId);

    Department UpdateDataPut(Long departmentId, Department department);

    Department ReturnDepByName(String departName);

    List<Department> SortByName();


    
}

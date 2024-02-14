package com.SPRINBOOT.springboot.service;

import java.util.Optional;
import java.util.List;
import java.util.Objects;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SPRINBOOT.springboot.Error.DepartmentNotFoundException;
import com.SPRINBOOT.springboot.entity.Department;
import com.SPRINBOOT.springboot.repository.DepartmentRepo;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;

    @SuppressWarnings("null")
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Department fetchDataById(Long departmrntId) throws DepartmentNotFoundException {
        Optional<Department> object = departmentRepo.findById(departmrntId);
        //findbyid returns optional use get for value

        if(!object.isPresent()){
            throw new DepartmentNotFoundException("department not found .. .. .. ..");
        }
        return object.get();
    }

    @Override
    public void DeleteDataById(Long departmrntId) {
        departmentRepo.deleteById(departmrntId);
        //returns null
    }

    @Override
    public Department UpdateDataPut(Long departmentId, Department department) {
        Department object=departmentRepo.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartName()) && !"".equalsIgnoreCase(department.getDepartName())){
            object.setDepartName(department.getDepartName());
        }

        if(Objects.nonNull(department.getDepartemntAddress()) && !"".equalsIgnoreCase(department.getDepartemntAddress())){
            object.setDepartemntAddress(department.getDepartemntAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            object.setDepartmentCode(department.getDepartmentCode());
        }

        System.out.println(department);
        return departmentRepo.save(object);

    }

    @Override
    public Department ReturnDepByName(String departName) {
        return departmentRepo.findByDepartName(departName);
    }

    @Override
    public List<Department> SortByName() {
        return departmentRepo.findAllByOrderByDepartName();
    }
    
}

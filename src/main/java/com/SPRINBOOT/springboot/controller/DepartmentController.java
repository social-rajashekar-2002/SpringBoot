package com.SPRINBOOT.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SPRINBOOT.springboot.Error.DepartmentNotFoundException;
import com.SPRINBOOT.springboot.entity.Department;
import com.SPRINBOOT.springboot.service.DepartmentService;

// import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private Logger logger=LogManager.getLogger(DepartmentController.class);
    
    @PostMapping("/department")
    public Department savDepartment(@Valid @RequestBody Department department){
        logger.info("post request is here ... ");
        logger.error("something has happend .. .. ");
        return departmentService.saveDepartment(department);
    }
    
    @GetMapping("/department")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmrntId) throws DepartmentNotFoundException{
        return departmentService.fetchDataById(departmrntId);
    }

    @DeleteMapping("/department/{id}")
    public List<Department> DeleteDepartmentById(@PathVariable("id") Long departmrntId){
        departmentService.DeleteDataById(departmrntId);
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/department/{id}")
    public Department UpdateData(@PathVariable("id") Long departmentId, @RequestBody Department department){
            return departmentService.UpdateDataPut(departmentId,department);
    }

    @GetMapping("/department/name/{name}")
    public Department FetchDepByDepName(@PathVariable("name") String departName){
        return departmentService.ReturnDepByName(departName);
    }

    @GetMapping("/department/sort")
    public List<Department> SortByName(){
        return departmentService.SortByName();
    } 
}
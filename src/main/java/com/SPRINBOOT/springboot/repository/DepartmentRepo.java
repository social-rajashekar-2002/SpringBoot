package com.SPRINBOOT.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SPRINBOOT.springboot.entity.Department;
import java.util.List;



@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    //pass entity and type of id 
    public Department findByDepartName(String departmenName);
    public Department findByDepartNameIgnoreCase(String departmenName);
    public List<Department> findAllByOrderByDepartName();
    public Department findByDepartmentId(Long departmrntId);

}

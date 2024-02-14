package com.SPRINBOOT.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.SPRINBOOT.springboot.entity.Department;

@DataJpaTest
public class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo repo;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp(){
        Department department=Department.builder()
                            .departName("civil")
                            .departemntAddress("vidyanagar")
                            .departmentCode("5978")
                            .departmentId(1)
                            .build();

        entityManager.persist(department);

        
    }


    @Test
    @Disabled
    public void returnDepartmentByIdTest(){

        Long id=1l;
        Department object=repo.findById(id).get();
        assertEquals(object.getDepartName(),"civil");


    }

}

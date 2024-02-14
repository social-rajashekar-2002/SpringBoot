package com.SPRINBOOT.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.SPRINBOOT.springboot.entity.Department;
import com.SPRINBOOT.springboot.repository.DepartmentRepo;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepartmentServiceImplementation object;

    @MockBean
    private DepartmentRepo repo;

    @BeforeEach
    void setUp(){
        Department test_dept_object=Department.builder()
                                    .departName("IT")
                                    .departemntAddress("vidyanagar")
                                    .departmentCode("")
                                    .departmentId(687)
                                    .build();

        Mockito.when(repo.findByDepartName("IT")).thenReturn(test_dept_object);

    }


    @Test
    @DisplayName("Get data based on valid department name")
    @Disabled
    public void test_Department_by_name_method(){

        String str="IT";

        Department dept_object=object.ReturnDepByName(str);

        assertEquals(str,dept_object.getDepartName());
        verify(repo, times(1)).findByDepartName(str);
    }
}

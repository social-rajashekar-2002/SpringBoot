package com.SPRINBOOT.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.SPRINBOOT.springboot.entity.Department;
import com.SPRINBOOT.springboot.service.DepartmentService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department=new Department();

    @BeforeEach
    void setUp() {
        // You don't need to instantiate Department here anymore
        Department department = Department.builder()
        .departName("it")
        .departemntAddress("hubli")
        .departmentCode("31")
        .build();

    }

    @Test
    void testSavDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departName("wivil")
                .departemntAddress("bangalore")
                .departmentCode("it-06")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departName\": \"wivil\",\n" +
                        "    \"departemntAddress\": \"bangalore\",\n" +
                        "    \"departmentCode\": \"it-06\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void testFetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDataById(1L)).thenReturn(department);

        mockMvc.perform(get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departName").value(department.getDepartName()));
    }

    @Test
    void testFetchDepartmentList() {
        // Implement this test
    }
}

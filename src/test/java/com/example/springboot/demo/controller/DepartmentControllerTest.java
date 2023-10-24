package com.example.springboot.demo.controller;

import com.example.springboot.demo.entity.Department;
import com.example.springboot.demo.errors.DepartmentNotFoundException;
import com.example.springboot.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentId(1L)
                .departmentName("Mechanical")
                .departmentAddress("Mumbai")
                .departmentCode("MECH-02")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentName("Mechanical")
                .departmentAddress("Mumbai")
                .departmentCode("MECH-02")
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);

        mockmvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"Mechanical\",\n" +
                        "\t\"departmentAddress\":\"Mumbai\",\n" +
                        "\t\"departmentCode\":\"MECH-02\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockmvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}
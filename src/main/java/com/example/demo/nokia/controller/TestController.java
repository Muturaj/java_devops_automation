package com.example.demo.nokia.controller;

import com.example.demo.nokia.dto.Employee;
import com.example.demo.nokia.entity.EmployeeEntity;
import com.example.demo.nokia.repo.TestRepo;
import com.example.demo.nokia.request.EmployeeRequest;
import com.example.demo.nokia.response.MessageResponse;
import com.example.demo.nokia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.Query;

//@RequiredArgsConstructor
@RestController
public class TestController {

    @Autowired
    private  EmployeeService employeeService;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private  TestRepo testRepo;

    @PostMapping("/saveEmployee")
    public com.example.demo.nokia.jpastuff.Employee saveEmployee(@RequestBody com.example.demo.nokia.jpastuff.Employee employee) {
        return employeeService.saveEmpAddressDetails(employee);

    }

    @GetMapping("/getEmployee/{emp_id}")
     public com.example.demo.nokia.jpastuff.Employee getEmployee(@PathVariable String emp_id) {
        Query q = entityManager.createNativeQuery("SELECT emp_name FROM employee_table where emp_id = ?1").setParameter(1,emp_id);
        String result= (String) q.getSingleResult();
        System.out.println("result response: "+result);
        return employeeService.getEmployyeDetailsFromDB(emp_id);

     }

    @GetMapping("/employee")
    public Employee demoCheck() {
        Employee employee=   employeeService.getEmployeeinfo();
        return employee;
    }

    @PostMapping(value = "/employee",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE},produces =  { MediaType.APPLICATION_JSON_VALUE} )
    public MessageResponse saveEmployee(@RequestPart(value ="employeeData",required = true) EmployeeRequest employeeData, MultipartFile employeefile) {
         Employee employeeinfo = employeeService.getEmployeeinfo();
        EmployeeEntity e=  employeeService.saveEmployeeDetails(employeeinfo,employeefile);
        return MessageResponse.builder().message("Successfully saved").httpStatus(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
        EmployeeEntity dbFile = employeeService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFilename() + "\"")
                .body(new ByteArrayResource(dbFile.getEmployeedata()));
    }

}

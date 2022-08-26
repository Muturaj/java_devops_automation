package com.example.demo.nokia.service;

import com.example.demo.nokia.dto.Employee;
import com.example.demo.nokia.entity.EmployeeEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface EmployeeService {
    Employee getEmployeeinfo();

    EmployeeEntity saveEmployeeDetails(Employee employeeinfo, MultipartFile m);

    EmployeeEntity getFile(Long fileId);

    com.example.demo.nokia.jpastuff.Employee saveEmpAddressDetails(com.example.demo.nokia.jpastuff.Employee employee);

    com.example.demo.nokia.jpastuff.Employee getEmployyeDetailsFromDB(String emp_id);
}

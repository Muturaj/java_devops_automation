package com.example.demo.nokia.repo;

import com.example.demo.nokia.jpastuff.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAddressRepo extends JpaRepository<Employee,String> {
    Employee findByEmpId(String emp_id);
}

package com.example.demo.nokia.repo;

import com.example.demo.nokia.jpastuff.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Employee,String> {

    @Query(value = "SELECT emp_name FROM employee_table u WHERE  u.emp_id ='1'", nativeQuery = true)
    String findusersFromempTable();


}

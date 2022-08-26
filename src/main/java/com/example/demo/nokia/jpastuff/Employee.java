package com.example.demo.nokia.jpastuff;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    @Column(name = "emp_id", unique = true)
    private String empId;

    @Column(name = "EMP_NAME",length = 100)
    private String empName;

    @Column(name = "EMP_PHONE_NUMBER",length =10 )
    private long empPhoneNumber;

    @Column(name = "EMP_DOB")
    @JsonDeserialize
    @JsonSerialize
    private LocalDateTime dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "EMP_EMAIL",length = 100)
    private String email;

   // @JoinColumn(name = "emp_id",nullable = false,updatable = false)
   // @OneToMany(cascade = CascadeType.ALL)
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private List<Address> empAddress;




}
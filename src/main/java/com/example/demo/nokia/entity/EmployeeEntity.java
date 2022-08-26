package com.example.demo.nokia.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "employee")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String  url;
    private String text;
    @Lob
    private byte[] employeedata;
    private String filetype;
    private String filename;

}

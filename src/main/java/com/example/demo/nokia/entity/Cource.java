package com.example.demo.nokia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COURSE_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cource {

    @Id
    @GeneratedValue
    private Long id;
    private String c_name;
    private String c_branc;
    private String c_address;
    @ManyToMany(mappedBy = "cource",fetch = FetchType.LAZY)
    private Set<Student> students;
}

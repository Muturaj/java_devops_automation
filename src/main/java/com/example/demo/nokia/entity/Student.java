package com.example.demo.nokia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENT_TBL")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String roll_number;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TBL",joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    })
    private Set<Cource> cource;
}

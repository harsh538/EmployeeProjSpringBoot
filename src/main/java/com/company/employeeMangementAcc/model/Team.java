package com.company.employeeMangementAcc.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="Team")
public class Team {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "teamId")
    private Integer teamId;
    @Column(name="TeamName")
    private String teamName;
//    @OneToMany(mappedBy = "team")
//    private List<Employee> employees;

}

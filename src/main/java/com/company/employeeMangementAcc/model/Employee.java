package com.company.employeeMangementAcc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teamId")
    private Team team;
}

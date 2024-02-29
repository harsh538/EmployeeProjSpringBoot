package com.company.employeeMangementAcc.service;

import com.company.employeeMangementAcc.EmployeeController;
import com.company.employeeMangementAcc.model.Employee;
import com.company.employeeMangementAcc.model.Team;
import com.company.employeeMangementAcc.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
//    @Autowired
    private final EmployeeRepo emp;
    private static final Logger logger = LogManager.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepo emp) {
        this.emp = emp;
    }

    public Employee save(Employee e){
////        System.out.println(e.getTeam().getTeamName());
////        Employee existingEntity= emp.findByTeamTeamName(e.getTeam().getTeamName());
//////        System.out.println(existingEntity.getTeam().getTeamName());
////        if(existingEntity!=null){
////            e.setTeam(existingEntity.getTeam());
////        }
        return emp.save(e);
    }
//    public Employee saveEmployeeWithTeam(Employee e){
//        return emp.saveEmployeeWithTeam(e);
//    }


    public Employee findByTeamTeamName(String name){
        logger.info("EmployeeService.findByTeamTeamName name [{}]", name);
        return emp.findByTeamTeamName(name);
    }

    public List<Employee> findAll(){
        logger.info("Hello world");
        logger.warn("warning");
        return emp.findAll();
    }

    public void deleteByTeamIsNull(){
        emp.deleteByTeamIsNull();
    }

    public Integer deleteByFirstName(String name){
        return emp.deleteByFirstName(name);
    }



}

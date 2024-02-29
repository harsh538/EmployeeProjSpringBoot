package com.company.employeeMangementAcc;

import com.company.employeeMangementAcc.model.Employee;
import com.company.employeeMangementAcc.model.Team;
import com.company.employeeMangementAcc.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void myMethod() {
        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");
        System.out.println("Hello harshad Task1");
        System.out.println("Task2");
    }

    @PostMapping(value="/save",consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e){
        Employee e1 = employeeService.save(e);
        return new ResponseEntity<Employee>(e1, HttpStatus.OK);
    }

    @GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<List<Employee>>(employeeService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteByTeamNull")
    public ResponseEntity<String> deleteByTeamIsNull(){
        employeeService.deleteByTeamIsNull();
        return new ResponseEntity<String>("Null Teams deleted Successfully",HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteByFirstName/{name}")
    public ResponseEntity<String> deleteByFirstName(@PathVariable("name") String name){
        Integer a= employeeService.deleteByFirstName(name);
        return new ResponseEntity<String>("Total Employee Deleted : "+ a,HttpStatus.OK);
    }
    @GetMapping(value="/getByTeamName/{teamName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> findByTeamTeamName(@PathVariable("teamName") String teamName){
        return new ResponseEntity<>(employeeService.findByTeamTeamName(teamName), HttpStatus.OK);
    }
}

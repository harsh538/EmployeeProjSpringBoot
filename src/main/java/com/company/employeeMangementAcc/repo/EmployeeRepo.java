package com.company.employeeMangementAcc.repo;

import com.company.employeeMangementAcc.model.Employee;
import com.company.employeeMangementAcc.model.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee save(Employee e);

//     default Employee saveEmployeeWithTeam(Employee employee) {
//      // Save the employee
//      Employee savedEmployee = save(employee);
//
//      // Save the associated team
//      Team team = savedEmployee.getTeam();
//      if (team != null) {
//       team.getEmployees().add(savedEmployee);
//       savedEmployee.setTeam(team);
//      }
//
//      return savedEmployee;
//     }

     List<Employee> findAll();

     @Transactional
     Employee findByTeamTeamName(String teamName); //findByTeamName

     @Transactional
     void deleteByTeamIsNull();

     @Transactional
     Integer deleteByFirstName(String firstName);
}

package com.hando.adm.controller;

import com.hando.adm.dto.Employee;
import com.hando.adm.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee-registry/")
public class MainController {

    @Autowired
    EmployeeRepository employeeService;

    @PostMapping(value = {"create","update"})
    public ResponseEntity createEmployee(@RequestBody  @Validated Employee employee){
        employeeService.addOrUpdateEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @PostMapping(value = "delete")
    public ResponseEntity removeEmployee(@RequestBody long employeeId){
        employeeService.removeEmployee(employeeId);
        return ResponseEntity.ok(employeeId);
    }

    @GetMapping(value = "info/{employeeId}", produces = "application/json")
    public ResponseEntity showEmployeeInfo(@PathVariable long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeInfo(employeeId));
    }

    @GetMapping(value = "employeeList/{supervisorId}", produces = "application/json")
    public ResponseEntity showEmployeeList(@PathVariable long supervisorId){
        return ResponseEntity.ok(employeeService.getEmployeesBySupervisor(supervisorId));
    }
}

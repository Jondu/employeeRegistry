package com.hando.adm.controller;

import com.hando.adm.dto.Employee;
import com.hando.adm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee-registry/")
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = {"create","update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createEmployee(@RequestBody  @Validated Employee employee){
        employeeService.addOrUpdateEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity removeEmployee(@RequestBody long employeeId){
        employeeService.removeEmployee(employeeId);
        return ResponseEntity.ok(employeeId);
    }

    @RequestMapping(value = "info", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity showEmployeeInfo(@RequestParam long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeInfo(employeeId));
    }

    @RequestMapping(value = "employeeList", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity showEmployeeList(@RequestParam long supervisorId){
        return ResponseEntity.ok(employeeService.getEmployeesBySupervisor(supervisorId));
    }
}

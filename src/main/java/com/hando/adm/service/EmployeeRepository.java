package com.hando.adm.service;

import com.hando.adm.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private static final String UPDATE = "MERGE INTO employees KEY (id) VALUES (?,?,?,?)";
    private static final String GET_INFO = "SELECT * FROM employees WHERE id= ?";
    private static final String DELETE = "DELETE FROM employees WHERE id= ?";
    private static final String GET_BY_SUPERVISOR =
            "SELECT employees.id,employees.firstname,employees.lastname,employees.jobname " +
                    "from employees " +
                    "inner join relation on relation.employee_id = employees.id " +
                    "where relation.supervisor_id = ?;";

    public void addOrUpdateEmployee(Employee employee) {
        jdbcTemplate.update(UPDATE,
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getJobName()
        );
    }


    public void removeEmployee(long id) {
        jdbcTemplate.update(DELETE, id);
    }

    public Employee getEmployeeInfo(long id) {
        return jdbcTemplate.queryForObject(GET_INFO,
                new Object[]{id},
                (rs, rowNum) -> {
                    Employee employee = makeEmployee(rs);
                    return employee;
                });
    }

    public List<Employee> getEmployeesBySupervisor(long id) {
        return jdbcTemplate.query(GET_BY_SUPERVISOR,
                new Object[]{id},
                (rs, rowNum) -> {
                    Employee employee = makeEmployee(rs);
                    return employee;
                });
    }

    private Employee makeEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFirstName(rs.getString("firstname"));
        employee.setLastName(rs.getString("lastname"));
        employee.setJobName(rs.getString("jobname"));
        return employee;
    }

}

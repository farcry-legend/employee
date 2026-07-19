package com.deepak.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

@RestController
public class EmpController {

    List<Employee> employees = new ArrayList<>();

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {

        return employees;
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Saved Successfully";
    }

    @PutMapping("employees")
    public String updateEmployee(@RequestBody Employee employee) {
        for (Employee emp : employees) {
            if (emp.getName().equals(employee.getName())) {
                emp.setPhone(employee.getPhone());
                emp.setEmail(employee.getEmail());
                return "Updated Successfully";
            }
        }
        return "Employee not found";
    }

    @PatchExchange("employees")
    public static String patchEmployee(EmpController empController, @RequestBody Employee employee) {
        for (Employee emp : empController.employees) {
            if (emp.getName().equals(employee.getName())) {
                if (employee.getPhone() != null) {
                    emp.setPhone(employee.getPhone());
                }
                if (employee.getEmail() != null) {
                    emp.setEmail(employee.getEmail());
                }
                return "Patched Successfully";
            }
        }
        return "Employee not found";
    }

    @DeleteMapping("employees")
    public String deleteEmployee(@RequestBody Employee employee) {
        for (Employee emp : employees) {
            if (emp.getName().equals(employee.getName())) {
                employees.remove(emp);
                return "Deleted Successfully";
            }
        }
        return "Employee not found";
    }

}

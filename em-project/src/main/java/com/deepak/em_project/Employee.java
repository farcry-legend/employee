package com.deepak.em_project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String phone;
    private String email;

}

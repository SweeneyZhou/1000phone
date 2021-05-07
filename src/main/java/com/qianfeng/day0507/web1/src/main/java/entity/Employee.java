package entity;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;
    private Integer salary;
    private Double comm;
    private Integer managerId;
    private String departmentName;
    private String pic;
}
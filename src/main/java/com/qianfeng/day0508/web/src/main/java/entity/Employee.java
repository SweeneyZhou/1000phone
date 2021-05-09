package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author sweeney 2021/5/9 18:36
 */
@Data
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Integer salary;
    private Double comm;
    private Integer managerId;
    private Integer departmentId;
    private String pic;

    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String jobId, Integer salary, Double comm, Integer managerId, Integer departmentId, String pic) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.comm = comm;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.pic = pic;
    }
}

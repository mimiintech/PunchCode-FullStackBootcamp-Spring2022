package com.techelevator;

public class Employee {

<<<<<<< HEAD

    //  name class and access level
//   instance variables/attributes

    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;


//    create a  constructor with 4 arguments/parameters

    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {

        this.firstName = firstName;
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

//    create getter(s) and setter(s)
    public int getEmployeeId() {return  employeeId;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getFullName() {return lastName + ", " + firstName;}
    //    derived attribute <<fullName>> returns lastName, firstName

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public double getAnnualSalary() {return annualSalary;}


    //    create method to increase <<raiseSalary>>

    public void raiseSalary(double percentage) {
    double raiseAmount = annualSalary * Math.abs(percentage / 100.00);
    annualSalary += raiseAmount;
    }
}
=======
}
>>>>>>> upstream/main

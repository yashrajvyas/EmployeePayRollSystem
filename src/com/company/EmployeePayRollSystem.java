package com.company;

import java.util.ArrayList;

abstract class Employee45{
    private String name;
    private int id;

    public Employee45(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    abstract Double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name = " +name+ " id =" + id + "salary =" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee45{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, Double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public Double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee45{
    private int hoursWorked;
    private Double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, Double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public Double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

class PayRollSystem{
    private ArrayList<Employee45> employee45List;

    public PayRollSystem(){
        employee45List = new ArrayList<>();
    }

    public void addEmployee(Employee45 employee){
        employee45List.add(employee);
    }

    public void removeEmployee(int id){
        Employee45 employeeToremove = null;
        for(Employee45 employee : employee45List){
            if(employee.getId() == id){
                employeeToremove = employee;
                break;
            }
        }
        if (employeeToremove != null){
            employee45List.remove(employeeToremove);
        }
    }

    public void displayEmployees(){
        for(Employee45 employee : employee45List){
            System.out.println(employee);
        }
    }
}
public class EmployeePayRollSystem{
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Dan", 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 40, 100.0);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Initial employee details.");
        payRollSystem.displayEmployees();
        System.out.println("Removing Employees.");
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining employees details.");
        payRollSystem.displayEmployees();
    }
}

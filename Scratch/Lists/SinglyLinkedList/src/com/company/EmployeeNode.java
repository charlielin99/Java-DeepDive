package com.company;

public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next; //next node in list

    public EmployeeNode(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public String toString(){
        return employee.toString();
    }

}


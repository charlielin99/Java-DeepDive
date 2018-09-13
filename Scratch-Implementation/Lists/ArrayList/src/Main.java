import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){

        //LIST declaration
        List<Employee> employeeList = new ArrayList<>();

        //ADD ITEMS
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));


        System.out.println(employeeList.get(1)); //GET accesses array
        System.out.println(employeeList.isEmpty()); //CHECKS if empty
        employeeList.set(2, new Employee("John", "Adams", 4568)); //REPLACES element
        employeeList.size(); //NUM items
        employeeList.add(2, new Employee("john", "doe", 23)); //ADD in between
        employeeList.remove(2);//REMOVE

        //checks true vs false
        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));

        //returns index of object
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));


        employeeList.forEach(employee -> System.out.println(employee)); //PRINTS
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author mf251
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String name, ManagerType managerType, DepartmentType department) {
        employees.add(new Employee(name, managerType, department));
        System.out.println("\nEmployee added successfully!");
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployeeFromInput(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("\nSelect Manager Type:");
        for (ManagerType m : ManagerType.values()) {
            System.out.println("- " + m);
        }

        ManagerType managerType = null;
        while (managerType == null) {
            System.out.print("Your choice: ");
            String input = scanner.nextLine().toUpperCase();
            try {
                managerType = ManagerType.valueOf(input);
            } catch (Exception e) {
                System.out.println("Invalid manager type. Try again.");
            }
        }

        System.out.println("\nSelect Department:");
        for (DepartmentType d : DepartmentType.values()) {
            System.out.println("- " + d);
        }

        DepartmentType department = null;
        while (department == null) {
            System.out.print("Your choice: ");
            String input = scanner.nextLine().toUpperCase();
            try {
                department = DepartmentType.valueOf(input);
            } catch (Exception e) {
                System.out.println("Invalid department. Try again.");
            }
        }

        addEmployee(name, managerType, department);
    }
}
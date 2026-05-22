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
import java.io.BufferedReader;
import java.io.FileReader;

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

    // ===== name validation =====
    String name;
    while (true) {
        System.out.print("Enter employee name: ");
        name = scanner.nextLine().trim();

        // only letter and spaces allowed
        if (name.matches("[a-zA-Z ]+")) {
            break;
        } else {
            System.out.println("Invalid name. Only letters and spaces are allowed.");
        }
    }

    // ===== MANAGER TYPE =====
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

    // ===== DEPARTMENT =====
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

    // ===== create employee =====
    addEmployee(name, managerType, department);

    System.out.println("\nEmployee added successfully:");
    System.out.println(name + " | " + managerType + " | " + department);
}

    // ============================================
    // LOAD EMPLOYEES FROM FILE (NEW METHOD)
    // ============================================
    public void loadEmployeesFromFile(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;
        while ((line = br.readLine()) != null) {

            // jump empty lines
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            // 9 columns
            if (parts.length < 6) {
                System.out.println("Invalid line format: " + line);
                continue;
            }

            // File Colunms:
            // 0 = First name
            // 1 = Last name
            // 2 = Gender
            // 3 = Email
            // 4 = Salary
            // 5 = Department
            // 6 = Position
            // 7 = Job title
            // 8 = Company

            String firstName = parts[0].trim();
            String lastName = parts[1].trim();
            String fullName = firstName + " " + lastName;

            String deptString = parts[5].trim().toUpperCase();

            DepartmentType dept;
            try {
                dept = DepartmentType.valueOf(deptString.replace(" ", "_"));
            } catch (Exception e) {
                System.out.println("Invalid department: " + deptString);
                continue;
            }

            // ManagerType by default
            ManagerType defaultManager = ManagerType.SUPERVISOR;

            Employee emp = new Employee(fullName, defaultManager, dept);
            employees.add(emp);
        }

        System.out.println("Employees loaded successfully from file.");

    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
}
}
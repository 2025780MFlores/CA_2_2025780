/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CA_2;
import java.util.Scanner;
import java.util.List;


/**
 *
 * @author mf251
 */
public class CA_2_SchoolSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        MenuOption option = null;

        do {
            System.out.println("\n===== SCHOOL MANAGEMENT SYSTEM =====");
            System.out.println("Please select an option:");

            for (MenuOption m : MenuOption.values()) {
                System.out.println("- " + m);
            }

            System.out.print("\nYour choice: ");
            String input = scanner.nextLine().toUpperCase();

            try {
                option = MenuOption.valueOf(input);
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            switch (option) {

                // ============================
                // SORT (MERGE SORT)
                // ============================
                case SORT:
                    if (service.getEmployees().isEmpty()) {
                        System.out.println("No employees to sort.");
                        break;
                    }

                    RecursiveMergeSort sorter = new RecursiveMergeSort();
                    List<Employee> sortedList = sorter.mergeSort(service.getEmployees());

                    System.out.println("\n===== SORTED EMPLOYEES (BY NAME) =====");
                    for (Employee e : sortedList) {
                        System.out.println(e);
                    }
                    break;

                // ============================
                // SEARCH (BINARY SEARCH)
                // ============================
                case SEARCH:
                    if (service.getEmployees().isEmpty()) {
                        System.out.println("No employees to search.");
                        break;
                    }

                    System.out.print("Enter the employee name to search: ");
                    String nameToSearch = scanner.nextLine();

                    RecursiveMergeSort sorter2 = new RecursiveMergeSort();
                    List<Employee> sortedForSearch = sorter2.mergeSort(service.getEmployees());

                    RecursiveBinarySearch searcher = new RecursiveBinarySearch();
                    int index = searcher.binarySearch(sortedForSearch, nameToSearch, 0, sortedForSearch.size() - 1);

                    if (index != -1) {
                        System.out.println("\nEmployee found:");
                        System.out.println(sortedForSearch.get(index));
                    } else {
                        System.out.println("\nEmployee not found.");
                    }
                    break;

                // ============================
                // ADD EMPLOYEE
                // ============================
                case ADD_RECORD:
                    service.addEmployeeFromInput(scanner);
                    break;

                // ============================
                // LOAD EMPLOYEES FROM FILE
                // ============================
                case LOAD_FROM_FILE:
                    System.out.print("Enter filename (e.g., employees.txt): ");
                    String filename = scanner.nextLine();
                    service.loadEmployeesFromFile(filename);
                    break;

                // ============================
                // BINARY TREE (LEVEL ORDER)
                // ============================
                case CREATE_BINARY_TREE:
                    if (service.getEmployees().isEmpty()) {
                        System.out.println("No employees to insert into the binary tree.");
                        break;
                    }

                    BinaryTree tree = new BinaryTree();

                    for (Employee emp : service.getEmployees()) {
                        tree.insert(emp);
                    }

                    System.out.println("\n===== BINARY TREE (LEVEL ORDER TRAVERSAL) =====");
                    tree.printLevelOrder();

                    System.out.println("\nTree Height: " + tree.getHeight());
                    System.out.println("Total Nodes: " + tree.getNodeCount());
                    break;

                // ============================
                // EXIT
                // ============================
                case EXIT:
                    System.out.println("Exiting program...");
                    break;
            }

        } while (option != MenuOption.EXIT);

        scanner.close();
    }
}
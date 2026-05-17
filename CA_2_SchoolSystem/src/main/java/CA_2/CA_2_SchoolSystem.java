/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CA_2;
import java.util.Scanner;

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
                case SORT:
                    System.out.println("Sorting list (coming soon)...");
                    break;

                case SEARCH:
                    System.out.println("Searching (coming soon)...");
                    break;

                case ADD_RECORD:
                    service.addEmployeeFromInput(scanner);
                    break;

                case CREATE_BINARY_TREE:
                    System.out.println("Binary tree (coming soon)...");
                    break;

                case EXIT:
                    System.out.println("Exiting program...");
                    break;
            }

        } while (option != MenuOption.EXIT);

        scanner.close();
    }
}


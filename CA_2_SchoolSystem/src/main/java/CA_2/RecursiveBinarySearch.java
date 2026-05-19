/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.List;
/**
 *
 * @author mf251
 */
public class RecursiveBinarySearch {

    public int binarySearch(List<Employee> list, String target, int left, int right) {

        // Caso base: no encontrado
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        Employee midEmployee = list.get(mid);

        int comparison = midEmployee.getName().compareToIgnoreCase(target);

        if (comparison == 0) {
            return mid; // encontrado
        } else if (comparison > 0) {
            return binarySearch(list, target, left, mid - 1); // buscar izquierda
        } else {
            return binarySearch(list, target, mid + 1, right); // buscar derecha
        }
    }
}

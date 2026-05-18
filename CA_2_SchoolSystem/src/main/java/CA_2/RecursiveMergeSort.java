/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mf251
 */
public class RecursiveMergeSort {

    public List<Employee> mergeSort(List<Employee> list) {

        // Caso base: listas de 0 o 1 elemento ya están ordenadas
        if (list.size() <= 1) {
            return list;
        }

        // Dividir la lista en dos mitades
        int mid = list.size() / 2;
        List<Employee> left = new ArrayList<>(list.subList(0, mid));
        List<Employee> right = new ArrayList<>(list.subList(mid, list.size()));

        // Ordenar cada mitad recursivamente
        left = mergeSort(left);
        right = mergeSort(right);

        // Combinar ambas mitades ordenadas
        return merge(left, right);
    }

    private List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>();

        int i = 0, j = 0;

        // Comparar elementos de ambas listas
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}

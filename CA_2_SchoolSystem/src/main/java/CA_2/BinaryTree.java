/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author mf251
 */
public class BinaryTree {

    private TreeNode root;

    // Insertar un empleado en el árbol
    public void insert(Employee employee) {
        root = insertRecursive(root, employee);
    }

    // Inserción recursiva
    private TreeNode insertRecursive(TreeNode current, Employee employee) {

        // Caso base: llegamos a un espacio vacío
        if (current == null) {
            return new TreeNode(employee);
        }

        // Comparar por nombre (orden alfabético)
        int comparison = employee.getName().compareToIgnoreCase(current.getData().getName());

        if (comparison < 0) {
            current.setLeft(insertRecursive(current.getLeft(), employee));
        } else {
            current.setRight(insertRecursive(current.getRight(), employee));
        }

        return current;
    }

    // Recorrido INORDER (izquierda - nodo - derecha)
    public void inOrderTraversal() {
        System.out.println("\n===== BINARY TREE (INORDER TRAVERSAL) =====");
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());
    }
}

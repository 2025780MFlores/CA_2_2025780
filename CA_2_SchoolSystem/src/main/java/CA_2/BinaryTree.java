/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mf251
 */
public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // LEVEL-ORDER INSERTION
    public void insert(Employee emp) {
        TreeNode newNode = new TreeNode(emp);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    // LEVEL-ORDER TRAVERSAL
    public void printLevelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.getData());

            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
    }

    // HEIGHT OF TREE
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public int getHeight() {
        return getHeight(root);
    }

    // NODE COUNT
    private int getNodeCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + getNodeCount(node.getLeft()) + getNodeCount(node.getRight());
    }

    public int getNodeCount() {
        return getNodeCount(root);
    }
}
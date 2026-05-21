/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author mf251
 */
public class TreeNode {

    private Employee data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Employee getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
    this.left = left;
}

public void setRight(TreeNode right) {
    this.right = right;
}
}
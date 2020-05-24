package com.DataStructureAndAlgorithms.BinaryTrees;

public class TreeNode {
    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if(this.value == value)
            return;

        if(this.value > value) {
            if(leftChild == null)
                leftChild = new TreeNode(value);
            else
                leftChild.insert(value);
        }
        else {
            if(rightChild == null)
                rightChild = new TreeNode(value);
            else
                rightChild.insert(value);
        }
    }

    //Root, Left, Right
    public void traversePreOrder() {
        //Print the root
        System.out.print(value + ", ");

        //Recursively explore left subtree
        if(leftChild != null)
            leftChild.traversePreOrder();

        //Recursively explore right subtree
        if(rightChild != null)
            rightChild.traversePreOrder();
    }

    //Left, Root, Right = Sorted Order
    public void traverseInOrder() {
        //Recursively explore left subtree
        if(leftChild != null)
            leftChild.traverseInOrder();

        //Print the root
        System.out.print(value + ", ");

        //Recursively explore right subtree
        if(rightChild != null)
            rightChild.traverseInOrder();
    }

    //Left, Right, Root
    public void traversePostOrder() {
        //Recursively explore left subtree
        if(leftChild != null)
            leftChild.traversePostOrder();

        //Recursively explore right subtree
        if(rightChild != null)
            rightChild.traversePostOrder();

        //Print the root
        System.out.print(value + ", ");
    }

    public TreeNode get(int value) {
        if(this.value == value)
            return this;
        if(this.value > value)
            if(leftChild != null)
                return leftChild.get(value);
        if(this.value < value)
            if(rightChild != null)
                return rightChild.get(value);
        return null;
    }

    public int min() {
        if(leftChild == null)
            return this.value;
        return leftChild.min();
    }

    public int max() {
        if(rightChild == null)
            return this.value;
        return rightChild.max();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

package com.DataStructureAndAlgorithms.BinaryTrees;

public class BinaryTree {
    private TreeNode rootNode;

    public void insert(int value) {
        if(rootNode == null)
            rootNode = new TreeNode(value);
        else
            rootNode.insert(value);
    }

    public void traversePreOrder() {
        if(rootNode != null) {
            rootNode.traversePreOrder();
            System.out.println(" Done.");
        }
    }
    public void traverseInOrder() {
        if(rootNode != null) {
            rootNode.traverseInOrder();
            System.out.println(" Done.");
        }
    }

    public void traversePostOrder() {
        if(rootNode != null) {
            rootNode.traversePostOrder();
            System.out.println(" Done.");
        }
    }

    public TreeNode get(int value) {
        if(rootNode != null)
            return rootNode.get(value);
        return null;
    }

    public void delete(int value) {
        rootNode = delete(rootNode, value);
    }

    private TreeNode delete(TreeNode subtreeRootNode, int value) {
        if(subtreeRootNode == null) //Catch the null case
            return subtreeRootNode; //Always null but the format indicates that we will return and do nothing

        //These two statements do the deleting/replacing
        if(value < subtreeRootNode.getValue())
            subtreeRootNode.setLeftChild(delete(subtreeRootNode.getLeftChild(),value));
        else if (value > subtreeRootNode.getValue())
            subtreeRootNode.setRightChild(delete(subtreeRootNode.getRightChild(),value));

        //IF THE VALUE IS EQUAL, let's check the children
        else {
            //Case 1: If the subtree has no children,...
            /*
            SEE BELOW. If the first statement is true, root node will be set to right child.
            The right child is null. Thus, the root becomes null. No problems.
             */

            //Deceptive: the following is Case 1 as well
            //Case 2: If the subtree has one child, we will set the subtree root to one of them
            //Since the node is deleted, that ONE child will move up and become the new subtree root.
            if(subtreeRootNode.getLeftChild() == null)
                return subtreeRootNode.getRightChild();
            else if(subtreeRootNode.getRightChild() == null)
                return subtreeRootNode.getLeftChild();

            //Case 3: if the above two statements are false, there must be two children.
            //This implementation replaces the root with the max of the left subtree. Why? Learn about it urself.
            else {
                int max = subtreeRootNode.max();

                delete(max);
                subtreeRootNode.setValue(max);
            }
        }
        return subtreeRootNode;
    }

    public int min() {
        if(rootNode == null)
            return Integer.MIN_VALUE;
        return rootNode.min();
    }

    public int max() {
        if(rootNode == null)
            return Integer.MAX_VALUE;
        return rootNode.max();
    }

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }
}

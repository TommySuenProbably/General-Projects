//Search up AVL and red-black trees

package com.DataStructureAndAlgorithms.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        int[] values = new int[] {25,20,15,27,30,29,26,22,32};
        BinaryTree bTree = new BinaryTree();

        for(int value: values)
            bTree.insert(value);

        bTree.delete(20);
        System.out.println(bTree.max());
        bTree.traversePreOrder();
        bTree.traverseInOrder();
        bTree.traversePostOrder();
    }
}

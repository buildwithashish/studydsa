package com.mixer.trees.problems1;

import com.mixer.trees.bst.BST;
import com.mixer.trees.bst.BinaryNode;

public class FindKthSmallestInBST {

    static BST bst = new BST();

    public static void main(String[] args) {

        bst.insert(5);
        bst.insert(4);
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(7);
        bst.insert(9);
        bst.insert(8);
        bst.insert(6);

        bst.inOrder(bst.root);
        System.out.println();
        System.out.print("Kth smallest element is :" + ans);

    }

    private static void findKthSmallest(BinaryNode node, int k) {
        inOrder(node, k);
    }

    static int ans = 0;
    private static void inOrder(BinaryNode node, int k) {
        if(node == null)
            return;

        inOrder(node.left, k);
        k--;
        if(k==0) {
            ans = node.value;
            return;
        }
        inOrder(node.right, k);
    }
}

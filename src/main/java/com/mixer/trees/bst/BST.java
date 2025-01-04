package com.mixer.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    public BinaryNode root;

    public BST() {
        root = null;
    } //O(1) / O(1)

    //insert O(logN) / O(logN)
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            if(this.root == null) {
                this.root = newNode;
            }
            return newNode;
        } else if(value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        insert(root, value);
    }


    //preOrder O(N) / O(N)
    public void preOrder(BinaryNode node) {
        //System.out.println("Entered");
        if(node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //inOrder O(N) / O(N)
    public void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    //postOrder O(N) / O(N)
    void postOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    //level order O(N) / O(N)
    void levelOrder() {
        if(root == null) {
            System.out.println("AVL is null");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    //search O(logN) / O(logN)
    BinaryNode search(BinaryNode node, int value) {
        if(node == null) {
            System.out.println(value + " not found in AVL.");
            return null;
        } else if(node.value == value) {
            System.out.println(value + " found in AVL");
            return node;
        } else if(value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    //minimumNode
    public BinaryNode minimumNode(BinaryNode root) {
        if(root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    //delete node O(logN) / O(logN)
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if(root == null) {
            System.out.println("The value not found in bst.");
            return null;
        }

        if(value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if(value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if(root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode successorForRight = minimumNode(temp.right);
                root.value = successorForRight.value;
                root.right = deleteNode(root.right, successorForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if(root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;
    }

    //delete bst O(1) / O(1)
    public void deleteBST() {
        this.root = null;
    }
}

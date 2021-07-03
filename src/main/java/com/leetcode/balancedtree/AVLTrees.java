package com.leetcode.balancedtree;


import com.interviewbit.arrays.NobleInteger;
import jdk.jshell.spi.SPIResolutionException;

/*
    AVL tree is a self-balancing Binary Search Tree (BST) where the difference between heights
    of left and right subtrees cannot be more than one for all nodes.

    Height Difference Cannot Become More than One.
    Search Max Min Insert Delete take O(h) time.


 */
public class AVLTrees {


    public static void main(String[] args) {

        AVLTrees obj = new AVLTrees();
        Node root = null;
        root = obj.insert(root, 10);
        root = obj.insert(root, 20);
        root = obj.insert(root, 30);
        root = obj.insert(root, 40);
        root = obj.insert(root, 50);
        root = obj.insert(root, 25);
        obj.preOrder(root);
    }


    public Node rightRotate(Node node) {
        Node root = node.left;
        node.left = root.right;
        root.right = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return root;
    }

    public Node leftRotate(Node node) {
        Node root = node.right;
        node.right = root.left;
        root.left = node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return root;
    }

    public int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    public int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    public Node insert(Node root, int key) {

        if (root == null) {
            Node node = new Node(key);
            node.height = 1;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else
            return root;

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        int balance = getBalanceFactor(root);

        if (balance > 1 && key < root.left.key)
            return rightRotate(root);

        if (balance < -1 && key > root.right.key)
            return leftRotate(root);

        if (balance > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.key + " -- ");
        preOrder(root.left);
        preOrder(root.right);
    }


}


class Node {
    int key;
    int height;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
    }
}
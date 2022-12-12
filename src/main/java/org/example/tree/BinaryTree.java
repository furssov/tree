package org.example.tree;

public class BinaryTree {

    private Node root;

    public void insert()
    {

    }

    public void delete()
    {

    }

    private Node find(int key)
    {
        Node current = root;
        while (current.key != key)
        {
            if (key < current.key)
            {
                current = current.leftChild;
            }
            else current = current.rightChild;
            if (current == null)
            {
                return null;
            }
        }
        return current;
    }

    class Node
    {
         private int key;
         private Node leftChild;
         private Node rightChild;
    }
}

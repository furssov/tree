package org.example.tree;

public class Node {
    public int key;
    public Node leftChild;
    public Node rightChild;

    public Node(int key)
    {
        this.key = key;
    }
    public void displayNode()
// Вывод узла
    {
        System.out.print('{');
        System.out.print(key);
        System.out.print("} ");
    }

    @Override
    public String toString() {
        return "{"+key+"}";
    }
}


package org.example.tree;

public class BinaryTree {

    private Node root;

    public void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.key);
            inOrder(localRoot.rightChild);
        }
    }

    public void insert(int key)
    {
        Node newNode = new Node(key);
        if (root == null)
        {
            root = newNode;
        }
        else
        {
            Node current = root;
            Node parent;

            while (true)
            {
                parent = current;
                if (key < current.key)
                {
                    current = current.leftChild;
                    if (current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                    else
                    {
                        current = current.rightChild;
                        if (current == null)
                        {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                }
            }
        }
    }

    public boolean delete(int key)
    {
          Node current =root;
          Node parent = root;
          boolean isLeftChild = true;
          while (current.key != key)
          {
              parent = current;
              if (key < current.key)
              {
                  isLeftChild = true;
                  current = current.leftChild;
              }
              else
              {
                  isLeftChild = false;
                  current = current.rightChild;
              }
              if (current == null) return false;
          }
          if (current.leftChild == null && current.rightChild == null)
          {
              if (current == root) root = null;
              else if (isLeftChild) parent.leftChild = null;
              else parent.rightChild = null;
          } else if (current.rightChild == null) {
              if (current == root) root = root.leftChild;
              else if (isLeftChild) {
                   parent.leftChild = current.leftChild;
              }
              else
                  parent.rightChild = current.leftChild;
          } else if (current.leftChild == null) {
              if(current == root)
                  root = current.rightChild;
              else if(isLeftChild)
                  parent.leftChild = current.rightChild;
              else
                  parent.rightChild = current.rightChild;
          }
          else
          {
              Node successor = getSuccessor(current);
              if (current == root) root = successor;
              else if (isLeftChild) {
                  parent.leftChild = successor;
              }
              else parent.rightChild = successor;
          }
          return true;

    }

    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
// Переход к правому потомку
        while(current != null)
// Пока остаются левые потомки
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
// Переход к левому потомку
        }
// Если преемник не является
        if(successor != delNode.rightChild) // правым потомком,
        {
// создать связи между узлами
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
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

         public Node(int key)
         {
             this.key = key;
         }
    }
}

package org.example.tree;

import java.util.Stack;

public class BinaryTree {

    private Node root;

    //симетричный обход
    private void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }
    //
    private void preOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.key + " ");
        }
    }

    public void insert(int key)
    {
        Node newNode = new Node(key);

        if(root==null)
// Корневой узел не существует
            root = newNode;
        else
// Корневой узел занят
        {
            Node current = root;
// Начать с корневого узла
            Node parent;
            while(true)
// (внутренний выход из цикла)
            {
                parent = current;
                if(key < current.key) // Двигаться налево?
                {
                    current = current.leftChild;
                    if(current == null) // Если достигнут конец цепочки,
                    {
// вставить слева
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
// Или направо?
                {
                    current = current.rightChild;
                    if(current == null) // Если достигнут конец цепочки,
                    {
// вставить справа
                        parent.rightChild = newNode;
                        return;
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

    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(isRowEmpty==false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;
    for(int j=0; j<nBlanks; j++)
            System.out.print(' ');
while(globalStack.isEmpty()==false)
    {
        Node temp = (Node)globalStack.pop();
        if(temp != null)
        {
            System.out.print(temp.key);
            localStack.push(temp.leftChild);
            localStack.push(temp.rightChild);
            if(temp.leftChild != null ||
                    temp.rightChild != null)
                isRowEmpty = false;
        }
        else
        {
            System.out.print("--");
            localStack.push(null);
            localStack.push(null);
        }
        for(int j=0; j<nBlanks*2-2; j++)
            System.out.print(' ');
    }
System.out.println();
    nBlanks /= 2;
while(localStack.isEmpty()==false)
        globalStack.push( localStack.pop() );
}
System.out.println(
        "......................................................");
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


    public Node find(int key)
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


}

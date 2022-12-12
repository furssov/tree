package org.example;

import org.example.tree.BinaryTree;

import org.example.tree.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        BinaryTree theTree = new BinaryTree();
        
        theTree.insert(5);
        theTree.insert(2);
        theTree.insert(3);
        theTree.insert(4);
        theTree.insert(7);
        theTree.insert(8);
        theTree.insert(6);
        theTree.insert(9);
        theTree.insert(0);
        theTree.insert(1);
        theTree.displayTree();
/*
        System.out.println("deleting 0...");
        theTree.delete(0);
        System.out.println("Is 0 found ? " + theTree.find(0));
        System.out.println("Is 9 found ? " + theTree.find(9));
        System.out.println("deleting 8...");
        theTree.delete(8);
        System.out.println("deleting 2...");
        theTree.delete(2);
        System.out.println("Is 2 found ? " + theTree.find(2));
        System.out.println("Is 8 found ? " + theTree.find(8));
        System.out.println("deleting 9...");
        theTree.delete(9);
        System.out.println("inserting 8...");
        theTree.insert(8);
        System.out.println("deleting 5...");
        theTree.delete(5);
        System.out.println("Is 5 found ? " + theTree.find(5));
        System.out.println("Is 8 found ? " + theTree.find(8));
        theTree.displayTree();
*/
        int value;
        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch (choice) {
                case 'd' : value = getInt(); theTree.delete(value); break;
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
                    else System.out.println("not found");
            }

        }

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
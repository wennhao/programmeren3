/* *****************************
 * Author: Elvira van der Ven  *
 * Date:   01/03/2024          *                                                                                          *
 *******************************/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App42 {
    public static void main(String[] args) {
        // Lees ./input in zoals behandeld in Les 6: File I/O
        String input = "";
        try   { input = Files.readString(Paths.get("SPO4-2/src/input.txt")); }
        catch ( IOException e ) { e.printStackTrace(); }

        // Split het bestand op in een array van woorden (String)
        String splitString[] = input.split(" ");

        // Stop alle woorden in de LinkedList, achter elkaar.
        SinglyLinkedList list = new SinglyLinkedList();
        Queue queue = new Queue();
        Stack stack = new Stack();
        for (String str : splitString) {
            stack.push(str);
            //queue.enqueue(str);
            //list.push(1000,str);
        }

        /* Testing Queue code*/
//        queue.printQueue();
//        queue.dequeue();
//        queue.printQueue();
//        queue.dequeue();
//        queue.enqueue("Hey!");
//        queue.dequeue();
//        queue.printQueue();
//        queue.peek();
        /* Testing LinkedList code*/
//        list.print();
//        list.pop("Nobody");
//        list.print();
//        list.pop(2);
//        list.print();

        /* Testsing Stack code*/
//        stack.printStack();
//        System.out.println("\nPopping the top element:");
//        stack.pop();
//        stack.printStack();
//
//        String peekedValue = stack.peek(); // Should print the current top element
//
//        System.out.println("\nPopping two more elements:");
//        stack.pop();
//        stack.pop();
//        stack.printStack();
//
//        System.out.println("\nAdding a new element to the stack:");
//        stack.push("Hey!");
//        stack.printStack();
    }
}
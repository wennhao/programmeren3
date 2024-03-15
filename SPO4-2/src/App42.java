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
        try   { input = Files.readString(Paths.get("./input.txt")); }
        catch ( IOException e ) { e.printStackTrace(); }

        // Split het bestand op in een array van woorden (String)
        String splitString[] = input.split(" ");

        // Stop alle woorden in de LinkedList, achter elkaar.
        SinglyLinkedList list = new SinglyLinkedList();
        for (String str : splitString) {
            list.push(1000,str);
        }

        // Tests
        list.print();
        list.pop("Nobody");
        list.print();
        list.pop(2);
        list.print();
    }
}





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * TINPRO04-3 Les 7 // Singly Linked List, non-generic
 * 20240217 // m.skelo@hr.nl
 * 
 * @Matej 20240217: Misschien in groepjes van 3, waarbij ieder een van: {push(), pop(), peek()} schrijft. 
 *                  Anders is het niet te doen in 1 les.
 */

class App4 {
    public static void main(String[] args) {
        // Lees ./input in zoals behandeld in Les 6: File I/O
        Path file = Paths.get("SPO4/src/input.txt");
        String content = "";
        // TIP: Gebruik Files.readString() om een bestand (File)
        //      direct in een String te stoppen
        try {
           content = Files.readString(file);

        } catch (NoSuchFileException e) {
            System.out.println(file + " is empty, i can't read it !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String splitString[] = content.split("\\s+");
        // Split het bestand op in een array van woorden (String)


        // Maak een Linked List aan en stop alle woorden in de LinkedList in de juiste volgorde
        LinkedList list = new LinkedList();
        list.pop(0);
        for (String word : splitString) {
            list.push(word);
        }


        // Tests
        list.print();
        list.pop("actually");
        list.print();
        list.pop(2);
        list.print();



        //external test
//        LinkedList lijst = new LinkedList();
//
//        lijst.pop(1);
//        lijst.push("Elf");
//        lijst.push("is");
//        lijst.push("moe1");
//        lijst.push("moe2");
//        lijst.push("moe3");
//        lijst.push("moe4");
//
////       lijst.print();
//        lijst.push(1, "moe5");
//        lijst.pop(9);
////        lijst.print();
//        lijst.peek("moe2");
//        lijst.peek("moe1");

      //lijst.print();
//        System.out.println("-----------");
//        System.out.println(lijst.toString());

    }
}


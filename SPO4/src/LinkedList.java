
public class LinkedList {
    // Fields:
    private Node head;
    private Node tail;
    private int size;

    // Constructors (n/a)

    // Get/set methods (n/a)

    // Other methods:

    /**
     * void push(String value):
     *      - Loopt Node voor Node door de lijst, en zet de meegegeven waarde aan het einde van de lijst neer (in een `new Node()`).
     *      - Anders, als de lijst leeg is, wordt de head-Node gelijkgesteld aan de meegegeven parameter.
     *
     */
    public void push(String value) {
        // TODO
        Node toPush = new Node(value);
        if (head == null) {
            head = toPush;
            tail = toPush;
        }
        else {
            tail.setNext(toPush);
            toPush.setPrevious(tail);//set previous reference of the new node of the current tail
            tail = toPush;
        }
        size++;
    }

    /**
     * void push(int index, String value):
     *      - Loop Node voor Node door de lijst heen.
     *      - Als je ziet dat de huidige index == index-1:
     *      - Sla de /VOLGENDE/ Node op in een tijdelijke variabele
     *      - Stel de /HUIDIGE/ Node z'n `next` gelijk aan de nieuwe node met de value uit de parameter
     *      - Stel de /NIEUWE/ Node zijn `next` gelijk aan de /VOLGENDE/ Node die in een tijdelijke variabele opgeslagen was
     *
     */
    public void push(int index, String value) {
        // TODO
        Node toPush = new Node(value);
        if (head == null && tail == null) {
            head = toPush;
            tail = toPush;
        } else if (index == 0) {
            toPush.setNext(head);
            head.setPrevious(toPush);
            head = toPush;
        } else if (index == size) {
            tail.setNext(toPush);
            toPush.setPrevious(tail);
            tail = toPush;
        } else {
            Node currentNode = head;
            //kijk waar ik heen wil!
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            toPush.setNext(currentNode.getNext());
            toPush.setPrevious(currentNode);//set the previous reference o the new node
            currentNode.getNext().setPrevious(toPush);//update previous reference of the next node
            currentNode.setNext(toPush);
        }
        size++;
    }


    /**
     * String pop(String value):
     *      - Loop Node voor Node door de lijst heen.
     *      - Als je ziet dat de /VOLGENDE/ Node een value heeft die gelijk is aan de meegegeven parameter:
     *      - Sla de te verwijderen Node op in een tijdelijke variabele
     *      - Stel de /HUIDIGE/ Node z'n `next` gelijk aan de eerstvolgende Node NA de verwijderde Node
     *      !!! Dit is enorm belangrijk: als je dit vergeet wordt de rest van de lijst na de huidige Node opgeruimd door de Garbage Collector
     *      - Return de waarde uit de verwijderde Node
     *      - Als er geen Node met gegeven waarde in de lijst zit, returnt de method "Not found"
     *
     */
    public String pop(String value) {
        // TODO
        if (head == null){
            System.out.println("The list is empty! There's nothing to pop!");
            return null;
        }

        Node currentNode = head;
        Node previousNode = null;

        while (head != null) {
            if (currentNode.getValue().equalsIgnoreCase(value)) {
                if (previousNode == null) { //kijk of de list eigenlijk 1 node heeft zo ja dan hoef je geen links te verwijderen en kan je gewoon een node poppen en wordt de list empty.
                    head = currentNode.getNext();
                    if(head != null){
                        head.setPrevious(null);
                    }
                    else{
                        tail = null;
                    }
                    size--;
                } else { //skip als het ware 1 node, dus je hebt een lsit van 1,2,3 dan laat je de link verwijzen naar 3 aka 2 wordt verwijderd.
                    previousNode.setNext(currentNode.getNext());
                    size--;
                    if (currentNode.getNext() != null) { //kijk of je iets wilt poppen aan het einde van de linkedlist aka je hoeft geen nieuwe link meer te maken.
                        currentNode.getNext().setPrevious(previousNode);
                    }
                    else{
                        tail = previousNode;//update tail if the node to pop is the last node
                        size--;
                    }
                }
                
                System.out.println(currentNode + " is verwijderd!");
                return currentNode.getValue();
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * String pop(int index):
     *      - Loop Node voor Node door de lijst heen.
     *      - Als je ziet dat de huidige index == index-1:
     *      - Sla de /VOLGENDE/ Node op in een tijdelijke variabele
     *      - Stel de /HUIDIGE/ Node z'n `next` gelijk aan de eerstvolgende Node NA de verwijderde Node
     *      !!! Dit is enorm belangrijk: als je dit vergeet wordt de rest van de lijst na de huidige Node opgeruimd door de Garbage Collector
     *      - Return de waarde uit de verwijderde Node
     *      - Als er geen Node met gegeven waarde in de lijst zit, returnt de method "Not found"
     *
     */
    public String pop(int index) {

        if (head == null) {// check if the linkedlist is empty
            System.out.println("List is empty, you can't use the pop method!");
            return null;
        }

        if (index < 0 || index >= size) { // check if the pop index is in the size
            System.out.println("The given index [" + index + "] is not in the list! Maybe you're trying too far.");
            return null;
        }

        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null && index > 0) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            index--;
        }

        if (previousNode == null) {
            head = currentNode.getNext();

        } else {
            currentNode.getPrevious().setNext(currentNode.getNext());
        }
           if(currentNode == tail){
            tail = currentNode.getPrevious();
           } else{
            currentNode.getNext().setPrevious(currentNode.getPrevious());
           }
        
        //nimai goed nieuws, hij werkt wonderbaarlijk
        size--;
        return null;
    }

    /**
     * int peek(String value):
     *      - Zoekt in de lijst naar een Node met value gelijk aan parameter.
     *      - Als er een bestaat, returnt de method de index van de desbetreffende Node zonder de lijst te wijzigen
     *      - Als geen bestaande waarde wordt gevonden returnt de method "-1"
     *
     */
    public int peek(String value) {
        // TODO
        int index = 0;
        Node currentNode = head;

        while(currentNode != null) {
            if (currentNode.getValue().equalsIgnoreCase(value)) {
                System.out.println("\"" + value + "\" found at index [" + index + "]");
                return index;
            } else {
                currentNode = currentNode.getNext();
                index++;
            }
        }
        System.out.println("I can't find \"" + value + "\"! Maybe the list is empty or the value doesn't exist.");
        return -1;
    }

    /**
     * void print(): Print alle waardes in de lijst achter elkaar, met een nette newline op het eind.
     *
     */
    public void print() {
        Node currentforward = head;
        Node currentback = tail;
  //      System.out.println("forward: ");
        while (currentforward != null) {
            System.out.print(currentforward.getValue()+" ");
            currentforward = currentforward.getNext();
        }
//        System.out.println("back: ");
        while(currentback != null){
            System.out.println(currentback.getValue()+" ");
            currentback = currentback.getPrevious();
        }
  //      System.out.println();
    }
    /**
     * String tostring(): Geeft een string met alle waardes in de lijst achter elkaar, met een nette newline op het eind.
     *
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Node current = this.head; current != null; current = current.getNext()){
            stringBuilder.append(current.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
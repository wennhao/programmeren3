
/*
 * In deze uitvoering van de Linked List is express geen gebruik gemaakt van de field previous in de class Node.
 */
public class SinglyLinkedList {
    // Fields:
    private Node head;
    private Node tail;
    private int size;

    // Constructors (n/a)

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Get/set methods (n/a)

    // Other methods:
    /*
     * Pushed een value aan het einde van de lijst. Als we een LL met head EN tail field gebruiken,
     * hoeven we hier niet helemaal door de LL te lopen om de laatste element te bereiken.
     * Daarvoor moeten we de tail wel bijhouden.
     */
    public void push(String value) {
        Node newNode = new Node(value);
        if (this.head == null && this.tail == null && this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
        /* als je geen tail gebruikt is dit een mainier.
        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        current.getNext().setPrevious(current);  // Staar hier even naar.
        */
            /* Het kan ook efficienter, door middel van het gebruik van de tail*/
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    /*
     * Pushed een value naar de gevraagde positie. Hier kunnen drie situaties optreden:
     * 1. Wil pushen naar de positie helemaal vooraan - index 0
     * 2. Wil pushen naar de positie helemaal achteraan - index ==size of index >= size.
     *      Keuze hierin is aan de ontwikkelaar. Ik kies om bij index > size altijd achteraan toe te voegen.
     *      Dus regular push gebruiken)
     * 3. Wil pushen ergens in het midden. Dat is de "lastigste" om te implementeren.
     */
    public void push(int index, String value) {
        if(index >size -1){
            this.push(value);
        }
        else {
            Node toPushNode = new Node(value);
            if(index == 0){
                toPushNode.setNext(head);
                this.head = toPushNode;
            }
            else {
                Node current = head;
                for (int i = 0; i < index-1; i++){
                    current = current.getNext();
                }
                toPushNode.setNext(current.getNext());
                current.setNext(toPushNode);
            }
            size++;
        }
    }
    /*
     * Poped de node met de gevraagde value. Retourneert de value alleen. Hier kunnen drie situaties optreden:
     * 1. Wil een Node popen die helemaal vooraal staat - roep methode pop op index 0 aan.
     * 2. Wil een Node popen ergens in het midden of achteraan.
     *      Omdat om achteraan te popen dezelfde sequience doorlopen wordt, maak ik daar voor nu geen ondescheid tussen.
     * 3. Wil een Node popen met gegeven waarde, maar die waarde staat niet in een node. Dan krijgt gebruiker een "Not found" terug.
     */
    public String pop(String value) {
        if(head.getValue().equalsIgnoreCase(value)){
            return pop(0);
        }
        else {
            for(Node current = head; current != null; current = current.getNext()){
                Node toPop;
                if (current.getNext().getValue().equalsIgnoreCase(value)){
                    toPop = current.getNext();
                    current.setNext(toPop.getNext());
                    if(toPop == this.tail) {
                        this.tail = current;
                    }
                    toPop.setNext(null);

                    size--;
                    return toPop.getValue();
                }
            }
        }
        return "Not found";
    }

    /*
     * Poped een value van de gevraagde positie. Hier kunnen drie situaties optreden:
     * 1. Wil popen vanaf de positie helemaal vooraan - index 0
     * 2. Wil popen vanaf de positie helemaal achteraan - index == size of index >= size.
     *      Keuze hierin is aan de ontwikkelaar. Ik kies om bij index == size achteraan te verwijderen.
     *      En bij index > size melding te geven dat de index niet bestaat door "Not found" te returnen.
     * 3. Wil popen ergens in het midden. Dat is de "lastigste" om te implementeren.
     */
    public String pop(int index) {
        if(index > size){
            return "Not found";
        }
        Node toPop;
        if(index == 0){
            toPop = this.head;
            this.head = toPop.getNext();
            toPop.setNext(null);
        }
        else {
            Node current = head;
            for (int i = 0; i < index-1; i++){
                current = current.getNext();
            }
            toPop = current.getNext();
            current.setNext(toPop.getNext());
            toPop.setNext(null);
        }
        if(toPop == this.tail){
            this.tail = null;
        }
        size--;
        return toPop.getValue();
    }

    public String peek(String value) {
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                return current.getNext().getValue();
            }
            current = current.getNext();
        }
        return "Not found";
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue()+" ");
            current = current.getNext();
        }
        System.out.println();
    }
}

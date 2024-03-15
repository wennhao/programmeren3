
class Node {
    // Fields:
    private Node next;
    private Node Previous;
    private String value;

    // Constructor(s):
    public Node(String value) {
        this.value = value;
    }

    // Get/set methods:
    public Node getNext() {
        return this.next;
    }
    public Node getPrevious(){
        return this.Previous;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node Previous){
        this.Previous = Previous;
    }
    public String getValue() {
        return this.value;
    }

    // Other methods (n/a)

    @Override
    public String toString() {
        return this.value;
    }
}

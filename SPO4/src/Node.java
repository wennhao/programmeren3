
class Node {
    // Fields:
    private Node next;
    private String value;

    // Constructor(s):
    public Node(String value) {
        this.value = value;
    }

    // Get/set methods:
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next) {
        this.next = next;
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

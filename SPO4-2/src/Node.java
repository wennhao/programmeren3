class Node {
    // Fields:
    private Node next;
    private Node previous;
    private String value;

    // Constructor(s):
    public Node(String value) {
        this.setValue(value);
    }

    // Get/set methods:
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // Other methods (n/a)
    @Override
    public String toString() {
        return this.value;
    }
}
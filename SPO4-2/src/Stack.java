public class Stack {
    private SinglyLinkedList list;

    public Stack() {
        this.list = new SinglyLinkedList();
    }

    // Adds an item to the top of the stack
    public void push(String value) {
        list.push(0, value); // Add to the beginning of the list, which is the "top" of the stack
        System.out.println("Pushed: " + value);
    }

    // Removes and returns the item at the top of the stack
    public String pop() {
        if (list.getSize() == 0) {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        String value = list.pop(0); // Remove from the beginning of the list, which is the "top" of the stack
        System.out.println("Popped: " + value);
        return value;
    }

    // Returns the item at the top of the stack without removing it
    public String peek() {
        if (list.getSize() == 0) {
            System.out.println("Stack is empty, cannot peek.");
            return null;
        }
        // Since we don't have a direct peekFirst method, you would ideally add one
        // to your SinglyLinkedList class similar to what was suggested for the Queue.
        // Assuming you've added peekFirst to SinglyLinkedList:
        String value = list.peekFirst();
        System.out.println("Peeked: " + value);
        return value;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    public void printStack() {
        list.print();
    }
}
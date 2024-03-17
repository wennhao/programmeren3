public class Queue {
    private SinglyLinkedList list;

    public Queue() {
        this.list = new SinglyLinkedList();
    }

    public void enqueue(String value) {
        list.push(value);
        System.out.println("Enqueued: " + value);
    }

    public String dequeue() {
        if (list.getSize() == 0) {
            System.out.println("Queue is empty, cannot dequeue.");
            return null;
        }
        String value = list.pop(0);
        System.out.println("Dequeued: " + value);
        return value;
    }

    public String peek() {
        String value = list.peekFirst();
        if (value == null) {
            System.out.println("Queue is empty, cannot peek.");
        } else {
            System.out.println("Peeked: " + value);
        }
        return value;
    }


    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    // Utility method to print the queue (optional)
    public void printQueue() {
        list.print();
    }
}
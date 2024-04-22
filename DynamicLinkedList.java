// Implementation dynamic list using a singly linked list in Java.
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DynamicLinkedList {
    private Node head;
    private int size;

    // Constructor
    public DynamicLinkedList() {
        head = null;
        size = 0;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to insert an element at the end of the list
    public void insert(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to insert an element at a specific position in the list
    public void insert(int element, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(element);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Method to remove an element from a specific position in the list
    public void remove(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Method to display the elements in the list
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        DynamicLinkedList list = new DynamicLinkedList();
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.display(); // Output: List: 2 4 5
        list.insert(3, 1); // Inserting 3 at position 1
        list.display(); // Output: List: 2 3 4 5
        list.remove(0); // Removing element at position 0
        list.display(); // Output: List: 3 4 5
    }
}

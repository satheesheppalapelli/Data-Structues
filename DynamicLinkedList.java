// Node class representing individual elements in the linked list
class Node {
    int data;   // Data stored in the head node
    Node next;  // Reference to the next node in the list

    // Constructor to initialize a node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// DynamicLinkedList class representing a dynamic list implemented using a singly linked list
public class DynamicLinkedList {
    private Node head;  // Reference to the head node of the list
    private int size;   // Number of elements in the list

    // Constructor to initialize an empty list
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
            head = newNode; // If list is empty, new node becomes the head
        } else {
            // Traverse to the end of the list and append the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++; // Increment size of the list
    }

    // Method to insert an element at a specific position in the list
    public void insert(int element, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position"); // Check for invalid position
            return;
        }
        Node newNode = new Node(element);
        if (position == 0) {
            newNode.next = head;
            head = newNode; // Insert at the beginning of the list
        } else {
            Node current = head;
            // Traverse to the position before the insertion point
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next; // Link new node to the next node
            current.next = newNode; // Link previous node to the new node
        }
        size++; // Increment size of the list
    }

    // Method to update the element at a specific position in the list
    public void update(int element, int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position"); // Check for invalid position
            return;
        }
        Node current = head;
        // Traverse to the node at the specified position
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.data = element; // Update data of the node
    }

    // Method to remove an element from a specific position in the list
    public void remove(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position"); // Check for invalid position
            return;
        }
        if (position == 0) {
            head = head.next; // Remove the head node
        } else {
            Node current = head;
            // Traverse to the node before the one to be removed
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next; // Link previous node to the next one
        }
        size--; // Decrement size of the list
    }

    // Method to display the elements in the list
    public void display() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " "); // Print data of each node
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
        list.update(6, 2); // Updating element at position 2
        list.display(); // Output: List: 3 4 6
    }
}

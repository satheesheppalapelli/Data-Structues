// Implementation of a dynamic list data structure using arrays in Java. 
public class DynamicList {
    private int[] array;
    private int end; // variable to mark the end of the list

    // Constructor
    public DynamicList(int maxSize) {
        array = new int[maxSize]; // declare a large array
        end = -1; // initialize end to indicate an empty list
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return end == -1;
    }

    // Method to insert an element at the end of the list
    public void insert(int element) {
        if (end == array.length - 1) {
            // If array is full, resize it
            resizeArray();
        }
        end++;
        array[end] = element;
    }

    // Method to insert an element at a specific position in the list
    public void insert(int element, int position) {
        if (position < 0 || position > end + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (end == array.length - 1) {
            // If array is full, resize it
            resizeArray();
        }
        for (int i = end; i >= position; i--) {
            array[i + 1] = array[i]; // shift elements to the right
        }
        array[position] = element;
        end++;
    }

    // Method to remove an element from a specific position in the list
    public void remove(int position) {
        if (position < 0 || position > end) {
            System.out.println("Invalid position");
            return;
        }
        for (int i = position; i < end; i++) {
            array[i] = array[i + 1]; // shift elements to the left
        }
        end--;
    }

    // Method to resize the array when it's full
    private void resizeArray() {
        int[] newArray = new int[array.length * 2]; // create a new larger array
        for (int i = 0; i <= end; i++) {
            newArray[i] = array[i]; // copy elements to the new array
        }
        array = newArray; // update reference to the new array
    }

    // Method to display the elements in the list
    public void display() {
        System.out.print("List: ");
        for (int i = 0; i <= end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        DynamicList list = new DynamicList(5); // Creating a list with initial size 5
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

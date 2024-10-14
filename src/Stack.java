public class Stack {
    private String[] stackArray; // Array to store stack elements

    // Constructor to initialize the stack with a specific capacity
    public Stack() {
        stackArray = new String[0]; // Initialize the array
    }

    // Method to add an element to the stack
    public void push(String element) {
        String[] newArray = new String[stackArray.length + 1];
        for(int i = 0; i < stackArray.length; i ++){
            newArray[i+1] = stackArray[i];
        }
        newArray[0] = element;
        stackArray = newArray;
    }

    // Method to remove the top element from the stack
    public String pop() {
        String[] newArray = new String[stackArray.length - 1];
        for(int i = 1; i < stackArray.length; i ++){
            newArray[i-1] = stackArray[i];
        }
        String element = stackArray[0];
        stackArray = newArray;
        return element;
    }

    // Method to check the top element without removing it
    public String peek() {
        return stackArray[0];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stackArray.length == 0;
    }


    // Method to get the current size of the stack
    public int size() {
        return stackArray.length;
    }

    // Method to display the stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i < stackArray.length; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

}


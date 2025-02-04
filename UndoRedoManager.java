package DoubleLinkedList;

/**
 * Implememt an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;

    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        }
        currentState = newNode;
    }
    //Undo operation
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No more undo available");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }


    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No more redo available");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }
    public static void main(String[] args) {


    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

/**
 *
 * @author Sing Keat
 */
public class ItemList<T> implements ItemInterface<T> {
    private Node<T> firstItem;
    private int numberOfItem;
    
    public ItemList() {
        clearItem();
    }
    
    public void clearItem() {
        firstItem = null;
        numberOfItem = 0;
    }
    
    @Override
    public boolean addItem(T newItem) { // add at the back
        Node<T> newItemLink = new Node<>(newItem);	// create the new node

        if (isEmpty()) { // if empty list
            firstItem = newItemLink;
        } else {                        // add to end of nonempty list
            Node<T> lastItemLink = getNodeAt(getNumberOfItem());
            lastItemLink.setNext(newItemLink);
        }

        numberOfItem++;
        return true;
    }
    
    @Override
    public boolean addItem(int newPosition, T newEntry) { // OutOfMemoryError possible
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= getNumberOfItem() + 1)) {
            Node<T> newNode = new Node<T>(newEntry);

            if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
                newNode.setNext(firstItem);
                firstItem = newNode;
            } else { // case 2: list is not empty and newPosition > 1
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNext();
                newNode.setNext(nodeAfter);	// make new node point to current node at newPosition
                nodeBefore.setNext(newNode);		// make the node before point to the new node
            }

            numberOfItem++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }
    
    @Override
    public T removeItem(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = firstItem.getData();     // save entry to be removed
                firstItem = firstItem.getNext();
            } else {                         // case 2: givenPosition > 1
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.getNext();
                Node<T> nodeAfter = nodeToRemove.getNext(); // nodeBefore.next.next
                nodeBefore.setNext(nodeAfter);
                result = nodeToRemove.getData();  // save entry to be removed
            } 																// one to be deleted (to disconnect node from chain)

            numberOfItem--;
        }

        return result;                   // return removed entry, or null
    }

    @Override
    public boolean replaceItem(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            Node<T> desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getItem(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            result = getNodeAt(givenPosition).getData();
        }

        return result;
    }

    @Override
    public boolean containsItem(T anEntry) {
        boolean found = false;
        Node<T> currentItem = firstItem;

        while (!found && (currentItem != null)) {
            if (anEntry.equals(currentItem.getData())) {
                found = true; // break
            } else {
                currentItem = currentItem.getNext();
            }
        }

        return found;
    }

    @Override
    public int getNumberOfItem() {
        return numberOfItem;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = getNumberOfItem() == 0;

        return result;
    }

    private Node<T> getNodeAt(int givenPosition) {
        Node<T> currentItem = firstItem;

        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node<T> currentItem = firstItem;
        while (currentItem != null) {
            outputStr += currentItem.getData() + "\n";
            currentItem = currentItem.getNext();
        }
        return outputStr;
    }

    private void displayChain(Node nodeOne) { // display the nodes in the list
        if (nodeOne != null) {
            System.out.print(nodeOne.getData() + " ");
            displayChain(nodeOne.getNext());
        }
    }
}

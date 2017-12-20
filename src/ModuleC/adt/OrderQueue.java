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
public class OrderQueue<T> implements  OrderInterface<T> {
    private Node<T> firstOrder;
    private Node<T> lastOrder;
    private int numberOfOrder = 0;
    
    public OrderQueue () {
        clearQueue();
    }
    
    @Override
    public void clearQueue() {
        this.firstOrder = null;
        this.lastOrder = null;
        numberOfOrder = 0;
    }
    
    @Override
    public void enqueueOrder(T newOrder) {
        Node<T> newOrderLink = new Node(newOrder);
        
        if (isEmpty()) {
            firstOrder = newOrderLink;
        } else {
            lastOrder.setNext(newOrderLink);
        }
        
        lastOrder = newOrderLink;
        numberOfOrder++;
    }
    
    @Override
    public T dequeueOrder() {
        T first = null;
        
        if (!isEmpty()) {
            first = this.firstOrder.getData();
            this.firstOrder = (this.firstOrder.getNext());
            
            if (this.firstOrder == null)
                lastOrder = null;
        }
        
        numberOfOrder--;
        return first;
    }
    
    @Override
    public T getFirstOrder() {
        T first = null;
        
        if (!isEmpty())
            first = this.firstOrder.getData();
        
        return first;
    }
    
    @Override
    public T getOrder(int givenPosition) {
        T order = null;
        
        if ((givenPosition >= 1) && !isEmpty()) {
            order = getOrderAt(givenPosition).getData();
        }
        
        return order;
    }
    
    private Node<T> getOrderAt(int givenPosition) {
        Node<T> currentOrder = firstOrder;

        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentOrder = currentOrder.getNext();
        }

        return currentOrder;
    }
    
    @Override
    public T getLastOrder() {
        T last = null;
        
        if (!isEmpty())
            last = this.lastOrder.getData();
        
        return last;
    }
    
    @Override
    public int getNumberOfOrder() {
        return this.numberOfOrder;
    }
    
    @Override
    public boolean isEmpty() {
        return (this.firstOrder == null) && (this.lastOrder == null) && (numberOfOrder == 0);
    }
}

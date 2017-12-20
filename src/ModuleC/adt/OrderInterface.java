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
public interface OrderInterface<T> {
    public void enqueueOrder(T newOrder);
    public T dequeueOrder();
    public T getFirstOrder();
    public T getOrder(int givenPosition);
    public T getLastOrder();
    public int getNumberOfOrder();
    public boolean isEmpty();
    public void clearQueue();
    //public T getOrder(int givenPosition);
    //sort by order's item size
    //sort by order date
}

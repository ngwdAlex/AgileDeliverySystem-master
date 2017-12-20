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
public interface ItemInterface<T> {
    public boolean addItem(T newItem);
    public boolean addItem(int newPosition, T newItem);
    public T removeItem(int givenPosition);
    public void clearItem();
    public boolean replaceItem(int givenPosition, T newItem);
    public T getItem(int givenPosition);
    public boolean containsItem(T newItem);
    public int getNumberOfItem();
    public boolean isEmpty();
}

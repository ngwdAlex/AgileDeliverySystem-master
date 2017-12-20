package ModuleC.controller;

import ModuleA.entity.Customer;
import ModuleA.entity.Food;
import ModuleC.entity.Order;
import ModuleC.entity.OrderItem;
import ModuleC.ui.OrderUI;

public class CreateOrder {
    public Order order = new Order(OrderUI.ORDER_QUEUE.getNumberOfOrder() + 1);
    public int itemCnt = 1;
    public int orderItemQuantity = order.getItemList().getNumberOfItem();
    
    public void CreateOrder() {}
    
    public void updateItemList(Food selectedItem) {
        if (order.getItemList().getNumberOfItem() == 0) { // Check whether the list has been initialized
            addNewItem(selectedItem); // add item in the first index
        } else { // if the item list isn't empty
            boolean itemExistance = false; // check the existance of the object
            for (int i = 0 ; i < order.getItemList().getNumberOfItem() ; i++) { // compare the selected item with evey items in the list
                if (order.getItem(i).getFoodItem() == selectedItem) {
                    removeItem(i);
                    itemExistance = true;
                }
            }
            
            // if the item didn't selected before, add it into the list
            if (!itemExistance) {
                addNewItem(selectedItem);
            }
        }
    }
    
    public Order getOrder() {
        return order;
    }
    
    public int getOrderItemQuantity() {
        return order.getItemList().getNumberOfItem();
    }
    
    public String getOrderItemName(int givenPosition) {
        return getOrderItem(givenPosition).getFoodItem().getFoodName();
    }
    
    public void addNewItem(Food selectedItem) {
        order.setItem(selectedItem);
    }
    
    public void removeItem(int givenPosition) {
        order.getItemList().removeItem(givenPosition + 1);
    }
    
    public void addItemQuantity(int givenPosition, int addValue) {
        if (getItemQuantity(givenPosition) >= 0)
            setItemQuantity(givenPosition, getItemQuantity(givenPosition) + 1);
    }
    
    public void subtractItemQuantity(int givenPosition, int subtractValue) {
        if (getItemQuantity(givenPosition) > 0)
            setItemQuantity(givenPosition, getItemQuantity(givenPosition) - 1);
    }
    
    public int getItemQuantity(int givenPosition) {
        return getOrderItem(givenPosition).getItemQTY();
    }
    
    public void setItemQuantity(int givenPosition, int quantity) {
        getOrderItem(givenPosition).setItemQTY(quantity);
        updateSubTotal(givenPosition);
    }
    
    public OrderItem getOrderItem(int givenPosition) {
        return order.getItem(givenPosition);
    }
    
    public void updateSubTotal(int givenPosition) {
        getOrderItem(givenPosition).setSubTotal(calculateSubTotal(givenPosition));
    }
    
    public double getItemSubTotal(int givenPosition) {
        return getOrderItem(givenPosition).getSubTotal();
    }
    
    public double calculateSubTotal(int givenPosition) {
        return getOrderItem(givenPosition).getItemQTY() * getOrderItem(givenPosition).getFoodItem().getFoodPrice();
    }
    
    public void clearOrder(){
        order.getItemList().clearItem();
    }
    
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = null;
        
        for (int loopCnt = 1 ; loopCnt <= OrderUI.CUSTOMER_LIST.getNumberOfEntries() ; loopCnt++) {
            customer = OrderUI.CUSTOMER_LIST.getEntry(loopCnt); // retrieve the customer from the list
            if (customer.getCustTelNo().equals(phoneNumber))
                break;
            else
                customer = null;
        }
        
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        order.setCustomer(customer);
    }
    
    public Customer getCustomer() {
        return order.getCustomer();
    }
}
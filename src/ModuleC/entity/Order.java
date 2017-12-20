package ModuleC.entity;

import ModuleC.adt.ItemInterface;
import ModuleA.entity.Customer;
import ModuleA.entity.Food;
import ModuleC.adt.ItemList;

public class Order{
    private ItemInterface<OrderItem> itemList = new ItemList<>();
    private int orderID;
    private Customer customer;

    public Order() {}
    
    public Order(int orderID) {
        this.orderID = orderID;
    }
    
    public void setItem(Food selectedItem) {
        this.itemList.addItem(new OrderItem(selectedItem));
    }
    
    public ItemInterface<OrderItem> getItemList(){
        return itemList;
    }

    public OrderItem getItem(int givenPosition){
        return itemList.getItem(givenPosition + 1);
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    @Override
    public String toString(){
        String formatOutput = "";
        for (int i = 1 ; i <= itemList.getNumberOfItem(); i++) {
            formatOutput += i + ".\t" + itemList.getItem(i).getFoodItem().getFoodName() + "\t" + itemList.getItem(i).getItemQTY() + "\n";
        }
        return formatOutput;
    }
}
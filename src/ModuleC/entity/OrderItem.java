package ModuleC.entity;

import ModuleA.entity.Food;

public class OrderItem {
    private Food foodItem;
    private int itemQTY;
    private double subTotal;

    public OrderItem() {}
    
    public OrderItem(Food item) {
        this.foodItem = item;
        this.itemQTY = 1;
        this.subTotal = this.foodItem.getFoodPrice();
    }
    
    public Food getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(Food foodItem) {
        this.foodItem = foodItem;
    }

    public int getItemQTY() {
        return itemQTY;
    }

    public void setItemQTY(int itemQTY) {
        this.itemQTY = itemQTY;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.controller;

import ModuleA.entity.Customer;
import ModuleC.adt.OrderInterface;
import ModuleC.adt.OrderQueue;
import ModuleC.entity.Order;
import ModuleC.ui.OrderUI;

/**
 *
 * @author Sing Keat
 */
public class RetrieveOrder {
    static public OrderInterface<Order> orderList = new OrderQueue<>();
    
    public OrderInterface<Order> retrieveOrderListByPhoneNumber(String phoneNum) {
        orderList = new OrderQueue<>();
        Customer customer = new CreateOrder().findCustomerByPhoneNumber(phoneNum);
        Order order = null;
        for (int loopCnt = 1 ; loopCnt <= OrderUI.ORDER_QUEUE.getNumberOfOrder() ; loopCnt++) {
            order = OrderUI.ORDER_QUEUE.getOrder(loopCnt);
            if (customer == order.getCustomer())
                orderList.enqueueOrder(order);
            
        }

        return orderList;
    }
    
//    public double calculateTotal(Order order) {
//        
//    }
}

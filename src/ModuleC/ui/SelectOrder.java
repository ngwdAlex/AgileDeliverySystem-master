/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.ui;

import ModuleC.adt.OrderInterface;
import ModuleC.controller.RetrieveOrder;
import ModuleC.entity.Order;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Sing Keat
 */
public class SelectOrder extends JPanel{
    private final JPanel jplPhoneNumber = new JPanel(new GridLayout(0, 2));
    private final JPanel jplOrderList = new JPanel();
    private final JLabel jlbPhoneNum = new JLabel("Customer Phone Number: ", SwingConstants.RIGHT);
    private final JTextField jtfPhoneNum = new JTextField();
    private final JButton jbtRetrieveOrder = new JButton("Retrieve Order");
    private final JButton jbtBack = new JButton("Back");
    
    public SelectOrder() {
        RetrieveOrderActList retrieveOrderAct = new RetrieveOrderActList();
        
        jbtRetrieveOrder.addActionListener(retrieveOrderAct);
        jbtBack.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new OrderUIType());
        });
        jplPhoneNumber.add(jlbPhoneNum);
        jplPhoneNumber.add(jtfPhoneNum);
        jplPhoneNumber.add(jbtBack);
        jplPhoneNumber.add(jbtRetrieveOrder);
        setLayout(new BorderLayout());
        add(jplPhoneNumber, BorderLayout.NORTH);
        add(jplOrderList, BorderLayout.CENTER);
    }
    
    public void initOrderListPanel() {
        jplOrderList.removeAll();
        for (int loopCnt = 1 ; loopCnt <= RetrieveOrder.orderList.getNumberOfOrder() ; loopCnt++) {
            System.out.println(RetrieveOrder.orderList.getOrder(loopCnt).getOrderID());
            System.out.println(RetrieveOrder.orderList.getNumberOfOrder());
            jplOrderList.add(orderListFactory(RetrieveOrder.orderList.getOrder(loopCnt).getOrderID()));
            jplOrderList.add(viewButtonFactory(RetrieveOrder.orderList.getOrder(loopCnt)));
        }
        jplOrderList.validate();
        jplOrderList.repaint();
    }
    
    public JLabel orderListFactory(Object orderDetail) {
        return new JLabel(orderDetail.toString());
    }
    
    public JButton viewButtonFactory(Order order) {
        JButton jbtView = new JButton("Select");
        jbtView.addActionListener((ActionEvent e) -> {
            new ShowOrderDetails(order);
        });
        return jbtView;
    }
    
    private class RetrieveOrderActList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RetrieveOrder retrieveOrder = new RetrieveOrder();
            try {
                retrieveOrder.retrieveOrderListByPhoneNumber(jtfPhoneNum.getText());
                initOrderListPanel();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Please enter another phone number.", "Phone Number not found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}

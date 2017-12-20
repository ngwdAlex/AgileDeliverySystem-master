package ModuleC.ui;

import ModuleA.adt.FoodInterface;
import ModuleA.adt.FoodList;
import ModuleA.entity.Food;
import ModuleA.entity.Menu;
import ModuleC.controller.CreateOrder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectMenuItem extends JPanel{
    private final JButton[] jbtFoodList;
    private JButton[] jbtDecrease;
    private JButton[] jbtIncrease;
    private JTextField[] jtfQuantity;
    private final JButton jbtOrder = new JButton("Confirm Order");
    private final JButton jbtCancel = new JButton("Cancel Order");
    private final JButton jbtReset = new JButton("Clear Cart");
    private final JPanel jpSelectFood;
    private final JPanel jpOrder = new JPanel(new BorderLayout());
    private final JPanel jpItemList = new JPanel();
    private final JPanel jpOrderAction = new JPanel();
    public CreateOrder createOrder = new CreateOrder();
    public OrderUI orderUI;
    public FoodInterface<Food> foodList = new FoodList<>();
    
    public SelectMenuItem(Menu selectedMenu){
        foodList = selectedMenu.getFoodList(); // get food list
        jbtFoodList = new JButton[foodList.getNumberOfFood()]; // allocate the jbutton size refer to food item quantity.
        jpSelectFood = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        PassSelectedFood passSelectedFood = new PassSelectedFood();
        // show all available Item on the Frame
        for (int i = 0, loopCnt = 1; i < foodList.getNumberOfFood() ; i++, loopCnt++){
            String foodButton = String.format("%s %n%nRM %.2f", foodList.getFoodEntry(loopCnt).getFoodName(), foodList.getFoodEntry(loopCnt).getFoodPrice());
            jbtFoodList[i] = new JButton("" + foodButton); // get the food from the list to buttons
            jbtFoodList[i].addActionListener(passSelectedFood);
            jpSelectFood.add(jbtFoodList[i], gbc);
            if (gbc.gridx < 3) {
                gbc.gridx++;
            } else {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }
        
        //initialize GUI
        setLayout(new BorderLayout());
        OrderActListn orderAL = new OrderActListn();
        jbtOrder.addActionListener(orderAL);
        jbtCancel.addActionListener(orderAL);
        jbtReset.addActionListener(orderAL);
        add(jpSelectFood, BorderLayout.CENTER);
        
        jpOrderAction.add(jbtOrder);
        jpOrderAction.add(jbtCancel);
        jpOrderAction.add(jbtReset);
        jpOrder.add(jpItemList, BorderLayout.CENTER);
        jpOrder.add(jpOrderAction, BorderLayout.SOUTH);
        add(jpOrder, BorderLayout.EAST);
    }
    
    private class PassSelectedFood implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            //get the selected button to update the item list.
            int selectedFoodIndex = 1;
            for (int loopCnt = 0 ; loopCnt < jbtFoodList.length ; loopCnt++) {
                if (jbtFoodList[loopCnt] == buttonClicked){
                    System.out.println(jbtFoodList[loopCnt].getText());
                    selectedFoodIndex += loopCnt;
                }
            }
            
            createOrder.updateItemList(foodList.getFoodEntry(selectedFoodIndex));
            System.out.print(createOrder.order.toString());
            updateItemPanel();
        } 
    }
    
    public void updateItemPanel(){
        jbtDecrease = new JButton[createOrder.getOrderItemQuantity()];
        jbtIncrease = new JButton[createOrder.getOrderItemQuantity()];
        jtfQuantity = new JTextField[createOrder.getOrderItemQuantity()];

        createAndShowGUI();
    }
    
    private class UpdateQuantity implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            // update the quantity of the item
            for (int loopCnt = 0; loopCnt < createOrder.getOrderItemQuantity() ; loopCnt++) {
                if (jbtDecrease[loopCnt] == buttonClicked)
                    createOrder.subtractItemQuantity(loopCnt, 1);
                else if (jbtIncrease[loopCnt] == buttonClicked)
                    createOrder.addItemQuantity(loopCnt, 1);
                
                // if the quantity is 0, remove it from the list
                if (createOrder.getItemQuantity(loopCnt) == 0)
                    createOrder.removeItem(loopCnt);
                else
                    jtfQuantity[loopCnt].setText(String.valueOf(createOrder.getItemQuantity(loopCnt)));
            }
            createAndShowGUI();
        }
    }
    
    public void createAndShowGUI() {
        UpdateQuantity updQty = new UpdateQuantity();
        jpItemList.removeAll();
        jpItemList.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int loopCnt = 0; loopCnt < createOrder.getOrderItemQuantity() ; loopCnt++) {
            jpItemList.add(new JLabel(createOrder.getOrderItemName(loopCnt)), gbc);
            gbc.gridx++;
            jbtDecrease[loopCnt] = new JButton("-");
            jbtDecrease[loopCnt].addActionListener(updQty);
            jbtIncrease[loopCnt] = new JButton("+");
            jbtIncrease[loopCnt].addActionListener(updQty);
            
            jtfQuantity[loopCnt] = new JTextField(String.valueOf(createOrder.getItemQuantity(loopCnt)));
            jtfQuantity[loopCnt].setFont(new Font("Arial", Font.BOLD, 18));
            jtfQuantity[loopCnt].setBackground(Color.white);
            jtfQuantity[loopCnt].setEditable(false);
            
            jpItemList.add(jbtDecrease[loopCnt], gbc);
            gbc.gridx++;
            jpItemList.add(jbtIncrease[loopCnt], gbc);
            gbc.gridx++;
            jpItemList.add(jtfQuantity[loopCnt], gbc);
            
            gbc.gridx = 0;
            gbc.gridy++;
        }
        jpItemList.validate();
        jpItemList.repaint();
    }
    
    public void createConfirmationBox() {
        if (createOrder.getOrderItemQuantity() == 0) { // if no food selected prompt warning message
            JOptionPane.showMessageDialog(null, "Please select at least 1 food.", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JDialog.setDefaultLookAndFeelDecorated(true);
            String formattedString = String.format("%3s %-20s %15s %8s%n", "No.", "FoodName", "Quantity", "Sub Total");
            double total = 0;
            for (int i = 0 ; i < createOrder.getOrderItemQuantity() ; i++) {
                total += createOrder.getItemSubTotal(i);
                String orderListString = String.format("%3d %-20s %8d RM %.2f%n", (i + 1), createOrder.getOrderItem(i).getFoodItem().getFoodName(), createOrder.getItemQuantity(i), createOrder.getItemSubTotal(i));
                formattedString += orderListString;
            }
            formattedString += "---------------------------------------------------------\n";
            formattedString += String.format("Total: RM %.2f%n", total);
            formattedString += "---------------------------------------------------------\n";
            formattedString += "Do you want to continue?";
            int response = JOptionPane.showConfirmDialog(null, formattedString, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
                case JOptionPane.NO_OPTION:
                    System.out.println("No button clicked");
                    break;
                case JOptionPane.YES_OPTION:
                    System.out.println("Yes button clicked");
                    createNewOrder();
                    break;
                case JOptionPane.CLOSED_OPTION:
                    System.out.println("JOptionPane closed");
                    break;
                default:
                    break;
            }
        }
    }
    
    public void createNewOrder() {
        String phoneNumber = JOptionPane.showInputDialog("Please provide your phone number. (xxx-xxxxxxx)");
        createOrder.setCustomer(createOrder.findCustomerByPhoneNumber(phoneNumber));
        if (createOrder.getCustomer() == null) { // if the phone number not match with any customer's phone number
            JOptionPane.showMessageDialog(null, "Please enter another phone number.", "Phone Number not found", JOptionPane.ERROR_MESSAGE);
        } else {
            OrderUI.ORDER_QUEUE.enqueueOrder(createOrder.getOrder());
            JOptionPane.showMessageDialog(null, "Your order has been created. Thank you for ordering.");
            new ShowOrderDetails(OrderUI.ORDER_QUEUE.getLastOrder());
            OrderUI.changePanel(new OrderUIType());
        }
    }
    
    
    
    private class OrderActListn implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            
            if (src.equals(jbtOrder)){
                System.out.println("Order button clicked");
                createConfirmationBox();
            }else if (src.equals(jbtReset)){
                System.out.println("Clear Cart button clicked");
                createOrder.clearOrder();
                updateItemPanel();
            }else if (src.equals(jbtCancel)){
                System.out.println("Cancel Order button clicked");
                createOrder.clearOrder();
                OrderUI.changePanel(new SelectRestaurant());
            }
        }
    }
}

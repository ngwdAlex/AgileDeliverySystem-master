/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleA.entity.Food;
import ModuleA.adt.FoodList;
import ModuleA.adt.FoodInterface;


/**
 *
 * @author User
 */
public class DeleteMenuItem extends JFrame{
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JLabel jblFoodName = new JLabel("Food Name :");
    private JLabel jblFoodPrice = new JLabel("Food Price :");
    private JLabel jblFoodDesc = new JLabel("Description :");
    
    
    private JTextField jtfFoodID = new JTextField();
    private JTextField jtfFoodName = new JTextField();
    private JTextField jtfFoodPrice = new JTextField();
    private JTextField jtfFoodDesc = new JTextField();   
  //  private JTextArea jtaFoodList = new JTextArea(20, 20);
    
    private JButton jbtDeleteFood = new JButton("Delete Food");
    private JButton jbtReset = new JButton("Reset");
    
    public FoodInterface<Food> foodList = new FoodList<>();

    
    public DeleteMenuItem(){
        initializeList();
        setTitle("Delete Menu");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblFoodID.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblFoodID.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodName.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setVerticalAlignment(SwingConstants.CENTER);
        
   //     jtaFoodList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(6,2));
        jpNew.add(jblFoodID);
        jpNew.add(jtfFoodID);
        jpNew.add(jblFoodName);
        jpNew.add(jtfFoodName);
        jpNew.add(jblFoodPrice);
        jpNew.add(jtfFoodPrice);
        jpNew.add(jblFoodDesc);
        jpNew.add(jtfFoodDesc);
        jpNew.add(jbtDeleteFood);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        SearchListener foodListener = new SearchListener();
        jtfFoodID.addActionListener(foodListener);
        DeleteMenuListener updateListener = new DeleteMenuListener();
        jbtDeleteFood.addActionListener(updateListener);
        ResetListener resetListener = new ResetListener();
        jbtReset.addActionListener(resetListener);
 //       JScrollPane scrollPane = new JScrollPane(jtaFoodList);
 //       add(scrollPane, BorderLayout.CENTER);
    }
    
        private class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int foodID = Integer.parseInt(jtfFoodID.getText());
                    
                    if(foodID == 1001){
                        jtfFoodName.setText("McD Chicken");
                        jtfFoodPrice.setText("8.50");
                        jtfFoodDesc.setText("Delicious!!");              
                    }else if(foodID == 1002){
                        jtfFoodName.setText("KFC Chizza");
                        jtfFoodPrice.setText("9.50");
                        jtfFoodDesc.setText("Delicious!!"); 
                    }else{ 
                        JOptionPane.showMessageDialog(null, "No such food items");
                        clearText();
                    }
                    
                    
                    
                    //Menu menu = new Menu(menuName, menuPrice, menuStatus, menuPromo);
                   // Food food = new Food(foodID, foodName, foodPrice, foodDesc);
                 //   foodList.addFood(food);
                  //  jtaFoodList.setText("Food List\n" + foodList);
                    //menuInt.createMenu(menu);
                    //jtaMenuList.setText(menuInt.toMenuString());
                    
                }catch(Exception ex){
            //        jtaFoodList.setText("No such Menu \n Error: " + ex.getMessage());
               }
            }
        }
        
        private class DeleteMenuListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                int foodID = Integer.parseInt(jtfFoodID.getText());
                String foodName = jtfFoodName.getText();
                double foodPrice = Double.parseDouble(jtfFoodPrice.getText());
                String foodDesc = jtfFoodDesc.getText();
                Food food = new Food(foodID, foodName, foodPrice, foodDesc);
                foodList.DeleteFood(foodID);
                JOptionPane.showConfirmDialog(null, "Do you want to delete this menu?");
                JOptionPane.showMessageDialog(null, "Menu has been deleted");
                clearText();
                
                
                
            }
        }
        private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
                 //jtaMenuList.setText(menuInt.toMenuString());
             }
        }
        
        public void clearText(){
            jtfFoodID.setText("");
            jtfFoodName.setText("");
            jtfFoodPrice.setText("");
            jtfFoodDesc.setText("");
        }
        
        private void initializeList() {
            
            //jtaMenuList.setText(menuInt.toMenuString());
            
        }     
    
        public static void main(String[] args) {
            DeleteMenuItem frame = new DeleteMenuItem();
            frame.getContentPane().setPreferredSize(new Dimension(400, 200));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        }
    
}

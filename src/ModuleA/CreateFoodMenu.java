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
public class CreateFoodMenu extends JFrame{
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JLabel jblFoodName = new JLabel("Food Name :");
    private JLabel jblFoodPrice = new JLabel("Food Price :");
    private JLabel jblFoodDesc = new JLabel("Description :");
    
    
    private JTextField jtfFoodID = new JTextField();
    private JTextField jtfFoodName = new JTextField();
    private JTextField jtfFoodPrice = new JTextField();
    private JTextField jtfFoodDesc = new JTextField();   
    private JTextArea jtaFoodList = new JTextArea(20, 20);
    
    private JButton jbtCreateFood = new JButton("Create Food");
    private JButton jbtReset = new JButton("Reset");
    
    public FoodInterface<Food> foodList = new FoodList<>();

    
    public CreateFoodMenu(){
        initializeList();
        setTitle("Create Menu");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblFoodID.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblFoodID.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodName.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaFoodList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(6,2));
        jpNew.add(jblFoodID);
        jpNew.add(jtfFoodID);
        jpNew.add(jblFoodName);
        jpNew.add(jtfFoodName);
        jpNew.add(jblFoodPrice);
        jpNew.add(jtfFoodPrice);
        jpNew.add(jblFoodDesc);
        jpNew.add(jtfFoodDesc);
        jpNew.add(jbtCreateFood);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        CreateMenuListener createListener = new CreateMenuListener();
        jbtCreateFood.addActionListener(createListener);
        JScrollPane scrollPane = new JScrollPane(jtaFoodList);
        add(scrollPane, BorderLayout.CENTER);
    }
     private class CreateMenuListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                int foodID = Integer.parseInt(jtfFoodID.getText());
                String foodName = jtfFoodName.getText();
                double foodPrice = Double.parseDouble(jtfFoodPrice.getText());
                String foodDesc = jtfFoodDesc.getText();
                Food food = new Food(foodID, foodName, foodPrice, foodDesc);
                foodList.addFood(food);
                JOptionPane.showConfirmDialog(null, "Do you want to create this menu?");
                JOptionPane.showMessageDialog(null, "Menu has been created");
               
                String resultString ="Food List \n";
                resultString+= "Food ID: " + Integer.parseInt(jtfFoodID.getText());
                resultString += "\nFood Name : " + jtfFoodName.getText();
                resultString += "\nFood Price :" + Double.parseDouble(jtfFoodPrice.getText());
                resultString += "\nDescription :" + jtfFoodDesc.getText();
                jtaFoodList.setText(resultString);
                clearText();
                
                
            }
            
            
             
             public void clearText(){
                jtfFoodID.setText("");
                jtfFoodName.setText("");
                jtfFoodPrice.setText("");
                jtfFoodDesc.setText("");
            }
            
             
        }
     
      
            private void initializeList() {
            
            //jtaMenuList.setText(menuInt.toMenuString());
            }     
            
        public static void main(String[] args) {
            CreateFoodMenu frame = new CreateFoodMenu();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        }
     }
        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleB.adt.DeliveryProfile;
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.entity.DeliveryMan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kevin lim
 */
public class UpdateStatus extends JFrame{
         private JLabel jblID = new JLabel("Delivery Man ID:");
         private JLabel jblStatus = new JLabel("Delivery Man Status:");
         
         private JTextField jtfID = new JTextField();
         private JTextField jtfStatus = new JTextField();
         
         private JButton search = new JButton("Search");
         private JButton resigned = new JButton("Resigned");
         private JTextArea jtaStaffList = new JTextArea(20, 20); // StaffList
         public DeliveryProfileInterface dpi = new DeliveryProfile();
         
         public UpdateStatus(){
            initializeList();

            setTitle("Update Resigned Status");
            jblID.setHorizontalAlignment(SwingConstants.CENTER);
            jblStatus.setHorizontalAlignment(SwingConstants.CENTER);
            
             jblID.setHorizontalAlignment(SwingConstants.CENTER);
             jblStatus.setHorizontalAlignment(SwingConstants.CENTER);
         
            jtaStaffList.setEditable(false);
            JPanel jpInfo = new JPanel(new GridLayout(3,2));
            jpInfo.add(jblID);
            jpInfo.add(jtfID);
            jpInfo.add(jblStatus);
            jpInfo.add(jtfStatus);
            jpInfo.add(search);
            jpInfo.add(resigned);
            
            add(jpInfo, BorderLayout.NORTH);
        
            SearchProfileButtonListener listener = new SearchProfileButtonListener();
            search.addActionListener(listener);

            ResignedButtonListener listener2 = new ResignedButtonListener();
            resigned.addActionListener(listener2);

            JScrollPane scrollPane = new JScrollPane(jtaStaffList);
            add(scrollPane, BorderLayout.CENTER);
         }
         
        private class SearchProfileButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     int id = Integer.parseInt(jtfID.getText());
                    jtfStatus.setText(dpi.retrieveSelectedProfile(id).getStatus());
                  }catch(Exception ex){
                    jtaStaffList.setText("Invalid Input due to invalid inputs.\n Error:" + ex.getMessage());
                }
            }
        }
        
        private class ResignedButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dpi.updateResigned(Integer.parseInt(jtfID.getText()));
                    initializeList();
                }catch(Exception ex){
                    jtaStaffList.setText("Invalid Input due to invalid inputs.\n Error:" + ex.getMessage());
                }
            }
        }
        
      private void initializeList() {
            jtaStaffList.setText(dpi.toResignedString());
      }
        
    public static void main(String[] args) {
      UpdateStatus frame = new UpdateStatus();
      frame.getContentPane().setPreferredSize(new Dimension(600, 500));
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      //frame.setResizable(false);
    }
}

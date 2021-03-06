/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD;
import ModuleB.adt.DeliveryProfile;
import ModuleB.adt.DeliveryProfileInterface;
import ModuleB.entity.DeliveryMan;
import ModuleD.entity.Schedule;
import ModuleD.adt.ScheduleInterface;
//import ModuleB.adt.*;
//import ModuleB.entity.*;
//import ModuleC.adt.ListInterface;
//import ModuleC.adt.OrderInterface;
//import ModuleC.entity.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Ng
 */
public class CreateJob extends javax.swing.JFrame {
//    public static ScheduleInterface<Schedule> scheduleQueue = new ScheduleQueue<>();
    public static ScheduleInterface<Schedule> scheduleList = new ModuleD.adt.ScheduleADT<>();
    public static DeliveryProfileInterface<DeliveryMan> deliveryProfileList = new DeliveryProfile<>();
//    public static ScheduleInterface<Schedule> scheduleList = new ScheduleList<>();
//    public static OrderInterface<Order> orderList = new ModuleC.adt.OrderQueue<>();
    
    public void setList(ScheduleInterface<Schedule> scheduleList){
        this.scheduleList = scheduleList;
    }
    
    public ScheduleInterface<Schedule> getList(){
        return this.scheduleList;
    }
    
    public void setList (DeliveryProfileInterface<DeliveryMan> deliveryProfileList){
        this.deliveryProfileList = deliveryProfileList;   // setter for super list object
    }
    
    public DeliveryProfileInterface<DeliveryMan> getProfileList (){
        return this.deliveryProfileList;      // getter for super list object
    }
    /**
     * Creates new form CreateJob
     */
    public CreateJob() {
        initComponents();
        initialize();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbDeliveryman = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbOrderNo = new javax.swing.JComboBox();
        btnAssign = new javax.swing.JButton();
        lblDeliverymanName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbDeliveryman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDeliverymanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Job Assignation");

        jLabel2.setText("Deliveryman Number:");

        jLabel3.setText("Order Number:");

        btnAssign.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAssign.setText("ASSIGN");
        btnAssign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAssignMouseClicked(evt);
            }
        });

        jLabel5.setText("Deliveryman Name:");

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModuleD/icon_taxa_nav_arrow_left.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbOrderNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblBack)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbDeliveryman, 0, 164, Short.MAX_VALUE)
                                    .addComponent(lblDeliverymanName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDeliveryman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeliverymanName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAssignMouseClicked
        Object selectedDeliveryman = jcbDeliveryman.getSelectedItem();
        int selectedDelivery = jcbDeliveryman.getSelectedIndex();
        int deliveryman = (int)selectedDeliveryman;
        jcbDeliveryman.removeItemAt(selectedDelivery);
        Object order = jcbOrderNo.getSelectedItem();
        int selectedOrder = jcbOrderNo.getSelectedIndex();
        String orderNo = String.valueOf(order);
        jcbOrderNo.removeItemAt(selectedOrder);
        Schedule schedule = new Schedule(deliveryman,orderNo);
        scheduleList.addSchedule(schedule);
//        scheduleList.addSchedule(deliveryman,orderNo);
//        System.out.print(scheduleList);
        
        //set status to delivering
        deliveryProfileList.setDeliveryStatus(deliveryman, "Delivering", true ,false); 
        JOptionPane.showMessageDialog(null, "Delivery job has successfully assigned!");
    }//GEN-LAST:event_btnAssignMouseClicked

    private void jcbDeliverymanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDeliverymanActionPerformed
        String selected = String.valueOf(jcbDeliveryman.getSelectedItem());
        for(int i = 0; i<scheduleList.getNumberOfSchedule();i++){
            int staff = scheduleList.getSchedule(i).getStaffID();
            if(String.valueOf(staff).equals(selected)){
                String name = scheduleList.getSchedule(i).getStaffName();
                lblDeliverymanName.setText(name);
            }
        }
    }//GEN-LAST:event_jcbDeliverymanActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        this.dispose();
        ModuleDDriver driver = new ModuleDDriver();
        driver.setLocationRelativeTo(null);
        driver.setDefaultCloseOperation(EXIT_ON_CLOSE);
        driver.setVisible(true);
    }//GEN-LAST:event_lblBackMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateJob driver = new CreateJob();
                driver.setLocationRelativeTo(null);
                driver.setDefaultCloseOperation(EXIT_ON_CLOSE);
                driver.setVisible(true);            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcbDeliveryman;
    private javax.swing.JComboBox jcbOrderNo;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDeliverymanName;
    // End of variables declaration//GEN-END:variables

    private void initialize(){
        Schedule initializeList1, initializeList2, initializeList3, initializeList4,initializeList5,
                            initializeList6,initializeList7,initializeList8,initializeList9,
                            initializeList10,initializeList11,initializeList12,initializeList13,
                            initializeList14,initializeList15,initializeList16,initializeList17,
                            initializeList18,initializeList19,initializeList20,initializeList21,initializeList22;
                    initializeList1= new Schedule("A001","LimKH", 1629,"A01", "pewdiepie", "0162313212", "Delivering","5min");
                    initializeList2= new Schedule("A002","LimKW", 1111,"A02", "MsTingTT", "012432434", "Delivering","5min");
                    initializeList3= new Schedule("A003","LowSK",3456, "A03", "AhLiao", "01312321213", "Delivering","5min");
                    initializeList4= new Schedule("A004","NgWD",9909, "A04", "Kazuma", "015213797", "Delivering","5min");     
                    initializeList5= new Schedule("A005","LooJW",1233,"A05","Kalima","01124356","Delivering","5min");
                    initializeList6= new Schedule("A006","LimJJ",1012,"A06", "LeongFoei", "01239909", "Delivering","5min");
                    initializeList7= new Schedule("A007","MahHW",3757,"A07","KongKong","012283747","Delivering","5min");
                    initializeList8= new Schedule("A008","LoiKH",9610,"A08","MigMing","012636383","Delivering","5min"); 
                    initializeList9= new Schedule("A009","LimNF",5566,"A09","MsTing","0192726363","Delivering","5min");
                    initializeList10= new Schedule("A010","LohKC",6969,"A10","KitKat","017265353","Delivering","5min");
                    
                    initializeList11= new Schedule("A011","LimKH", 1629,"A11", "Kari", "012213778", "Delivering","5min");
                    initializeList12= new Schedule("A012","LimKW", 1111,"A12", "Yolo", "0162328212", "Delivering","5min");
                    initializeList13= new Schedule("A013","LowSK", 3456,"A13", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList14= new Schedule("A015","LowSK", 3456,"A14", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList15= new Schedule("A016","LooJW", 1233,"A15", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList16= new Schedule("A017","LimJJ", 1012,"A16", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList17= new Schedule("A018","LimJJ", 1012,"A17", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList18= new Schedule("A019","LoiKH", 9610,"A18", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList19= new Schedule("A020","LimNF", 5566,"A19", "Hahaha", "0198377213", "Delivering","5min");
                    initializeList20= new Schedule("A021","LimNF", 5566,"A20", "Hahaha", "0198377213", "Delivering","5min");
                    
                    //completed jobs
                    initializeList21= new Schedule("A022","LimKH", 1629,"A21", "Doggo", "0198377213", "Completed","5min");
                    initializeList22= new Schedule("A023","LimKH", 1629,"A22", "Cloud", "0198377213", "Completed","5min");
        scheduleList.addSchedule(initializeList1);
        scheduleList.addSchedule(initializeList2);
        scheduleList.addSchedule(initializeList3);
        scheduleList.addSchedule(initializeList4);
        scheduleList.addSchedule(initializeList5);
        scheduleList.addSchedule(initializeList6);
        scheduleList.addSchedule(initializeList7);
        scheduleList.addSchedule(initializeList8);
        scheduleList.addSchedule(initializeList9);
        scheduleList.addSchedule(initializeList10);
        scheduleList.addSchedule(initializeList11);
        scheduleList.addSchedule(initializeList12);
        scheduleList.addSchedule(initializeList13);
        scheduleList.addSchedule(initializeList14);
        scheduleList.addSchedule(initializeList15);
        scheduleList.addSchedule(initializeList16);
        scheduleList.addSchedule(initializeList17);            
        scheduleList.addSchedule(initializeList18);
        scheduleList.addSchedule(initializeList19);
        scheduleList.addSchedule(initializeList20);
        scheduleList.addSchedule(initializeList21);
        scheduleList.addSchedule(initializeList22);
        
        

        for(int i = 0; i<scheduleList.getNumberOfSchedule();i++){
            int staff = scheduleList.getSchedule(i).getStaffID();
            jcbDeliveryman.addItem(staff);
            
            String order = scheduleList.getSchedule(i).getOrderID();
            jcbOrderNo.addItem(order);

        }
        
        
//            jcbDeliveryman.addActionListener(jcbOrderNo);
//        for(int i = 0; i<scheduleList.getNumberOfSchedule();i++){
//            jcbOrderNo.addItem(scheduleList.getSchedule(i).getOrderID());
//        }
    }
}

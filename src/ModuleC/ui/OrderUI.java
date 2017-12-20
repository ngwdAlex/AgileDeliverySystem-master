package ModuleC.ui;

import ModuleA.adt.AffiliatesList;
import ModuleA.adt.AffiliatesRegistrationInterface;
import ModuleA.entity.Customer;
import ModuleA.entity.Food;
import ModuleA.entity.Menu;
import ModuleA.entity.Restaurant;
import ModuleC.adt.OrderInterface;
import ModuleC.adt.OrderQueue;
import ModuleC.entity.Order;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderUI extends JFrame{
    private final static JPanel JP_CONTENT = new JPanel();
    final static public OrderInterface<Order> ORDER_QUEUE = new OrderQueue<>();
    final static public AffiliatesRegistrationInterface<Restaurant> RESTAURANT_LIST = new AffiliatesList<>();
    final static public AffiliatesRegistrationInterface<Customer> CUSTOMER_LIST = new AffiliatesList<>();
    
    public OrderUI() {
        setTitle("Order");
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JP_CONTENT.setLayout(new BoxLayout(JP_CONTENT, BoxLayout.Y_AXIS));
        add(JP_CONTENT);
        changePanel(new OrderUIType());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RESTAURANT_LIST.add(new Restaurant("McD", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("KFC", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("Pizza Hut", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("Domino Pizza", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant5", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant6", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant7", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant8", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant9", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.add(new Restaurant("restaurant10", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.getEntry(1).setMenu(new Menu(1, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(1).setMenu(new Menu(2, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(1).setMenu(new Menu(3, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(2).setMenu(new Menu(4, "X'mas", "unavailable"));
        RESTAURANT_LIST.getEntry(2).setMenu(new Menu(5, "Lunar New Year", "available"));
        RESTAURANT_LIST.getEntry(2).setMenu(new Menu(6, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(3).setMenu(new Menu(7, "X'mas", "unavailable"));
        RESTAURANT_LIST.getEntry(3).setMenu(new Menu(8, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(3).setMenu(new Menu(9, "Chinese New Year", "available"));
        RESTAURANT_LIST.getEntry(4).setMenu(new Menu(10, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(4).setMenu(new Menu(11, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(4).setMenu(new Menu(12, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(5).setMenu(new Menu(13, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(5).setMenu(new Menu(14, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(5).setMenu(new Menu(15, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(6).setMenu(new Menu(16, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(6).setMenu(new Menu(17, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(6).setMenu(new Menu(18, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(7).setMenu(new Menu(19, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(7).setMenu(new Menu(20, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(7).setMenu(new Menu(21, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(8).setMenu(new Menu(22, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(8).setMenu(new Menu(23, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(8).setMenu(new Menu(24, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(9).setMenu(new Menu(25, "X'mas", "available"));
        RESTAURANT_LIST.getEntry(9).setMenu(new Menu(26, "Lunar New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(9).setMenu(new Menu(27, "Chinese New Year", "unavailable"));
        RESTAURANT_LIST.getEntry(1).getMenu(1).setFood(new Food(1, "McD Chicken", 8.50, "promo"));
        RESTAURANT_LIST.getEntry(1).getMenu(1).setFood(new Food(2, "Ayam goreng", 8.50,"promo"));
        RESTAURANT_LIST.getEntry(1).getMenu(1).setFood(new Food(3, "name02", 2.00,"promo"));
        RESTAURANT_LIST.getEntry(1).getMenu(1).setFood(new Food(4, "name03", 3.00,"promo"));
        RESTAURANT_LIST.getEntry(2).getMenu(2).setFood(new Food(5, "KFC Chizza", 12.50,"promo"));
        RESTAURANT_LIST.getEntry(2).getMenu(2).setFood(new Food(6, "name12", 12.00,"promo"));
        RESTAURANT_LIST.getEntry(2).getMenu(2).setFood(new Food(7, "name13", 13.00,"promo"));
        RESTAURANT_LIST.getEntry(2).getMenu(2).setFood(new Food(8, "name14", 14.00,"promo"));
        RESTAURANT_LIST.getEntry(3).getMenu(3).setFood(new Food(9, "Pepperoni", 15.00,"promo"));
        RESTAURANT_LIST.getEntry(3).getMenu(3).setFood(new Food(10, "name22", 22.00, "promo"));
        RESTAURANT_LIST.getEntry(3).getMenu(3).setFood(new Food(11, "name23", 23.00, "promo"));
        RESTAURANT_LIST.getEntry(4).getMenu(1).setFood(new Food(12, "BBQ Chicken", 13.00, "promo"));
        RESTAURANT_LIST.getEntry(5).getMenu(1).setFood(new Food(13, "name41", 41.00, "promo"));
        RESTAURANT_LIST.getEntry(5).getMenu(1).setFood(new Food(14, "name42", 42.00, "promo"));
        
        CUSTOMER_LIST.add(new Customer("Lim Kah Him", "971234-12-1234", "011-1111111", "No1/A, jalan a, taman b, 533000 Kuala Lumpur", "kevimlim@gmail.com"));
        CUSTOMER_LIST.add(new Customer("Lim Kah Wai", "950827-10-9431", "013-3333333", "No2/A, jalan a, taman b, 533000 Kuala Lumpur", "khlim@gmail.com"));
        CUSTOMER_LIST.add(new Customer("Low Sing Keat", "971010-14-5050", "012-2222222", "No3/A, jalan a, taman c, 533000 Kuala Lumpur", "sklow@gmail.com"));
        CUSTOMER_LIST.add(new Customer("Ng Wen Da", "95050-08-0202", "014-4444444", "No4/A, jalan a, taman b, 533000 Kuala Lumpur", "wdng@gmail.com"));
        new OrderUI();
    }
    
    //move this to main page, change the jpSelectRestaurant name
    public static void changePanel(JPanel newPanel){
        JP_CONTENT.removeAll();
        JP_CONTENT.add(newPanel);
        JP_CONTENT.validate();
        JP_CONTENT.repaint();
    }
}

class OrderUIType extends JPanel {
    private final JLabel jlbWelcomeBanner = new JLabel("Welcome to Fast Food Delivery.", SwingConstants.CENTER);
    private final JButton jbtOrder = new JButton("Create Order");
    private final JButton jbtViewOrder = new JButton("View Orders");
    private final JPanel jplButtons = new JPanel(new FlowLayout());
    
    public OrderUIType() {
        UITypeActionListnr typeAct = new UITypeActionListnr();
        jbtOrder.addActionListener(typeAct);
        jbtViewOrder.addActionListener(typeAct);
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        jplButtons.add(jbtOrder);
        jplButtons.add(jbtViewOrder);
        add(jlbWelcomeBanner);
        add(jplButtons);
    }
    
    private class UITypeActionListnr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            
            if (src.equals(jbtOrder)){
                OrderUI.changePanel(new SelectRestaurant());
            }else if (src.equals(jbtViewOrder)){
                OrderUI.changePanel(new SelectOrder());
            }
        }
    }
}
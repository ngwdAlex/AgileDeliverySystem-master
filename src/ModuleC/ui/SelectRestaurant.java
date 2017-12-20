package ModuleC.ui;

import ModuleA.entity.Restaurant;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectRestaurant extends JPanel{
    private final JButton[] jbtRestaurantList;
    private final JPanel jpSelectRestaurant;
    
    public SelectRestaurant(){
        PassSelectedMenu passSelectedRest = new PassSelectedMenu();

        jbtRestaurantList = new JButton[OrderUI.RESTAURANT_LIST.getNumberOfEntries()];
        jpSelectRestaurant = new JPanel(new GridLayout(0, 5));
        //change the loop refer to restaurantlist size
        for (int i = 0, loopCnt = 1 ; i < OrderUI.RESTAURANT_LIST.getNumberOfEntries() ; i++, loopCnt++){
            jbtRestaurantList[i] = new JButton("" + OrderUI.RESTAURANT_LIST.getEntry(loopCnt).getName()); // get the restaurants from the list to buttons
            jbtRestaurantList[i].addActionListener(passSelectedRest);
            jpSelectRestaurant.add(jbtRestaurantList[i]);
        }

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(jpSelectRestaurant);
    }
    
    private class PassSelectedMenu implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            Restaurant selectedRestaurant = null;
            for (int loopCnt = 0 ; loopCnt < OrderUI.RESTAURANT_LIST.getNumberOfEntries() ; loopCnt++) {
                if (jbtRestaurantList[loopCnt] == buttonClicked)
                    selectedRestaurant = OrderUI.RESTAURANT_LIST.getEntry(loopCnt + 1);
            }
            
            for (int loopCnt = 0 ; loopCnt < selectedRestaurant.getMenuList().getNumberOfMenu() ; loopCnt++) {
                if (selectedRestaurant.getMenu(loopCnt + 1).getMenuStatus().equalsIgnoreCase("available")) {
                    OrderUI.changePanel(new SelectMenuItem((selectedRestaurant.getMenu(loopCnt + 1))));
                    break;
                }
            }
        }
    }
}

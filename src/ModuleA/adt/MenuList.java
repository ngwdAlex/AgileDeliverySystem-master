/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.adt.MenuInterface;
import ModuleA.adt.MenuList;
import ModuleA.entity.Restaurant;
import ModuleA.entity.Menu;
import ModuleA.entity.Food;
/**
 *
 * @author User
 */
public class MenuList<T> implements MenuInterface<T> {
    
    private MenuData firstMenu;
    private int numberMenuOfEntries;
    
    public MenuList(){
        clearMenu();
    }
    
    public final void clearMenu(){
        firstMenu = null;
        numberMenuOfEntries = 0;
    }
    
    public boolean addMenu(T newMenu){
        MenuData newMenuData = new MenuData(newMenu);
        if(isMenuEmpty()){
            firstMenu = newMenuData;
        }else{
            MenuData currentMenuData = firstMenu;
            while(currentMenuData.nextMenu != null){
                currentMenuData = currentMenuData.nextMenu;
            }
             currentMenuData.nextMenu = newMenuData;
        }
        numberMenuOfEntries ++;
        return true;
    }
    
    public boolean addMenu(int newMenuPosition, T newMenu){
        boolean isSuccessful = true;

    if ((newMenuPosition >= 1) && (newMenuPosition <= numberMenuOfEntries + 1)) {
      MenuData newMenuData = new MenuData(newMenu);

      if (isMenuEmpty() || (newMenuPosition == 1)) {     
        newMenuData.nextMenu = firstMenu;
        firstMenu = newMenuData;
      } else {								                    
        MenuData menuBefore = firstMenu;
        for (int i = 1; i < newMenuPosition - 1; ++i) {
          menuBefore = menuBefore.nextMenu;		
        }

        newMenuData.nextMenu = menuBefore.nextMenu;	
        menuBefore.nextMenu = newMenuData;		
      }

      numberMenuOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T DeleteMenu(int givenMenuPosition){
         T result = null;                 

    if ((givenMenuPosition >= 1) && (givenMenuPosition <= numberMenuOfEntries)) {
      if (givenMenuPosition == 1) {      
        result = firstMenu.menuData;    
        firstMenu = firstMenu.nextMenu;
      } else {                         
        MenuData menuBefore = firstMenu;
        for (int i = 1; i < givenMenuPosition - 1; ++i) {
          menuBefore = menuBefore.nextMenu;		
        }
        result = menuBefore.nextMenu.menuData;  
        menuBefore.nextMenu = menuBefore.nextMenu.nextMenu;	
      } 																// one to be deleted (to disconnect node from chain)

      numberMenuOfEntries--;
    }

    return result; 
    }
    public boolean updateMenu(int givenMenuPosition, T newMenu){
        boolean isSuccessful = true;

    if ((givenMenuPosition >= 1) && (givenMenuPosition <= numberMenuOfEntries)) {
      MenuData currentMenuData = firstMenu;
      for (int i = 0; i < givenMenuPosition - 1; ++i) {
      
        currentMenuData = currentMenuData.nextMenu;
      }
      currentMenuData.menuData = newMenu;	
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T getMenuEntry(int givenMenuPosition){
        T result = null;

    if ((givenMenuPosition >= 1) && (givenMenuPosition <= numberMenuOfEntries)) {
      MenuData currentMenuData = firstMenu;
      for (int i = 0; i < givenMenuPosition - 1; ++i) {
        currentMenuData = currentMenuData.nextMenu;
      }
      result = currentMenuData.menuData;	
    }

    return result;
    }
    
    public int getNumberOfMenu(){
        return numberMenuOfEntries;
    }
    
    
    public boolean isMenuEmpty() {
    boolean result;

    result = numberMenuOfEntries == 0;

    return result;
  }

    public String toMenuString() {
    String outputStr = "";
    MenuData currentMenuData = firstMenu;
    while (currentMenuData != null) {
      outputStr += currentMenuData.menuData + "\n";
      currentMenuData = currentMenuData.nextMenu;
    }
    return outputStr;
  }
    
    
private class MenuData {

    private T menuData;
    private MenuData nextMenu;

    private MenuData(T menuData) {
      this.menuData = menuData;
      this.nextMenu = null;
    }

    private MenuData(T menuData, MenuData nextMenu) {
      this.menuData = menuData;
      this.nextMenu = nextMenu;
    }
  }
        
}

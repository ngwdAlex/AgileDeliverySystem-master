/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.FoodList;
import ModuleA.entity.Restaurant;
import ModuleA.entity.Menu;
import ModuleA.entity.Food;
/**
 *
 * @author User
 */
public class FoodList<T> implements FoodInterface<T> {
    private FoodData firstFood;
    private int numberFoodOfEntries;
    
    public FoodList(){
        clearFood();
    }
    
    public final void clearFood(){
        firstFood = null;
        numberFoodOfEntries = 0;
    }
    
    public boolean addFood(T newFood){
        FoodData newFoodData = new FoodData(newFood);
        if(isFoodEmpty()){
            firstFood = newFoodData;
        }else{
            FoodData currentFoodData = firstFood;
            while(currentFoodData.nextFood != null){
                currentFoodData = currentFoodData.nextFood;
            }
             currentFoodData.nextFood = newFoodData;
        }
        numberFoodOfEntries ++;
        return true;
    }
    
    public boolean addFood(int newFoodPosition, T newFood){
        boolean isSuccessful = true;

    if ((newFoodPosition >= 1) && (newFoodPosition <= numberFoodOfEntries + 1)) {
      FoodData newFoodData = new FoodData(newFood);

      if (isFoodEmpty() || (newFoodPosition == 1)) {     
        newFoodData.nextFood = firstFood;
        firstFood = newFoodData;
      } else {								                    
        FoodData foodBefore = firstFood;
        for (int i = 1; i < newFoodPosition - 1; ++i) {
          foodBefore = foodBefore.nextFood;		
        }

        newFoodData.nextFood = foodBefore.nextFood;	
        foodBefore.nextFood = newFoodData;		
      }

      numberFoodOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T DeleteFood(int givenFoodPosition){
         T result = null;                 

    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      if (givenFoodPosition == 1) {      
        result = firstFood.foodData;    
        firstFood = firstFood.nextFood;
      } else {                         
        FoodData foodBefore = firstFood;
        for (int i = 1; i < givenFoodPosition - 1; ++i) {
          foodBefore = foodBefore.nextFood;		
        }
        result = foodBefore.nextFood.foodData;  
        foodBefore.nextFood = foodBefore.nextFood.nextFood;	
      } 																// one to be deleted (to disconnect node from chain)

      numberFoodOfEntries--;
    }

    return result; 
    }
    public boolean updateFood(int givenFoodPosition, T newFood){
        boolean isSuccessful = true;

    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      FoodData currentFoodData = firstFood;
      for (int i = 0; i < givenFoodPosition - 1; ++i) {
      
        currentFoodData = currentFoodData.nextFood;
      }
      currentFoodData.foodData = newFood;	
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T getFoodEntry(int givenFoodPosition){
        T result = null;

    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      FoodData currentFoodData = firstFood;
      for (int i = 0; i < givenFoodPosition - 1; ++i) {
        currentFoodData = currentFoodData.nextFood;
      }
      result = currentFoodData.foodData;	
    }

    return result;
    }
    
    public int getNumberOfFood(){
        return numberFoodOfEntries;
    }
    
    
    public boolean isFoodEmpty() {
    boolean result;

    result = numberFoodOfEntries == 0;

    return result;
  }

    public String toFoodString() {
    String outputStr = "";
    FoodData currentFoodData = firstFood;
    while (currentFoodData != null) {
      outputStr += currentFoodData.foodData + "\n";
      currentFoodData = currentFoodData.nextFood;
    }
    return outputStr;
  }   
private class FoodData {

    private T foodData;
    private FoodData nextFood;

    private FoodData(T foodData) {
      this.foodData = foodData;
      this.nextFood = null;
    }

    private FoodData(T foodData, FoodData nextFood) {
      this.foodData = foodData;
      this.nextFood = nextFood;
    }
  }    
}

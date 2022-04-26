package food;

import management.Menu;
import java.util.List;
import static management.Menu.*;

public class Pizza extends FoodItems {
    // pizza variable/attribute:
    String size;

    // pizza overloaded constructor:
    public Pizza(String pizzaType, String size){
        if (size.equalsIgnoreCase(SMALL)) {
            this.type = pizzaType;
            this.size = size;
            price = Menu.getSmallSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(MEDIUM)){
            this.type = pizzaType;
            this.size = size;
            price = Menu.getMediumSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(LARGE)){
            this.type = pizzaType;
            this.size = size;
            price = Menu.getLargeSpecialtyPizza();
        }
        else if (size.equalsIgnoreCase(XLARGE)){
            this.type = pizzaType;
            this.size = size;
            price = Menu.getXtraLargeSpecialtyPizza();
        }

        setFoodName("pizza");
    }

    // this constructor is used in food.BYO so that PizzaType is not needed:
    public Pizza(String size){
        this.size = size;
    }

    // getters and setters for pizza:
    public void setPizzaType(String pizzaType) {
        this.type = pizzaType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
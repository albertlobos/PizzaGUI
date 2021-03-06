package controllers.pizzagui;

import food.BYO;
import food.FoodItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import management.Order;
import management.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BYOController{

    public CheckBox anchoviesCheckBox;
    public CheckBox pineappleCheckBox;
    @FXML
    private Label currentUser;
    private Order newOrder;
    public CheckBox pepCheckBox;
    public CheckBox sausCheckBox;
    public CheckBox greenPepperCheckBox;
    public CheckBox mushCheckBox;
    public CheckBox hamCheckBox;
    public CheckBox chickenCheckBox;
    public Text errorLabel;
    public ToggleGroup sizeGroup;
    public ToggleButton smallToggle;
    public ToggleButton extraLargeToggle;
    public ToggleButton mediumToggle;
    public ToggleButton largeToggle;
    public ToggleButton handTossed;
    public ToggleButton pan;
    public ToggleButton stuffed;
    public ToggleButton lightSauce;
    public ToggleButton regularCheese;
    public ToggleButton lightCheese;
    public ToggleButton xtraCheese;
    public ToggleButton regularSauce;
    public ToggleButton xtraSauce;
    public ToggleGroup crustTypes;
    public ToggleGroup sauceTypes;
    public ToggleGroup cheeseAmount;
    public Label label;

    private List<FoodItems> list = new ArrayList<>();
    private Staff employee;

    private Label customerPhoneNum;



    public void logOutButton(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("PieHackers Pizza Restaurant!");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    public void addToOrder(ActionEvent actionEvent) throws IOException {

        if (crustTypes.getSelectedToggle() == null || cheeseAmount.getSelectedToggle() == null ||
                sauceTypes.getSelectedToggle() == null || sizeGroup.getSelectedToggle() == null) {
            errorLabel.setText("Please make sure you choose all options before you add to cart.");
        } else {
            String pizzaCrust = "";
            String sauceAmount = "";
            String cheeseAmount = "";
            String size = "";
            ArrayList<String> toppingsList = new ArrayList<>();


            if (crustTypes.getSelectedToggle() == stuffed) {
                pizzaCrust = "stuffed crust";
            } else if (crustTypes.getSelectedToggle() == pan) {
                pizzaCrust = "pan";
            } else if (crustTypes.getSelectedToggle() == handTossed) {
                pizzaCrust = "Hand Tossed";
            }

            if (this.cheeseAmount.getSelectedToggle() == lightCheese) {
                cheeseAmount = "Light Cheese";
            } else if (this.cheeseAmount.getSelectedToggle() == regularCheese) {
                cheeseAmount = "Regular Cheese";
            } else if (this.cheeseAmount.getSelectedToggle() == xtraCheese) {
                cheeseAmount = "Extra Cheese";
            }

            if (sauceTypes.getSelectedToggle() == lightSauce) {
                sauceAmount = "Light Sauce";
            } else if (sauceTypes.getSelectedToggle() == regularSauce) {
                sauceAmount = "Regular Sauce";
            } else if (sauceTypes.getSelectedToggle() == xtraSauce) {
                sauceAmount = "Extra Sauce";
            }

            if (sizeGroup.getSelectedToggle() == smallToggle) {
                size = "Small";
            } else if (sizeGroup.getSelectedToggle() == mediumToggle) {
                size = "Medium";
            } else if (sizeGroup.getSelectedToggle() == largeToggle) {
                size = "Large";
            }else if (sizeGroup.getSelectedToggle() == extraLargeToggle) {
                size = "Extra Large";
            }

            if(chickenCheckBox.isSelected()){
                toppingsList.add("Chicken");
            }if(sausCheckBox.isSelected()){
                toppingsList.add("Sausage");
            }if(pepCheckBox.isSelected()){
                toppingsList.add("Pepperoni");
            }if(mushCheckBox.isSelected()){
                toppingsList.add("Mushroom");
            }if(greenPepperCheckBox.isSelected()){
                toppingsList.add("Green Pepper");
            }if(hamCheckBox.isSelected()){
                toppingsList.add("Ham");
            }if(pineappleCheckBox.isSelected()){
                toppingsList.add("Pineapple");
            }if(anchoviesCheckBox.isSelected()){
                toppingsList.add("Anchovies");
            }

            if (toppingsList.size() > 4){
                resetToggles();
            }

            else {

                FoodItems newBYO = new BYO(sauceAmount, cheeseAmount, size, pizzaCrust, toppingsList);

            list.add(newBYO);



            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            ////This preloads the next fxml
            Parent root = fxmlLoader.load();
            ////This grabs the controller being used in the current fxmlLoader
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);
            ////Sets employee attribute in the controller to the user here
            orderMenuController.setFoodList(getList());
            orderMenuController.setEmployee(getEmployee());


            Stage window = (Stage) label.getScene().getWindow();
            Scene scene = new Scene(root, 900, 600);
            window.setTitle("Order Menu");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
            }
        }
    }

    public void resetToggles() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Build-Your-Own-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        BYOController byoController = fxmlLoader.getController();
        fxmlLoader.setController(byoController);
        ////Sets employee attribute in the controller to the user here
        byoController.setList(list);
        byoController.setEmployee(getEmployee());
        byoController.setCurrentUser(getCurrentUser());
        byoController.updateError();

        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Build Your Own");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    public void updateError(){
        this.errorLabel.setText("You can not choose more than 4 toppings");
    }

    public void goBackToOrderMenu(ActionEvent actionEvent) throws IOException {

        if(isManager()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(getEmployee());
//                orderMenuController.setFoodList(getCart());
            orderMenuController.setNewOrder(getNewOrder());
            orderMenuController.setCurrentUser(getCurrentUser());

            orderMenuController.displayName();


            Stage window = (Stage) label.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Order Menu");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

//        If it's a staff logged in, go back to staff view
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
            Parent root = fxmlLoader.load();
            OrderMenuController orderMenuController = fxmlLoader.getController();
            fxmlLoader.setController(orderMenuController);

            orderMenuController.setEmployee(getEmployee());
//                orderMenuController.setFoodList(getCart());
            orderMenuController.setNewOrder(getNewOrder());
            orderMenuController.setCurrentUser(getCurrentUser());

            orderMenuController.displayName();

            Stage window = (Stage) label.getScene().getWindow();

            Scene scene = new Scene(root,900,600);
            window.setTitle("Order Menu");
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

    }
    public boolean isManager(){
        return employee.getEmployeeType().equals("Manager");
    }

    public void setList (List < FoodItems > list) {
        this.list = list;
    }


    public Staff getEmployee () {
        return employee;
    }

    public void setEmployee (Staff employee){
        this.employee = employee;
    }
     public List<FoodItems> getList() {
        return list;
     }

    public Order getNewOrder() {
        return newOrder;
    }

        public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public Text getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(Text errorLabel) {
        this.errorLabel = errorLabel;
    }
}


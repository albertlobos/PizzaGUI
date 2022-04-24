package controllers.pizzagui;

import food.FoodItems;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BYOController {

    public ToggleButton lightSauce;
    public ToggleGroup PizzaTypes;
    public ToggleButton stuffed;
    public ToggleButton handToss;
    public ToggleButton pan;
    public ToggleButton regSauce;
    public ToggleButton small;
    public ToggleGroup sizeGroup;
    public ToggleButton medium;
    public ToggleButton large;
    public ToggleButton xlarge;
    public ToggleButton lightCheese;
    public ToggleGroup cheeseGroup;
    public ToggleButton regCheese;
    public ToggleButton pepperoni;
    public ToggleButton mushrooms;
    public ToggleGroup toppingsGroup;
    public ToggleButton ham;
    public ToggleButton chicken;
    public ToggleButton veggies;
    public ToggleButton sausage;
    public ToggleGroup crustGroup;
    public ToggleButton onion;
    public ToggleButton xtraCheese;
    public ToggleButton xtraSauce;
    public ToggleGroup sauceGroup;
    private List<FoodItems> list = new ArrayList<>();
    private Label customerPhoneNum;


    @FXML
    public Label label;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        ////This preloads the next fxml
        Parent root = fxmlLoader.load();
        ////This grabs the controller being used in the current fxmlLoader
        OrderMenuController orderMenuController = fxmlLoader.getController();
        fxmlLoader.setController(orderMenuController);
        ////Sets employee attribute in the controller to the user here
        orderMenuController.setFoodList(list);


        Stage window = (Stage) label.getScene().getWindow();
        Scene scene = new Scene(root,900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }


    public void goBackToStaffView(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage) label.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Order-Menu-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        window.setTitle("Staff View");
        window.setScene(scene);
        window.setResizable(false);
        window.show();

    }

    public void setList(List<FoodItems> list) {
        this.list = list;
    }
}

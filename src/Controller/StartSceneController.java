package Controller;

import ShoeShop.Database;
import ShoeShop.Main;
import ShoeShop.Shopper;
import View.StartScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class StartSceneController {
    private String input1;
    private String input2;
    private StartScene startScene;
    private Database database;
    private Main main;
    private Shopper shopper;
    Button no = new Button("no");
    Button yes = new Button("yes");
    Label createAccLabel = new Label("no account exists in that name, do you want to create a new account?");
    boolean accExists = true;


    public StartSceneController(StartScene startScene, Main main, Database database, Shopper shopper) {
        this.startScene = startScene;
        this.main = main;
        this.database = database;
        this.shopper = shopper;
    }

    public void start() {
        startScene.setUp();
        startScene.getCustomers().setOnAction(actionEvent -> {
            main.getCustomers();
        });

        startScene.getOrders().setOnAction(actionEvent -> {
            try {
                main.getOrders();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        startScene.getNotInStock().setOnAction(actionEvent -> {
            main.getOutStock();
        });

        startScene.getLoginButton().setOnAction(actionEvent -> {
            input1 = startScene.getNameField().getText();
            input2 = startScene.getPasswdField().getText();
            for (int i = 0; i < database.customers.size(); i++) {
                if(input1.equalsIgnoreCase(database.customers.get(i).getName())) {
                    accExists = true;
                    if(input2.equalsIgnoreCase(database.customers.get(i).getPassword())) {

                        shopper.setName(database.customers.get(i).getName());
                        shopper.setPassword(database.customers.get(i).getPassword());
                        shopper.setArea(database.customers.get(i).getArea());
                        shopper.setID(database.customers.get(i).getID());

                        try {
                            database.getOrder(shopper);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        changeToShopScene();
                        break;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"wrong password");
                        break;
                    }
                }
                else {
                    accExists = false;
                }
            }
            if(!accExists) {
                newAccountQuestion();
            }
        });

    }

    public String getInput() {
        return input1;
    }

    public void changeToShopScene() {
        main.goToShopScene();
    }

    public void changeToCreateCustomerView() {
        main.goToCreateAccScene();
    }

    public void newAccountQuestion() {
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(createAccLabel);
        HBox buttons = new HBox(yes, no);
        layout.getChildren().add(hBox);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        createAccLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        yes.setPrefSize(88,45);
        no.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        yes.setCursor(Cursor.HAND);
        no.setCursor(Cursor.HAND);

        no.setOnAction(actionEvent -> {
            dialogStage.close();
        });

        yes.setOnAction(actionEvent -> {
            changeToCreateCustomerView();
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }


}

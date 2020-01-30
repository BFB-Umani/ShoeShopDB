package Controller;

import ShoeShop.Customer;
import ShoeShop.Database;
import ShoeShop.Main;
import ShoeShop.Shopper;
import View.CreateAccScene;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CreateAccSceneController {
    private String input1;
    private String input2;
    private String input3;
    private CreateAccScene createAccScene;
    private Database database;
    private Main main;
    private Shopper shopper;

    public CreateAccSceneController(CreateAccScene createAccScene, Main main, Database database, Shopper shopper) {
        this.createAccScene = createAccScene;
        this.main = main;
        this.database = database;
        this.shopper = shopper;
    }

    public void start() {
        createAccScene.setUp();
        createAccScene.getLoginButton().setOnAction(actionEvent -> {
            input1 = createAccScene.getNameField().getText();
            input2 = createAccScene.getPasswdField().getText();
            input3 = createAccScene.getAreaField().getText();
            if (!input1.equalsIgnoreCase("") && !input2.equalsIgnoreCase("") && !input3.equalsIgnoreCase("")) {

                shopper.setName(input1);
                shopper.setPassword(input2);
                shopper.setArea(input3);

                try {
                    database.callAddCustomer(shopper);
                    main.updateDatabase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                changeToStartScene();
            }
        });

    }

    public String getInput() {
        return input1;
    }

    public void changeToStartScene() {
        main.goToStartScene();
    }
}

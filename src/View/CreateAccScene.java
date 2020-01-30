package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CreateAccScene {
    private VBox designLayout = new VBox();
    private Label quizkampen = new Label("Create Account");
    private HBox nameArea = new HBox();
    private HBox passwdArea = new HBox();
    private HBox adressArea = new HBox();
    private Label name = new Label("Name:          ");
    private Label passwd = new Label("Password:    ");
    private Label area = new Label("Area:            ");
    private TextField nameField = new TextField();
    private TextField passwdField = new TextField();
    private TextField areaField = new TextField();
    private Button loginButton = new Button("Create Account");



    public void setUp() {
        designLayout.getChildren().add(quizkampen);
        designLayout.getChildren().add(nameArea);
        designLayout.getChildren().add(passwdArea);
        designLayout.getChildren().add(adressArea);

        nameArea.getChildren().add(name);
        nameArea.getChildren().add(nameField);
        passwdArea.getChildren().add(passwd);
        passwdArea.getChildren().add(passwdField);
        adressArea.getChildren().add(area);
        adressArea.getChildren().add(areaField);

        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().add(loginButton);
        designLayout.getChildren().add(buttonLayout);

        quizkampen.setPrefSize(300,275);
        quizkampen.setMaxWidth(Double.MAX_VALUE);
        quizkampen.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        quizkampen.setId("quizKampenText");

        nameArea.setAlignment(Pos.CENTER);
        passwdArea.setAlignment(Pos.CENTER);
        adressArea.setAlignment(Pos.CENTER);

        nameArea.setPadding(new Insets(10));
        passwdArea.setPadding(new Insets(10));
        adressArea.setPadding(new Insets(10));

        name.setId("nameText");
        passwd.setId("nameText");
        area.setId("nameText");

        buttonLayout.setAlignment(Pos.CENTER);
        loginButton.setPrefSize(88,30);
        buttonLayout.setId("buttonLayout");
        loginButton.setMaxWidth(Double.MAX_VALUE);


    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getQuizkampen() {
        return quizkampen;
    }

    public Label getName() {
        return name;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getPasswdField() {
        return passwdField;
    }

    public TextField getAreaField() {
        return areaField;
    }

    public Button getLoginButton() {
        return loginButton;
    }


}

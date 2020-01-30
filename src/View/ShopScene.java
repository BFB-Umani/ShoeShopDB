package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;


public class ShopScene {
    private VBox designLayout = new VBox();
    private GridPane buttonLayout = new GridPane();
    private Button myOrder = new Button("My Order");
    private Image img1 = new Image("file:resources/ID1_red_nike.png");
    private Image img2 = new Image("file:resources/ID2_black_nike.png");
    private Image img3 = new Image("file:resources/ID3_black_ecco.png");
    private Image img4 = new Image("file:resources/ID4_blue_nike.png");
    private Image img5 = new Image("file:resources/ID5_green_adidas.png");
    private Image img6 = new Image("file:resources/ID6_white_even&odd.png");
    private Image img7 = new Image("file:resources/ID7_red_reebok.png");
    private ImageView skobt1 = new ImageView(img1);
    private ImageView skobt2 = new ImageView(img2);
    private ImageView skobt3 = new ImageView(img3);
    private ImageView skobt4 = new ImageView(img4);
    private ImageView skobt5 = new ImageView(img5);
    private ImageView skobt6 = new ImageView(img6);
    private ImageView skobt7 = new ImageView(img7);
    private Label quizkampen = new Label("Shop");
    private Label sko1 = new Label("",skobt1);
    private Label sko2 = new Label("",skobt2);
    private Label sko3 = new Label("",skobt3);
    private Label sko4 = new Label("",skobt4);
    private Label sko5 = new Label("",skobt5);
    private Label sko6 = new Label("",skobt6);
    private Label sko7 = new Label("",skobt7);


    public void setUp() {
        designLayout.getChildren().add(quizkampen);
        designLayout.getChildren().add(myOrder);
        designLayout.getChildren().add(buttonLayout);
        buttonLayout.add(sko1, 0,0);
        buttonLayout.add(sko2, 1,0);
        buttonLayout.add(sko3, 2,0);

        buttonLayout.add(sko4, 0,1);
        buttonLayout.add(sko5, 1,1);
        buttonLayout.add(sko6, 2,1);

        buttonLayout.add(sko7, 1,2);

        quizkampen.setPrefSize(300,275);
        quizkampen.setMaxWidth(Double.MAX_VALUE);
        quizkampen.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        quizkampen.setId("quizKampenText");

    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getSko1() {
        return sko1;
    }

    public Label getSko2() {
        return sko2;
    }

    public Label getSko3() {
        return sko3;
    }

    public Label getSko4() {
        return sko4;
    }

    public Label getSko5() {
        return sko5;
    }

    public Label getSko6() {
        return sko6;
    }

    public Label getSko7() {
        return sko7;
    }

    public Button getMyOrder() {
        return myOrder;
    }
}

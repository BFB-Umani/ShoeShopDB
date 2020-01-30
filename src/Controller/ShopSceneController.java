package Controller;

import ShoeShop.Database;
import ShoeShop.Main;
import ShoeShop.Shopper;
import View.ShopScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShopSceneController {
    private ShopScene shopScene;
    private Database database;
    private Main main;
    private Shopper shopper;
    private boolean inStock = true;
    Button no = new Button("no");
    Button yes = new Button("yes");
    Button ok = new Button("ok");
    Label createAccLabel = new Label("the shoe has been added to your order, do you want to add more?");
    Label stockLabel = new Label("the shoe is out of stock, please come back later");
    Label orderLabel = new Label("");


    public ShopSceneController(ShopScene shopScene, Main main, Database database, Shopper shopper) {
        this.shopScene = shopScene;
        this.main = main;
        this.database = database;
        this.shopper = shopper;
    }

    public void start() {
        shopScene.setUp();
        shopScene.getMyOrder().setOnAction(actionEvent -> {
            try {
                showMyOrder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        shopScene.getSko1().setOnMouseClicked(this::handle);
        shopScene.getSko2().setOnMouseClicked(this::handle);
        shopScene.getSko3().setOnMouseClicked(this::handle);
        shopScene.getSko4().setOnMouseClicked(this::handle);
        shopScene.getSko5().setOnMouseClicked(this::handle);
        shopScene.getSko6().setOnMouseClicked(this::handle);
        shopScene.getSko7().setOnMouseClicked(this::handle);

    }

    private void handle(MouseEvent mouseEvent) {
        Label button = (Label) mouseEvent.getSource();
        try {
            if (button == shopScene.getSko1()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 1) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 1);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko2()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 2) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 2);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko3()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 3) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 3);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko4()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 4) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 4);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko5()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 5) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 5);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko6()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 6) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 6);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }

            } else if (button == shopScene.getSko7()) {
                for (int i = 0; i <database.stockList.size() ; i++) {
                    if(database.stockList.get(i).getShoeId() == 7) {
                        inStock = false;
                        outOfStock();
                        break;
                    }
                    else {
                        inStock = true;
                    }
                }
                if(inStock) {
                    database.callAddToCart(shopper, 7);
                    main.updateDatabase();
                    anotherShoeQuestion();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void anotherShoeQuestion() {
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
            main.goToStartScene();
            dialogStage.close();
        });

        yes.setOnAction(actionEvent -> {
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void outOfStock() {
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(stockLabel);
        HBox buttons = new HBox(ok);
        layout.getChildren().add(hBox);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        stockLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        ok.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        ok.setCursor(Cursor.HAND);

        ok.setOnAction(actionEvent -> {
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void showMyOrder() throws Exception {
        database.showOrderSpecs();
        String message = "";
        int total = 0;
        for (int i = 0; i < database.wantsList.size() ; i++) {
            if(database.wantsList.get(i).getOrderId() == shopper.getOrderId()) {
                message += database.shoes.get(database.wantsList.get(i).getShoesId()-1).toString();
                total += database.shoes.get(database.wantsList.get(i).getShoesId()-1).getPrice();
            }
        }
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(orderLabel);
        HBox buttons = new HBox(ok);
        layout.getChildren().add(hBox);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        orderLabel.setAlignment(Pos.CENTER);
        orderLabel.setText(message + "\ntotal: " + total);
        hBox.setAlignment(Pos.CENTER);
        ok.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        ok.setCursor(Cursor.HAND);

        ok.setOnAction(actionEvent -> {
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

package ShoeShop;

import Controller.CreateAccSceneController;
import Controller.ShopSceneController;
import Controller.StartSceneController;
import View.CreateAccScene;
import View.ShopScene;
import View.StartScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private Scene scene;
    private StartScene startScene;
    private ShopScene shopScene;
    private CreateAccScene createAccScene;
    private Shopper shopper = new Shopper();
    private Database dbr = new Database();
    public Stage stage = new Stage();

    public void Main() {

    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        updateDatabase();
        stage.setTitle("Shoe Shop");
        stage.setResizable(false);
        startScene = new StartScene();
        shopScene = new ShopScene();
        createAccScene = new CreateAccScene();

        scene = new Scene(startScene.getDesignLayout(),480,620);
        scene.getStylesheets().add(Main.class.getResource("Style.css").toExternalForm());
        stage.setScene(scene);

        StartSceneController startSceneController = new StartSceneController(startScene,this, dbr, shopper);
        startSceneController.start();

        ShopSceneController shopSceneController = new ShopSceneController(shopScene,this, dbr, shopper);
        shopSceneController.start();

        CreateAccSceneController createAccSceneController = new CreateAccSceneController(createAccScene,this, dbr, shopper);
        createAccSceneController.start();

        stage.setOnCloseRequest(t -> {
            stage.close();
            System.exit(0);
        });

        stage.show();
    }

    public void goToStartScene() {
        scene.setRoot(startScene.getDesignLayout());
    }

    public void goToShopScene() {
        stage.setWidth(640);
        stage.setHeight(680);
        scene.setRoot(shopScene.getDesignLayout());
    }

    public void goToCreateAccScene() {
        scene.setRoot(createAccScene.getDesignLayout());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void updateDatabase() throws IOException, ClassNotFoundException {
        dbr.connectToAndQueryShoeShop();
    }

    public void getCustomers() {
        for (int i = 0; i <dbr.customers.size() ; i++) {
            System.out.println(dbr.customers.get(i).getName());

        }
    }

    public void getOrders() throws IOException, ClassNotFoundException {
        dbr.getOrder(shopper);
        for (int i = 0; i <dbr.orders.size() ; i++) {
            System.out.println("ID: " + dbr.orders.get(i).getID() + " date " + dbr.orders.get(i).getDatum());
        }
    }

    public void getOutStock() {
        for (int i = 0; i <dbr.stockList.size() ; i++) {
            System.out.println("ID: " + dbr.stockList.get(i).getShoeId() + " is not in stock");
        }
    }

}

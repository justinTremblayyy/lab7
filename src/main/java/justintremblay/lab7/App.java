package justintremblay.lab7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class App extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        
        Pane animationPane = new Pane();

        Polygon path = new Polygon(70, 40, 570, 40, 570, 290, 70, 290);
        path.setFill(Color.WHITE);
        path.setStroke(Color.BLACK);

        Label labelM = new Label("M");
        labelM.setLayoutX(50);
        labelM.setLayoutY(15);
        
        Label labelN = new Label("N");
        labelN.setLayoutX(575);
        labelN.setLayoutY(15);
        
        Label labelP = new Label("P");
        labelP.setLayoutX(575);
        labelP.setLayoutY(295);
        
        Label labelQ = new Label("Q");
        labelQ.setLayoutX(50);
        labelQ.setLayoutY(295);

        BorderPane root = new BorderPane();
        root.setCenter(animationPane);

        Scene scene = new Scene(root, 640, 420);
        primaryStage.setTitle("Path and Sequential Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

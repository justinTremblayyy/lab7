package justintremblay.lab7;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {

    
    private Circle objectA;
    private Ellipse objectB;

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

        
        objectA = new Circle(70, 40, 12);
        objectA.setFill(Color.ORANGE);
        objectA.setStroke(Color.BLACK);

        objectB = new Ellipse(320, 165, 50, 25);
        objectB.setFill(Color.DARKBLUE);

        
        animationPane.getChildren().addAll(path, labelM, labelN, labelP, labelQ, objectB, objectA);

        PathTransition pathTransition = new PathTransition(Duration.millis(12000), path, objectA);
        pathTransition.setInterpolator(Interpolator.LINEAR);

        FadeTransition fade = new FadeTransition(Duration.millis(4000), objectB);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);

        ScaleTransition scale = new ScaleTransition(Duration.millis(2000), objectB);
        scale.setFromX(1);
        scale.setFromY(1);
        scale.setToX(1.5);
        scale.setToY(1.5);

        RotateTransition rotate = new RotateTransition(Duration.millis(4000), objectB);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);

        TranslateTransition moveUp = new TranslateTransition(Duration.millis(2000), objectB);
        moveUp.setFromY(0);
        moveUp.setToY(-80);

        SequentialTransition sequence = new SequentialTransition(fade, scale, rotate, moveUp);

        
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
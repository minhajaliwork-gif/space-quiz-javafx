package com.solarexplorer.solarexplorer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    	
    	
    	
    	
    	GameCanvas canvas = new GameCanvas(500,500);
    	QuestionPanel panel = new QuestionPanel();
    	panel.setPrefWidth(220);
    	
    	GameController controller = new GameController(
    			canvas, panel , canvas.getGraphicsContext2D()
    			);
    	
    	HBox root = new HBox(canvas , panel);
    	Scene scene = new Scene(root, 720, 500);
    	scene.setFill(javafx.scene.paint.Color.BLACK);
    	stage.setTitle("Solar System Explorer");
    	stage.setScene(scene);
    	stage.show();
    
 
    
    }
       
    

    public static void main(String[] args) {
        launch();
    }

}
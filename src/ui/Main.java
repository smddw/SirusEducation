
package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Lucifer-PC
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Front Desk Managment System");
            primaryStage.setScene(scene);
            primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

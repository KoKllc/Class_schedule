package Tabulation_prototype;
import javafx.scene.Group;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main_data extends Application{
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Start_sport.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image("/Tabulation_prototype/Img/scroll.png");

            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.setTitle("視覺化輔助編輯班表");
            stage.show();
            
            
        } catch(IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);

        
    }
}

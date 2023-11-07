package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,720,430);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			//primaryStage.setTitle("MNdoceria");
			Image icon = new Image("logo.png");
			primaryStage.getIcons().add(icon);
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

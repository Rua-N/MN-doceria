package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;



public class TelaController{
	private Stage stage;
	private Scene scene;
	private Parent root;
	String usuario = "Admin";
	String password = "123";
	//botão de fechar a tela
	@FXML
	private Button close; 
	
	public void close(ActionEvent event) {
		stage = (Stage)close.getScene().getWindow();
		stage.close();
	}
	//msg de senha incorretas
	
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField senha;
	
	public void Login(ActionEvent event) throws IOException {
		if(username.getText().equals(usuario) && senha.getText().equals(password)){
			TrocaDeTelaG(event);
		}if(username.getText().isBlank() == false && senha.getText().isBlank() == false ) {
			showAlert("Error", "Usuário ou senha inválidos!");
		} 
		else {
			System.out.print("erro");
		} 
			
		}
		
		 
	
	//trocas de tela
	public void TrocaDeTelaL(ActionEvent event) throws IOException {
		root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setX(600);
		stage.setY(300);
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	public void TrocaDeTelaG(ActionEvent event) throws IOException  {
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
		root = (BorderPane)FXMLLoader.load(getClass().getResource("graphs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,screenSize.getWidth(), screenSize.getHeight());
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocaDeTelaT(ActionEvent event) throws IOException  {
		Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
		root = (BorderPane)FXMLLoader.load(getClass().getResource("TACO.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,screenSize.getWidth(), screenSize.getHeight());
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}


	

	private void showAlert(String title, String content) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
    
    
}}

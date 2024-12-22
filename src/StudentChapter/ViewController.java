package StudentChapter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ViewController {
	WebEngine webEngine= null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView webview;

    @FXML
    void BACK(ActionEvent event) throws IOException {
    	// Load the new FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/home/View.fxml"));
        
        // Get the current node, which represents any visual element in the scene graph
        Node source = (Node) event.getSource();
        
        // Get the stage of the current node
        Stage stage = (Stage) source.getScene().getWindow();
        
        // Set the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CHAPTER_ACM(ActionEvent event) {
    	webEngine.load("https://www.upesacmw.org/");
    }

    @FXML
    void CHAPTER_CSA(ActionEvent event) {
    	webEngine.load("http://www.upescsa.in/");
    }

    @FXML
    void CHAPTER_CSI(ActionEvent event) {
    	webEngine.load("https://upescsi.in/");
    }

    @FXML
    void CLOSE(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void initialize() {
        assert webview != null : "fx:id=\"webview\" was not injected: check your FXML file 'View.fxml'.";
        webEngine =webview.getEngine();
        
    }
}


package Photos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private ComboBox<String> searchCOMBO;
    
    @FXML
    void initialize() {
        ObservableList<String> eventOptions = FXCollections.observableArrayList(
            "Convocation2023",
            "Holi",
            "Campus"
            
            // Add more event options here
        );
        searchCOMBO.setItems(eventOptions);
    }

    @FXML
    private TilePane photoTilePane;

    @FXML
    void back(ActionEvent event) throws IOException {
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
    void close(ActionEvent event) {
       System.exit(0);
    }

    @FXML
    void SEARCH(ActionEvent event) {
        
        String selectedEvent = searchCOMBO.getSelectionModel().getSelectedItem();
        List<String> photoURLs = getPhotosForEvent(selectedEvent);
        displayPhotos(photoURLs);
    }

    // Sample method to get photos for a specific event (Replace with your logic)
    private List<String> getPhotosForEvent(String event) {
        // Add logic to fetch photos based on the selected event
        // For now, returning sample URLs
        if (event != null) {
            switch (event.toLowerCase()) {
                case "convocation2023":
                    return Arrays.asList(
                            "photo1.png",
                            "photo2.png",
                            "photo3.png"
                            // Add more photo URLs for convocation2023 event if needed
                    );
                case "holi":
                    return Arrays.asList(
                            "holi1.png"             
                            // Add more photo URLs for holi event if needed
                    );
                case "campus":
                    return Arrays.asList(
                            "campus1.png",
                            "campus2.png",
                            "campus4.png"
                            // Add more photo URLs for convocation2023 event if needed
                    );
                // Add cases for other events
                default:
                    return new ArrayList<>(); // Return empty list if event is not recognized
            }
        }
        return new ArrayList<>(); // Return empty list if no event selected
    }

    // Method to display photos in the TilePane
    private void displayPhotos(List<String> photoURLs) {
        photoTilePane.getChildren().clear(); // Clear previous photos

        for (String url : photoURLs) {
            Image image = new Image(getClass().getResourceAsStream(url));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            photoTilePane.getChildren().add(imageView);
        }
    }
}

package freeRooms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ViewController {

    @FXML
    private TableView<CollegeTourRecord> tableView;

    @FXML
    private TableColumn<CollegeTourRecord, String> blockNameColumn;

    @FXML
    private TableColumn<CollegeTourRecord, String> classNameColumn;

    @FXML
    private TableColumn<CollegeTourRecord, String> timeAvailableColumn;

    @FXML
    private TextField blockNameInput;

    @FXML
    private TextField classNameInput;

    @FXML
    private TextField timeAvailableInput;

    @FXML
    private Button addRecordButton;

    // Initialize method to set up the table view
    @FXML
    public void initialize() {
    	assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'View.fxml'.";
        assert blockNameInput != null : "fx:id=\"blockNameInput\" was not injected: check your FXML file 'View.fxml'.";
        assert classNameInput != null : "fx:id=\"classNameInput\" was not injected: check your FXML file 'View.fxml'.";
        assert timeAvailableInput != null : "fx:id=\"timeAvailableInput\" was not injected: check your FXML file 'View.fxml'.";
        blockNameColumn.setCellValueFactory(cellData -> cellData.getValue().blockNameProperty());
        classNameColumn.setCellValueFactory(cellData -> cellData.getValue().classNameProperty());
        timeAvailableColumn.setCellValueFactory(cellData -> cellData.getValue().timeAvailableProperty());
        

        // Load existing records into the TableView
        loadRecords();
    }


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
    // Method to load existing records into the TableView
    private void loadRecords() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://admin.c502siqwszjj.ap-south-1.rds.amazonaws.com:3306/college_tour", "admin", "Radhika12345");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM college_tour");

            ObservableList<CollegeTourRecord> records = FXCollections.observableArrayList();
            while (rs.next()) {
                String blockName = rs.getString("block_name");
                String className = rs.getString("class_name");
                String timeAvailable = rs.getString("time_available");

                records.add(new CollegeTourRecord(blockName, className, timeAvailable));
            }

            tableView.setItems(records);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new record
    @FXML
    private void addRecord() {
        String blockName = blockNameInput.getText();
        String className = classNameInput.getText();
        String timeAvailable = timeAvailableInput.getText();

        if (!blockName.isEmpty() && !className.isEmpty() && !timeAvailable.isEmpty()) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://admin.c502siqwszjj.ap-south-1.rds.amazonaws.com:3306/college_tour","admin","Radhika12345");
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO college_tour (block_name, class_name, time_available) VALUES (?, ?, ?)");
                pstmt.setString(1, blockName);
                pstmt.setString(2, className);
                pstmt.setString(3, timeAvailable);

                pstmt.executeUpdate();

                pstmt.close();
                conn.close();

                // Clear input fields after adding record
                blockNameInput.clear();
                classNameInput.clear();
                timeAvailableInput.clear();

                // Reload records to update TableView
                loadRecords();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

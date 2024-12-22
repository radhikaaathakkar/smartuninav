package teacher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ViewController {

    @FXML
    private TableView<Teacher> teacherQueryTable;
    @FXML
    private TableColumn<Teacher, String> colTeacherName;
    @FXML
    private TableColumn<Teacher, String> colBlockAssigned;
    @FXML
    private TableColumn<Teacher, String> colContact;
    @FXML
    private TableColumn<Teacher, String> colEmail;
    @FXML
    private TableColumn<Teacher, String> colSubject;
    @FXML
    private TableColumn<Teacher, String> colPeriod1;
    @FXML
    private TableColumn<Teacher, String> colPeriod2;
    @FXML
    private TableColumn<Teacher, String> colPeriod3;
    @FXML
    private TableColumn<Teacher, String> colPeriod4;

    private final String url = "jdbc:mysql://admin.c502siqwszjj.ap-south-1.rds.amazonaws.com/college_tour";
    private final String username = "admin";
    private final String password = "Radhika12345";
    
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
    
    public void initialize() {
        // Initialize columns
        colTeacherName.setCellValueFactory(data -> data.getValue().teacherNameProperty());
        colBlockAssigned.setCellValueFactory(data -> data.getValue().blockAssignedProperty());
        colContact.setCellValueFactory(data -> data.getValue().contactProperty());
        colEmail.setCellValueFactory(data -> data.getValue().emailProperty());
        colSubject.setCellValueFactory(data -> data.getValue().subjectProperty());
        colPeriod1.setCellValueFactory(data -> data.getValue().period1Property());
        colPeriod2.setCellValueFactory(data -> data.getValue().period2Property());
        colPeriod3.setCellValueFactory(data -> data.getValue().period3Property());
        colPeriod4.setCellValueFactory(data -> data.getValue().period4Property());

        // Load table data
        loadTableData();
    }

    private void loadTableData() {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM techerquerry";
        
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            // Check if connected to the database
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
                return;
            }

            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        resultSet.getString("teacher_name"),
                        resultSet.getString("block_assigned"),
                        resultSet.getString("contact"),
                        resultSet.getString("email"),
                        resultSet.getString("subject"),
                        resultSet.getString("period1"),
                        resultSet.getString("period2"),
                        resultSet.getString("period3"),
                        resultSet.getString("period4")
                );
                teachers.add(teacher);
            }
            teacherQueryTable.setItems(teachers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

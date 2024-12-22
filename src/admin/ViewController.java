package admin;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField uploadTeacherName;

    @FXML
    private TextField uploadBlock;

    @FXML
    private TextField uploadMobile;

    @FXML
    private TextField uploadEmail;

    @FXML
    private TextField uploadSubject;

    @FXML
    private TextField uploadPeriod1;

    @FXML
    private TextField uploadPeriod2;

    @FXML
    private TextField uploadPeriod3;

    @FXML
    private TextField uploadPeriod4;

    @FXML
    private TextField sapid;

    @FXML
    private TextArea updateResponse;

    @FXML
    private TextField teacherNameForDeleteALLRecord;

    // JDBC connection parameters
    private final String url = "jdbc:mysql://admin.c502siqwszjj.ap-south-1.rds.amazonaws.com/college_tour";
    private final String username = "admin";
    private final String password = "Radhika12345";

    @FXML
    void addSchedule(ActionEvent event) {
        String teacherName = uploadTeacherName.getText();
        String block = uploadBlock.getText();
        String mobile = uploadMobile.getText();
        String email = uploadEmail.getText();
        String subject = uploadSubject.getText();
        String period1 = uploadPeriod1.getText();
        String period2 = uploadPeriod2.getText();
        String period3 = uploadPeriod3.getText();
        String period4 = uploadPeriod4.getText();

        // Call method to insert teacher record into teacherquerry table
        addTeacherRecord(teacherName, block, mobile, email, subject, period1, period2, period3, period4);

        // Clear input fields
        clearTeacherInputs();
    }

    @FXML
    void delete(ActionEvent event) {
        String teacherName = teacherNameForDeleteALLRecord.getText();

        // Call method to delete record from teacherquerry table
        deleteTeacherRecord(teacherName);

        // Clear input field
        teacherNameForDeleteALLRecord.clear();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
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
    void postReply(ActionEvent event) {
        String sapIdValue = sapid.getText();
        String response = updateResponse.getText();

        // Call method to update response in Form table
        updateResponseInFormTable(sapIdValue, response);

        // Clear input fields
        sapid.clear();
        updateResponse.clear();
    }

    @FXML
    void initialize() {
        // Check for injected FXML elements
    	assert uploadTeacherName != null : "fx:id=\"uploadTeacherName\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadBlock != null : "fx:id=\"uploadBlock\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadMobile != null : "fx:id=\"uploadMobile\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadEmail != null : "fx:id=\"uploadEmail\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadSubject != null : "fx:id=\"uploadSubject\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadPeriod1 != null : "fx:id=\"uploadPeriod1\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadPeriod2 != null : "fx:id=\"uploadPeriod2\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadPeriod3 != null : "fx:id=\"uploadPeriod3\" was not injected: check your FXML file 'View.fxml'.";
        assert uploadPeriod4 != null : "fx:id=\"uploadPeriod4\" was not injected: check your FXML file 'View.fxml'.";
        assert sapid != null : "fx:id=\"sapid\" was not injected: check your FXML file 'View.fxml'.";
        assert updateResponse != null : "fx:id=\"updateResponse\" was not injected: check your FXML file 'View.fxml'.";
        assert teacherNameForDeleteALLRecord != null : "fx:id=\"teacherNameForDeleteALLRecord\" was not injected: check your FXML file 'View.fxml'.";

    }

    private void addTeacherRecord(String teacherName, String block, String mobile, String email, String subject,
            String period1, String period2, String period3, String period4) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO techerquerry (teacher_Name, block_assigned, contact, email, subject, period1, period2, period3, period4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherName);
            preparedStatement.setString(2, block);
            preparedStatement.setString(3, mobile);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, subject);
            preparedStatement.setString(6, period1);
            preparedStatement.setString(7, period2);
            preparedStatement.setString(8, period3);
            preparedStatement.setString(9, period4);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Show success message
                showAlert("Success", "Record added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteTeacherRecord(String teacherName) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM techerquerry WHERE teacher_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherName);
            showAlert("Success", "Record deleted successfully.");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateResponseInFormTable(String sapId, String response) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE Form SET reply = ? WHERE sap_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, response);
            preparedStatement.setString(2, sapId);

            preparedStatement.executeUpdate();
            showAlert("Success", "Response added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearTeacherInputs() {
        uploadTeacherName.clear();
        uploadBlock.clear();
        uploadMobile.clear();
        uploadEmail.clear();
        uploadSubject.clear();
        uploadPeriod1.clear();
        uploadPeriod2.clear();
        uploadPeriod3.clear();
        uploadPeriod4.clear();
    }
    private void showAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

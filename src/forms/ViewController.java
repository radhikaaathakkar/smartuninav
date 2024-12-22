package forms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private TableView<Form> formTable;
    @FXML
    private TableColumn<Form, String> colSapId;
    @FXML
    private TableColumn<Form, String> colName;
    @FXML
    private TableColumn<Form, String> colEmail;
    @FXML
    private TableColumn<Form, String> colQuery;
    @FXML
    private TableColumn<Form, String> colReply;

    @FXML
    private TextArea querry;
    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TextField sapid;
    

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

    // JDBC connection parameters
    private final String url = "jdbc:mysql://admin.c502siqwszjj.ap-south-1.rds.amazonaws.com/college_tour";
    private final String username = "admin";
    private final String password = "Radhika12345";

    @FXML
    public void initialize() {
        // Initialize columns
        colSapId.setCellValueFactory(data -> data.getValue().sapIdProperty());
        colName.setCellValueFactory(data -> data.getValue().nameProperty());
        colEmail.setCellValueFactory(data -> data.getValue().emailProperty());
        colQuery.setCellValueFactory(data -> data.getValue().queryProperty());

        colReply.setCellValueFactory(data -> data.getValue().replyProperty());
        colReply.setCellFactory(TextFieldTableCell.forTableColumn());
        colReply.setOnEditCommit(event -> {
            // Get the edited reply
            String updatedReply = event.getNewValue();
            // Update the corresponding Form object
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setReply(updatedReply);
        });

        assert querry != null : "fx:id=\"querry\" was not injected: check your FXML file 'View.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'View.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'View.fxml'.";
        assert sapid != null : "fx:id=\"sapid\" was not injected: check your FXML file 'View.fxml'.";

        // Load table data
        loadTableData();
    }

    @FXML
    void post(ActionEvent event) {
        // Get data from text fields
        String sapIdValue = sapid.getText();
        String nameValue = name.getText();
        String emailValue = email.getText();
        String queryValue = querry.getText();

        // Create a new Form object with the entered data
        Form newForm = new Form(sapIdValue, nameValue, emailValue, queryValue, "");

        // Add the new form to the table
        formTable.getItems().add(newForm);

        // Insert the new form into the database
        insertFormData(newForm);

        // Clear text fields
        sapid.clear();
        name.clear();
        email.clear();
        querry.clear();
    }

    @FXML
    void saveReply(ActionEvent event) {
        // Save changes to MySQL database
        // Iterate over the TableView items and update the "Reply" column in the database
        for (Form form : formTable.getItems()) {
            String sapId = form.getSapId();
            String updatedReply = form.getReply();
            // Execute update query in MySQL to save the updated reply for the corresponding SAP ID
            updateReplyInDatabase(sapId, updatedReply);
        }
    }

    private void loadTableData() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL query to retrieve data from the Form table
            String query = "SELECT sap_id, name, email, query, reply FROM Form";

            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute query and get result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process result set and populate TableView
            while (resultSet.next()) {
                String sapId = resultSet.getString("sap_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String queryText = resultSet.getString("query");
                String reply = resultSet.getString("reply");

                Form form = new Form(sapId, name, email, queryText, reply);
                formTable.getItems().add(form);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any SQL errors
        }
    }

    private void insertFormData(Form form) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL query to insert form data into the database
            String query = "INSERT INTO Form (sap_id, name, email, query, reply) VALUES (?, ?, ?, ?, ?)";

            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, form.getSapId());
            preparedStatement.setString(2, form.getName());
            preparedStatement.setString(3, form.getEmail());
            preparedStatement.setString(4, form.getQuery());
            preparedStatement.setString(5, form.getReply());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any SQL errors
        }
    }

    private void updateReplyInDatabase(String sapId, String updatedReply) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL query to update the reply for a specific SAP ID
            String query = "UPDATE Form SET reply = ? WHERE sap_id = ?";

            // Create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, updatedReply);
            preparedStatement.setString(2, sapId);

            // Execute the update statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any SQL errors
        }
    }
}

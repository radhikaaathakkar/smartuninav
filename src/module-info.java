module Campus_Project {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	requires java.sql;
    
    opens application to javafx.graphics, javafx.fxml;
    opens map to javafx.fxml,javafx.graphics; // Open the map package to javafx.fxml
    opens home to javafx.fxml,javafx.graphics; // Open the map package to javafx.fxml
    opens News to javafx.fxml,javafx.graphics;
    opens about to javafx.fxml,javafx.graphics;
    opens Photos to javafx.fxml,javafx.graphics;
    opens Contact to javafx.fxml,javafx.graphics;
    opens StudentChapter to javafx.fxml,javafx.graphics;
    opens CollegeSecurity to javafx.fxml,javafx.graphics;
    opens services to javafx.fxml,javafx.graphics;
    opens admin to javafx.fxml,javafx.graphics,jav,sql;
    opens teacher to javafx.fxml,javafx.graphics,jav,sql;
    opens forms to javafx.fxml,javafx.graphics,jav,sql;
    opens Placement to javafx.fxml,javafx.graphics,jav,sql;
    opens freeRooms to javafx.fxml,javafx.graphics,jav,sql;
    exports map;
}

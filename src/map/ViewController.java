package map;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
public class ViewController {
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private ComboBox<String> COMBOBOX;
	    
	@FXML
    private ImageView newImage;
    
    @FXML
    private ImageView mapImageView;
    
    @FXML
    private Label buildingName;

    @FXML
    private Label noOFclass;

    @FXML
    private Label area;

    @FXML
    private Label address;

    @FXML
    private Label management;

    @FXML
    private Label floorsNo;

    @FXML
    private Label aboutline1;

    @FXML
    private Label aboutline2;

    @FXML
    private Label aboutline3;

    @FXML
    private Label SUPPORT;
    

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
    void CLOSE(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void REFRESH(ActionEvent event) {
    	set_map_text("","","","","","","","","");
    	newImage.setImage(null); // Set the image property to null
    	SUPPORT.setText("");
    }
    
    public void set_map_text(String building_name,String class_No,String AREA, String Addres, String Management, String floor_count, String abt_line1, String abt_line2,String abt_line3) {
    	buildingName.setText(building_name);
    	noOFclass.setText(class_No);
    	area.setText(AREA);
    	address.setText(Addres);
    	management.setText(Management);
    	floorsNo.setText(floor_count);
    	aboutline1.setText(abt_line1);
    	aboutline2.setText(abt_line2);
    	aboutline3.setText(abt_line3);
    	//write code to set no image!.
    }

    @FXML
    void SEARCH(ActionEvent event) {
    	String selected= COMBOBOX.getEditor().getText();
    	//according to user selection show details like image and its other details from setmaptext()
    	if (selected != null) {
            switch (selected) {
                case "Tennis Court":
                    set_map_text("Tennis Court","Status: Open","Area: 500 sq ft","Address: Near Physical Education Complex","Management +91 8546221436","Count: 2","About: Our campus have","2 tennis courts","open from 9AM to 9PM.");
                    displayImage("/map/buliding_1.png");
                    break;
                case "Athletic field":
                    set_map_text("Athletic filed","Status: Open","Area: 2400 sq ft","Address: Near Tennis Court","Management +91 889451756","Count: 1","About: We have one beautiful designed","Athletic filed you can enjoy here","Opens from 9AM to 9PM.");
                    displayImage("/map/atheletic_field.png");
                    break;
                case "Physical Edu Complex":
                    set_map_text("Physical Education Complex","Status: Open","Area: 1200 sq ft","Address: Near Tennis Court","Management +91 889451756","Floor Count: 3","About: In this Physical education complex","we have facilities for GYM,YOGA,pool","Opens from 9AM to 5PM.");
                    displayImage("/map/physical_edu_complex.png");
                    break;
                case "Child care center":
                    set_map_text("Child Care Center","Status: Open","Area: 200 sq ft","Address: Tennis Court","Management +91 889454586","Floor Count: 2","About: Child care center provides care for ","teachers having thier childern with them","Opens from 9AM to 5PM.");
                    displayImage("/map/child_care.png");
                    break;
                case "Grounds Maintainance":
                    set_map_text("Ground Maintainance","Status: Open","Area: 270 sq ft","Address: Near Parking A","Management +91 889454586","Floor Count: 3","About: This office verifies all the ground maintainance work ","you can report any plantation or damage on grounds.","Opens from 9AM to 5PM.");
                    displayImage("/map/ground_maintainanace.png");
                    break;
                case "Tower J":
                    set_map_text("Tower- J","Status: Open","Area: 340 sq ft","Address: Near Parking A","Management +91 999454586","Floor Count: 9","About: This is Tower - J, or school of computer science","all first year computer science students get thier academics here.","Opens from 9AM to 9PM.");
                    displayImage("/map/J_block.png");
                    break;
                case "Library":
                    set_map_text("Library","Status: Open","Area: 700 sq ft","Address: Near Parking Facility","Management +91 999454586","Floor Count: 4","About: This is Library, You can read number of books","all students can issue books form here.","Opens from 24 X 7");
                    displayImage("/map/library.png");
                    break;
                case "Parking Facility":
                    set_map_text("Parking facility","Status: Open","Area: 1000 sq ft","Address: Near Library","Management +91 999432486","Floor Count: 2","About: This is parking area","Teachers parking is at Ground floor","Opens from 24 X 7");
                    displayImage("/map/parking_facility.png");
                    break;
                case "BBH_Auditoriam":
                    set_map_text("Bhagat Singh Auditorium","Status: Open","Area: 1000 sq ft","Address: Near Library","Management +91 994532486","Floor Count: 7","About: This is BBH Auditorium based on Sr. Bhagat singh ji","All cultural and national activites are conducted here","Opens from 10 am to 10 pm");
                    displayImage("/map/audotorium.png");
                    break;
                case "Fine Art Center":
                    set_map_text("Fine Art Center","Status: Open","Area: 1500 sq ft","Address: Near Library","Management +91 99732486","Floor Count: 3","About: This is BBH Fine art center","Art lab is in basement","Opens from 9 am to 5 pm");
                    displayImage("/map/art_buiding.png");
                    break;
                case "Tower H":
                    set_map_text("Tower- H","Classes: 92","Area: 340 sq ft","Address: Near Fine Art block","Management +91 999454586","Floor Count: 8","About: These are Block - H, or school of electrical science","all semesters electronics students get thier academics here.","Opens from 9AM to 9PM.");
                    displayImage("/map/tower_H.png");
                    break;
                case "Tower F":
                    set_map_text("Tower- F","Classes: 84","Area: 340 sq ft","Address: Near fine art block","Management +91 999454586","Floor Count: 6","About: These are Block - F, or school of Mechanics","all semesters mechanics students get thier academics here.","Opens from 9AM to 9PM.");
                    displayImage("/map/tower_F.png");
                    break;
                case "TowerLWH":
                    set_map_text("Hostel- LWH","Rooms: 184","Area: 1940 sq ft","Address: Near tower F","Management +91 999454586","Floor Count: 16","About: This is Hostel first 6 floors are assigned","to girls 7th to 16th floor is for boys","Opens from 5AM to 11PM.");
                    displayImage("/map/hostel.png");
                    break;
                case "Business College":
                    set_map_text("Business College","Classes: 74","Area: 1940 sq ft","Address: Near Hostel","Management +91 999454586","Floor Count: 6","About: This is Hostel business and management college","All academics for BBA is planned here","Opens from 9AM to 5PM.");
                    displayImage("/map/business_college.png");
                    break;
                default:
                    // Handle unknown selection
                    break;
            }
        }
    }

    private void displayImage(String imagePath) {
        newImage.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }
    

    @FXML
    void SUPPORT(ActionEvent event) {
    	SUPPORT.setText("Project Developer: Zeline Projects. Mob:- +918824414850");
    }
  
    @FXML
    private void handleMapClick(MouseEvent event) {
        double imageXc = event.getX();
        double imageYc = event.getY();
        
        double imageViewWidth = mapImageView.getBoundsInLocal().getWidth();
        double imageViewHeight = mapImageView.getBoundsInLocal().getHeight();
        
        double imageWidth = mapImageView.getImage().getWidth();
        double imageHeight = mapImageView.getImage().getHeight();
        
        // Map coordinates to image dimensions
        double xRatio = imageWidth / imageViewWidth;
        double yRatio = imageHeight / imageViewHeight;
        
        double actualXc = imageXc * xRatio;
        double actualYc = imageYc * yRatio;
        
        // Now, 'actualX' and 'actualY' represent the coordinates on the image
        System.out.println("Clicked coordinates on the image: (" + actualXc + ", " + actualYc + ")");
        double imageX = event.getX();
        double imageY = event.getY();
        
        // Load and set new image based on clicked coordinates
        Image clickedImage = loadImageBasedOnCoordinates(imageX, imageY);
        if (clickedImage != null) {
            newImage.setImage(clickedImage);
        }
    }
    
    private Image loadImageBasedOnCoordinates(double x, double y) {
      
        if (isTennisCourt(x, y)) {
            
        	set_map_text("Tennis Court","Status: Open","Area: 500 sq ft","Address: Near Physical Education Complex","Management +91 8546221436","Count: 2","About: Our campus have","2 tennis courts","open from 9AM to 9PM.");
            return new Image(getClass().getResource("/map/buliding_1.png").toExternalForm());
            
        } else if (isAthleticfield(x, y)) {
            
        	set_map_text("Athletic filed","Status: Open","Area: 2400 sq ft","Address: Near Tennis Court","Management +91 889451756","Count: 1","About: We have one beautiful designed","Athletic filed you can enjoy here","Opens from 9AM to 9PM.");

            return new Image(getClass().getResource("/map/atheletic_field.png").toExternalForm());
        }
        else if (isPhysicalEduComplex(x, y)) {
            
        	set_map_text("Physical Education Complex","Status: Open","Area: 1200 sq ft","Address: Near Tennis Court","Management +91 889451756","Floor Count: 3","About: In this Physical education complex","we have facilities for GYM,YOGA,pool","Opens from 9AM to 5PM.");

            return new Image(getClass().getResource("/map/physical_edu_complex.png").toExternalForm());
        }
        else if (isChildcarecenter(x, y)) {
            
        	set_map_text("Child Care Center","Status: Open","Area: 200 sq ft","Address: Tennis Court","Management +91 889454586","Floor Count: 2","About: Child care center provides care for ","teachers having thier childern with them","Opens from 9AM to 5PM.");

            return new Image(getClass().getResource("/map/child_care.png").toExternalForm());
        }
        else if (isGroundsMaintainance(x, y)) {
            
        	set_map_text("Ground Maintainance","Status: Open","Area: 270 sq ft","Address: Near Parking A","Management +91 889454586","Floor Count: 3","About: This office verifies all the ground maintainance work ","you can report any plantation or damage on grounds.","Opens from 9AM to 5PM.");

            return new Image(getClass().getResource("/map/ground_maintainanace.png").toExternalForm());
        }
        else if (isTowerJ(x, y)) {
            
        	set_map_text("Tower- J","Status: Open","Area: 340 sq ft","Address: Near Parking A","Management +91 999454586","Floor Count: 9","About: This is Tower - J, or school of computer science","all first year computer science students get thier academics here.","Opens from 9AM to 9PM.");

            return new Image(getClass().getResource("/map/J_block.png").toExternalForm());
        }
        else if (isLibarary(x, y)) {
            
        	set_map_text("Library","Status: Open","Area: 700 sq ft","Address: Near Parking Facility","Management +91 999454586","Floor Count: 4","About: This is Library, You can read number of books","all students can issue books form here.","Opens from 24 X 7");

            return new Image(getClass().getResource("/map/library.png").toExternalForm());
        }
        else if (isParking_facility(x, y)) {
            
        	set_map_text("Parking facility","Status: Open","Area: 1000 sq ft","Address: Near Library","Management +91 999432486","Floor Count: 2","About: This is parking area","Teachers parking is at Ground floor","Opens from 24 X 7");

            return new Image(getClass().getResource("/map/parking_facility.png").toExternalForm());
        }
        else if (isBBH_Auditoriam(x, y)) {
            
        	set_map_text("Bhagat Singh Auditorium","Status: Open","Area: 1000 sq ft","Address: Near Library","Management +91 994532486","Floor Count: 7","About: This is BBH Auditorium based on Sr. Bhagat singh ji","All cultural and national activites are conducted here","Opens from 10 am to 10 pm");

            return new Image(getClass().getResource("/map/audotorium.png").toExternalForm());
        }
        else if (isFineArtCenter(x, y)) {
            
        	set_map_text("Fine Art Center","Status: Open","Area: 1500 sq ft","Address: Near Library","Management +91 99732486","Floor Count: 3","About: This is BBH Fine art center","Art lab is in basement","Opens from 9 am to 5 pm");

            return new Image(getClass().getResource("/map/art_buiding.png").toExternalForm());
        }
        else if (isTowerH(x, y)) {
            
        	set_map_text("Tower- H","Classes: 92","Area: 340 sq ft","Address: Near Fine Art block","Management +91 999454586","Floor Count: 8","About: These are Block - H, or school of electrical science","all semesters electronics students get thier academics here.","Opens from 9AM to 9PM.");

            return new Image(getClass().getResource("/map/tower_H.png").toExternalForm());
        }
        else if (isTowerF(x, y)) {
            
        	set_map_text("Tower- F","Classes: 84","Area: 340 sq ft","Address: Near fine art block","Management +91 999454586","Floor Count: 6","About: These are Block - F, or school of Mechanics","all semesters mechanics students get thier academics here.","Opens from 9AM to 9PM.");

            return new Image(getClass().getResource("/map/tower_F.png").toExternalForm());
        }
        else if (isTowerLWH(x, y)) {
            
        	set_map_text("Hostel- LWH","Rooms: 184","Area: 1940 sq ft","Address: Near tower F","Management +91 999454586","Floor Count: 16","About: This is Hostel first 6 floors are assigned","to girls 7th to 16th floor is for boys","Opens from 5AM to 11PM.");

            return new Image(getClass().getResource("/map/hostel.png").toExternalForm());
        }       
        else if (isCollegeOFbusinessANDmanagement(x, y)) {
            
        	set_map_text("Business College","Classes: 74","Area: 1940 sq ft","Address: Near Hostel","Management +91 999454586","Floor Count: 6","About: This is Hostel business and management college","All academics for BBA is planned here","Opens from 9AM to 5PM.");

            return new Image(getClass().getResource("/map/business_college.png").toExternalForm());
        }
        // Add more conditions for other areas as needed
        return null;
    }
    
    private boolean isTennisCourt(double x, double y) {
        // Define the coordinates or region for area A (Tennis Court)
        double areaAXStart = 390; // Define the starting x-coordinate of area A
        double areaAYStart = 470; // Define the starting y-coordinate of area A
        double areaAXEnd = 450;   // Define the ending x-coordinate of area A
        double areaAYEnd = 550;   // Define the ending y-coordinate of area A
        
        // Check if the clicked coordinates fall within the defined region for area A
        return x >= areaAXStart && x <= areaAXEnd && y >= areaAYStart && y <= areaAYEnd;
    }

    private boolean isAthleticfield(double x, double y) {
        // Define the coordinates or region for area B (Athletic Field)
        double areaBXStart = 137; // Define the starting x-coordinate of area B
        double areaBYStart = 390; // Define the starting y-coordinate of area B
        double areaBXEnd = 380;   // Define the ending x-coordinate of area B
        double areaBYEnd = 537;   // Define the ending y-coordinate of area B
        
        // Check if the clicked coordinates fall within the defined region for area B
        return x >= areaBXStart && x <= areaBXEnd && y >= areaBYStart && y <= areaBYEnd;
    }

    private boolean isPhysicalEduComplex(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 364; // Define the starting x-coordinate of area C
        double areaCYStart = 327; // Define the starting y-coordinate of area C
        double areaCXEnd = 431;   // Define the ending x-coordinate of area C
        double areaCYEnd = 402;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isChildcarecenter(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 222; // Define the starting x-coordinate of area C
        double areaCYStart = 314; // Define the starting y-coordinate of area C
        double areaCXEnd = 271;   // Define the ending x-coordinate of area C
        double areaCYEnd = 344;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isGroundsMaintainance(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 249; // Define the starting x-coordinate of area C
        double areaCYStart = 265; // Define the starting y-coordinate of area C
        double areaCXEnd = 318;   // Define the ending x-coordinate of area C
        double areaCYEnd = 303;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isTowerJ(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 217; // Define the starting x-coordinate of area C
        double areaCYStart = 226; // Define the starting y-coordinate of area C
        double areaCXEnd = 258;   // Define the ending x-coordinate of area C
        double areaCYEnd = 247;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isLibarary(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 437; // Define the starting x-coordinate of area C
        double areaCYStart = 151; // Define the starting y-coordinate of area C
        double areaCXEnd = 510;   // Define the ending x-coordinate of area C
        double areaCYEnd = 205;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isParking_facility(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 320; // Define the starting x-coordinate of area C
        double areaCYStart = 113; // Define the starting y-coordinate of area C
        double areaCXEnd = 445;   // Define the ending x-coordinate of area C
        double areaCYEnd = 188;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isBBH_Auditoriam(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 616; // Define the starting x-coordinate of area C
        double areaCYStart = 215; // Define the starting y-coordinate of area C
        double areaCXEnd = 751;   // Define the ending x-coordinate of area C
        double areaCYEnd = 261;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isFineArtCenter(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 515; // Define the starting x-coordinate of area C
        double areaCYStart = 117; // Define the starting y-coordinate of area C
        double areaCXEnd = 588;   // Define the ending x-coordinate of area C
        double areaCYEnd = 165;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isTowerH(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 475; // Define the starting x-coordinate of area C
        double areaCYStart = 87; // Define the starting y-coordinate of area C
        double areaCXEnd = 550;   // Define the ending x-coordinate of area C
        double areaCYEnd = 115;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }

    private boolean isTowerF(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 600; // Define the starting x-coordinate of area C
        double areaCYStart = 75; // Define the starting y-coordinate of area C
        double areaCXEnd = 635;   // Define the ending x-coordinate of area C
        double areaCYEnd = 105;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isTowerLWH(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 665; // Define the starting x-coordinate of area C
        double areaCYStart = 70; // Define the starting y-coordinate of area C
        double areaCXEnd = 695;   // Define the ending x-coordinate of area C
        double areaCYEnd = 100;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }
    
    private boolean isCollegeOFbusinessANDmanagement(double x, double y) {
        // Define the coordinates or region for area C (Physical Education Complex)
        double areaCXStart = 700; // Define the starting x-coordinate of area C
        double areaCYStart = 100; // Define the starting y-coordinate of area C
        double areaCXEnd = 850;   // Define the ending x-coordinate of area C
        double areaCYEnd = 160;   // Define the ending y-coordinate of area C
        
        // Check if the clicked coordinates fall within the defined region for area C
        return x >= areaCXStart && x <= areaCXEnd && y >= areaCYStart && y <= areaCYEnd;
    }


    @FXML
    void initialize() {
        assert newImage != null : "fx:id=\"newImage\" was not injected: check your FXML file 'View.fxml'.";
        assert COMBOBOX != null : "fx:id=\"COMBOBOX\" was not injected: check your FXML file 'View.fxml'.";
        assert mapImageView != null : "fx:id=\"mapImageView\" was not injected: check your FXML file 'View.fxml'.";
        assert buildingName != null : "fx:id=\"buildingName\" was not injected: check your FXML file 'View.fxml'.";
        assert noOFclass != null : "fx:id=\"noOFclass\" was not injected: check your FXML file 'View.fxml'.";
        assert area != null : "fx:id=\"area\" was not injected: check your FXML file 'View.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'View.fxml'.";
        assert management != null : "fx:id=\"management\" was not injected: check your FXML file 'View.fxml'.";
        assert floorsNo != null : "fx:id=\"floorsNo\" was not injected: check your FXML file 'View.fxml'.";
        assert aboutline1 != null : "fx:id=\"aboutline1\" was not injected: check your FXML file 'View.fxml'.";
        assert aboutline2 != null : "fx:id=\"aboutline2\" was not injected: check your FXML file 'View.fxml'.";
        assert aboutline3 != null : "fx:id=\"aboutline3\" was not injected: check your FXML file 'View.fxml'.";
        assert SUPPORT != null : "fx:id=\"SUPPORT\" was not injected: check your FXML file 'View.fxml'.";

        // Add hover effect to map image
        mapImageView.setOnMouseEntered(e -> mapImageView.setCursor(Cursor.HAND));
        mapImageView.setOnMouseExited(e -> mapImageView.setCursor(Cursor.DEFAULT));
        
        // Add clicking animation
        mapImageView.setOnMousePressed(e -> mapImageView.setEffect(new DropShadow()));
        mapImageView.setOnMouseReleased(e -> mapImageView.setEffect(null));
        
        //combo box deployment
        ArrayList<String> ary=new ArrayList<String>(Arrays.asList("Tennis Court","Athletic field","Physical Edu Complex","Child care center","Grounds Maintainance","Tower J","Libarary","Parking Facility", "BBH_Auditoriam", "Fine Art Center", "Tower H","Tower F","TowerLWH","Business College"));
    	COMBOBOX.getItems().addAll(ary);
    }
}
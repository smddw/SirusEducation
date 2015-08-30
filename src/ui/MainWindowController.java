/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lucifer-PC
 */
public class MainWindowController implements Initializable {
    @FXML
    private ToggleButton tglBtnGroup;
    @FXML
    private ToggleButton tblBtnLedger;
    @FXML
    private ToggleButton tglBtnRoomType;
    @FXML
    private ToggleButton tglBtnRoomRate;
    @FXML
    private ToggleButton tglBtnRoom;
    @FXML
    private ToggleButton tglBtnAminities;
    @FXML
    private ToggleButton tglBtnServices;
    @FXML
    private ToggleButton tglBtnMeal;
    @FXML
    private ToggleButton tglBtnFood;
    @FXML
    private ToggleButton tblBtnNewEmp;
    @FXML
    private ToggleButton tglBtnNewUser;
    @FXML
    private ToggleButton tglBtnPrivilage;
    @FXML
    private ToggleButton tglBtnBuilding;
    @FXML
    private ToggleButton tglBtnFloor;
    @FXML
    private ToggleButton tglBtnSeasonType;
    @FXML
    private ToggleButton tglBtnSeason;
    @FXML
    private ToggleButton tglBtnStudent;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

   
    @FXML
    private void tglBtnGroupAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("GroupGuestUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Group Guest");
            primaryStage.setScene(scene);
            primaryStage.setWidth(755);
            primaryStage.setHeight(505);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load GroupGuestUI.fxml");
            System.out.println(e.getMessage());
        }          
    }

    @FXML
    private void tblBtnLedgerAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("GuestLedgerUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Guest Ledger");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1250);
            primaryStage.setHeight(660);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load GuestLedgerUI.fxml");
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void tglBtnRoomTypeAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("RoomTypeUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Room Type");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1045);
            primaryStage.setHeight(525);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load RoomTypeUI.fxml");
            System.out.println(e.getMessage());
        }        
    }

    @FXML
    private void tglBtnRoomRateAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("RateTypeUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Rate Type");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1205);
            primaryStage.setHeight(700);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load RateTypeUI.fxml");
            System.out.println(e.getMessage());
        }        
    }

    @FXML
    private void tglBtnRoomAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("RoomUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Room");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1065);
            primaryStage.setHeight(640);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load RoomUI.fxml");
            System.out.println(e.getMessage());
        }        
    }

    @FXML
    private void tglBtnAminitiesAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("RoomServiceUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Room Service");
            primaryStage.setScene(scene);
            primaryStage.setWidth(762);
            primaryStage.setHeight(480);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load RoomServiceUI.fxml");
            System.out.println(e.getMessage());
        }          
    }

    @FXML
    private void tglBtnServicesAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("HotelServiceUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Hotel Service");
            primaryStage.setScene(scene);
            primaryStage.setWidth(770);
            primaryStage.setHeight(495);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load HotelServiceUI.fxml");
            System.out.println(e.getMessage());
        }               
    }

    @FXML
    private void tglBtnMealAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("HotelMealUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Hotel Meal");
            primaryStage.setScene(scene);
            primaryStage.setWidth(775);
            primaryStage.setHeight(470);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load HotelMealUI.fxml");
            System.out.println(e.getMessage());
        }          
    }

    @FXML
    private void tglBtnFoodAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("HotelFoodUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Hotel Food");
            primaryStage.setScene(scene);
            primaryStage.setWidth(770);
            primaryStage.setHeight(480);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load HotelFoodUI.fxml");
            System.out.println(e.getMessage());
        }           
    }

    @FXML
    private void tblBtnNewEmpAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("EmployeeUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Employee");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1105);
            primaryStage.setHeight(700);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load EmployeeUI.fxml");
            System.out.println(e.getMessage());
        }         
    }

    @FXML
    private void tglBtnNewUserAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("UserUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("User");
            primaryStage.setScene(scene);
            primaryStage.setWidth(955);
            primaryStage.setHeight(580);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load UserUI.fxml");
            System.out.println(e.getMessage());
        }          
    }

    @FXML
    private void tglBtnPrivilageAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("UserPrivilageUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("User Privilage");
            primaryStage.setScene(scene);
            primaryStage.setWidth(955);
            primaryStage.setHeight(420);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load UserPrivilageUI.fxml");
            System.out.println(e.getMessage());
        }         
    }

    @FXML
    private void tglBtnBuildingAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("BuildingUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Building");
            primaryStage.setScene(scene);
            primaryStage.setWidth(770);
            primaryStage.setHeight(480);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load BuildingUI.fxml");
            System.out.println(e.getMessage());
        }          
    }

    @FXML
    private void tglBtnFloorAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("FloorUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Floor");
            primaryStage.setScene(scene);
            primaryStage.setWidth(770);
            primaryStage.setHeight(480);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load FloorUI.fxml");
            System.out.println(e.getMessage());
        }        
    }

    @FXML
    private void tglBtnSeasonTypeAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("SeasonTypeUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Season Type");
            primaryStage.setScene(scene);
            primaryStage.setWidth(770);
            primaryStage.setHeight(480);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load SeasonTypeUI.fxml");
            System.out.println(e.getMessage());
        }        
    }

    @FXML
    private void tglBtnSeasonAP(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("SeasonUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Season");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1055);
            primaryStage.setHeight(510);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("can not load SeasonUI.fxml");
            System.out.println(e.getMessage());
        }         
    }

    @FXML
    private void tglBtnStudentAP(ActionEvent event) {
        
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("GuestUI.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Guest");
            primaryStage.setScene(scene);
            primaryStage.setWidth(1105);
            primaryStage.setHeight(585);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("Can not load GuestUI.fxml");
            System.out.println(e.getMessage());
        }      
    }

    @FXML
    private void tglBtnWalkInAP(ActionEvent event) {
    }

   

    
   
   
    
    
    
  
}

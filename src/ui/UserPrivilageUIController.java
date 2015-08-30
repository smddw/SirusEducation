/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import dao.ModuleDao;
import dao.RoleDao;
import dao.UserPrivilageDao;
import entity.Module;
import entity.Privilege;
import entity.Role;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import util.FXStyle;

/**
 * FXML Controller class
 *
 * @author Lucifer-PC
 */
public class UserPrivilageUIController implements Initializable {
    @FXML
    private ComboBox<Role> cmbRole;
    @FXML
    private ComboBox<Module> cmbModule;
    @FXML
    private CheckBox cbxSelect;
    @FXML
    private CheckBox cbxInsert;
    @FXML
    private CheckBox cbxUpdate;
    @FXML
    private CheckBox cbxDelete;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAdd;
    @FXML
    private ComboBox<Module> cmbModuleSearch;
    @FXML
    private ComboBox<Role> cmbRoleSearch;
    @FXML
    private Button btnReset;
    @FXML
    private Label labRecordCount;
    @FXML
    private TableView<Privilege> tblPrivilage;
    @FXML
    private TableColumn<Privilege, Role> tbcRole;
    @FXML
    private TableColumn<Privilege, Module> tbcModule;
    @FXML
    private TableColumn<Privilege, Integer> tbcSelect;
    @FXML
    private TableColumn<Privilege, Integer> tbcInsert;
    @FXML
    private TableColumn<Privilege, Integer> tbcUpdate;
    @FXML
    private TableColumn<Privilege, Integer> tbcDelete;
    @FXML
    private Pagination paginate;
    
    Privilege privilege;
    Privilege oldPrivilege;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDefault();
    }    
    
    private void loadDefault(){
        this.privilege = new Privilege();
        oldPrivilege = null;
        fillComboRole();
        cmbModule.setDisable(true);
        fillComboRoleSearch();
        fillComboModuleSearch();
        fillTablePrivilege(UserPrivilageDao.getAll());
        cbxSelect.setSelected(false);
        cbxInsert.setSelected(false);
        cbxDelete.setSelected(false);
        cbxUpdate.setSelected(false);
        setStyle(FXStyle.initial);
        disableButtons(false, true, true);
    }
    
    private void fillComboRole(){
        ObservableList<Role> roles = RoleDao.getAll();
        cmbRole.setItems(roles);
        cmbRole.getSelectionModel().select(-1);
    }
    
    private void fillComboRoleSearch(){
        ObservableList<Role> roles = RoleDao.getAll();
        cmbRoleSearch.setItems(roles);
        cmbRoleSearch.getSelectionModel().select(-1);
    }
    
    private void fillComboModuleSearch(){
        ObservableList<Module> modules = ModuleDao.getAll();
        cmbModuleSearch.setItems(modules);
        cmbModuleSearch.getSelectionModel().select(-1);
    } 
    
    private void fillTablePrivilege(ObservableList<Privilege> privileges){
        tbcRole.setCellValueFactory(new PropertyValueFactory<>("roleId"));
        tbcModule.setCellValueFactory(new PropertyValueFactory<>("moduleId"));
        tbcSelect.setCellValueFactory(new PropertyValueFactory<>("sel"));
        tbcInsert.setCellValueFactory(new PropertyValueFactory<>("ins"));
        tbcUpdate.setCellValueFactory(new PropertyValueFactory<>("upd"));
        tbcDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
        tblPrivilage.setItems(privileges);
        labRecordCount.setText("[ "+String.valueOf(privileges.size())+" Record(s) Found ]");
        tblPrivilage.getSelectionModel().clearSelection();
    }
    
    private void setStyle(String color){
        cmbRole.setStyle(color);
        cmbModule.setStyle(color);
    }
    
    private void disableButtons(boolean add, boolean update, boolean delete){
        btnAdd.setDisable(add);
        btnUpdate.setDisable(update);
        btnDelete.setDisable(delete);
    }
    
    private void fillForm(Privilege privilege){
        setStyle(FXStyle.valid);
        disableButtons(true, false, false);
        oldPrivilege = UserPrivilageDao.getById(privilege.getId());
        this.privilege = UserPrivilageDao.getById(privilege.getId());
        cmbRole.getItems().clear();
        cmbRole.getItems().add((Role)privilege.getRoleId());
        cmbRole.getSelectionModel().select(0);
        cmbModule.getItems().clear();
        cmbModule.getItems().add((Module)privilege.getModuleId());
        cmbModule.getSelectionModel().select(0);
        cbxSelect.setSelected(privilege.getSel().equals("Yes"));
        cbxInsert.setSelected(privilege.getIns().equals("Yes"));
        cbxUpdate.setSelected(privilege.getUpd().equals("Yes"));
        cbxDelete.setSelected(privilege.getDelete().equals("Yes"));
    }
    
    public String getErrors() {

        String errors = "";
        
        if (privilege.getRoleId() == null) {
            errors = errors + "Role is Not Selected\n";
        }
        if (privilege.getModuleId() == null) {
            errors = errors + "Module is Not Selected\n";
        }
        if (!(cbxSelect.isSelected()|| cbxInsert.isSelected()|| cbxUpdate.isSelected()|| cbxDelete.isSelected())) {
            errors = errors + "Privilage is Not Selected";
        }

        return errors;

    } 
    
    public String getUpdates() {
        
        privilege.setSel(cbxSelect.isSelected()?"Yes":"No"); 
        privilege.setIns(cbxInsert.isSelected()?"Yes":"No");
        privilege.setUpd(cbxUpdate.isSelected()?"Yes":"No");
        privilege.setDelete(cbxDelete.isSelected()?"Yes":"No");

        String confermation = "";

        if (!privilege.getSel().equals(oldPrivilege.getSel())) {
            confermation = confermation + "Select Changed " + oldPrivilege.getSel() + " to " + privilege.getSel() + "\n";
        }
        
         if (!privilege.getIns().equals(oldPrivilege.getIns())) {
            confermation = confermation + "Insert Changed " + oldPrivilege.getIns() + " to " + privilege.getIns() + "\n";
        }
         
         if (!privilege.getUpd().equals(oldPrivilege.getUpd())) {
            confermation = confermation + "Update Changed " + oldPrivilege.getUpd() + " to " + privilege.getUpd() + "\n";
        }
          if (!privilege.getDelete().equals(oldPrivilege.getDelete())) {
            confermation = confermation + "Delete Changed " + oldPrivilege.getDelete() + " to " + privilege.getDelete()+ "\n";
        }

        
        return confermation;

    }    

    @FXML
    private void cmbRoleAP(ActionEvent event) {
        if (cmbRole.getSelectionModel().getSelectedItem() != null) {
            privilege.setRoleId((Role)cmbRole.getSelectionModel().getSelectedItem());
            if (oldPrivilege != null && !privilege.getRoleId().equals(oldPrivilege.getRoleId())) {
                cmbRole.setStyle(FXStyle.updated);
            } else {
                cmbRole.setStyle(FXStyle.valid);
            }
            cmbModule.getItems().clear();
            cmbModule.setDisable(false);
            cmbModule.getSelectionModel().select(-1);
            cmbModule.setItems(UserPrivilageDao.getUnAssignedModulesByRole((Role)cmbRole.getSelectionModel().getSelectedItem()));            
        }        
    }

    @FXML
    private void cmbModuleAP(ActionEvent event) {
        if (cmbModule.getSelectionModel().getSelectedItem() != null) {
            privilege.setModuleId((Module)cmbModule.getSelectionModel().getSelectedItem());
            if (oldPrivilege != null && !privilege.getModuleId().equals(oldPrivilege.getModuleId())) {
                cmbModule.setStyle(FXStyle.updated);
            } else {
                cmbModule.setStyle(FXStyle.valid);
            }            
        }   
    }
    
    

    @FXML
    private void btnAddAP(ActionEvent event) {
        privilege.setSel(cbxSelect.isSelected()?"Yes":"No"); 
        privilege.setIns(cbxInsert.isSelected()?"Yes":"No");
        privilege.setUpd(cbxUpdate.isSelected()?"Yes":"No");
        privilege.setDelete(cbxDelete.isSelected()?"Yes":"No");
        
        boolean validity = privilege.validity();
                
        if (validity) {

            String confermation = "Ara you sure you need to add this Privilages with following details\n "
                    + "\nRole   : " + privilege.getRoleId().getName()
                    + "\nModule : " + privilege.getModuleId().getName()
                    + "\nSelect : " + privilege.getSel()
                    + "\nInsert : " + privilege.getIns()
                    + "\nUpdate : " + privilege.getUpd()
                    + "\nDelete : " + privilege.getDelete();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you want add values ?");
            alert.setContentText(confermation);
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK) {
                UserPrivilageDao.add(privilege);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Successfully added!");
                alert.showAndWait();
                loadDefault();
            }

        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Please fill following fields.");
            alert.setContentText(getErrors());
            alert.showAndWait();    

        }      
    }

    @FXML
    private void btnUpdateAP(ActionEvent event) {
        
        boolean validity = privilege.validity();
               
        if (validity) {
            String updates = getUpdates();

            if (!updates.isEmpty()) {

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Do you want update Privilege with following modifications?\n");
                alert.setContentText(updates);
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    UserPrivilageDao.update(privilege);
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated!");
                    alert.showAndWait();
                    loadDefault();
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Please fill following fields.");
                alert.setContentText("Update relevent fields");
                alert.showAndWait();
            }
        } else {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Please fill following fields.");
            alert.setContentText(getErrors());
            alert.showAndWait();

        }             
    }
    
    @FXML
    private void btnDeleteAP(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, It is going to delete?");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            UserPrivilageDao.delete(privilege);
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Deleted");
            alert.setContentText("Successfully deleted!");
            alert.showAndWait();
            loadDefault();
        }         
    }    
    
    @FXML
    private void btnClearAP(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, It is going to discard values");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            loadDefault();
        }         
    }

    @FXML
    private void cmbModuleSearchAP(ActionEvent event) {
        if (cmbModuleSearch.getSelectionModel().getSelectedItem() != null) {
            fillTablePrivilege(UserPrivilageDao.getByModule((Module)cmbModuleSearch.getSelectionModel().getSelectedItem()));
        }        
    }

    @FXML
    private void cmbRoleSearchAP(ActionEvent event) {
        if (cmbRoleSearch.getSelectionModel().getSelectedItem() != null) {
            fillTablePrivilege(UserPrivilageDao.getByRole((Role)cmbRoleSearch.getSelectionModel().getSelectedItem()));
        }
    }

    @FXML
    private void btnResetAP(ActionEvent event) {
        loadDefault();
    }

    @FXML
    private void tblPrivilageMC(MouseEvent event) {
        if (!tblPrivilage.getSelectionModel().isEmpty()) {
            fillForm((Privilege)tblPrivilage.getSelectionModel().getSelectedItem());            
        }
    }

    @FXML
    private void tblPrivilageKR(KeyEvent event) {
        if (!tblPrivilage.getSelectionModel().isEmpty()) {
            fillForm((Privilege)tblPrivilage.getSelectionModel().getSelectedItem());            
        }       
    }
    
}

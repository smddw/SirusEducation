/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import dao.EmployeeDao;
import dao.RoleDao;
import dao.UserDao;
import entity.Employee;
import entity.Role;
import entity.User;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import util.FXStyle;

/**
 * FXML Controller class
 *
 * @author Lucifer-PC
 */
public class UserUIController implements Initializable {
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;
    @FXML
    private ListView<Role> lstLeft;
    @FXML
    private ListView<Role> lstRight;
    @FXML
    private Button btnRightAll;
    @FXML
    private Button btnRight;
    @FXML
    private Button btnLeft;
    @FXML
    private Button btnLeftAll;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAdd;
    @FXML
    private ComboBox<Employee> cmbEmployee;
    @FXML
    private ComboBox<Role> cmbRoleSearch;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtUser;
    @FXML
    private TableView<User> tblUser;
    @FXML
    private TableColumn<User, Employee> tbcEmpName;
    @FXML
    private TableColumn<User, Role> tbcRole;
    @FXML
    private Pagination paginate;
    @FXML
    private Label labRecordCount;

    private User user;
    private User oldUser;
    
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
        user = new User();
        oldUser = null;
        fillComboEmployee();
        fillComboRoleSearch();
        fillTable(UserDao.getAll());
        lstLeft.setItems(RoleDao.getAll());
        lstRight.getItems().clear();
        lstRight.setStyle(FXStyle.initial);
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtUser.setText("");
        setStyle(FXStyle.initial);
        disableButtons(false, true, true);
        btnLeft.setDisable(true);
        btnLeftAll.setDisable(true);
        btnRight.setDisable(false);
        btnRightAll.setDisable(false);        
    }
        
    private void fillComboEmployee(){
        ObservableList<Employee> employees = EmployeeDao.getAll();
        cmbEmployee.setItems(employees);
        cmbEmployee.getSelectionModel().select(-1);
    }
    
    private void fillComboRoleSearch(){
        ObservableList<Role> roles = RoleDao.getAll();
        cmbRoleSearch.setItems(roles);
        cmbRoleSearch.getSelectionModel().select(-1);
    }
    
    private void fillTable(ObservableList<User> users){
        tbcEmpName.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        tbcRole.setCellValueFactory(new PropertyValueFactory<>("roleList"));
        tblUser.setItems(users);
        labRecordCount.setText("[ "+String.valueOf(users.size())+" Record(s) Found ]");
        tblUser.getSelectionModel().clearSelection();
    }
    
    private void fillForm(User user){
        disableButtons(true, false, false);
        setStyle(FXStyle.valid);
        this.oldUser = UserDao.getById(user.getId());
        this.user = UserDao.getById(user.getId());
        cmbEmployee.getItems().clear();
        cmbEmployee.getItems().add((Employee) user.getEmployeeId());
        cmbEmployee.getSelectionModel().select(0);        
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        txtConfirmPassword.setText(user.getPassword());        
        lstRight.setItems(FXCollections.observableArrayList(user.getRoleList()));        
        lstLeft.setItems(RoleDao.getAll());
        lstLeft.getItems().removeAll(FXCollections.observableArrayList(user.getRoleList()));               
        validateList();
    }

    private void setStyle(String color){
        cmbEmployee.setStyle(color);
        txtUsername.setStyle(color);
        txtPassword.setStyle(color);
        txtConfirmPassword.setStyle(color);
    }
    
    private void disableButtons(boolean add, boolean update, boolean delete) {
       btnAdd.setDisable(add);
       btnUpdate.setDisable(update);
       btnDelete.setDisable(delete);
    }
    
    @FXML
    private void cmbEmployeeAP(ActionEvent event) {
        if (cmbEmployee.getSelectionModel().getSelectedItem() != null) {
            user.setEmployeeId((Employee)cmbEmployee.getSelectionModel().getSelectedItem());
            if (oldUser != null && !user.getEmployeeId().equals(oldUser.getEmployeeId())) {
                cmbEmployee.setStyle(FXStyle.updated);
            } else {
                cmbEmployee.setStyle(FXStyle.valid);
            }
        }
    }    
    
    @FXML
    private void txtUsernameKR(KeyEvent event) {
        if (user.setUsername(txtUsername.getText().trim())) {
            if (oldUser != null && !user.getUsername().equals(oldUser.getUsername())) {
                txtUsername.setStyle(FXStyle.updated);
            } else {
                txtUsername.setStyle(FXStyle.valid);
            }
        } else {
            txtUsername.setStyle(FXStyle.invalid);
        }      
    }
    
    @FXML
    private void txtPasswordKR(KeyEvent event) {
        txtConfirmPassword.setText("");
        if (user.setPassword(txtPassword.getText().trim())) {
            if (oldUser != null && !user.getPassword().equals(oldUser.getPassword())) {
                txtPassword.setStyle(FXStyle.updated);
            } else {
                txtPassword.setStyle(FXStyle.valid);
            }
        } else {
            txtPassword.setStyle(FXStyle.invalid);
        }        
    }  
    
    @FXML
    private void txtConfirmPasswordKR(KeyEvent event) {
        if (txtPassword.getText().trim().equals(txtConfirmPassword.getText().trim())) {            
            txtConfirmPassword.setStyle(FXStyle.valid);
            
        } else {
            txtConfirmPassword.setStyle(FXStyle.invalid);
        }        
    }
    
    private void validateList() {
        
        if (user.setRoleList(lstRight.getItems())) {
            lstRight.setStyle(FXStyle.valid);
        } else {
            lstRight.setStyle(FXStyle.invalid); 
            
        }
        if(lstLeft.getItems().isEmpty()){
            btnRight.setDisable(true);
            btnRightAll.setDisable(true);
            btnLeft.setDisable(false);
            btnLeftAll.setDisable(false);
        }
        else if(lstRight.getItems().isEmpty()){
            btnRight.setDisable(false);
            btnRightAll.setDisable(false);
            btnLeft.setDisable(true);
            btnLeftAll.setDisable(true);
        } 
        else
        {
            btnRight.setDisable(false);
            btnRightAll.setDisable(false);
            btnLeft.setDisable(false);
            btnLeftAll.setDisable(false);
        
        } 
               
    }
    
    public String getErrors() {

        String errors = "";

        if (user.getUsername() == null) {
            errors = errors + "Username is Invalid\n";
        }
        if (user.getEmployeeId() == null) {
            errors = errors + "Employee is Not Selected\n";
        }
        if (user.getRoleList() == null) {
            errors = errors + "Roles are Not Selected\n";
        }
        if (user.getPassword() == null) {
            errors = errors + "Password is Invalid\n";
        }

        if (!txtPassword.getText().equals(txtConfirmPassword.getText())) {
            errors = errors + "Confirm Password is Mismatch";
        }

        return errors;

    }
    
    public String getUpdates() {
        
        String confermation = "";
        
        if (!user.getUsername().equals(oldUser.getUsername())) {
            confermation = confermation + oldUser.getUsername() + " chnaged to " + user.getUsername() + "\n";
        }
        
        if (!user.getPassword().equals(oldUser.getPassword())) {
            confermation = confermation + oldUser.getPassword() + " chnaged to " + user.getPassword() + "\n";
        }
        
        if (!(user.getRoleList().containsAll(oldUser.getRoleList())&& oldUser.getRoleList().containsAll(user.getRoleList()))) {
            confermation = confermation + oldUser.getRoleList().toString() + " chnaged to " + user.getRoleList().toString() + "\n";
        }
        
        return confermation;
        
    }    

    @FXML
    private void btnRightAllAP(ActionEvent event) {
        lstRight.setItems(RoleDao.getAll());
        lstLeft.getItems().clear();
        validateList();        
    }

    @FXML
    private void btnRightAP(ActionEvent event) {
        lstRight.getItems().addAll(lstLeft.getSelectionModel().getSelectedItems());
        lstLeft.getItems().removeAll(lstLeft.getSelectionModel().getSelectedItems()); 
        validateList();       
    }

    @FXML
    private void btnLeftAP(ActionEvent event) {
        lstLeft.getItems().addAll(lstRight.getSelectionModel().getSelectedItems());
        lstRight.getItems().removeAll(lstRight.getSelectionModel().getSelectedItems()); 
        validateList();       
    }

    @FXML
    private void btnLeftAllAP(ActionEvent event) {
        lstLeft.setItems(RoleDao.getAll());
        lstRight.getItems().clear();
        validateList();       
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
    private void btnAddAP(ActionEvent event) {
        
        boolean validity = user.validity()
                && txtPassword.getText().equals(txtConfirmPassword.getText());
        
        if (validity) {
            
            String confermation = "Ara you sure you need to add this User with following details\n "
                    + "\nEmployee :     \t\t" + user.getEmployeeId().getName()
                    + "\nUsername :     \t\t" + user.getUsername()
                    + "\nRoles    :     \t\t" + user.getRoleList().toString();
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you want add values ?");
            alert.setContentText(confermation);
            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK) {
                UserDao.add(user);
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
        boolean validity = user.validity()
                && txtPassword.getText().equals(txtConfirmPassword.getText());

        if (validity) {
            String updates = getUpdates();

            if (!updates.isEmpty()) {

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Do you want update User with following modifications?\n");
                alert.setContentText(updates);
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK) {
                    UserDao.update(user);
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
            UserDao.delete(user);
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Deleted");
            alert.setContentText("Successfully deleted!");
            alert.showAndWait();
            loadDefault();
        }        
    }    
    
    @FXML
    private void cmbRoleSearchAP(ActionEvent event) {
        if (cmbRoleSearch.getSelectionModel().getSelectedItem() != null) {
            fillTable(UserDao.getByRoles((Role)cmbRoleSearch.getSelectionModel().getSelectedItem()));
        }
    }
    
    @FXML
    private void txtUserKR(KeyEvent event) {
        fillTable(UserDao.getByUsername(txtUser.getText().trim()));
    }

    @FXML
    private void btnResetAP(ActionEvent event) {
        loadDefault();
    }

    @FXML
    private void tblUserMC(MouseEvent event) {
        fillForm((User)tblUser.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void tblUserKR(KeyEvent event) {
        fillForm((User)tblUser.getSelectionModel().getSelectedItem());
    }


    
}

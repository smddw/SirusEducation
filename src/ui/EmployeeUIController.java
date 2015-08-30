package ui;

import util.FXStyle;
import dao.CivilstatusDao;
import dao.DesignationDao;
import dao.EmployeeDao;
import dao.GenderDao;
import entity.Civilstatus;
import entity.Designation;
import entity.Employee;
import entity.Gender;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EmployeeUIController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<Gender> cmbGender;
    @FXML
    private ComboBox<Civilstatus> cmbCivilStatus;
    @FXML
    private TextField txtAddress;
    @FXML
    private DatePicker dtpDOB;
    @FXML
    private ComboBox<Designation> cmbDesignation;
    @FXML
    private TextField txtMobileNo;
    @FXML
    private TextField txtLandNo;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnAdd;
    @FXML
    private DatePicker dtpAssignDate;
    @FXML
    private TextField txtNameSearch;
    @FXML
    private TextField txtMobileSearch;
    @FXML
    private ComboBox<Gender> cmbGenderSearch;
    @FXML
    private ComboBox<Designation> cmbDesignationSearch;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSearch;
    @FXML
    private Label labRecordCount;
    @FXML
    private TableView<Employee> tblEmployee;
    @FXML
    private TableColumn<Employee, String> tbcName;
    @FXML
    private TableColumn<Employee, Gender> tbcGender;
    @FXML
    private TableColumn<Employee, Civilstatus> tbcCivilStatus;
    @FXML
    private TableColumn<Employee, Designation> tbcDesignation;
    @FXML
    private TableColumn<Employee, String> tbcMobileNo;
    @FXML
    private TableColumn<Employee, String> tbcEmail;
    @FXML
    private Pagination paginate;

    boolean valName;
    boolean valAddress;
    boolean valGender;
    boolean valCivilstatus;
    boolean valDOB;
    boolean valMobile;
    boolean valLand;
    boolean valEmail;
    boolean valDesignation;
    boolean valAssign;

    boolean updateName;
    boolean updateAddress;
    boolean updateGender;
    boolean updateCivilstatus;
    boolean updateDOB;
    boolean updateMobile;
    boolean updateLand;
    boolean updateEmail;
    boolean updateDesignation;
    boolean updateAssign;

    String valMsgName;
    String valMsgAddress;
    String valMsgGender;
    String valMsgCivilstatus;
    String valMsgDOB;
    String valMsgMobile;
    String valMsgLand;
    String valMsgEmail;
    String valMsgDesignation;
    String valMsgAssign;

    String msgName = "\nName is Invalid";
    String msgAddress = "\nAddress is Invalid";
    String msgGender = "\nSelect a Gender";
    String msgCivilstatus = "\nSelect a Civilstatus";
    String msgDOB = "\nSelect a Valid Date of Birth";
    String msgMobile = "\nMobile Number is Invalid";
    String msgLand = "\nLand Number is Invalid";
    String msgEmail = "\nEmail is Invalid";
    String msgDesignation = "\nSelect a Designation";
    String msgAssign = "\nSelect a Valid Assign Date";

    private Employee employee;
    private Employee oldEmployee;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDefault();
    }

    private void loadDefault() {
        employee = new Employee();
        oldEmployee = employee;
        fillComboGender();
        fillComboCivilStatus();
        fillComboDesignation();
        fillComboGenderSearch();
        fillComboDesignationSearch();
        fillTableEmployee(EmployeeDao.getAll());
        txtName.setText("");
        txtName.setStyle(FXStyle.initial);
        cmbGender.setStyle(FXStyle.initial);
        cmbCivilStatus.setStyle(FXStyle.initial);
        txtAddress.setText("");
        txtAddress.setStyle(FXStyle.initial);
        dtpDOB.getEditor().setText("");
        dtpDOB.getEditor().setStyle(FXStyle.initial);
        //dtpDOB.getEditor().setEditable(false);
        cmbDesignation.setStyle(FXStyle.initial);
        dtpAssignDate.getEditor().setText("");
        dtpAssignDate.getEditor().setStyle(FXStyle.initial);
        //dtpAssignDate.getEditor().setEditable(false);
        txtMobileNo.setText("");
        txtMobileNo.setStyle(FXStyle.initial);
        txtLandNo.setText("");
        txtLandNo.setStyle(FXStyle.initial);
        txtEmail.setText("");
        txtEmail.setStyle(FXStyle.initial);
        txtNameSearch.setText("");
        txtMobileSearch.setText("");
        enableButtons(false, true, true);
        validateForm(false);
    }

    private void fillComboGender() {
        ObservableList<Gender> genders = GenderDao.getAll();
        cmbGender.setItems(genders);
        cmbGender.getSelectionModel().select(-1);
    }

    private void fillComboCivilStatus() {
        ObservableList<Civilstatus> civilstatuses = CivilstatusDao.getAll();
        cmbCivilStatus.setItems(civilstatuses);
        cmbCivilStatus.getSelectionModel().select(-1);
    }

    private void fillComboDesignation() {
        ObservableList<Designation> designations = DesignationDao.getAll();
        cmbDesignation.setItems(designations);
        cmbDesignation.getSelectionModel().select(-1);
    }

    private void fillComboGenderSearch() {
        ObservableList<Gender> genders = GenderDao.getAll();
        cmbGenderSearch.setItems(genders);
        cmbGenderSearch.getSelectionModel().select(-1);
    }

    private void fillComboDesignationSearch() {
        ObservableList<Designation> designations = DesignationDao.getAll();
        cmbDesignationSearch.setItems(designations);
        cmbDesignationSearch.getSelectionModel().select(-1);
    }

    private void fillTableEmployee(ObservableList<Employee> employees) {
        tbcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tbcGender.setCellValueFactory(new PropertyValueFactory<>("genderId"));
        tbcCivilStatus.setCellValueFactory(new PropertyValueFactory<>("civilstatusId"));
        tbcDesignation.setCellValueFactory(new PropertyValueFactory<>("designationId"));
        tbcMobileNo.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblEmployee.setItems(employees);
        labRecordCount.setText("[ " + String.valueOf(employees.size()) + " Record(s) Found ]");
        tblEmployee.getSelectionModel().clearSelection();
    }
    
    private void fillForm(){
        oldEmployee = EmployeeDao.getById(employee.getId());
        txtName.setText(employee.getName());
        cmbGender.getSelectionModel().select(employee.getGenderId());
        cmbCivilStatus.getSelectionModel().select(employee.getCivilstatusId());
        txtAddress.setText(employee.getAddress());
        dtpDOB.setValue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(employee.getDob())));
        cmbDesignation.getSelectionModel().select(employee.getDesignationId());
        dtpAssignDate.setValue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(employee.getAssign())));
        txtMobileNo.setText(employee.getMobile());
        txtLandNo.setText(employee.getLand());
        txtEmail.setText(employee.getEmail());
        
        valName = true;
        valMsgName = "";
        txtName.setStyle(FXStyle.valid);
        valGender = true;
        valMsgGender = "";
        cmbGender.setStyle(FXStyle.valid);
        valCivilstatus = true;
        valMsgCivilstatus = "";
        cmbCivilStatus.setStyle(FXStyle.valid);        
        valAddress = true;
        valMsgAddress = "";
        txtAddress.setStyle(FXStyle.valid);
        valDOB = true;
        valMsgDOB = "";
        dtpDOB.getEditor().setStyle(FXStyle.valid);
        valDesignation = true;
        valMsgDesignation = "";
        cmbDesignation.setStyle(FXStyle.valid);
        valAssign = true;
        valMsgAssign = "";
        dtpAssignDate.getEditor().setStyle(FXStyle.valid);        
        valMobile = true;
        valMsgMobile = "";
        txtMobileNo.setStyle(FXStyle.valid);
        valLand = true;
        valMsgLand = "";
        txtLandNo.setStyle(FXStyle.valid);
        valEmail = true;
        valMsgEmail = "";
        txtEmail.setStyle(FXStyle.valid);
        enableButtons(true, false, false);        
    }
    
    private void clear(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, It is going to discard values");
        alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            loadDefault();
        }    
    }

    private void enableButtons(boolean add, boolean update, boolean delete) {
        btnAdd.setDisable(add);
        btnUpdate.setDisable(update);
        btnDelete.setDisable(delete);
    }

    private void validateForm(boolean validity) {
        valName = validity;
        valDOB = validity;
        valAddress = validity;
        valMobile = validity;
        valLand = validity;
        valEmail = validity;
        valGender = validity;
        valCivilstatus = validity;
        valAssign = validity;

        if (validity) {
            valMsgName = "";
            valMsgDOB = "";
            valMsgAddress = "";
            valMsgMobile = "";
            valMsgLand = "";
            valMsgEmail = "";
            valMsgGender = "";
            valMsgDesignation = "";
            valMsgCivilstatus = "";
            valMsgAssign = "";
        } else {
            valMsgName = msgName;
            valMsgDOB = msgDOB;
            valMsgAddress = msgAddress;
            valMsgMobile = msgMobile;
            valMsgLand = msgLand;
            valMsgEmail = msgEmail;
            valMsgGender = msgGender;
            valMsgDesignation = msgDesignation;
            valMsgCivilstatus = msgCivilstatus;
            valMsgAssign = msgAssign;
        }
    }

    @FXML
    private void txtNameKR(KeyEvent event) {
        String name = txtName.getText().trim();
        if (name.matches("[A-Za-z\\s]{2}[A-Za-z\\s]+")) {
            valName = true;
            employee.setName(name);
            if (oldEmployee.getName().equals(employee.getName())) {
                valMsgName = "";
                txtName.setStyle(FXStyle.valid);
                updateName = false;
            } else {
                valMsgName = "\nName Changed : " + oldEmployee.getName() + " To " + employee.getName();
                txtName.setStyle(FXStyle.updated);
                updateName = true;
            }
        } else {
            txtName.setStyle(FXStyle.invalid);
            valName = false;
            valMsgName = msgName;
            employee.setName(null);
        }
    }

    @FXML
    private void cmbGenderAP(ActionEvent event) {
        if (cmbGender.getSelectionModel().getSelectedItem() != null) {
            valGender = true;
            employee.setGenderId((Gender) cmbGender.getSelectionModel().getSelectedItem());
            if (oldEmployee.getGenderId().getName().equals(employee.getGenderId().getName())) {
                valMsgGender = "";
                cmbGender.setStyle(FXStyle.valid);
                updateGender = false;
            } else {
                valMsgGender = "\nGender Chnaged : " + oldEmployee.getGenderId().getName() + " To " + employee.getGenderId().getName();
                cmbGender.setStyle(FXStyle.updated);
                updateGender = true;
            }
        }
    }

    @FXML
    private void cmbCivilStatusAP(ActionEvent event) {
        if (cmbCivilStatus.getSelectionModel().getSelectedItem() != null) {
            valCivilstatus = true;
            employee.setCivilstatusId((Civilstatus) cmbCivilStatus.getSelectionModel().getSelectedItem());
            if (oldEmployee.getCivilstatusId().getName().equals(employee.getCivilstatusId().getName())) {
                valMsgCivilstatus = "";
                cmbCivilStatus.setStyle(FXStyle.valid);
                updateCivilstatus = false;
            } else {
                valMsgCivilstatus = "\nCivilstatus Changed : " + oldEmployee.getCivilstatusId().getName() + " To " + employee.getCivilstatusId().getName();
                cmbCivilStatus.setStyle(FXStyle.updated);
                updateCivilstatus = true;
            }
        }
    }

    @FXML
    private void txtAddressKR(KeyEvent event) {
        String address = txtAddress.getText().trim();
        if (address.length() > 10) {
            valAddress = true;
            employee.setAddress(address);
            if (oldEmployee.getAddress().equals(employee.getAddress())) {
                valMsgAddress = "";
                txtAddress.setStyle(FXStyle.valid);
                updateAddress = false;
            } else {
                valMsgAddress = "\nAddress Changed : " + oldEmployee.getAddress() + " To " + employee.getAddress();
                txtAddress.setStyle(FXStyle.updated);
                updateAddress = true;
            }
        } else {
            txtAddress.setStyle(FXStyle.invalid);
            valAddress = false;
            valMsgAddress = msgAddress;
            employee.setAddress(null);
        }
    }

    @FXML
    private void dtpDOBAP(ActionEvent event) {
        LocalDate dob = dtpDOB.getValue();
        if (dob.isBefore(LocalDate.now())) {
            valDOB = true;
            valMsgDOB = "";
            employee.setDob(Date.from(LocalDateTime.of(dob, LocalTime.now()).toInstant(ZoneOffset.UTC)));
            if (oldEmployee.getDob().equals(employee.getDob())) {
                valMsgDOB = "";
                dtpDOB.getEditor().setStyle(FXStyle.valid);
                updateDOB = false;
            } else {
                valMsgDOB = "\nDOB Changed : " + oldEmployee.getDob() + " To " + employee.getDob();
                dtpDOB.getEditor().setStyle(FXStyle.updated);
                updateDOB = true;
            }
        } else {
            valDOB = false;
            valMsgDOB = msgDOB;
            dtpDOB.getEditor().setStyle(FXStyle.invalid);
            employee.setDob(null);
        }
    }

    @FXML
    private void cmbDesignationAP(ActionEvent event) {
        if (cmbDesignation.getSelectionModel().getSelectedItem() != null) {
            valDesignation = true;
            valMsgDesignation = "";
            employee.setDesignationId((Designation) cmbDesignation.getSelectionModel().getSelectedItem());
            if (oldEmployee.getDesignationId().getName().equals(employee.getDesignationId().getName())) {
                cmbDesignation.setStyle(FXStyle.valid);
                updateDesignation = false;
            } else {
                valMsgDesignation = "\nDesignation Changed : " + oldEmployee.getDesignationId().getName() + " To " + employee.getDesignationId().getName();
                cmbDesignation.setStyle(FXStyle.updated);
                updateDesignation = true;
            }
        }
    }

    @FXML
    private void dtpAssignDateAP(ActionEvent event) {
        LocalDate assignDate = dtpAssignDate.getValue();
        if (assignDate.isAfter(LocalDate.now())) {
            valAssign = true;
            valMsgAssign = "";
            employee.setAssign(Date.from(LocalDateTime.of(assignDate, LocalTime.now()).toInstant(ZoneOffset.UTC)));
            if (oldEmployee.getAssign().equals(employee.getAssign())) {
                valMsgAssign = "";
                dtpAssignDate.getEditor().setStyle(FXStyle.valid);
                updateAssign = false;
            } else {
                valMsgAssign = "\nAssign Date Changed : " + oldEmployee.getAssign() + " To " + employee.getAssign();
                dtpAssignDate.getEditor().setStyle(FXStyle.updated);
                updateAssign = true;
            }
        } else {
            valAssign = false;
            valMsgAssign = msgAssign;
            dtpAssignDate.getEditor().setStyle(FXStyle.invalid);
            employee.setAssign(null);
        }
    }

    @FXML
    private void txtMobileNoKR(KeyEvent event) {
        String mobile = txtMobileNo.getText().trim();
        if (mobile.matches("0\\d{9}")) {
            //((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{10}
            valMobile = true;
            valMsgMobile = "";
            employee.setMobile(mobile);
            if (oldEmployee.getMobile().equals(employee.getMobile())) {
                valMsgMobile = "";
                txtMobileNo.setStyle(FXStyle.valid);
                updateMobile = false;
            } else {
                valMsgMobile = "\nMobile Changed : " + oldEmployee.getMobile() + " To " + employee.getMobile();
                txtMobileNo.setStyle(FXStyle.updated);
                updateMobile = true;
            }
        } else {
            txtMobileNo.setStyle(FXStyle.invalid);
            valMobile = false;
            valMsgMobile = msgMobile;
            employee.setMobile(null);
        }
    }

    @FXML
    private void txtLandNoKR(KeyEvent event) {
        String land = txtLandNo.getText().trim();
        if (land.matches("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{10}")) {
            valLand = true;
            valMsgLand = "";
            employee.setLand(land);
            if (oldEmployee.getLand().equals(employee.getLand())) {
                valMsgLand = "";
                txtLandNo.setStyle(FXStyle.valid);
                updateLand = false;
            } else {
                valMsgLand = "\nLand Changed : " + oldEmployee.getLand() + " To " + employee.getLand();
                txtLandNo.setStyle(FXStyle.updated);
                updateLand = true;
            }
        } else {
            txtLandNo.setStyle(FXStyle.invalid);
            valLand = false;
            valMsgLand = msgLand;
            employee.setLand(null);
        }
    }

    @FXML
    private void txtEmailKR(KeyEvent event) {
        String email = txtEmail.getText().trim();
        if (email.matches("\\w+\\.?\\w+@\\w+\\.\\w+\\w+")) {
            valEmail = true;
            valMsgEmail = "";
            employee.setEmail(email);
            if (oldEmployee.getEmail() != null && oldEmployee.getEmail().equals(employee.getEmail())) {
                valMsgEmail = "";
                txtEmail.setStyle(FXStyle.valid);
                updateEmail = false;
            } else {
                valMsgEmail = "\nEmail Changed : " + oldEmployee.getEmail() + " To " + employee.getEmail();
                txtEmail.setStyle(FXStyle.updated);
                updateEmail = true;
            }
        } else {
            txtEmail.setStyle(FXStyle.invalid);
            valEmail = false;
            valMsgEmail = msgEmail;
            employee.setEmail(null);
        }
    }

    @FXML
    private void btnAddAP(ActionEvent event) {
        boolean validity
                = valName
                && valGender
                && valCivilstatus
                && valAddress
                && valDOB
                && valDesignation
                && valAssign
                && valMobile
                && valLand
                && valEmail;

        String messege
                = valMsgName
                + valMsgGender
                + valMsgCivilstatus
                + valMsgAddress
                + valMsgDOB
                + valMsgDesignation
                + valMsgAssign
                + valMsgMobile
                + valMsgLand
                + valMsgEmail;

        if (validity) {

            String data
                    = "Name : " + employee.getName()
                    + "\nGender : " + employee.getGenderId().getName()
                    + "\nCivil Status : " + employee.getCivilstatusId().getName()
                    + "\nAddress : " + employee.getAddress()
                    + "\nDate of Birth : " + employee.getDob().toString()
                    + "\nDesignation : " + employee.getDesignationId().getName()
                    + "\nAssign Date : " + employee.getAssign().toString()
                    + "\nMobile No : " + employee.getMobile()
                    + "\nLand No : " + employee.getLand()
                    + "\nEmail : " + employee.getEmail();

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you want add values ?");
            alert.setContentText(data);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                EmployeeDao.add(employee);
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
            alert.setContentText(messege);
            alert.showAndWait();

        }
    }

    @FXML
    private void btnUpdateAP(ActionEvent event) {
        boolean validity
                = valName
                && valGender
                && valCivilstatus
                && valAddress
                && valDOB
                && valDesignation
                && valAssign
                && valMobile
                && valLand
                && valEmail;

        String messege
                = valMsgName
                + valMsgGender
                + valMsgCivilstatus
                + valMsgAddress
                + valMsgDOB
                + valMsgDesignation
                + valMsgAssign
                + valMsgMobile
                + valMsgLand
                + valMsgEmail;

        if (!validity) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Contain Inavalid Data with following modifications");
            alert.setContentText(messege);
            alert.showAndWait();     
        } else {

            boolean update
                    = updateName
                    || updateAddress
                    || updateGender
                    || updateCivilstatus
                    || updateDOB
                    || updateMobile
                    || updateLand
                    || updateEmail
                    || updateDesignation
                    || updateAssign;

            if (update) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Update this Employee with following modifications?");
                    alert.setContentText(messege);
                    Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    EmployeeDao.update(employee);
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
                alert.setHeaderText("Nothing Chnaged.");
                alert.setContentText("Update relevent fields");
                alert.showAndWait();
            }
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
            EmployeeDao.delete(employee);
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
        clear();
    }    

    @FXML
    private void txtNameSearchKR(KeyEvent event) {
        fillTableEmployee(EmployeeDao.getAllByName(txtNameSearch.getText().trim()));
    }

    @FXML
    private void txtMobileSearchKR(KeyEvent event) {
        fillTableEmployee(EmployeeDao.getAllByMobile(txtMobileSearch.getText().trim()));
    }

    @FXML
    private void cmbGenderSearchAP(ActionEvent event) {
        if (cmbGenderSearch.getSelectionModel().getSelectedItem()!= null) {
            fillTableEmployee(EmployeeDao.getAllByGender((Gender)cmbGenderSearch.getSelectionModel().getSelectedItem()));
        }
    }

    @FXML
    private void cmbDesignationSearchAP(ActionEvent event) {
        if (cmbDesignationSearch.getSelectionModel().getSelectedItem()!= null) {
            fillTableEmployee(EmployeeDao.getAllByDesignation((Designation)cmbDesignationSearch.getSelectionModel().getSelectedItem()));
        }       
    }

    @FXML
    private void btnResetAP(ActionEvent event) {
        loadDefault();
    }

    @FXML
    private void btnSearchAP(ActionEvent event) {
    }

    @FXML
    private void tblEmployeeMC(MouseEvent event) {
        employee = tblEmployee.getSelectionModel().getSelectedItem();
        fillForm();
    }

    @FXML
    private void tblEmployeeKR(KeyEvent event) {
        employee = tblEmployee.getSelectionModel().getSelectedItem();
        fillForm();        
    }

}

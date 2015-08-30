package dao;

import entity.Designation;
import entity.Employee;
import entity.Gender;
import java.util.HashMap;
import javafx.collections.ObservableList;

public class EmployeeDao {

    /**
     * This method use to add employee
     * @param employee Employee Object
     */
    public static void add(Employee employee) {
        CommonDao.add(employee);
    }

    /**
     * This method use to get all employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAll() {
        return (ObservableList<Employee>) CommonDao.select("Employee.findAll");
    }

    /**
     * This method use to get all employees to given name
     * @param name Name of the employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAllByName(String name) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", name+"%");
        return (ObservableList<Employee>)CommonDao.select("Employee.findByName", hashMap);
    }

    /**
     * This method use to get all employees to given designation
     * @param designation Designation of the employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAllByDesignation(Designation designation) {
        HashMap hashMap = new HashMap();
        hashMap.put("designationId", designation);
        return (ObservableList<Employee>)CommonDao.select("Employee.findByDesignation", hashMap);       
    }

    /**
     * This method use to get employee to given id
     * @param id Id of the employee
     * @return Employee List
     */
    public static Employee getById(Integer id) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Employee)CommonDao.select("Employee.findById", hashMap).get(0);
    }

    /**
     * This method use to get all employees to given name and designation
     * @param name Name of the employee
     * @param designation Designation of the employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAllByNameAndDesignation(String name, Designation designation) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("designationId", designation);
        return (ObservableList<Employee>)CommonDao.select("Employee.findByDesignationAndName", hashMap);
    }
    
    /**
     * This method use to get all employees to given gender
     * @param gender Gender of the employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAllByGender(Gender gender) {
        HashMap hashMap = new HashMap();
        hashMap.put("genderId", gender);
        return (ObservableList<Employee>)CommonDao.select("Employee.findByGender", hashMap);
    }
    
    /**
     * This method use to get all employees to given mobile
     * @param mobile Mobile of the employee
     * @return Employee List
     */
    public static ObservableList<Employee> getAllByMobile(String mobile) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", mobile+"%");
        return (ObservableList<Employee>)CommonDao.select("Employee.findByMobile", hashMap);
    }     

    /**
     * This method use to update employee
     * @param employee Employee Object
     */
    public static void update(Employee employee) {
        CommonDao.update(employee);
    }

    /**
     * This method use to delete employee
     * @param employee Employee Object
     */
    public static void delete(Employee employee) {
        CommonDao.delete(employee);
    }


}

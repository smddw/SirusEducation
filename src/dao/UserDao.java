

package dao;

import entity.Employee;
import entity.Role;
import entity.User;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class UserDao {
    
    /**
     * This method use to add user
     * @param user user object
     */
    public static void add(User user){
        CommonDao.add(user);
    }
    
    /**
     * This method use to get all users
     * @return users list
     */
    public static ObservableList<User> getAll(){
        return (ObservableList<User>)CommonDao.select("User.findAll");
    }
    
    /**
     * This method use to get user to given id
     * @param id id of the user
     * @return user object
     */
    public static User getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (User)CommonDao.select("User.findById", hashMap).get(0);
    }
    
    /**
     * This method use to get user to given employee
     * @param employee employee of the user
     * @return user object
     */
    public static User getByEmployee(Employee employee){
        HashMap hashMap = new HashMap();
        hashMap.put("employeeId", employee);
        return (User)CommonDao.select("User.findByEmployee", hashMap).get(0);
    }
    
    /**
     * This method use to get user list to given username
     * @param username of the user
     * @return user list
     */
    public static ObservableList<User> getByUsername(String username){
        HashMap hashMap = new HashMap();
        hashMap.put("username", username+"%");
        return (ObservableList<User>)CommonDao.select("User.findByUsername", hashMap);
    }
    
    /**
     * This method use to get user list to given roles
     * @param role role name of the user
     * @return user list
     */
    public static ObservableList<User> getByRoles(Role role){
        HashMap hashMap = new HashMap();
        hashMap.put("role", role);
        return (ObservableList<User>)CommonDao.select("User.findByRole", hashMap);
    }
    
    /**
     * This method use to update user
     * @param user user object
     */
    public static void update(User user){
        CommonDao.update(user);
    }
    
    /**
     * This method use to delete user
     * @param user user object
     */
    public static void delete(User user){
        CommonDao.delete(user);
    }
    
}

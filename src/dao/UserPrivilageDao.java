

package dao;

import entity.Module;
import entity.Privilege;
import entity.Role;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class UserPrivilageDao {
    
    /**
     * This method use to add privilege
     * @param privilege privilege object
     */
    public static void add(Privilege privilege){
        CommonDao.add(privilege);
    }
    
    /**
     * This method use to get all privileges
     * @return privilege list
     */
    public static ObservableList<Privilege> getAll(){
        return (ObservableList<Privilege>)CommonDao.select("Privilege.findAll");
    }
    
    /**
     * This method use to get privilege to given id
     * @param id id of the privilege
     * @return privilege object
     */
    public static Privilege getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Privilege)CommonDao.select("Privilege.findById", hashMap).get(0);
    }
    
    /**
     * This method use to get privileges to given module
     * @param module module
     * @return privilege list
     */
    public static ObservableList<Privilege> getByModule(Module module){
        HashMap hashMap = new HashMap();
        hashMap.put("moduleId", module);
        return (ObservableList<Privilege>)CommonDao.select("Privilege.findByModule", hashMap);
    }
    
    /**
     * This method use to get privileges to given role
     * @param role role
     * @return privilege list
     */
    public static ObservableList<Privilege> getByRole(Role role){
        HashMap hashMap = new HashMap();
        hashMap.put("roleId", role);
        return (ObservableList<Privilege>)CommonDao.select("Privilege.findByRole", hashMap);
    }
    
    public static ObservableList<Module> getUnAssignedModulesByRole(Role role){
        ObservableList<Module> allModules = ModuleDao.getAll();
        ObservableList<Module> assignedModule = FXCollections.observableArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("roleId", role);
        ObservableList<Privilege> privileges = (ObservableList<Privilege>)CommonDao.select("Privilege.findByRole", hashMap);
        if (!privileges.isEmpty()) {
            for (Privilege privilege : privileges) {
                assignedModule.add(privilege.getModuleId());
            }
        }
        if (!assignedModule.isEmpty()) {
            for (Module module : assignedModule) {
                if (allModules.contains(module)) {
                    allModules.remove(module);
                }
            }
        }
        return allModules;
    }
    
    /**
     * This method use to update privilege
     * @param privilege privilege object
     */
    public static void update(Privilege privilege){
        CommonDao.update(privilege);
    }
    
    /**
     * This method use to delete privilege
     * @param privilege privilege object
     */
    public static void delete(Privilege privilege){
        CommonDao.delete(privilege);
    }
    
}

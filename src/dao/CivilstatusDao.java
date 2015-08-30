
package dao;

import entity.Civilstatus;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class CivilstatusDao {
    
    /**
     * This method use to get all civil statuses
     * @return Civil Status List
     */
    public static ObservableList<Civilstatus> getAll(){
        return (ObservableList<Civilstatus>)CommonDao.select("Civilstatus.findAll");
    } 
    
    /**
     * This method use to get civil status to given id
     * @param id Id of the civil status
     * @return Civil Status List
     */
    public static Civilstatus getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Civilstatus)CommonDao.select("Civilstatus.findById", hashMap).get(0);        
    }   
    
}

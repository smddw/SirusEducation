
package dao;

import entity.Designation;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class DesignationDao {
    
    /**
     * This method use to get all designation
     * @return Designation List
     */
    public static ObservableList<Designation> getAll(){
        return (ObservableList<Designation>)CommonDao.select("Designation.findAll");        
    }  
  
    /**
     * This method use to get designation to given id
     * @param id Id of the designation
     * @return Designation List
     */
    public static Designation getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Designation)CommonDao.select("Designation.findById", hashMap).get(0); 
    }
    
}


package dao;

import entity.Gender;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class GenderDao {
 
    /**
     * This method use to get all genders
     * @return Gender List
     */
    public static ObservableList<Gender> getAll(){
        return (ObservableList<Gender>)CommonDao.select("Gender.findAll");        
    }   
    
    /**
     * This method use to get gender to given id
     * @param id Id of the gender
     * @return Gender List
     */
    public static Gender getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Gender)CommonDao.select("Gender.findById", hashMap).get(0);         
    }   
   
}

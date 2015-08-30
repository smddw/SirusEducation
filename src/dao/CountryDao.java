

package dao;

import entity.Country;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class CountryDao {
    
    public static ObservableList<Country> getAll(){
        return (ObservableList<Country>)CommonDao.select("Country.findAll");
    }
    
    public static Country getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Country)CommonDao.select("Country.findById", hashMap).get(0);
    }
    
}

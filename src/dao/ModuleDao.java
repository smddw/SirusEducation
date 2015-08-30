

package dao;

import entity.Module;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class ModuleDao {
    
    public static ObservableList<Module> getAll(){
        return (ObservableList<Module>)CommonDao.select("Module.findAll");
    }
    
    public static Module getById(Integer id){
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Module)CommonDao.select("Module.findById", hashMap).get(0);
    }
    
}

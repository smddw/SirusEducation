
package dao;

import entity.Role;
import java.util.HashMap;
import javafx.collections.ObservableList;


public class RoleDao {

    public static ObservableList<Role> getAll() {
        return (ObservableList<Role>) CommonDao.select("Role.findAll");
    }

    public static Role getById(Integer id) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", id);
        return (Role) CommonDao.select("Role.findById", hashMap).get(0);
    }

}

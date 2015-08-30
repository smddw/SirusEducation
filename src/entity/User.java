/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import util.Security;

/**
 *
 * @author Lucifer-PC
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username like :username"),
    @NamedQuery(name = "User.findByEmployee", query = "SELECT u FROM User u WHERE u.employeeId = :employeeId"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u inner join u.roleList role WHERE role = :role"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @JoinTable(name = "userrole", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)    
    private List<Role> roleList;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @Fetch(value = FetchMode.SELECT)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Employee employeeId;
    @Transient
    private Role role;
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public boolean  setUsername(String username) {
        boolean validity = username.matches("[A-Za-z\\s]{2}[A-Za-z\\s]+");
        if (validity) {
            this.username = username;
        } else {
            this.username = null;
        }
        return validity;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        boolean validity = password.matches("\\d{3}");
        if (validity) {
            this.password = Security.getHash(password);
        } else {
            this.password = null;
        }
        return validity;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        return roleList;
    }

    public boolean setRoleList(List<Role> roleList) {
        boolean validity = roleList != null && !roleList.isEmpty();
        if (validity) {
            this.roleList = roleList;
        } else {
            this.roleList = null;
        }
        return validity;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public boolean setEmployeeId(Employee employeeId) {
        boolean validity = employeeId != null;
        if (validity) {
            this.employeeId = employeeId;
        } else {
            this.employeeId = null;
        }
        return validity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }
    
    public boolean validity() {

        return username != null
                && employeeId != null
                && password != null
                && roleList != null;
    }  
    
}

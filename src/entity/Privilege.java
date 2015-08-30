/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucifer-PC
 */
@Entity
@Table(name = "privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
    @NamedQuery(name = "Privilege.findById", query = "SELECT p FROM Privilege p WHERE p.id = :id"),
    @NamedQuery(name = "Privilege.findBySel", query = "SELECT p FROM Privilege p WHERE p.sel = :sel"),
    @NamedQuery(name = "Privilege.findByIns", query = "SELECT p FROM Privilege p WHERE p.ins = :ins"),
    @NamedQuery(name = "Privilege.findByUpd", query = "SELECT p FROM Privilege p WHERE p.upd = :upd"),
    @NamedQuery(name = "Privilege.findByModule", query = "SELECT p FROM Privilege p WHERE p.moduleId = :moduleId"),
    @NamedQuery(name = "Privilege.findByRole", query = "SELECT p FROM Privilege p WHERE p.roleId = :roleId"),
    @NamedQuery(name = "Privilege.findByDelete", query = "SELECT p FROM Privilege p WHERE p.del = :del")})
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sel")
    private String sel;
    @Column(name = "ins")
    private String ins;
    @Column(name = "upd")
    private String upd;
    @Column(name = "del")
    private String del;    
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role roleId;
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Module moduleId;

    public Privilege() {
    }

    public Privilege(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getUpd() {
        return upd;
    }

    public void setUpd(String upd) {
        this.upd = upd;
    }

    public String getDelete() {
        return del;
    }

    public void setDelete(String delete) {
        this.del = delete;
    }    

    public Role getRoleId() {
        return roleId;
    }

    public boolean setRoleId(Role roleId) {
        boolean validity = roleId != null;
        if (validity) {
            this.roleId = roleId;
        } else {
            this.roleId = null;
        }
        return validity;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public boolean setModuleId(Module moduleId) {
        boolean validity = moduleId != null;
        if (validity) {
            this.moduleId = moduleId;
        } else {
            this.moduleId = null;
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
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Privilege[ id=" + id + " ]";
    }
    
    public boolean validity() {

        return moduleId != null
                && roleId != null
                && (sel.equals("Yes") || ins.equals("Yes") || upd.equals("Yes") || del.equals("Yes"));
    }     
    
}

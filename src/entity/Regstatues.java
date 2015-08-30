/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author ionesoft
 */
@Entity
@Table(name = "regstatues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regstatues.findAll", query = "SELECT r FROM Regstatues r"),
    @NamedQuery(name = "Regstatues.findById", query = "SELECT r FROM Regstatues r WHERE r.id = :id")})
public class Regstatues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regstatuesId", fetch = FetchType.EAGER)
    private List<Courseregistration> courseregistrationList;

    public Regstatues() {
    }

    public Regstatues(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Courseregistration> getCourseregistrationList() {
        return courseregistrationList;
    }

    public void setCourseregistrationList(List<Courseregistration> courseregistrationList) {
        this.courseregistrationList = courseregistrationList;
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
        if (!(object instanceof Regstatues)) {
            return false;
        }
        Regstatues other = (Regstatues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Regstatues[ id=" + id + " ]";
    }
    
}

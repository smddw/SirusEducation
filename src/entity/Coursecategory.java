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
@Table(name = "coursecategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coursecategory.findAll", query = "SELECT c FROM Coursecategory c"),
    @NamedQuery(name = "Coursecategory.findById", query = "SELECT c FROM Coursecategory c WHERE c.id = :id"),
    @NamedQuery(name = "Coursecategory.findByName", query = "SELECT c FROM Coursecategory c WHERE c.name = :name")})
public class Coursecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coursecategoryId", fetch = FetchType.EAGER)
    private List<Course> courseList;

    public Coursecategory() {
    }

    public Coursecategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
        if (!(object instanceof Coursecategory)) {
            return false;
        }
        Coursecategory other = (Coursecategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Coursecategory[ id=" + id + " ]";
    }
    
}

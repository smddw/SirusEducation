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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "university")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findById", query = "SELECT u FROM University u WHERE u.id = :id"),
    @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name"),
    @NamedQuery(name = "University.findByAddress", query = "SELECT u FROM University u WHERE u.address = :address"),
    @NamedQuery(name = "University.findByLandno1", query = "SELECT u FROM University u WHERE u.landno1 = :landno1"),
    @NamedQuery(name = "University.findByLandno2", query = "SELECT u FROM University u WHERE u.landno2 = :landno2"),
    @NamedQuery(name = "University.findByFax", query = "SELECT u FROM University u WHERE u.fax = :fax"),
    @NamedQuery(name = "University.findByEmail", query = "SELECT u FROM University u WHERE u.email = :email"),
    @NamedQuery(name = "University.findByWeburl", query = "SELECT u FROM University u WHERE u.weburl = :weburl")})
public class University implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "landno1")
    private String landno1;
    @Column(name = "landno2")
    private String landno2;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "weburl")
    private String weburl;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Country countryId;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId", fetch = FetchType.EAGER)
    private List<Course> courseList;

    public University() {
    }

    public University(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandno1() {
        return landno1;
    }

    public void setLandno1(String landno1) {
        this.landno1 = landno1;
    }

    public String getLandno2() {
        return landno2;
    }

    public void setLandno2(String landno2) {
        this.landno2 = landno2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.University[ id=" + id + " ]";
    }
    
}

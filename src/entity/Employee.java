/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Lucifer-PC
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name like :name"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByDob", query = "SELECT e FROM Employee e WHERE e.dob = :dob"),
    @NamedQuery(name = "Employee.findByNic", query = "SELECT e FROM Employee e WHERE e.nic = :nic"),
    @NamedQuery(name = "Employee.findByMobile", query = "SELECT e FROM Employee e WHERE e.mobile like :mobile"),
    @NamedQuery(name = "Employee.findByLand", query = "SELECT e FROM Employee e WHERE e.land = :land"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByDesignation", query = "SELECT e FROM Employee e WHERE e.designationId = :designationId"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.genderId = :genderId"),
    @NamedQuery(name = "Employee.findByAssign", query = "SELECT e FROM Employee e WHERE e.assign = :assign")})
public class Employee implements Serializable {
    @Lob
    @Column(name = "image")
    private byte[] image;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "nic")
    private String nic;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "land")
    private String land;
    @Column(name = "email")
    private String email;
    @Column(name = "assign")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assign;
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gender genderId;
    @JoinColumn(name = "civilstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Civilstatus civilstatusId;
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Designation designationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<User> userList;

    public Employee() {
    }

    public Employee(Integer id) {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAssign() {
        return assign;
    }

    public void setAssign(Date assign) {
        this.assign = assign;
    }


    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Civilstatus getCivilstatusId() {
        return civilstatusId;
    }

    public void setCivilstatusId(Civilstatus civilstatusId) {
        this.civilstatusId = civilstatusId;
    }

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}

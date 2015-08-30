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
 * @author ionesoft
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByRegno", query = "SELECT s FROM Student s WHERE s.regno = :regno"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findByFullname", query = "SELECT s FROM Student s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "Student.findByNic", query = "SELECT s FROM Student s WHERE s.nic = :nic"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob"),
    @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"),
    @NamedQuery(name = "Student.findByMobile", query = "SELECT s FROM Student s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "Student.findByLandno", query = "SELECT s FROM Student s WHERE s.landno = :landno"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"),
    @NamedQuery(name = "Student.findByRegdate", query = "SELECT s FROM Student s WHERE s.regdate = :regdate"),
    @NamedQuery(name = "Student.findByApplydate", query = "SELECT s FROM Student s WHERE s.applydate = :applydate"),
    @NamedQuery(name = "Student.findByCeo", query = "SELECT s FROM Student s WHERE s.ceo = :ceo"),
    @NamedQuery(name = "Student.findByRemark", query = "SELECT s FROM Student s WHERE s.remark = :remark"),
    @NamedQuery(name = "Student.findByDescription", query = "SELECT s FROM Student s WHERE s.description = :description")})
public class Student implements Serializable {
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "civilstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Civilstatus civilstatusId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "regno")
    private String regno;
    @Column(name = "name")
    private String name;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "nic")
    private String nic;
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "address")
    private String address;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "landno")
    private String landno;
    @Column(name = "email")
    private String email;
    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @Column(name = "ceo")
    private Short ceo;
    @Column(name = "remark")
    private String remark;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Passport passportId;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Country countryId;
    @JoinColumn(name = "stustatues_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Stustatues stustatuesId;
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Gender genderId;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentid", fetch = FetchType.EAGER)
    private List<Courseregistration> courseregistrationList;

    public Student() {
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandno() {
        return landno;
    }

    public void setLandno(String landno) {
        this.landno = landno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }


    public Short getCeo() {
        return ceo;
    }

    public void setCeo(Short ceo) {
        this.ceo = ceo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Passport getPassportId() {
        return passportId;
    }

    public void setPassportId(Passport passportId) {
        this.passportId = passportId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Stustatues getStustatuesId() {
        return stustatuesId;
    }

    public void setStustatuesId(Stustatues stustatuesId) {
        this.stustatuesId = stustatuesId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Student[ id=" + id + " ]";
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Civilstatus getCivilstatusId() {
        return civilstatusId;
    }

    public void setCivilstatusId(Civilstatus civilstatusId) {
        this.civilstatusId = civilstatusId;
    }
    
}

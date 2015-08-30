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
@Table(name = "passport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p"),
    @NamedQuery(name = "Passport.findById", query = "SELECT p FROM Passport p WHERE p.id = :id"),
    @NamedQuery(name = "Passport.findByPassportno", query = "SELECT p FROM Passport p WHERE p.passportno = :passportno"),
    @NamedQuery(name = "Passport.findByIssuredate", query = "SELECT p FROM Passport p WHERE p.issuredate = :issuredate"),
    @NamedQuery(name = "Passport.findByExpriydate", query = "SELECT p FROM Passport p WHERE p.expriydate = :expriydate")})
public class Passport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "passportno")
    private String passportno;
    @Column(name = "issuredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issuredate;
    @Column(name = "expriydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expriydate;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(mappedBy = "passportId", fetch = FetchType.EAGER)
    private List<Student> studentList;

    public Passport() {
    }

    public Passport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public Date getIssuredate() {
        return issuredate;
    }

    public void setIssuredate(Date issuredate) {
        this.issuredate = issuredate;
    }

    public Date getExpriydate() {
        return expriydate;
    }

    public void setExpriydate(Date expriydate) {
        this.expriydate = expriydate;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
        if (!(object instanceof Passport)) {
            return false;
        }
        Passport other = (Passport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Passport[ id=" + id + " ]";
    }
    
}

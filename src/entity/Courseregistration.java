/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ionesoft
 */
@Entity
@Table(name = "courseregistration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courseregistration.findAll", query = "SELECT c FROM Courseregistration c"),
    @NamedQuery(name = "Courseregistration.findById", query = "SELECT c FROM Courseregistration c WHERE c.id = :id"),
    @NamedQuery(name = "Courseregistration.findByApplydate", query = "SELECT c FROM Courseregistration c WHERE c.applydate = :applydate")})
public class Courseregistration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "applydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydate;
    @JoinColumn(name = "Student_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Student studentid;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Course courseId;
    @JoinColumn(name = "regstatues_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Regstatues regstatuesId;

    public Courseregistration() {
    }

    public Courseregistration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Regstatues getRegstatuesId() {
        return regstatuesId;
    }

    public void setRegstatuesId(Regstatues regstatuesId) {
        this.regstatuesId = regstatuesId;
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
        if (!(object instanceof Courseregistration)) {
            return false;
        }
        Courseregistration other = (Courseregistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Courseregistration[ id=" + id + " ]";
    }
    
}

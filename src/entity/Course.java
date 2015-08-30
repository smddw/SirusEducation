/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByFee", query = "SELECT c FROM Course c WHERE c.fee = :fee"),
    @NamedQuery(name = "Course.findByEntryqualification", query = "SELECT c FROM Course c WHERE c.entryqualification = :entryqualification"),
    @NamedQuery(name = "Course.findByDuration", query = "SELECT c FROM Course c WHERE c.duration = :duration"),
    @NamedQuery(name = "Course.findByStartdate", query = "SELECT c FROM Course c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "Course.findByEnddate", query = "SELECT c FROM Course c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "Course.findByStatues", query = "SELECT c FROM Course c WHERE c.statues = :statues"),
    @NamedQuery(name = "Course.findByRemark", query = "SELECT c FROM Course c WHERE c.remark = :remark"),
    @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fee")
    private BigDecimal fee;
    @Column(name = "entryqualification")
    private String entryqualification;
    @Column(name = "duration")
    private String duration;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "statues")
    private String statues;
    @Column(name = "remark")
    private String remark;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "coursecategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coursecategory coursecategoryId;
    @JoinColumn(name = "coursetype_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coursetype coursetypeId;
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private University universityId;
    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.EAGER)
    private List<Courseregistration> courseregistrationList;

    public Course() {
    }

    public Course(Integer id) {
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getEntryqualification() {
        return entryqualification;
    }

    public void setEntryqualification(String entryqualification) {
        this.entryqualification = entryqualification;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
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

    public Coursecategory getCoursecategoryId() {
        return coursecategoryId;
    }

    public void setCoursecategoryId(Coursecategory coursecategoryId) {
        this.coursecategoryId = coursecategoryId;
    }

    public Coursetype getCoursetypeId() {
        return coursetypeId;
    }

    public void setCoursetypeId(Coursetype coursetypeId) {
        this.coursetypeId = coursetypeId;
    }

    public University getUniversityId() {
        return universityId;
    }

    public void setUniversityId(University universityId) {
        this.universityId = universityId;
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
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Course[ id=" + id + " ]";
    }
    
}

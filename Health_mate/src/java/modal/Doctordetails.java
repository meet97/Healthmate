/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author sonav
 */
@Entity
@Table(name = "doctordetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctordetails.findAll", query = "SELECT d FROM Doctordetails d")
    ,
    @NamedQuery(name = "Doctordetails.findByDoctorId", query = "SELECT d FROM Doctordetails d WHERE d.doctorId = :doctorId")
    ,
    @NamedQuery(name = "Doctordetails.findByFirstname", query = "SELECT d FROM Doctordetails d WHERE d.firstname = :firstname")
    ,
    @NamedQuery(name = "Doctordetails.findByMiddlename", query = "SELECT d FROM Doctordetails d WHERE d.middlename = :middlename")
    ,
    @NamedQuery(name = "Doctordetails.findByLastname", query = "SELECT d FROM Doctordetails d WHERE d.lastname = :lastname")
    ,
    @NamedQuery(name = "Doctordetails.findBySpeciality1", query = "SELECT d FROM Doctordetails d WHERE d.speciality1 = :speciality1")
    ,
    @NamedQuery(name = "Doctordetails.findBySpeciality2", query = "SELECT d FROM Doctordetails d WHERE d.speciality2 = :speciality2")
    ,
    @NamedQuery(name = "Doctordetails.findByMobile1", query = "SELECT d FROM Doctordetails d WHERE d.mobile1 = :mobile1")
    ,
    @NamedQuery(name = "Doctordetails.findByMobile2", query = "SELECT d FROM Doctordetails d WHERE d.mobile2 = :mobile2")
    ,
    @NamedQuery(name = "Doctordetails.findByFlag", query = "SELECT d FROM Doctordetails d WHERE d.flag = :flag")
    ,
    @NamedQuery(name = "Doctordetails.findByDateTime", query = "SELECT d FROM Doctordetails d WHERE d.dateTime = :dateTime")})
public class Doctordetails implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<Receptionistdetails> receptionistdetailsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    private Collection<Appointmentdetails> appointmentdetailsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "firstname")
    @Expose
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    @Expose
    private String lastname;
    @Column(name = "speciality1")
    @Expose
    private String speciality1;
    @Column(name = "speciality2")
    @Expose
    private String speciality2;
    @Column(name = "mobile1")
    private String mobile1;
    @Column(name = "mobile2")
    private String mobile2;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "hopital_id", referencedColumnName = "hospital_id")
    @ManyToOne
    private Hospitaldetails hopitalId;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne
    private Logindetails loginId;

    public Doctordetails() {
    }

    public Doctordetails(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpeciality1() {
        return speciality1;
    }

    public void setSpeciality1(String speciality1) {
        this.speciality1 = speciality1;
    }

    public String getSpeciality2() {
        return speciality2;
    }

    public void setSpeciality2(String speciality2) {
        this.speciality2 = speciality2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Hospitaldetails getHopitalId() {
        return hopitalId;
    }

    public void setHopitalId(Hospitaldetails hopitalId) {
        this.hopitalId = hopitalId;
    }

    public Logindetails getLoginId() {
        return loginId;
    }

    public void setLoginId(Logindetails loginId) {
        this.loginId = loginId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctordetails)) {
            return false;
        }
        Doctordetails other = (Doctordetails) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Doctordetails[ doctorId=" + doctorId + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Appointmentdetails> getAppointmentdetailsCollection() {
        return appointmentdetailsCollection;
    }

    public void setAppointmentdetailsCollection(Collection<Appointmentdetails> appointmentdetailsCollection) {
        this.appointmentdetailsCollection = appointmentdetailsCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Receptionistdetails> getReceptionistdetailsCollection() {
        return receptionistdetailsCollection;
    }

    public void setReceptionistdetailsCollection(Collection<Receptionistdetails> receptionistdetailsCollection) {
        this.receptionistdetailsCollection = receptionistdetailsCollection;
    }

}

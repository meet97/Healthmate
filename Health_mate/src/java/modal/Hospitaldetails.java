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
@Table(name = "hospitaldetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitaldetails.findAll", query = "SELECT h FROM Hospitaldetails h")
    ,
    @NamedQuery(name = "Hospitaldetails.findByHospitalId", query = "SELECT h FROM Hospitaldetails h WHERE h.hospitalId = :hospitalId")
    ,
    @NamedQuery(name = "Hospitaldetails.findByHospitalname", query = "SELECT h FROM Hospitaldetails h WHERE h.hospitalname = :hospitalname")
    ,
    @NamedQuery(name = "Hospitaldetails.findByMobile1", query = "SELECT h FROM Hospitaldetails h WHERE h.mobile1 = :mobile1")
    ,
    @NamedQuery(name = "Hospitaldetails.findByMobile2", query = "SELECT h FROM Hospitaldetails h WHERE h.mobile2 = :mobile2")
    ,
    @NamedQuery(name = "Hospitaldetails.findByEmailid1", query = "SELECT h FROM Hospitaldetails h WHERE h.emailid1 = :emailid1")
    ,
    @NamedQuery(name = "Hospitaldetails.findByEmailid2", query = "SELECT h FROM Hospitaldetails h WHERE h.emailid2 = :emailid2")
    ,
    @NamedQuery(name = "Hospitaldetails.findByFlag", query = "SELECT h FROM Hospitaldetails h WHERE h.flag = :flag")
    ,
    @NamedQuery(name = "Hospitaldetails.findByDateTime", query = "SELECT h FROM Hospitaldetails h WHERE h.dateTime = :dateTime")})
public class Hospitaldetails implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId")
    private Collection<Receptionistdetails> receptionistdetailsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId")
    private Collection<Appointmentdetails> appointmentdetailsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "hospital_id")
    private Integer hospitalId;
    @Basic(optional = false)
    @Column(name = "hospitalname")
    @Expose
    private String hospitalname;
    @Column(name = "mobile1")
    private String mobile1;
    @Column(name = "mobile2")
    private String mobile2;
    @Column(name = "emailid1")
    private String emailid1;
    @Column(name = "emailid2")
    private String emailid2;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne
    private Locationdetails locationId;
    @OneToMany(mappedBy = "hopitalId")
    private Collection<Doctordetails> doctordetailsCollection;

    public Hospitaldetails() {
    }

    public Hospitaldetails(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Hospitaldetails(Integer hospitalId, String hospitalname) {
        this.hospitalId = hospitalId;
        this.hospitalname = hospitalname;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
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

    public String getEmailid1() {
        return emailid1;
    }

    public void setEmailid1(String emailid1) {
        this.emailid1 = emailid1;
    }

    public String getEmailid2() {
        return emailid2;
    }

    public void setEmailid2(String emailid2) {
        this.emailid2 = emailid2;
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

    public Locationdetails getLocationId() {
        return locationId;
    }

    public void setLocationId(Locationdetails locationId) {
        this.locationId = locationId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Doctordetails> getDoctordetailsCollection() {
        return doctordetailsCollection;
    }

    public void setDoctordetailsCollection(Collection<Doctordetails> doctordetailsCollection) {
        this.doctordetailsCollection = doctordetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospitalId != null ? hospitalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitaldetails)) {
            return false;
        }
        Hospitaldetails other = (Hospitaldetails) object;
        if ((this.hospitalId == null && other.hospitalId != null) || (this.hospitalId != null && !this.hospitalId.equals(other.hospitalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Hospitaldetails[ hospitalId=" + hospitalId + " ]";
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

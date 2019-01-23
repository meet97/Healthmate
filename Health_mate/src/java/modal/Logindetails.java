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
@Table(name = "logindetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logindetails.findAll", query = "SELECT l FROM Logindetails l")
    ,
    @NamedQuery(name = "Logindetails.findByLoginId", query = "SELECT l FROM Logindetails l WHERE l.loginId = :loginId")
    ,
    @NamedQuery(name = "Logindetails.findByEmailid", query = "SELECT l FROM Logindetails l WHERE l.emailid = :emailid")
    ,
    @NamedQuery(name = "Logindetails.findByPassword", query = "SELECT l FROM Logindetails l WHERE l.password = :password")
    ,
    @NamedQuery(name = "Logindetails.findByRole", query = "SELECT l FROM Logindetails l WHERE l.role = :role")
    ,
    @NamedQuery(name = "Logindetails.findByFlag", query = "SELECT l FROM Logindetails l WHERE l.flag = :flag")
    ,
    @NamedQuery(name = "Logindetails.findByDateTime", query = "SELECT l FROM Logindetails l WHERE l.dateTime = :dateTime")})
public class Logindetails implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId")
    private Collection<Receptionistdetails> receptionistdetailsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId")
    private Collection<Appointmentdetails> appointmentdetailsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "login_id")
    private Integer loginId;
    @Basic(optional = false)
    @Column(name = "emailid")
    @Expose
    private String emailid;
    @Basic(optional = false)
    @Column(name = "password")
    @Expose
    private String password;
    @Basic(optional = false)
    @Column(name = "role")
    @Expose
    private String role;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @OneToMany(mappedBy = "loginId")
    @Expose
    private Collection<Userdetails> userdetailsCollection;
    @OneToMany(mappedBy = "loginId")
    private Collection<Doctordetails> doctordetailsCollection;

    public Logindetails() {
    }

    public Logindetails(Integer loginId) {
        this.loginId = loginId;
    }

    public Logindetails(Integer loginId, String emailid, String password, String role) {
        this.loginId = loginId;
        this.emailid = emailid;
        this.password = password;
        this.role = role;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @XmlTransient
    @JsonIgnore
    public Collection<Userdetails> getUserdetailsCollection() {
        return userdetailsCollection;
    }

    public void setUserdetailsCollection(Collection<Userdetails> userdetailsCollection) {
        this.userdetailsCollection = userdetailsCollection;
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
        hash += (loginId != null ? loginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logindetails)) {
            return false;
        }
        Logindetails other = (Logindetails) object;
        if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Logindetails[ loginId=" + loginId + " ]";
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

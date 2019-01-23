/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * @author admin
 */
@Entity
@Table(name = "appointmentdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointmentdetails.findAll", query = "SELECT a FROM Appointmentdetails a")
    , @NamedQuery(name = "Appointmentdetails.findByAppointmentId", query = "SELECT a FROM Appointmentdetails a WHERE a.appointmentId = :appointmentId")
    , @NamedQuery(name = "Appointmentdetails.findByDate", query = "SELECT a FROM Appointmentdetails a WHERE a.date = :date")
    , @NamedQuery(name = "Appointmentdetails.findByTime", query = "SELECT a FROM Appointmentdetails a WHERE a.time = :time")
    , @NamedQuery(name = "Appointmentdetails.findByFlag", query = "SELECT a FROM Appointmentdetails a WHERE a.flag = :flag")
    , @NamedQuery(name = "Appointmentdetails.findByDateTime", query = "SELECT a FROM Appointmentdetails a WHERE a.dateTime = :dateTime")})
public class Appointmentdetails implements Serializable {

    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false)
    @Expose
    private Doctordetails doctorId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @ManyToOne(optional = false)
    @Expose
    private Hospitaldetails hospitalId;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    @Expose
    private Logindetails loginId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "appointment_id")
    private Integer appointmentId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @Expose
    private Date date;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    @Expose
    private Date time;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    public Appointmentdetails() {
    }

    public Appointmentdetails(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Appointmentdetails(Integer appointmentId, Date date, Date time) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentId != null ? appointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointmentdetails)) {
            return false;
        }
        Appointmentdetails other = (Appointmentdetails) object;
        if ((this.appointmentId == null && other.appointmentId != null) || (this.appointmentId != null && !this.appointmentId.equals(other.appointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Appointmentdetails[ appointmentId=" + appointmentId + " ]";
    }

    public Doctordetails getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctordetails doctorId) {
        this.doctorId = doctorId;
    }

    public Hospitaldetails getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospitaldetails hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Logindetails getLoginId() {
        return loginId;
    }

    public void setLoginId(Logindetails loginId) {
        this.loginId = loginId;
    }

}

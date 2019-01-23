/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "receptionistdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receptionistdetails.findAll", query = "SELECT r FROM Receptionistdetails r")
    , @NamedQuery(name = "Receptionistdetails.findByReceptionistId", query = "SELECT r FROM Receptionistdetails r WHERE r.receptionistId = :receptionistId")
    , @NamedQuery(name = "Receptionistdetails.findByFirstname", query = "SELECT r FROM Receptionistdetails r WHERE r.firstname = :firstname")
    , @NamedQuery(name = "Receptionistdetails.findByLastname", query = "SELECT r FROM Receptionistdetails r WHERE r.lastname = :lastname")})
public class Receptionistdetails implements Serializable {

    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false)
    private Doctordetails doctorId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    @ManyToOne(optional = false)
    private Hospitaldetails hospitalId;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne(optional = false)
    private Logindetails loginId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "receptionist_id")
    private Integer receptionistId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    public Receptionistdetails() {
    }

    public Receptionistdetails(Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    public Integer getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Integer receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receptionistId != null ? receptionistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receptionistdetails)) {
            return false;
        }
        Receptionistdetails other = (Receptionistdetails) object;
        if ((this.receptionistId == null && other.receptionistId != null) || (this.receptionistId != null && !this.receptionistId.equals(other.receptionistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Receptionistdetails[ receptionistId=" + receptionistId + " ]";
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

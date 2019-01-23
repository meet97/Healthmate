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
 * @author sonav
 */
@Entity
@Table(name = "userdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM Userdetails u")
    ,
    @NamedQuery(name = "Userdetails.findByUserId", query = "SELECT u FROM Userdetails u WHERE u.userId = :userId")
    ,
    @NamedQuery(name = "Userdetails.findByFirstname", query = "SELECT u FROM Userdetails u WHERE u.firstname = :firstname")
    ,
    @NamedQuery(name = "Userdetails.findByMiddlename", query = "SELECT u FROM Userdetails u WHERE u.middlename = :middlename")
    ,
    @NamedQuery(name = "Userdetails.findByLastname", query = "SELECT u FROM Userdetails u WHERE u.lastname = :lastname")
    ,
    @NamedQuery(name = "Userdetails.findByMobile", query = "SELECT u FROM Userdetails u WHERE u.mobile = :mobile")
    ,
    @NamedQuery(name = "Userdetails.findByFlag", query = "SELECT u FROM Userdetails u WHERE u.flag = :flag")
    ,
    @NamedQuery(name = "Userdetails.findByDateTime", query = "SELECT u FROM Userdetails u WHERE u.dateTime = :dateTime")})
public class Userdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "firstname")
    @Expose
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    @Expose
    private String lastname;
    @Basic(optional = false)
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne
    private Locationdetails locationId;
    @JoinColumn(name = "login_id", referencedColumnName = "login_id")
    @ManyToOne
    private Logindetails loginId;

    public Userdetails() {
    }

    public Userdetails(Integer userId) {
        this.userId = userId;
    }

    public Userdetails(Integer userId, String firstname, String mobile) {
        this.userId = userId;
        this.firstname = firstname;
        this.mobile = mobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Logindetails getLoginId() {
        return loginId;
    }

    public void setLoginId(Logindetails loginId) {
        this.loginId = loginId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Userdetails[ userId=" + userId + " ]";
    }

}

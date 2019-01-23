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
@Table(name = "locationdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locationdetails.findAll", query = "SELECT l FROM Locationdetails l")
    ,
    @NamedQuery(name = "Locationdetails.findByLocationId", query = "SELECT l FROM Locationdetails l WHERE l.locationId = :locationId")
    ,
    @NamedQuery(name = "Locationdetails.findByAddress", query = "SELECT l FROM Locationdetails l WHERE l.address = :address")
    ,
    @NamedQuery(name = "Locationdetails.findByArea", query = "SELECT l FROM Locationdetails l WHERE l.area = :area")
    ,
    @NamedQuery(name = "Locationdetails.findByCity", query = "SELECT l FROM Locationdetails l WHERE l.city = :city")
    ,
    @NamedQuery(name = "Locationdetails.findByState", query = "SELECT l FROM Locationdetails l WHERE l.state = :state")
    ,
    @NamedQuery(name = "Locationdetails.findByCountry", query = "SELECT l FROM Locationdetails l WHERE l.country = :country")
    ,
    @NamedQuery(name = "Locationdetails.findByPincode", query = "SELECT l FROM Locationdetails l WHERE l.pincode = :pincode")
    ,
    @NamedQuery(name = "Locationdetails.findByFlag", query = "SELECT l FROM Locationdetails l WHERE l.flag = :flag")
    ,
    @NamedQuery(name = "Locationdetails.findByDateTime", query = "SELECT l FROM Locationdetails l WHERE l.dateTime = :dateTime")})
public class Locationdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "address")
    private String address;
    @Column(name = "area")
    @Expose
    private String area;
    @Column(name = "city")
    @Expose
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "flag")
    private Boolean flag;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @OneToMany(mappedBy = "locationId")
    private Collection<Hospitaldetails> hospitaldetailsCollection;
    @OneToMany(mappedBy = "locationId")
    private Collection<Userdetails> userdetailsCollection;

    public Locationdetails() {
    }

    public Locationdetails(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
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
    public Collection<Hospitaldetails> getHospitaldetailsCollection() {
        return hospitaldetailsCollection;
    }

    public void setHospitaldetailsCollection(Collection<Hospitaldetails> hospitaldetailsCollection) {
        this.hospitaldetailsCollection = hospitaldetailsCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Userdetails> getUserdetailsCollection() {
        return userdetailsCollection;
    }

    public void setUserdetailsCollection(Collection<Userdetails> userdetailsCollection) {
        this.userdetailsCollection = userdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locationdetails)) {
            return false;
        }
        Locationdetails other = (Locationdetails) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modal.Locationdetails[ locationId=" + locationId + " ]";
    }

}


package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServiceID", query = "SELECT s FROM Services s WHERE s.serviceID = :serviceID"),
    @NamedQuery(name = "Services.findByServiceName", query = "SELECT s FROM Services s WHERE s.serviceName = :serviceName"),
    @NamedQuery(name = "Services.findByServiceDescription", query = "SELECT s FROM Services s WHERE s.serviceDescription = :serviceDescription"),
    @NamedQuery(name = "Services.findByStatus", query = "SELECT s FROM Services s WHERE s.status = :status"),
    @NamedQuery(name = "Services.findByServicePrice", query = "SELECT s FROM Services s WHERE s.servicePrice = :servicePrice")})
public class Services implements Serializable {
    @Size(max = 300)
    @Column(name = "Image")
    private String image;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID")
    private Integer serviceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ServiceName")
    private String serviceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "ServiceDescription")
    private String serviceDescription;
    @Column(name = "Status")
    private Boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ServicePrice")
    private BigDecimal servicePrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceID")
    private Collection<BillDetails> billDetailsCollection;
    @JoinColumn(name = "DomainID", referencedColumnName = "DomainID")
    @ManyToOne(optional = false)
    private Domains domainID;

    public Services() {
    }

    public Services(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public Services(Integer serviceID, String serviceName, String serviceDescription, BigDecimal servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    @XmlTransient
    public Collection<BillDetails> getBillDetailsCollection() {
        return billDetailsCollection;
    }

    public void setBillDetailsCollection(Collection<BillDetails> billDetailsCollection) {
        this.billDetailsCollection = billDetailsCollection;
    }

    public Domains getDomainID() {
        return domainID;
    }

    public void setDomainID(Domains domainID) {
        this.domainID = domainID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceID != null ? serviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        return (this.serviceID != null || other.serviceID == null) && (this.serviceID == null || this.serviceID.equals(other.serviceID));
    }

    @Override
    public String toString() {
        return "entities.Services[ serviceID=" + serviceID + " ]";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}

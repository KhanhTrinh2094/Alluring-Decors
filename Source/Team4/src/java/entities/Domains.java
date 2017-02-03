
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Domains")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domains.findAll", query = "SELECT d FROM Domains d"),
    @NamedQuery(name = "Domains.findByDomainID", query = "SELECT d FROM Domains d WHERE d.domainID = :domainID"),
    @NamedQuery(name = "Domains.findByDomainName", query = "SELECT d FROM Domains d WHERE d.domainName = :domainName"),
    @NamedQuery(name = "Domains.findByDomainDescription", query = "SELECT d FROM Domains d WHERE d.domainDescription = :domainDescription"),
    @NamedQuery(name = "Domains.findByStatus", query = "SELECT d FROM Domains d WHERE d.status = :status")})
public class Domains implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DomainID")
    private Integer domainID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DomainName")
    private String domainName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "DomainDescription")
    private String domainDescription;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domainID")
    private Collection<Services> servicesCollection;

    public Domains() {
    }

    public Domains(Integer domainID) {
        this.domainID = domainID;
    }

    public Domains(Integer domainID, String domainName, String domainDescription) {
        this.domainID = domainID;
        this.domainName = domainName;
        this.domainDescription = domainDescription;
    }

    public Integer getDomainID() {
        return domainID;
    }

    public void setDomainID(Integer domainID) {
        this.domainID = domainID;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainDescription() {
        return domainDescription;
    }

    public void setDomainDescription(String domainDescription) {
        this.domainDescription = domainDescription;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Services> getServicesCollection() {
        return servicesCollection;
    }

    public void setServicesCollection(Collection<Services> servicesCollection) {
        this.servicesCollection = servicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domainID != null ? domainID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Domains)) {
            return false;
        }
        Domains other = (Domains) object;
        return (this.domainID != null || other.domainID == null) && (this.domainID == null || this.domainID.equals(other.domainID));
    }

    @Override
    public String toString() {
        return domainName;
    }
    
}

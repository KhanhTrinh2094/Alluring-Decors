
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BillDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetails.findAll", query = "SELECT b FROM BillDetails b"),
    @NamedQuery(name = "BillDetails.findByDetailID", query = "SELECT b FROM BillDetails b WHERE b.detailID = :detailID"),
    @NamedQuery(name = "BillDetails.findByQuantity", query = "SELECT b FROM BillDetails b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "BillDetails.findByPrice", query = "SELECT b FROM BillDetails b WHERE b.price = :price"),
    @NamedQuery(name = "BillDetails.findByStatus", query = "SELECT b FROM BillDetails b WHERE b.status = :status")})
public class BillDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetailID")
    private Integer detailID;
    @Column(name = "Quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "Status")
    private Short status;
    @JoinColumn(name = "ServiceID", referencedColumnName = "ServiceID")
    @ManyToOne(optional = false)
    private Services serviceID;
    @JoinColumn(name = "BillID", referencedColumnName = "BillID")
    @ManyToOne(optional = false)
    private Bills billID;

    public BillDetails() {
    }

    public BillDetails(Integer detailID) {
        this.detailID = detailID;
    }

    public Integer getDetailID() {
        return detailID;
    }

    public void setDetailID(Integer detailID) {
        this.detailID = detailID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Services getServiceID() {
        return serviceID;
    }

    public void setServiceID(Services serviceID) {
        this.serviceID = serviceID;
    }

    public Bills getBillID() {
        return billID;
    }

    public void setBillID(Bills billID) {
        this.billID = billID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailID != null ? detailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BillDetails)) {
            return false;
        }
        BillDetails other = (BillDetails) object;
        return (this.detailID != null || other.detailID == null) && (this.detailID == null || this.detailID.equals(other.detailID));
    }

    @Override
    public String toString() {
        return "entities.BillDetails[ detailID=" + detailID + " ]";
    }
    
}

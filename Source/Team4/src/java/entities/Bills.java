
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Bills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b"),
    @NamedQuery(name = "Bills.findByBillID", query = "SELECT b FROM Bills b WHERE b.billID = :billID"),
    @NamedQuery(name = "Bills.findByTotalPrice", query = "SELECT b FROM Bills b WHERE b.totalPrice = :totalPrice"),
    @NamedQuery(name = "Bills.findByRecipientName", query = "SELECT b FROM Bills b WHERE b.recipientName = :recipientName"),
    @NamedQuery(name = "Bills.findByRecipientAddress", query = "SELECT b FROM Bills b WHERE b.recipientAddress = :recipientAddress"),
    @NamedQuery(name = "Bills.findByOrderTime", query = "SELECT b FROM Bills b WHERE b.orderTime = :orderTime"),
    @NamedQuery(name = "Bills.findByContactNumber", query = "SELECT b FROM Bills b WHERE b.contactNumber = :contactNumber"),
    @NamedQuery(name = "Bills.findByNote", query = "SELECT b FROM Bills b WHERE b.note = :note"),
    @NamedQuery(name = "Bills.findByOrderStatus", query = "SELECT b FROM Bills b WHERE b.orderStatus = :orderStatus")})
public class Bills implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BillID")
    private Integer billID;
    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;
    @Size(max = 60)
    @Column(name = "RecipientName")
    private String recipientName;
    @Size(max = 150)
    @Column(name = "RecipientAddress")
    private String recipientAddress;
    @Column(name = "OrderTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
    @Size(max = 11)
    @Column(name = "ContactNumber")
    private String contactNumber;
    @Size(max = 1073741823)
    @Column(name = "Note")
    private String note;
    @Column(name = "OrderStatus")
    private Short orderStatus;
    @OneToMany(mappedBy = "billID")
    private Collection<Projects> projectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billID")
    private Collection<BillDetails> billDetailsCollection;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Bills() {
    }

    public Bills(Integer billID) {
        this.billID = billID;
    }

    public Integer getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Short orderStatus) {
        this.orderStatus = orderStatus;
    }

    @XmlTransient
    public Collection<Projects> getProjectsCollection() {
        return projectsCollection;
    }

    public void setProjectsCollection(Collection<Projects> projectsCollection) {
        this.projectsCollection = projectsCollection;
    }

    @XmlTransient
    public Collection<BillDetails> getBillDetailsCollection() {
        return billDetailsCollection;
    }

    public void setBillDetailsCollection(Collection<BillDetails> billDetailsCollection) {
        this.billDetailsCollection = billDetailsCollection;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billID != null ? billID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        return (this.billID != null || other.billID == null) && (this.billID == null || this.billID.equals(other.billID));
    }

    @Override
    public String toString() {
        return "entities.Bills[ billID=" + billID + " ]";
    }
    
}

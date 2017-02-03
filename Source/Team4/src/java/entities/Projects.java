
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
@Table(name = "Projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findByProjectID", query = "SELECT p FROM Projects p WHERE p.projectID = :projectID"),
    @NamedQuery(name = "Projects.findByProjectName", query = "SELECT p FROM Projects p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "Projects.findByStartDate", query = "SELECT p FROM Projects p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Projects.findByProjectDetail", query = "SELECT p FROM Projects p WHERE p.projectDetail = :projectDetail"),
    @NamedQuery(name = "Projects.findByStatus", query = "SELECT p FROM Projects p WHERE p.status = :status"),
    @NamedQuery(name = "Projects.findByThumbImage", query = "SELECT p FROM Projects p WHERE p.thumbImage = :thumbImage"),
    @NamedQuery(name = "Projects.findByProjectPrice", query = "SELECT p FROM Projects p WHERE p.projectPrice = :projectPrice"),
    @NamedQuery(name = "Projects.findByDeliveryDate", query = "SELECT p FROM Projects p WHERE p.deliveryDate = :deliveryDate")})
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectID")
    private Integer projectID;
    @Size(max = 100)
    @Column(name = "ProjectName")
    private String projectName;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Size(max = 1073741823)
    @Column(name = "ProjectDetail")
    private String projectDetail;
    @Column(name = "Status")
    private Short status;
    @Size(max = 100)
    @Column(name = "ThumbImage")
    private String thumbImage;
    @Column(name = "ProjectPrice")
    private BigDecimal projectPrice;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;
    @JoinColumn(name = "BillID", referencedColumnName = "BillID")
    @ManyToOne
    private Bills billID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectID")
    private Collection<Images> imagesCollection;

    public Projects() {
    }

    public Projects(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public BigDecimal getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(BigDecimal projectPrice) {
        this.projectPrice = projectPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Bills getBillID() {
        return billID;
    }

    public void setBillID(Bills billID) {
        this.billID = billID;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectID != null ? projectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        return (this.projectID != null || other.projectID == null) && (this.projectID == null || this.projectID.equals(other.projectID));
    }

    @Override
    public String toString() {
        return "entities.Projects[ projectID=" + projectID + " ]";
    }
    
}


package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Feedbacks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedbacks.findAll", query = "SELECT f FROM Feedbacks f"),
    @NamedQuery(name = "Feedbacks.findByFeedbackID", query = "SELECT f FROM Feedbacks f WHERE f.feedbackID = :feedbackID"),
    @NamedQuery(name = "Feedbacks.findByFullname", query = "SELECT f FROM Feedbacks f WHERE f.fullname = :fullname"),
    @NamedQuery(name = "Feedbacks.findByEmail", query = "SELECT f FROM Feedbacks f WHERE f.email = :email"),
    @NamedQuery(name = "Feedbacks.findByDetail", query = "SELECT f FROM Feedbacks f WHERE f.detail = :detail"),
    @NamedQuery(name = "Feedbacks.findByStatus", query = "SELECT f FROM Feedbacks f WHERE f.status = :status")})
public class Feedbacks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeedbackID")
    private Integer feedbackID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Fullname")
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1073741823)
    @Column(name = "Detail")
    private String detail;
    @Column(name = "Status")
    private Boolean status;

    public Feedbacks() {
    }

    public Feedbacks(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Feedbacks(Integer feedbackID, String fullname, String email, String detail) {
        this.feedbackID = feedbackID;
        this.fullname = fullname;
        this.email = email;
        this.detail = detail;
    }

    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Feedbacks)) {
            return false;
        }
        Feedbacks other = (Feedbacks) object;
        return (this.feedbackID != null || other.feedbackID == null) && (this.feedbackID == null || this.feedbackID.equals(other.feedbackID));
    }

    @Override
    public String toString() {
        return "entities.Feedbacks[ feedbackID=" + feedbackID + " ]";
    }
    
}

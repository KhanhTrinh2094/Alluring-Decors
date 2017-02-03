
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findByImageID", query = "SELECT i FROM Images i WHERE i.imageID = :imageID"),
    @NamedQuery(name = "Images.findByImageTitle", query = "SELECT i FROM Images i WHERE i.imageTitle = :imageTitle"),
    @NamedQuery(name = "Images.findByImageUrl", query = "SELECT i FROM Images i WHERE i.imageUrl = :imageUrl")})
public class Images implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageID")
    private Integer imageID;
    @Size(max = 100)
    @Column(name = "ImageTitle")
    private String imageTitle;
    @Size(max = 200)
    @Column(name = "ImageUrl")
    private String imageUrl;
    @JoinColumn(name = "ProjectID", referencedColumnName = "ProjectID")
    @ManyToOne(optional = false)
    private Projects projectID;

    public Images() {
    }

    public Images(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Projects getProjectID() {
        return projectID;
    }

    public void setProjectID(Projects projectID) {
        this.projectID = projectID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        return (this.imageID != null || other.imageID == null) && (this.imageID == null || this.imageID.equals(other.imageID));
    }

    @Override
    public String toString() {
        return "entities.Images[ imageID=" + imageID + " ]";
    }
    
}


package bean;

import entities.Images;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ImagesFacade extends AbstractFacade<Images> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagesFacade() {
        super(Images.class);
    }
    
    public void delete(int projectID){
        Query q = em.createQuery("DELETE FROM Images a WHERE a.projectID.projectID = :projectID");
        q.setParameter("projectID", projectID);
        q.executeUpdate();
    }
    
}

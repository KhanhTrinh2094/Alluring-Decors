
package bean;

import entities.BillDetails;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BillDetailsFacade extends AbstractFacade<BillDetails> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillDetailsFacade() {
        super(BillDetails.class);
    }
    
    public List<BillDetails> getDetails(int billID){
        Query q = em.createQuery("SELECT a FROM BillDetails a WHERE a.billID.billID = :billID");
        q.setParameter("billID", billID);
        return q.getResultList();
    }
}

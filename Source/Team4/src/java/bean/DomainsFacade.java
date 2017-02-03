
package bean;

import entities.Domains;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DomainsFacade extends AbstractFacade<Domains> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomainsFacade() {
        super(Domains.class);
    }
    
    public List<Domains> findAll_US(){
        Query q = em.createQuery("SELECT a From Domains a WHERE a.status = 1");
        return q.getResultList();
    }
    
}

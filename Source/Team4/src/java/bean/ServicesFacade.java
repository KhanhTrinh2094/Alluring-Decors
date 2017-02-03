package bean;

import entities.Services;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ServicesFacade extends AbstractFacade<Services> {

    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicesFacade() {
        super(Services.class);
    }

    public List<Services> findAllIndex() {
        Query q = em.createQuery("SELECT a FROM Services a WHERE a.status = 1 order by a.serviceID desc");
        q.setMaxResults(8);
        return q.getResultList();
    }

    public List<Services> findRand(int randCount) {
        Query countQuery = em.createQuery("SELECT count(a) FROM Services a WHERE a.status = 1");
        long count = (Long) countQuery.getSingleResult();
        
        Random random = new Random();
        int number = random.nextInt((int) count);
        
        Query q = em.createQuery("SELECT a FROM Services a WHERE a.status = 1");
        q.setFirstResult(number);
        q.setMaxResults(randCount);
        return q.getResultList();
    }
    
    public List<Services> search(String name) {
        Query q = em.createQuery("SELECT a FROM Services a WHERE a.status = 1 AND a.serviceName LIKE :name order by a.serviceID desc");
        q.setParameter("name", "%" + name + "%");
        return q.getResultList();
    }

}

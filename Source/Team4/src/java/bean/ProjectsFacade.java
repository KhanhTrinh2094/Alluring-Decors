
package bean;

import entities.Projects;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProjectsFacade extends AbstractFacade<Projects> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectsFacade() {
        super(Projects.class);
    }
    
    public int createProjects(Projects project){
        getEntityManager().persist(project);
        getEntityManager().flush();
        getEntityManager().refresh(project);
        return project.getProjectID();
    }
    
    public List<Projects> findRand(int randCount) {
        Query countQuery = em.createQuery("SELECT count(a) FROM Projects a");
        long count = (Long) countQuery.getSingleResult();
        
        Random random = new Random();
        int number = random.nextInt((int) count);
        
        Query q = em.createQuery("SELECT a FROM Projects a");
        q.setFirstResult(number);
        q.setMaxResults(randCount);
        return q.getResultList();
    }
    
    public List<Projects> getListOnGoing(){
        Query q = em.createQuery("SELECT a FROM Projects a WHERE a.status = 0");
        return q.getResultList();
    }
    
    public List<Projects> getListUpComing(){
        Query q = em.createQuery("SELECT a FROM Projects a WHERE a.status = 1");
        return q.getResultList();
    }
    
    public List<Projects> getListAccomplished(){
        Query q = em.createQuery("SELECT a FROM Projects a WHERE a.status = 2");
        return q.getResultList();
    }
    
}

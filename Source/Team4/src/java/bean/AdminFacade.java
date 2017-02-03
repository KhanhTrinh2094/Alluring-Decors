
package bean;

import entities.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AdminFacade extends AbstractFacade<Admin> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    public boolean login(String username, String password){
        Query q = em.createQuery("SELECT COUNT(a) FROM Admin a WHERE a.username = :username AND a.password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return (long) q.getSingleResult() > 0;
    }
    
    public boolean changepass(String userName, String newPass){
        Query q = em.createQuery("UPDATE Admin a SET a.password = :password WHERE a.username = :username");
        q.setParameter("password", newPass);
        q.setParameter("username", userName);
        return q.executeUpdate() > 0;
    }
    
}

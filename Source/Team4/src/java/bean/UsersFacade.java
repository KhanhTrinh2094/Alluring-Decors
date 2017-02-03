
package bean;

import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public boolean login(String username, String password){
        Query q = em.createQuery("SELECT COUNT(a) FROM Users a WHERE a.username = :username AND a.password = :password AND a.status = 1");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return (long) q.getSingleResult() > 0;
    }
    
    public Users getUser(String username){
        Query q = em.createQuery("SELECT a FROM Users a WHERE a.username = :username");
        q.setParameter("username", username);
        return (Users) q.getSingleResult();
    }
    
    public boolean changepass(String userName, String newPass){
        Query q = em.createQuery("UPDATE Users a SET a.password = :password WHERE a.username = :username");
        q.setParameter("password", newPass);
        q.setParameter("username", userName);
        return q.executeUpdate() > 0;
    }
    
}

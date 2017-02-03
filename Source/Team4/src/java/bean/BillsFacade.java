package bean;

import entities.Bills;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BillsFacade extends AbstractFacade<Bills> {

    @PersistenceContext(unitName = "Team4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillsFacade() {
        super(Bills.class);
    }

    public int createBills(Bills entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        getEntityManager().refresh(entity);
        return entity.getBillID();
    }

}

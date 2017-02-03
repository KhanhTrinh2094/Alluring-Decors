package admin.manager;

import bean.BillDetailsFacade;
import bean.BillsFacade;
import entities.BillDetails;
import entities.Bills;
import entities.Projects;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BillMB {

    @EJB
    private BillDetailsFacade billDetailsFacade;

    @EJB
    private BillsFacade billsFacade;
    private Bills bill;

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

    public BillMB() {
    }

    public List<Bills> getList() {
        return billsFacade.findAll();
    }

    public String detail(int id) {
        bill = billsFacade.find(id);
        if (bill != null) {
            return "bill_detail";
        }
        return "";
    }

    public String changeStatus(int id, String status) {
        bill = billsFacade.find(id);
        if (bill != null) {
            try {
                bill.setOrderStatus(new Short(status));
                billsFacade.edit(bill);
                return "";
            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }

    public List<BillDetails> getDetails(int billID) {
        return billDetailsFacade.getDetails(billID);
    }
    
    public List<Bills> report(int number, String column, String sort){
        return billsFacade.report(number, column, sort);
    }
}

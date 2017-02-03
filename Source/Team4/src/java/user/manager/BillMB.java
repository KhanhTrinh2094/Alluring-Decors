package user.manager;

import bean.BillDetailsFacade;
import bean.BillsFacade;
import bean.ServicesFacade;
import bean.UsersFacade;
import entities.BillDetails;
import entities.Bills;
import entities.Carts;
import entities.Services;
import helper.SessionManaged;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "billMB_US")
@RequestScoped
public class BillMB {

    @EJB
    private ServicesFacade servicesFacade;

    @EJB
    private UsersFacade usersFacade;
    @EJB
    private BillDetailsFacade billDetailsFacade;
    @EJB
    private BillsFacade billsFacade;

    private Bills bill;

    public BillMB() {
        if (bill == null) {
            bill = new Bills();
        }
    }

    public Bills getBill() {
        return bill;
    }

    public void setBill(Bills bill) {
        this.bill = bill;
    }

    public String checkout() {
        int billID;
        if (bill != null) {
            bill.setOrderTime(Calendar.getInstance().getTime());
            bill.setOrderStatus(new Short("0"));
            bill.setUserID(usersFacade.getUser(SessionManaged.getSession().getAttribute("USER").toString()));
            BigDecimal totalPrice = new BigDecimal("0");
            billID = billsFacade.createBills(bill);

            CartMB cart = new CartMB();
            for (Map.Entry<Integer, Carts> item : cart.getCart().entrySet()) {
                Services service = servicesFacade.find(item.getKey());
                BillDetails detail = new BillDetails();
                detail.setServiceID(service);
                detail.setBillID(billsFacade.find(billID));
                detail.setQuantity(item.getValue().getQuantity());
                detail.setStatus(new Short("0"));
                detail.setPrice(new BigDecimal(item.getValue().getQuantity()).multiply(item.getValue().getPrice()));
                totalPrice = totalPrice.add(new BigDecimal(item.getValue().getQuantity()).multiply(item.getValue().getPrice()));
                billDetailsFacade.create(detail);
            }
            bill.setTotalPrice(totalPrice);
            billsFacade.edit(bill);
            SessionManaged.getSession().removeAttribute("CART");
            return "index";
        }
        return "";
    }
}

package admin.manager;

import bean.UsersFacade;
import entities.Users;
import helper.SessionManaged;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserMB {

    @EJB
    private UsersFacade usersFacade;

    public UserMB() {
    }
    
    public List<Users> getList(){
        return usersFacade.findAll();
    }
    
    public String active(int id){
        Users user = usersFacade.find(id);
        if(user != null && user.getUserID() != null){
            try {
                user.setStatus(true);
                usersFacade.edit(user);
                return "customer_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not active this Customer. Please try again");
                return "";
            }
        }
        return "";
    }
    
    public String deactive(int id){
        Users user = usersFacade.find(id);
        if(user != null && user.getUserID() != null){
            try {
                user.setStatus(false);
                usersFacade.edit(user);
                return "customer_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not deactive this Customer. Please try again");
                return "";
            }
        }
        return "";
    }
    
    public List<Users> report(int number, String column, String sort){
        return usersFacade.report(number, column, sort);
    }

}

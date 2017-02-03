package admin.manager;

import bean.AdminFacade;
import entities.Admin;
import helper.SessionManaged;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AdminMB {

    @EJB
    private AdminFacade adminFacade;
    private Admin admin;
    private String current, newpass, confirm;

    public AdminMB() {
        if (admin == null) {
            admin = new Admin();
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String login() {
        if (adminFacade.login(admin.getUsername(), admin.getPassword())) {
            SessionManaged.getSession().setAttribute("ADUser", admin.getUsername());
            return "index";
        }
        SessionManaged.getRequest().setAttribute("error", "Username or password is incorrect");
        return "";
    }

    public String logout() {
        SessionManaged.getSession().removeAttribute("ADUser");
        return "login";
    }

    public String changepass() {
        if (!confirm.equals(newpass)) {
            SessionManaged.getRequest().setAttribute("error", "Confirm password not match");
            return "";
        }
        if (adminFacade.login(SessionManaged.getSession().getAttribute("ADUser").toString(), current)) {
            if (adminFacade.changepass(SessionManaged.getSession().getAttribute("ADUser").toString(), newpass)) {
                SessionManaged.getRequest().setAttribute("error", "Change password successful");
                return "index";
            }
        } else {
            SessionManaged.getRequest().setAttribute("error", "Current password incorrect");
            return "";
        }
        return "";
    }

}

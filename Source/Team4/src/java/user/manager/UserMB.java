package user.manager;

import bean.UsersFacade;
import entities.Users;
import helper.SessionManaged;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userMB_US")
@SessionScoped
public class UserMB implements Serializable {

    @EJB
    private UsersFacade usersFacade;
    private Users user;
    private String current, newpass, confirm;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserMB() {
        if (user == null) {
            user = new Users();
        }
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

    public String register() {
        if (user != null && user.getUsername() != null) {
            try {
                user.setStatus(true);
                usersFacade.create(user);
                return "login";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not register. Please try again");
                return "";
            }
        }
        return "";
    }

    public String login() {
        if (usersFacade.login(user.getUsername(), user.getPassword())) {
            SessionManaged.getSession().setAttribute("USER", user.getUsername());
            return "index";
        }
        SessionManaged.getRequest().setAttribute("error", "Username or password incorrect");
        return "";
    }

    public String logout() {
        SessionManaged.getSession().removeAttribute("USER");
        return "index";
    }

    public Users getUserByUsername(String username) {
        if (usersFacade.getUser(username) != null) {
            return usersFacade.getUser(username);
        }
        return null;
    }

    public String edit(int id) {
        user = usersFacade.find(id);
        if (user != null) {
            return "edit_profile";
        }
        return "";
    }

    public String updateProfile() {
        if (user != null && user.getUsername() != null) {
            try {
                usersFacade.edit(user);
                return "profile";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not update profile. Please try again");
                return "";
            }
        }
        return "";
    }
    
    public String changePass(){
        if (!confirm.equals(newpass)) {
            SessionManaged.getRequest().setAttribute("error", "Confirm password not match");
            return "";
        }
        if (usersFacade.login(SessionManaged.getSession().getAttribute("USER").toString(), current)) {
            if (usersFacade.changepass(SessionManaged.getSession().getAttribute("USER").toString(), newpass)) {
                SessionManaged.getRequest().setAttribute("error", "Change password successful");
                return "";
            }
        } else {
            SessionManaged.getRequest().setAttribute("error", "Current password incorrect");
            return "";
        }
        return "";
    }

}

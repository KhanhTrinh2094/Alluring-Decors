package user.manager;

import bean.ServicesFacade;
import entities.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "searchMB_US")
@SessionScoped
public class SearchMB implements Serializable{

    @EJB
    private ServicesFacade servicesFacade;

    private String name;
    private List<Services> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Services> getList() {
        return list;
    }

    public void setList(List<Services> list) {
        this.list = list;
    }

    public SearchMB() {
    }

    public String search() {
        list = servicesFacade.search(name);
        return "search";
    }
    
    public void reset(){
        name = "";
        list = new ArrayList<>();
    }

}

package user.manager;

import bean.DomainsFacade;
import entities.Domains;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "domainMB_US")
@SessionScoped
public class DomainMB implements Serializable{

    private Domains domain;
    @EJB
    private DomainsFacade domainsFacade;

    public DomainMB() {
        if(domain == null){
            domain = new Domains();
        }
    }

    public Domains getDomain() {
        return domain;
    }

    public void setDomain(Domains domain) {
        this.domain = domain;
    }

    public List<Domains> getList() {
        return domainsFacade.findAll_US();
    }
    
    public String showDomain(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id;
        try {
            id = Integer.parseInt(params.get("ID"));
        } catch (NumberFormatException e) {
            return "index";
        }
        if (id <= 0) {
            return "index";
        } else {
            this.domain = domainsFacade.find(id);
            return "domain";
        }
    }

}

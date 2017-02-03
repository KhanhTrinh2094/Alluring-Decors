package admin.manager;

import bean.DomainsFacade;
import entities.Domains;
import helper.SessionManaged;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DomainMB implements Serializable {

    @EJB
    private DomainsFacade domainsFacade;
    private Domains domain;

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
    
    public List<Domains> getList(){
        return domainsFacade.findAll();
    }
    
    public String addDomain(){
        try {
            domain.setStatus(true);
            domainsFacade.create(domain);
            return "domain_manager";
        } catch (Exception e) {
            SessionManaged.getRequest().setAttribute("error", "Can not add this domain. Please try again");
            return "";
        }
    }
    
    public void newDomain(){
        domain = new Domains();
    }
    
    public String preUpdate(int id){
        domain = domainsFacade.find(id);
        if(domain != null && domain.getDomainID() != null){
            return "domain_edit";
        }
        return "";
    }

    public String update(){
        try {
            domainsFacade.edit(domain);
            return "domain_manager";
        } catch (Exception e) {
            SessionManaged.getRequest().setAttribute("error", "Can not update this domain. Please try again");
            return "";
        }
    }
    
    public String active(int id){
        domain = domainsFacade.find(id);
        if(domain != null && domain.getDomainID() != null){
            try {
                domain.setStatus(true);
                domainsFacade.edit(domain);
                return "domain_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not active this domain. Please try again");
                return "";
            }
        }
        return "";
    }
    
    public String deactive(int id){
        domain = domainsFacade.find(id);
        if(domain != null && domain.getDomainID() != null){
            try {
                domain.setStatus(false);
                domainsFacade.edit(domain);
                return "domain_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not deactive this domain. Please try again");
                return "";
            }
        }
        return "";
    }
    
    public List<Domains> report(int number, String column, String sort){
        return domainsFacade.report(number, column, sort);
    }
}

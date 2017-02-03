package user.manager;

import bean.ServicesFacade;
import entities.Services;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "servicesMB_US")
@SessionScoped
public class ServicesMB implements Serializable {

    @EJB
    private ServicesFacade servicesFacade;
    private Services service;

    public ServicesMB() {
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
    
    public List<Services> getList(){
        return servicesFacade.findAllIndex();
    }
    
    public List<Services> randomList(int ramdomCount){
        return servicesFacade.findRand(ramdomCount);
    }
    
    public String showService(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(params.get("ID"));
        if (id <= 0) {
            return "index";
        } else {
            this.service = servicesFacade.find(id);
            if(service != null){
                return "service_detail";
            }
        }
        return "";
    }

}

package admin.manager;

import bean.BillsFacade;
import bean.DomainsFacade;
import bean.FaqFacade;
import bean.FeedbacksFacade;
import bean.ProjectsFacade;
import bean.ServicesFacade;
import bean.UsersFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CountMB {

    @EJB
    private UsersFacade usersFacade;
    @EJB
    private ServicesFacade servicesFacade;
    @EJB
    private ProjectsFacade projectsFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    @EJB
    private FaqFacade faqFacade;
    @EJB
    private DomainsFacade domainsFacade;
    @EJB
    private BillsFacade billsFacade;

    public CountMB() {
    }
    
    public int getUserCount(){
        return usersFacade.count();
    }
    
    public int getServiceCount(){
        return servicesFacade.count();
    }
    
    public int getProjectCount(){
        return projectsFacade.count();
    }
    
    public int getFeedbackCount(){
        return feedbacksFacade.count();
    }
    
    public int getFaqCount(){
        return faqFacade.count();
    }
    
    public int getDomainCount(){
        return domainsFacade.count();
    }
    
    public int getBillCount(){
        return billsFacade.count();
    }

}

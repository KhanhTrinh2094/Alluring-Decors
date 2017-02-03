package user.manager;

import bean.FaqFacade;
import entities.Faq;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "fAQMB_US")
@RequestScoped
public class FAQMB {

    @EJB
    private FaqFacade faqFacade;

    public FAQMB() {
    }
    
    public List<Faq> getList(){
        return faqFacade.findAll();
    }
}

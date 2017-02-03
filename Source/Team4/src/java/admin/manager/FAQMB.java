package admin.manager;

import bean.FaqFacade;
import entities.Faq;
import helper.SessionManaged;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FAQMB implements Serializable {

    @EJB
    private FaqFacade faqFacade;
    private Faq faq;

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public FAQMB() {
        if(faq == null){
            faq = new Faq();
        }
    }

    public List<Faq> getList() {
        return faqFacade.findAll();
    }

    public String add() {
        if (faq != null && faq.getTitle() != null) {
            try {
                faqFacade.create(faq);
                faq = new Faq();
                return "faq_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not add this faq. Please try again");
            }
        }
        return "";
    }
    
    public String preUpdate(int id){
        faq = faqFacade.find(id);
        if(faq != null){
            return "faq_edit";
        }
        return "";
    }
    
    public String update(){
        if(faq != null){
            try {
                faqFacade.edit(faq);
                faq = new Faq();
                return "faq_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not update this faq. Please try again");
            }
        }
        return "";
    }
    
    public String delete(int id){
        faq = faqFacade.find(id);
        if(faq != null){
            faqFacade.remove(faq);
            return "faq_manager";
        }
        return "";
    }
    
    public void newFAQ(){
        faq = new Faq();
    }
}

package admin.manager;

import bean.FeedbacksFacade;
import entities.Feedbacks;
import helper.SessionManaged;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FeedbackMB {

    @EJB
    private FeedbacksFacade feedbacksFacade;

    public FeedbackMB() {
    }

    public List<Feedbacks> getList() {
        return feedbacksFacade.findAll();
    }
    
    public String delete(int id){
        Feedbacks feedback = feedbacksFacade.find(id);
        if(feedback != null){
            try {
                feedbacksFacade.remove(feedback);
                return "feedback_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not delete this feedback. Please try again");
                return "";
            }
        }
        return "";
    }
}

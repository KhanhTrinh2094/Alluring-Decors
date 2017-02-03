package user.manager;

import bean.FeedbacksFacade;
import entities.Feedbacks;
import helper.SessionManaged;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "feedback_US")
@RequestScoped
public class FeedbackMB {

    @EJB
    private FeedbacksFacade feedbacksFacade;
    private Feedbacks feedback;

    public Feedbacks getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedbacks feedback) {
        this.feedback = feedback;
    }

    public FeedbackMB() {
        if (feedback == null) {
            feedback = new Feedbacks();
        }
    }

    public String send() {
        if (feedback != null && feedback.getFullname() != null) {
            try {
                feedback.setStatus(true);
                feedbacksFacade.create(feedback);
                SessionManaged.getRequest().setAttribute("error", "Thank you for feedback !!!");
                feedback = new Feedbacks();
                return "";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not send feedback. Please try again");
            }
        }
        return "";
    }

}

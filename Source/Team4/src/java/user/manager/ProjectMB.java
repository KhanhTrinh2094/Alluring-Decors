package user.manager;

import bean.ProjectsFacade;
import entities.Projects;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "projectMB_US")
@SessionScoped
public class ProjectMB {

    @EJB
    private ProjectsFacade projectsFacade;
    private Projects project;

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public ProjectMB() {
    }

    public List<Projects> getList() {
        return projectsFacade.findAll();
    }

    public List<Projects> getList(String param) {
        switch (param) {
            case "0":
                return getListOnGoing();
            case "1":
                return getListUpComing();
            case "2":
                return getListAccomplished();
            default:
                return getList();
        }
    }

    public List<Projects> getListOnGoing() {
        return projectsFacade.getListOnGoing();
    }

    public List<Projects> getListUpComing() {
        return projectsFacade.getListUpComing();
    }

    public List<Projects> getListAccomplished() {
        return projectsFacade.getListAccomplished();
    }

    public String showProject() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int id = Integer.parseInt(params.get("ID"));
        if (id <= 0) {
            return "index";
        } else {
            this.project = projectsFacade.find(id);
            if (project != null) {
                return "project_detail";
            }
        }
        return "";
    }

    public List<Projects> randomList(int ramdomCount) {
        return projectsFacade.findRand(ramdomCount);
    }

}

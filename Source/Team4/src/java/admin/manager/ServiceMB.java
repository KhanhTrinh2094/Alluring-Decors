package admin.manager;

import bean.DomainsFacade;
import bean.ServicesFacade;
import entities.Domains;
import entities.Services;
import helper.JsfUtil;
import helper.SessionManaged;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class ServiceMB implements Serializable {

    @EJB
    private DomainsFacade domainsFacade;
    @EJB
    private ServicesFacade servicesFacade;
    private Services services;
    private ArrayList<Part> file;
    private Part files;

    public ServiceMB() {
        if (services == null) {
            services = new Services();
        }
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public ArrayList<Part> getFile() {
        return file;
    }

    public void setFile(ArrayList<Part> file) {
        this.file = file;
    }

    public Part getFiles() {
        return files;
    }

    public void setFiles(Part files) {
        this.files = files;
    }


    public List<Services> getList() {
        return servicesFacade.findAll();
    }

    public String addServices() {
        if (file.size() > 0) {
            files = file.get(0);
            String uploadRootPath = SessionManaged.getRequest().getServletContext().getRealPath("upload");
            File uploadRootDir = new File(uploadRootPath);
            if (!uploadRootDir.exists()) {
                uploadRootDir.mkdirs();
            }
            File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + files.getSubmittedFileName());
            try {
                InputStream is;
                OutputStream os;
                is = files.getInputStream();
                os = new FileOutputStream(serverFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                is.close();
                os.close();
            } catch (IOException e) {
            }
            services.setImage(files.getSubmittedFileName());
        }
        try {
            services.setStatus(true);
            servicesFacade.create(services);
            return "service_manager";
        } catch (Exception e) {
            SessionManaged.getRequest().setAttribute("error", "Can not add this services. Please try again");
            return "";
        }
    }

    public void newServices() {
        services = new Services();
    }

    public String preUpdate(int id) {
        services = servicesFacade.find(id);
        if (services != null && services.getDomainID() != null) {
            return "service_edit";
        }
        return "";
    }

    public String update() {
        if (file.size() > 0) {
            files = file.get(0);
            String uploadRootPath = SessionManaged.getRequest().getServletContext().getRealPath("upload");
            File uploadRootDir = new File(uploadRootPath);
            if (!uploadRootDir.exists()) {
                uploadRootDir.mkdirs();
            }
            File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + files.getSubmittedFileName());
            try {
                InputStream is;
                OutputStream os;
                is = files.getInputStream();
                os = new FileOutputStream(serverFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                is.close();
                os.close();
            } catch (IOException e) {
            }
            services.setImage(files.getSubmittedFileName());
        }
        try {
            servicesFacade.edit(services);
            return "service_manager";
        } catch (Exception e) {
            SessionManaged.getRequest().setAttribute("error", "Can not update this services. Please try again");
            return "";
        }
    }

    public String active(int id) {
        services = servicesFacade.find(id);
        if (services != null && services.getDomainID() != null) {
            try {
                services.setStatus(true);
                servicesFacade.edit(services);
                return "service_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not active this services. Please try again");
                return "";
            }
        }
        return "";
    }

    public String deactive(int id) {
        services = servicesFacade.find(id);
        if (services != null && services.getDomainID() != null) {
            try {
                services.setStatus(false);
                servicesFacade.edit(services);
                return "service_manager";
            } catch (Exception e) {
                SessionManaged.getRequest().setAttribute("error", "Can not deactive this services. Please try again");
                return "";
            }
        }
        return "";
    }

    public Domains getDomainsConverter(int id) {
        return domainsFacade.find(id);
    }

    public SelectItem[] getDomainItems() {
        return JsfUtil.getSelectItems(domainsFacade.findAll(), true);
    }

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        ArrayList<Part> filesValid = (ArrayList<Part>) value;
        Part fileValid = filesValid.get(0);
        if (fileValid != null) {
            List<FacesMessage> msgs = new ArrayList<>();
            if (!"image/png".equals(fileValid.getContentType()) && !"image/jpeg".equals(fileValid.getContentType()) && !"image/gif".equals(fileValid.getContentType())) {
                msgs.add(new FacesMessage("Please select image type"));
            }
            if (!msgs.isEmpty()) {
                throw new ValidatorException(msgs);
            }
        }
    }
    
    public List<Services> report(int number, String column, String sort){
        return servicesFacade.report(number, column, sort);
    }
}

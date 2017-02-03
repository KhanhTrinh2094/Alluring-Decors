package admin.manager;

import bean.BillsFacade;
import bean.ImagesFacade;
import bean.ProjectsFacade;
import entities.Bills;
import entities.Images;
import entities.Projects;
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
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class ProjectMB implements Serializable {

    @EJB
    private ImagesFacade imagesFacade;
    @EJB
    private BillsFacade billsFacade;
    @EJB
    private ProjectsFacade projectsFacade;
    private Projects project;
    private ArrayList<Part> file;
    private List<Part> imgs;
    private Images image;

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public ArrayList<Part> getFile() {
        return file;
    }

    public void setFile(ArrayList<Part> file) {
        this.file = file;
    }

    public List<Part> getImgs() {
        return imgs;
    }

    public void setImgs(List<Part> imgs) {
        this.imgs = imgs;
    }

    public ProjectMB() {
        if (project == null) {
            project = new Projects();
        }
    }

    public List<Projects> getList() {
        return projectsFacade.findAll();
    }

    public String create(int billID) {
        Bills bill = billsFacade.find(billID);
        if (bill != null) {
            project.setBillID(bill);
            project.setUserID(bill.getUserID());
            project.setProjectPrice(bill.getTotalPrice());
            return "project_add";
        }
        return "";
    }

    public String create() {
        Part indexFile;
        if (project != null) {
            try {
                if (file.size() > 0) {
                    indexFile = file.get(0);
                    String uploadRootPath = SessionManaged.getRequest().getServletContext().getRealPath("upload/project");
                    File uploadRootDir = new File(uploadRootPath);
                    if (!uploadRootDir.exists()) {
                        uploadRootDir.mkdirs();
                    }
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + indexFile.getSubmittedFileName());
                    try {
                        InputStream is;
                        OutputStream os;
                        is = indexFile.getInputStream();
                        os = new FileOutputStream(serverFile);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                        is.close();
                        os.close();
                        project.setThumbImage(indexFile.getSubmittedFileName());
                    } catch (IOException e) {
                    }
                }
                int projectID = projectsFacade.createProjects(project);

                if (imgs.size() > 0 && projectID > 0) {
                    for (Part item : imgs) {
                        String fileName = item.getSubmittedFileName().trim();
                        if (!fileName.isEmpty()) {
                            try (InputStream inputStream = item.getInputStream(); FileOutputStream outputStream = new FileOutputStream(SessionManaged.getRequest().getServletContext().getRealPath("upload/project") + File.separator + item.getSubmittedFileName())) {
                                int bytesRead = 0;
                                final byte[] chunck = new byte[1024];
                                while ((bytesRead = inputStream.read(chunck)) != -1) {
                                    outputStream.write(chunck, 0, bytesRead);
                                }
                                image = new Images();
                                image.setProjectID(projectsFacade.find(projectID));
                                image.setImageUrl(fileName);
                                image.setImageTitle(project.getProjectName());
                                imagesFacade.create(image);
                            } catch (IOException ex) {
                            }
                        }
                    }
                }

                project = new Projects();
                return "project_manager";
            } catch (Exception e) {
            }
        }
        return "";
    }

    public String update(int id) {
        project = projectsFacade.find(id);
        if (project != null) {
            return "project_edit";
        }
        return "";
    }

    public String update() {
        Part indexFile;
        if (project != null) {
            if (file.size() > 0) {
                indexFile = file.get(0);
                String uploadRootPath = SessionManaged.getRequest().getServletContext().getRealPath("upload/project");
                File uploadRootDir = new File(uploadRootPath);
                if (!uploadRootDir.exists()) {
                    uploadRootDir.mkdirs();
                }
                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + indexFile.getSubmittedFileName());
                try {
                    InputStream is;
                    OutputStream os;
                    is = indexFile.getInputStream();
                    os = new FileOutputStream(serverFile);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                    is.close();
                    os.close();
                    project.setThumbImage(indexFile.getSubmittedFileName());
                } catch (IOException e) {
                }
            }
            
            imagesFacade.delete(project.getProjectID());
            
            int projectID = project.getProjectID();

            if (imgs.size() > 0 && projectID > 0) {
                for (Part item : imgs) {
                    String fileName = item.getSubmittedFileName().trim();
                    if (!fileName.isEmpty()) {
                        try (InputStream inputStream = item.getInputStream(); FileOutputStream outputStream = new FileOutputStream(SessionManaged.getRequest().getServletContext().getRealPath("upload/project") + File.separator + item.getSubmittedFileName())) {
                            int bytesRead = 0;
                            final byte[] chunck = new byte[1024];
                            while ((bytesRead = inputStream.read(chunck)) != -1) {
                                outputStream.write(chunck, 0, bytesRead);
                            }
                            image = new Images();
                            image.setProjectID(projectsFacade.find(projectID));
                            image.setImageUrl(fileName);
                            image.setImageTitle(project.getProjectName());
                            imagesFacade.create(image);
                        } catch (IOException ex) {
                        }
                    }
                }
            }
            try {
                projectsFacade.edit(project);
                return "project_manager";
            } catch (Exception e) {
            }
        }
        return "";
    }

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        ArrayList<Part> list = (ArrayList<Part>) value;
        Part fileValid = list.get(0);
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
        
    public String delete(int id){
        project = projectsFacade.find(id);
        if(project != null){
            imagesFacade.delete(project.getProjectID());
            projectsFacade.remove(project);
        }
        return "";
    }
    
    public void setNew(){
        project = new Projects();
    }
    
    public List<Projects> report(int number, String column, String sort){
        return projectsFacade.report(number, column, sort);
    }
}

package admin.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@RequestScoped
public class UploadMB {

    private List<Part> files;

    public void upload(ActionEvent event) {

        if (files != null) {

            String fileTypes = "image/";

            for (Part file : files) {

                String fileName = file.getSubmittedFileName().trim();
                if (!fileName.isEmpty()) {

                    if (file.getContentType().startsWith(fileTypes)) {
                        try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream("F:" + File.separator + "files" + File.separator + file.getSubmittedFileName())) {

                            int bytesRead = 0;
                            final byte[] chunck = new byte[1024];
                            while ((bytesRead = inputStream.read(chunck)) != -1) {
                                outputStream.write(chunck, 0, bytesRead);
                            }

                        } catch (IOException ex) {
                        }
                    } else {
                    }
                }
            }
        }
    }

    public List<Part> getFiles() {
        return files;
    }

    public void setFiles(List<Part> files) {
        this.files = files;
    }
}

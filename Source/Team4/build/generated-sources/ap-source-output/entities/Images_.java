package entities;

import entities.Projects;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Images.class)
public class Images_ { 

    public static volatile SingularAttribute<Images, String> imageTitle;
    public static volatile SingularAttribute<Images, Projects> projectID;
    public static volatile SingularAttribute<Images, Integer> imageID;
    public static volatile SingularAttribute<Images, String> imageUrl;

}
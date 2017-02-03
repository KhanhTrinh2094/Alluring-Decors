package entities;

import entities.Bills;
import entities.Images;
import entities.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Projects.class)
public class Projects_ { 

    public static volatile SingularAttribute<Projects, Date> startDate;
    public static volatile SingularAttribute<Projects, Users> userID;
    public static volatile SingularAttribute<Projects, Integer> projectID;
    public static volatile SingularAttribute<Projects, String> projectDetail;
    public static volatile SingularAttribute<Projects, String> thumbImage;
    public static volatile SingularAttribute<Projects, Short> status;
    public static volatile SingularAttribute<Projects, Bills> billID;
    public static volatile CollectionAttribute<Projects, Images> imagesCollection;
    public static volatile SingularAttribute<Projects, Date> deliveryDate;
    public static volatile SingularAttribute<Projects, String> projectName;
    public static volatile SingularAttribute<Projects, BigDecimal> projectPrice;

}
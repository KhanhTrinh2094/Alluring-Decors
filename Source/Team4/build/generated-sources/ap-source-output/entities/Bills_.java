package entities;

import entities.BillDetails;
import entities.Projects;
import entities.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Bills.class)
public class Bills_ { 

    public static volatile SingularAttribute<Bills, Users> userID;
    public static volatile SingularAttribute<Bills, String> contactNumber;
    public static volatile SingularAttribute<Bills, String> recipientName;
    public static volatile SingularAttribute<Bills, Integer> billID;
    public static volatile CollectionAttribute<Bills, Projects> projectsCollection;
    public static volatile SingularAttribute<Bills, String> recipientAddress;
    public static volatile CollectionAttribute<Bills, BillDetails> billDetailsCollection;
    public static volatile SingularAttribute<Bills, Date> orderTime;
    public static volatile SingularAttribute<Bills, Short> orderStatus;
    public static volatile SingularAttribute<Bills, String> note;
    public static volatile SingularAttribute<Bills, BigDecimal> totalPrice;

}
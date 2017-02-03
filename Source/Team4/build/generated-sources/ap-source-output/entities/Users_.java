package entities;

import entities.Bills;
import entities.Projects;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile CollectionAttribute<Users, Bills> billsCollection;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, Boolean> status;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile CollectionAttribute<Users, Projects> projectsCollection;
    public static volatile SingularAttribute<Users, Boolean> gender;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> fullname;

}
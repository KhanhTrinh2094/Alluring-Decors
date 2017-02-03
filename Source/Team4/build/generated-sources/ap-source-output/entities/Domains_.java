package entities;

import entities.Services;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Domains.class)
public class Domains_ { 

    public static volatile SingularAttribute<Domains, String> domainDescription;
    public static volatile SingularAttribute<Domains, Integer> domainID;
    public static volatile SingularAttribute<Domains, Boolean> status;
    public static volatile CollectionAttribute<Domains, Services> servicesCollection;
    public static volatile SingularAttribute<Domains, String> domainName;

}
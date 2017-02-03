package entities;

import entities.BillDetails;
import entities.Domains;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(Services.class)
public class Services_ { 

    public static volatile SingularAttribute<Services, Boolean> status;
    public static volatile SingularAttribute<Services, Domains> domainID;
    public static volatile SingularAttribute<Services, Integer> serviceID;
    public static volatile CollectionAttribute<Services, BillDetails> billDetailsCollection;
    public static volatile SingularAttribute<Services, String> image;
    public static volatile SingularAttribute<Services, BigDecimal> servicePrice;
    public static volatile SingularAttribute<Services, String> serviceName;
    public static volatile SingularAttribute<Services, String> serviceDescription;

}
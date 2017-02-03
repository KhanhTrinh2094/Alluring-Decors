package entities;

import entities.Bills;
import entities.Services;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-10-23T11:12:38")
@StaticMetamodel(BillDetails.class)
public class BillDetails_ { 

    public static volatile SingularAttribute<BillDetails, BigDecimal> price;
    public static volatile SingularAttribute<BillDetails, Short> status;
    public static volatile SingularAttribute<BillDetails, Services> serviceID;
    public static volatile SingularAttribute<BillDetails, Bills> billID;
    public static volatile SingularAttribute<BillDetails, Integer> detailID;
    public static volatile SingularAttribute<BillDetails, Integer> quantity;

}
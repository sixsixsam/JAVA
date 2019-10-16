package Entity;

import Entity.DrivingLicense;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T00:21:27")
@StaticMetamodel(DrivingLicenseCategory.class)
public class DrivingLicenseCategory_ { 

    public static volatile CollectionAttribute<DrivingLicenseCategory, DrivingLicense> drivingLicenseCollection;
    public static volatile SingularAttribute<DrivingLicenseCategory, Long> id;
    public static volatile SingularAttribute<DrivingLicenseCategory, String> categoryName;

}
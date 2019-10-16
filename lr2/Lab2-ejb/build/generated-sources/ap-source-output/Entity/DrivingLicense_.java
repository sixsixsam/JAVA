package Entity;

import Entity.DrivingLicenseCategory;
import Entity.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-28T00:21:27")
@StaticMetamodel(DrivingLicense.class)
public class DrivingLicense_ { 

    public static volatile CollectionAttribute<DrivingLicense, DrivingLicenseCategory> drivingLicenseCategoryCollection;
    public static volatile CollectionAttribute<DrivingLicense, Person> personCollection;
    public static volatile SingularAttribute<DrivingLicense, Date> expireDate;
    public static volatile SingularAttribute<DrivingLicense, Long> id;
    public static volatile SingularAttribute<DrivingLicense, Date> issueDate;

}
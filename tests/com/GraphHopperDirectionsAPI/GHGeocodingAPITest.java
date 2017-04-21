import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by timsvensson on 21/04/17.
 */
@RunWith(Arquillian.class)
public class GHGeocodingAPITest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(com.GraphHopperDirectionsAPI.GHGeocodingAPI.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}

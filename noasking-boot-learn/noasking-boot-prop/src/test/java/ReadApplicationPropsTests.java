import com.noasking.boot.learn.prop.LearnPropApplication;
import com.noasking.boot.learn.prop.properties.PropsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by MaJing on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearnPropApplication.class)
public class ReadApplicationPropsTests {

    @Autowired
    private PropsConfig propsConfig;

    @Test
    public void testDisplayPropsValue() {
        String driverClassName = propsConfig.getDriverClassName();
        String url = propsConfig.getUrl();
        String username = propsConfig.getUsername();
        String password = propsConfig.getPassword();

        String filters = propsConfig.getFilters();
        String maxActive = propsConfig.getMaxActive();
        String initialSize = propsConfig.getInitialSize();
        String maxWait = propsConfig.getMaxWait();

        System.out.println("driverClassName -> " + driverClassName);
        System.out.println("url -> " + url);
        System.out.println("username -> " + username);
        System.out.println("password -> " + password);

        System.out.println("initialSize -> " + initialSize);
        System.out.println("maxWait -> " + maxWait);

    }

}

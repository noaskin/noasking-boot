import com.noasking.mybatis.Application;
import com.noasking.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by MaJing on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestApp {

    @Autowired
    private UserService userService;

    @Test
    public void testDisplayPropsValue() {
        System.out.println(userService.get());
    }

}

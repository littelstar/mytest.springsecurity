
import com.lpp.domain.Permission;
import com.lpp.domain.User;
import com.lpp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class userMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        User jack = userMapper.findUserByName("jack");
        System.out.println(jack);
        List<Permission> jack1 = userMapper.findPermissionByName("jack");
        System.out.println(jack1);

    }
    @Test
    public void testPassword(){
        User jack = userMapper.findUserByName("rose");
//        哈希算法+加盐
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        jack.setPassword(encode);
        userMapper.updateUserPassword(jack);

    }
}

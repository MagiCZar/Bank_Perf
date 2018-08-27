import com.bank.service.Impl.InforUpdateServiceImpl;
import com.bank.service.InforUpdateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    private InforUpdateService inforUpdateService;

    @Test
    @Transactional
    public void checkTest(){
        System.out.println(inforUpdateService.CheckPass(11001,"110011"));
    }
}

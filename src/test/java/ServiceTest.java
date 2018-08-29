import com.bank.service.CusChangeService;
import com.bank.service.EmpLoadService;
import com.bank.service.ExcelService;
import com.bank.service.Impl.InforUpdateServiceImpl;
import com.bank.service.InforUpdateService;
import com.bank.util.InfTransUtil;
import com.bank.util.ListUtil;
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
    @Autowired
    private ExcelService excelService;
    @Autowired
    private CusChangeService cusChangeService;
    @Autowired
    private EmpLoadService empLoadService;

    @Test
//    @Transactional
    public void checkTest(){
//        System.out.println(InfTransUtil.inf_trans(inforUpdateService.inf_load(14001),14001));
//        System.out.println(ListUtil.listTrans(11001,excelService.load(11001)));
//        System.out.println(inforUpdateService.passUpdate(11001,"123456"));
//        System.out.println(inforUpdateService.infUpdate(11001,"王大锤","1995-03-02","男"));
//        System.out.println(cusChangeService.cusChange(11002,11001));
        System.out.println(empLoadService.empLoad(24001));
    }
}

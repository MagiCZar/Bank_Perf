import com.bank.controller.EmpMainController;
import com.bank.controller.MngMainController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MngTest extends SpringTestBase {
    @Autowired
    private MngMainController mngMainController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(mngMainController).build();
    }

    @Test
    public void Test() throws Exception{
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(""));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }
}

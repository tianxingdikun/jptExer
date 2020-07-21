package JunitAndTest1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TestControllerTest {

    /**
     * 构建测试对象
     */
    @InjectMocks
    private TestController controller;

    /**
     * Mock出数据构建类
     */
    @Mock
    private testService service;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 构建初始化参数
     */
    Integer number = 1;

    @BeforeMethod
    public void createData() {
        number = 1;
    }

    @Test
    public void testTest1() {
        //当service中的getSomeData的参数为1的时候，则返回getData方法参数为1的数据
        when(service.getSomeData(1)).thenReturn(getData(1));
        //开始测试controller中的test方法,并返回结果
        List<DemoData> list = controller.test(number);
        //构建期望值（也就是告诉程序结果应该是个什么样子）
        List<DemoData> list1 = getData(1);
        //给当前测试下断言（结果值与期望值对比）
        Assert.assertEquals(list.size(),list1.size());
    }

    /**
     * 构建模型数据
     * @param number 需要返回的数据条数
     * @return 返回相应条数的数据
     */
    private List<DemoData> getData(Integer number){
        List<DemoData> list = new ArrayList<>();
        for(int run=0;run<number;run++){
            DemoData data = new DemoData();
            data.setDataName("name"+run);
            data.setDataInfo("info"+run);
            list.add(data);
        }
        return list;
    }

}
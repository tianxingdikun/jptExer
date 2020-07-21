package JunitAndTest1;

import aQute.bnd.component.annotations.Component;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface testService {
    /**
     * 获取部分数据
     * @param number 需要获取的数据量
     * @return 相应数据量的数据集
     */
    List<DemoData> getSomeData(int number);
}

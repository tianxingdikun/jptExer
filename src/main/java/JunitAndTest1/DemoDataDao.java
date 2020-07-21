package JunitAndTest1;

import java.util.List;

public interface DemoDataDao {
    /**
     * 通过传入的值返回相应数量的数据集
     * @param number 需要返回数据的数量
     * @return 和传入值相同数量的数据集
     */
    List<DemoData> getSomeData(int number);
}

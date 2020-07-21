package JunitAndTest1;

import aQute.bnd.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class TestServiceImpl implements testService {

    @Autowired
    private DemoDataDao demoDataDao;

    @Override
    public List<DemoData> getSomeData(int number){
        return demoDataDao.getSomeData(number);
    }
}

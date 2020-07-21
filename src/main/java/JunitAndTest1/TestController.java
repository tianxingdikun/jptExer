package JunitAndTest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private testService testService;

    private static Integer flagNumber = 5;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public List<DemoData> test(@RequestBody int number){
        if(number > flagNumber){
            return null;
        }else{
            return testService.getSomeData(number);
        }
    }
}

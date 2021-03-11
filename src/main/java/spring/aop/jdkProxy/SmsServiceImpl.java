package spring.aop.jdkProxy;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String indeedMission(String mission) {
        System.out.println("indeed mission:" + mission);
        return mission;
    }
}

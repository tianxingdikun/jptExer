package spring.aop.jdkProxy;

public class JdkProxyMain {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("好运来");
        smsService.indeedMission("代理接口中可以多个方法");
    }

}

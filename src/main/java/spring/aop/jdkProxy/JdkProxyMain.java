package spring.aop.jdkProxy;

/**
 * 1 JdkProxyMain
 * 2 SmsService
 * 3 SmsServiceImpl
 * 4 JdkProxyFactory 代理对象
 * 5 DebugInvocationHandler 具体实现
 *
 */
public class JdkProxyMain {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("好运来");
        smsService.indeedMission("代理接口中可以多个方法");
    }

}

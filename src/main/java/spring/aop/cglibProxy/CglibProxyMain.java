package spring.aop.cglibProxy;

/**
 *1 CglibProxyMain
 *2 AliSmsService
 *3 CglibProxyFactory
 *4 DebugMethodInterceptor
 */
public class CglibProxyMain {

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("cglib代理");
    }

}

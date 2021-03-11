package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.MessageService;

/**
 * 学习ioc和aop源码
 * 1 RunSpring
 * 2 MessageService
 * 3 MessageServiceImpl
 */
public class RunSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("启动成功");
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println("看看ioc" + messageService.getMessage());
    }

}

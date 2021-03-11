package spring.ioc;

import spring.ioc.MessageService;

public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "hello world";
    }
}

package controller;

import exception.SimpleException;

import java.util.ArrayList;
import java.util.List;

public class ProgramIdea {

    public static void main(String[] args) throws Exception {
        handleException();
    }

    public static void handleException() throws Exception {
        List<String> exceptionMessages = new ArrayList<String>();
        String s = null;
        if (s == null) {
            throw new NullPointerException("s==null");
        }
        for (int i = 0; i < 10; i++) {
            try {
            int a = 0;
            int b = 100 / a;
            System.out.println(b);
            } catch (Exception e) {
                exceptionMessages.add(e.getMessage());
                continue;
            }
        }
        throw new Exception("出现异常程序不中断，最后统一抛出异常：" + exceptionMessages);
        }
//    }


    public void exerciseException() {
        SelfCreateExceptionExer selfCreateExceptionExer = new SelfCreateExceptionExer();
        try {
            selfCreateExceptionExer.exerciseSimpleException();
        } catch (SimpleException s) {
            System.out.println("");
            System.err.println("");
        }
        Throwable throwable = new Throwable();
        throwable.getMessage();

    }

}

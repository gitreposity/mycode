package com.xxx.functioninterface.define;


public class ExeInterFace {

    public static void main(String[] args) {

        ExceptionInterface d = () -> {throw new ServiceE("你好");};
//        ExceptionInterface e = new ExceptionInterface() {
//            @Override
//            public void test() {
//                a();
//            }
//        };
//        e.test();
//        d.test();
        System.out.println("ee");
//        d.test();

    }

}

interface ExceptionInterface{
    String test();
}

class ServiceE extends RuntimeException{
    private String message;


    public ServiceE(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ServiceE(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

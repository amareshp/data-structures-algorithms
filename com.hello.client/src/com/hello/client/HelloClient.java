package com.hello.client;

import com.hello.Hello;

public class HelloClient {
    public static void main(String args[]) {
        Hello hello = new Hello();
        String helloStr = hello.sayHello();
        System.out.println(helloStr);
    }
}

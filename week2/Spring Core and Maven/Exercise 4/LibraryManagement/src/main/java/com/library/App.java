package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.web.servlet.DispatcherServlet;

public class App {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   Exercise 4: Maven Setup & Core/AOP/WebMVC Deps   ");
        System.out.println("====================================================");

        // Verify Spring AOP dependency works
        ProxyFactory proxyFactory = new ProxyFactory();
        System.out.println("[Verification] Spring AOP class resolved: " + proxyFactory.getClass().getName());

        // Verify Spring WebMVC dependency works
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        System.out.println("[Verification] Spring WebMVC class resolved: " + dispatcherServlet.getClass().getName());

        System.out.println("[Success] All requested Spring dependencies (Context, AOP, WebMVC) are verified and present!");
        System.out.println("====================================================");
    }
}

package kr.kiomn2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "kr.kiomnd2.subscriber")
public class EnglishSubscribeApplication {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
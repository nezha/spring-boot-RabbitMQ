package com.nezha;

import com.nezha.rabbit.fanout.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test07Application{

//    @Autowired
//    FanoutSender sender;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        sender.send();
//    }

    public static void main(String[] args) {
		SpringApplication.run(Test07Application.class, args);
	}
}

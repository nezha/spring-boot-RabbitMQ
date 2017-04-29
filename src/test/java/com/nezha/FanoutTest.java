package com.nezha;

import com.nezha.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by nezha on 2017/4/29.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest{
    @Autowired
    FanoutSender fanoutSender;

    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
    }
}
